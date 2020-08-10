package examples;

import java.util.concurrent.ArrayBlockingQueue;


public class ProducerAndConsumerWithBlockingQueue {
    private static class Buffer {
        private final ArrayBlockingQueue<Integer> queue;

        public Buffer(int size) {
            queue = new ArrayBlockingQueue<>(size);
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

    private final int BUFFERS = 20;

    private final Buffer buffer = new Buffer(BUFFERS);

    private class Producer implements Runnable {

        private synchronized void produce() throws InterruptedException {
            if (buffer.size() == BUFFERS) {
                System.out.println("Waiting for space.");
            }
            buffer.put(BUFFERS);
            System.out.println(Thread.currentThread().getName() + " produce " + 1 + " product.");
            System.out.println(buffer.size() + " products in buffer");
        }

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    produce();
                } catch (InterruptedException e) {
                    break;
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

        private synchronized void consume() throws InterruptedException {
            if (buffer.size() == 0) {
                System.out.println("Waiting for product.");
            }
            buffer.take();
            System.out.println(Thread.currentThread().getName() + " consume " + 1 + " product.");
            System.out.println(buffer.size() + " products in buffer");
        }

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    consume();
                } catch (InterruptedException e) {
                    break;
                }
                try {
                    Thread.sleep(1000);
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

    public static void main(String[] args) {
        ProducerAndConsumerWithBlockingQueue pap = new ProducerAndConsumerWithBlockingQueue();
        Producer producer = pap.new Producer();
        Consumer consumer = pap.new Consumer();

        int producerNum = 4;
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
            Thread.sleep(12000);
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
}

