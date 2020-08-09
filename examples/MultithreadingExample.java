package examples;

import java.util.ArrayList;
import java.util.List;

public class MultithreadingExample implements Runnable {


    List<Integer> list;
    private static final int THREADS = 2;

    public MultithreadingExample(List<Integer> integerList) {
        list = integerList;
    }


    @Override
    public void run() {
        synchronized (this) {
//            for (int i = 0; i < 10; i++) {
//                System.out.println(i);
//                System.out.println("from thread: " + Thread.currentThread().getName());
//            }
//        }
            for (int i = 0; i < 5000; i++) {
                list.add((int) Thread.currentThread().getId());
            }
        }
    }


//    public static void main(String[] args) {
//        Thread[] threads = new Thread[THREADS];
//        ArrayList<Integer> list = new ArrayList<>();
//        MultithreadingExample example = new MultithreadingExample(list);
//        for (int i = 0; i < THREADS; i++) {
//            threads[i] = new Thread(example);
//            threads[i].start();
//        }
//
////        Thread.currentThread().interrupt();
////        try {
////            threads[0].join();
////
////        } catch (InterruptedException e) {
////            System.out.println("123");
////        }
//////        Thread.currentThread().interrupt();
////        try {
////            threads[1].join();
////        } catch (InterruptedException e) {
////            e.printStackTrace();
////        }
////
////        for (Integer integer : list) {
////            System.out.println(integer);
////        }
////        System.out.println(list.size());
////        System.out.println(Thread.currentThread().isAlive());
//
//    }

}
