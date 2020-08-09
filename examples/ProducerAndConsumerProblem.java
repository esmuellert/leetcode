package examples;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerAndConsumerProblem {

    private final int BUFFERS = 20;
    private final int PRODUCT_BOUND = 2;
    private final Random random = new Random();
    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();
    private final Buffer buffer = new Buffer(BUFFERS);

    private class Producer implements Runnable {

        private int produce() {
            lock.lock();
            try {
                int product = random.nextInt(PRODUCT_BOUND) + 1;
                if (BUFFERS - buffer.size() < product) {
                    System.out.println("Waiting for space.");
                    while (BUFFERS - buffer.size() < product) {
                        notFull.await();
                    }
                }

                System.out.println(Thread.currentThread().getName() + " produce " + product + " products.");
                for (int i = 0; i < product; i++) {
                    buffer.put(product);
                }
                System.out.println(buffer.size() + " products in buffer");
                notEmpty.signal();
            } catch (InterruptedException e) {
//                e.printStackTrace();
                return 0;
            } finally {
                lock.unlock();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1;
        }

        @Override
        public void run() {
            int status = 1;
            while (!Thread.currentThread().isInterrupted() && status == 1) {
                status = produce();
            }
        }
    }

    private class Consumer implements Runnable {

        private int consume() {
            lock.lock();
            try {
                int consumption = random.nextInt(PRODUCT_BOUND) + 1;
                if (buffer.size() < consumption) {
                    System.out.println("Waiting for product.");
                    while (buffer.size() < consumption) {
                        notEmpty.await();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " consume " + consumption + " products.");
                for (int i = 0; i < consumption; i++) {
                    buffer.take();
                }
                System.out.println(buffer.size() + " products in buffer");
                notFull.signal();
            } catch (InterruptedException e) {
//                e.printStackTrace();
                return 0;
            } finally {
                lock.unlock();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return 0;
            }
            return 1;
        }

        @Override
        public void run() {
            int status = 1;
            while (!Thread.currentThread().isInterrupted() && status == 1) {
                status = consume();
            }
        }
    }

    private class Buffer {
        private ArrayList<Integer> queue;

        public Buffer(int size) {
            queue = new ArrayList<>(size);
        }

        public void put(int n) throws InterruptedException {
            queue.add(n);
        }

        public int take() throws InterruptedException {
            return queue.remove(0);
        }

        public int size() {
            return queue.size();
        }
    }

    public Producer producer() {
        return new Producer();
    }

    public Consumer consumer() {
        return new Consumer();
    }

    public static void main(String[] args) {
        ProducerAndConsumerProblem pap = new ProducerAndConsumerProblem();
        Producer producer = pap.producer();
        Consumer consumer = pap.consumer();

        int producerNum = 5;
        int consumerNum = 3;

        Thread[] consumers = new Thread[consumerNum];
        Thread[] producers = new Thread[producerNum];
        for (int i = 0; i < producerNum; i++) {
            producers[i] = new Thread(producer);
        }

        for (int i = 0; i < consumerNum; i++) {
            consumers[i] = new Thread(consumer);
        }

//        for (int i = 0; i < producerNum; i++) {
//            producers[i].start();
//        }
//
//        for (int i = 0; i < consumerNum; i++) {
//            consumers[i].start();;
//        }
        producers[0].start();
        consumers[0].start();
        producers[1].start();
        consumers[1].start();
        producers[2].start();
        consumers[2].start();
        producers[3].start();
        producers[4].start();

        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < producerNum; i++) {
            producers[i].interrupt();
        }

        for (int i = 0; i < consumerNum; i++) {
            consumers[i].interrupt();
        }
//        System.out.println("over");
    }
}
