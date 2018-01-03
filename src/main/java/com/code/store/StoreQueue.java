package com.code.store;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by gq on 2017/2/17.
 */
public class StoreQueue {
    private static final int MAX=100;

    private LinkedBlockingQueue<Integer> queue=new LinkedBlockingQueue<>(MAX);


}
