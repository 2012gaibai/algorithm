package com.code.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * User: 罗福兴 DateTime: 2015-12-30 10:56
 */
public class DocToSql {

    public static void main(String[] args) {

        String str = "stat_issue\n" +
                "字段名\t字段描述\t类型长度\tisNull\t备注\n" +
                "lotteryCode\t彩种\tstring(3)\t\t联合索引\n" +
                "issue\t期次\tstring(20)\t\t联合索引\n" +
                "bonusNumber\t开奖号码\tstring(255)\t\t\n" +
                "bonusTime\t开奖时间\tdateTime\t\t\n" +
                "createTime\t创建时间\tdateTime\t\t\n";

        System.out.println(build(str));
    }

    private static String build(String doc) {

        String[] arr = doc.split("\n");
        String tableName = arr[0].trim().toUpperCase();
        List<Field> fieldList = new ArrayList<>();
        for (int i = 2; i < arr.length; i++) {
            if (!arr[i].contains("\t")) {
                continue;
            }
            Field field = new Field();
            String[] fs = arr[i].split("\t");
            field.setName(formatFieldName(fs[0]));
            field.setType(formatFieldType(fs[2]));
            fieldList.add(field);
        }

//        return createSql(tableName, fieldList);
        return filter(createSql(tableName, fieldList));
    }

    private static String filter(String sql){
        return sql.replaceAll("((TYPE|STATUS) NUMBER\\()10(\\))","$12$3");
    }

    private static String createSql(String tableName, List<Field> fieldList) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE ").append(tableName).append("(");
        for (int i = 0; i < fieldList.size(); i++) {
            Field f = fieldList.get(i);
            sb.append(f.getName()).append(" ").append(f.getType());
            if (i < fieldList.size() - 1) {
                sb.append(",");
            }
        }
        sb.append(")");
        return sb.toString();
    }

    private static String formatFieldName(String str) {
        return str.replaceAll("([A-Z])", "_$1").toUpperCase();
    }


    private static String formatFieldType(String str) {
        String lcStr = str.toLowerCase();
        int index = lcStr.indexOf("(");
        String flag;
        String type;
        String length = null;
        if (index > 0) {
            flag = lcStr.substring(0, index);
            length = lcStr.substring(index + 1, lcStr.indexOf(")"));
        } else {
            flag = lcStr;
        }

        switch (flag) {
            case "int":
                type = "NUMBER";
                length = "10";
                break;
            case "long":
                type = "NUMBER";
                length = "16";
                break;
            case "string":
                type = "VARCHAR2";
                break;
            case "datetime":
                type = "TIMESTAMP";
                break;
            default:
                type = flag;
        }
        if (length == null) {
            return type;
        } else {
            return type + "(" + length + ")";
        }
    }

    static class Field {
        String name;
        String type;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
