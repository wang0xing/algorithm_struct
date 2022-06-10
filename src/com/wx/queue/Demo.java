package com.wx.queue;

public class Demo {

    public static void main(String[] args) {

        Queue queue = new Queue(5);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        System.out.println(queue);

        Object remove = queue.remove();
        System.out.println(remove);

        System.out.println(queue);
        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();
        System.out.println(queue);

//        queue.remove();
//        queue.add(6);

        LoopQueue loopQueue = new LoopQueue(5);
        loopQueue.add(1);
        loopQueue.add(2);
        loopQueue.add(3);
        loopQueue.add(4);
        loopQueue.add(5);

        System.out.println(loopQueue);
//        loopQueue.add(6);
        loopQueue.remove();
        loopQueue.remove();
        loopQueue.remove();
        loopQueue.remove();
        loopQueue.remove();
        System.out.println(loopQueue);
//        loopQueue.remove();
        loopQueue.add(1);
        loopQueue.add(1);
        loopQueue.add(1);
        System.out.println(loopQueue);

    }
}
