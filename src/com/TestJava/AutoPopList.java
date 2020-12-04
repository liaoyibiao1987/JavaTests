package com.TestJava;

import java.util.concurrent.LinkedBlockingQueue;

public class AutoPopList<T> {
    private LinkedBlockingQueue dataWarehouse;
    private int capacity;

    public AutoPopList(int capacity) {
        //SparseArray
        this.capacity = capacity;
        dataWarehouse = new LinkedBlockingQueue(capacity);
    }

    public void pushOne(T obj) {
        if (dataWarehouse.size() >= capacity) {
            dataWarehouse.poll();
        }
        if (!dataWarehouse.contains(obj)) {
            dataWarehouse.offer(obj);
        }
    }

    public boolean exits(T obj) {
        return dataWarehouse.contains(obj);
    }

    public static void main(String[] args) {
        AutoPopList<Integer> meetingID = new AutoPopList<>(10);
        meetingID.pushOne(12345);
        meetingID.pushOne(12345);
        meetingID.pushOne(12346);
        meetingID.pushOne(12347);
        meetingID.pushOne(12348);
        meetingID.pushOne(12349);
        meetingID.pushOne(12340);
        meetingID.pushOne(12344);
        meetingID.pushOne(212349);
        meetingID.pushOne(312340);
        meetingID.pushOne(412344);
        meetingID.pushOne(512349);
        meetingID.pushOne(612340);
        meetingID.pushOne(712344);
        meetingID.pushOne(812340);
        meetingID.pushOne(912344);

        System.out.println(meetingID.exits(12345));
        System.out.println(meetingID.exits(412345));
    }
}
