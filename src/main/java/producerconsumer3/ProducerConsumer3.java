package producerconsumer3;


import java.util.Random;

public class ProducerConsumer3 {

    public static void main(String[] args) {

        IntBuffer buffer = new IntBuffer();
        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);
        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();
    }

}

class IntBuffer {
    int[] buffer;
    int i;

    public IntBuffer() {
        i = 0;
        buffer = new int[10];
    }

    public synchronized void add(int item) {
        while (i == buffer.length - 1) {

            try {
                wait();
            } catch (InterruptedException e) {

            }
            buffer[i] = item;
            i++;
            notifyAll();
        }
    }

    public synchronized Integer remove() {
        while (i == 0) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        int item = buffer[i];
        i--;
        notifyAll();
        return item;

    }

}

class Producer implements Runnable {

    IntBuffer sharedResource;

    public Producer(IntBuffer sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {

        while (true) {

            Integer item = new Random().nextInt(10);
            sharedResource.add(item);
            System.out.println("###Produced: " + item);
        }
    }
}

class Consumer implements Runnable {

    IntBuffer sharedResource;

    public Consumer(IntBuffer sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        while (true) {
            Integer item = sharedResource.remove();
            if (item != null) {
                System.out.println("!!!Consumed: " + item);
            }

        }
    }
}
