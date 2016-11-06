package com.code.sort;

import com.code.utils.Util;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by gan on 2015/12/30.
 */
public class SortTest {

    Integer s[] = {6, 5, 3, 1, 8, 7, 2, 4};

    @Test
    public void testBubbleSort() throws Exception {
        Util.printintArr(s);
        new Sort().bubbleSort(s);
        Util.printintArr(s);
    }

    @Test
    public void testQuickSort() throws Exception {
        Util.printintArr(s);
        new Sort().quickSort(s, 0, s.length - 1);
        Util.printintArr(s);
    }

    @Test
    public void testSelectSort() throws Exception {
        new Sort().selectSort(s, s.length);
        Util.printintArr(s);
    }
}