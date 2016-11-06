package com.code.chapter.p2;

import java.util.Date;

/**
 * Created by 甘琪 on 2016/11/6.
 * <p>
 * init初始化
 * length返回元素数量
 * insert定点新增
 * add追加
 * delete删除
 * findById按序号查找
 * findByKey按关键字查找
 * listAll列出所有元素
 */
public class P2_1 {
    public static void main(String[] args) {
        SLType sl = new SLType();
        sl.init();
        Data t1 = new Data();
        t1.key = "1";
        t1.value = "haha";
        sl.add(t1);
        Data t2 = new Data();
        t2.key = "2";
        t2.value = "hehe";
        sl.insert(2, t2);
        sl.listAll();
        System.out.println(sl.delete(1));
    }

}

class Data {
    String key;
    String value;
}

class SLType {
    public static final int MAXLEN = 100;
    int len = 0;

    Data[] datas = new Data[MAXLEN + 1];

    public void init() {
        len = 0;
    }

    public int length() {
        return len;
    }

    /**
     * 定点新增
     *
     * @param i
     * @param data
     * @return 0失败 1成功
     */
    public int insert(int i, Data data) {
        if ((length() + 1) > MAXLEN) {
            System.out.println("顺序表已满");
            return 0;
        }
        if (i < 1 || i > length() + 1) {

            System.out.println("序号错误");
            return 0;
        }

        for (int j = length(); j >= i; j--) {
            datas[j + 1] = datas[j];
        }

        datas[i] = data;
        len++;
        return 1;
    }

    public int add(Data data) {
        if ((length() + 1) > MAXLEN) {
            System.out.println("顺序表已满");
            return 0;
        }

        datas[++len] = data;

        return 1;
    }

    public int delete(int n) {
        if (n < 1 || n > length()) {
            System.out.println("序号错误");
            return 0;
        }

        for (int i = n; i < length(); i++) {
            datas[i] = datas[i + 1];
        }
        len--;
        return 1;
    }

    public Data findById(int n) {
        if (n < 1 || n > length()) {
            System.out.println("序号错误");
            return null;
        }

        return datas[n];
    }

    public int findByKey(String key) {
        for (int i = 1; i <= length(); i++) {
            if (datas[i].key.equals(key)) {
                return i;
            }
        }

        return 0;
    }

    public void listAll() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= length(); i++) {
            sb.append("key:").append(datas[i].key).append("v:").append(datas[i].value);
            sb.append(",");
        }
        System.out.println(sb.toString());
    }


}