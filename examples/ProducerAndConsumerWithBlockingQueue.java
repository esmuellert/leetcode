package examples;

import java.util.concurrent.ArrayBlockingQueue;


public class ProducerAndConsumerWithBlockingQueue {

    private final int BUFFERS = 50;

    private final Buffer buffer = new Buffer(BUFFERS);

    private class Producer implements Runnable {

        private synchronized int produce() {

            try {
                if (buffer.size() == BUFFERS) {
                    System.out.println("Waiting for space.");
                }
                buffer.put(BUFFERS);
                System.out.println(Thread.currentThread().getName() + " produce " + 1 + " product.");
                System.out.println(buffer.size() + " products in buffer");

            } catch (InterruptedException e) {
//                e.printStackTrace();
                return 0;
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

        private synchronized int consume() {

            try {
                if (buffer.size() == 0) {
                    System.out.println("Waiting for product.");
                }
                buffer.take();
                System.out.println(Thread.currentThread().getName() + " consume " + 1 + " product.");
                System.out.println(buffer.size() + " products in buffer");
            } catch (InterruptedException e) {
//                e.printStackTrace();
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

    private static class Buffer {
        private final ArrayBlockingQueue<Integer> queue;

        public Buffer(int size) {
            queue = new ArrayBlockingQueue<>(size, true);
        }

        public void put(int n) throws InterruptedException {
            queue.put(n);
        }

        public int take() throws InterruptedException {
            return queue.take();
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
        ProducerAndConsumerWithBlockingQueue pap = new ProducerAndConsumerWithBlockingQueue();
        Producer producer = pap.producer();
        Consumer consumer = pap.consumer();

        Thread producer_1 = new Thread(producer);
        Thread producer_2 = new Thread(producer);
        Thread consumer_1 = new Thread(consumer);
        Thread consumer_2 = new Thread(consumer);
        Thread producer_3 = new Thread(producer);
        producer_1.start();
        consumer_1.start();
        producer_2.start();
        consumer_2.start();
        producer_3.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        producer_3.interrupt();
        producer_1.interrupt();
        consumer_1.interrupt();
        producer_2.interrupt();
        consumer_2.interrupt();
//        System.out.println("over");
    }
}

