package examples;

import org.junit.Test;

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

        private void produce() throws InterruptedException {
            lock.lock();

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


        }

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    produce();
                } catch (InterruptedException e) {
//                    e.printStackTrace();
                    break;
                } finally {
                    lock.unlock();
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }

    private class Consumer implements Runnable {

        private void consume() throws InterruptedException {
            lock.lock();

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

        }

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    consume();
                } catch (InterruptedException e) {
//                    e.printStackTrace();
                    break;
                } finally {
                    lock.unlock();
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }

    public Producer producer() {
        return new Producer();
    }

    public Consumer consumer() {
        return new Consumer();
    }

    private static class Buffer {
        private final ArrayList<Integer> queue;

        public Buffer(int size) {
            queue = new ArrayList<>(size);
        }

        public void put(int n) {
            queue.add(n);
        }

        public int take() {
            return queue.remove(0);
        }

        public int size() {
            return queue.size();
        }
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
            producers[i].start();
        }

        for (int i = 0; i < consumerNum; i++) {
            consumers[i] = new Thread(consumer);
            consumers[i].start();
        }


        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < producerNum; i++) {
            producers[i].interrupt();
        }

        for (int i = 0; i < consumerNum; i++) {
            consumers[i].interrupt();
        }
    }

//    @Test
//    public void test() {
//        for (int i = 0; i < 2; i++) {
//            ProducerAndConsumerProblem.main(null);
//        }
//    }
}
