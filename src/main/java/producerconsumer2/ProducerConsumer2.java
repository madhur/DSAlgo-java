package producerconsumer2;


import java.util.Random;

public class ProducerConsumer2 {

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
        i=0;
        buffer= new int[10];
    }

    public synchronized  void add(int item) {
        while(true) {
            if (i < buffer.length) {
                buffer[i] = item;
                i++;
                return;
            }
        }
    }

    public synchronized Integer remove() {
        while(true) {
            if (i > 0) {
                int item = buffer[i];
                i--;
                return item;
            }
        }
    }

}

class Producer implements Runnable {

    IntBuffer sharedResource;

    public Producer( IntBuffer sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {

        while(true) {

            Integer item = new Random().nextInt(10);
            sharedResource.add(item);
            System.out.println("###Produced: " + item);
        }
    }
}

class Consumer implements  Runnable {

    IntBuffer sharedResource;

    public Consumer( IntBuffer sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        while(true) {
            Integer item = sharedResource.remove();
            if (item != null) {
                System.out.println("!!!Consumed: " + item);
            }

        }
    }
}
