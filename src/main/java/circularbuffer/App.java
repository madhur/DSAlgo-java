package circularbuffer;

public class App {



    public static void main(String[] args) {

        RingBufferFlipMarker buffer = new RingBufferFlipMarker(10);
        System.out.println(buffer.capacity());
        buffer.put(5);
        System.out.println(buffer.capacity());
        buffer.put(6);
        System.out.println(buffer.capacity());
        buffer.put(7);
        buffer.put(8);
        buffer.put(9);
        buffer.put(10);
        buffer.put(11);
        buffer.put(12);
        buffer.put(13);
        buffer.put(14);
        buffer.put(15);
        buffer.put(16);
        buffer.put(17);

        System.out.println(buffer.capacity());

        System.out.println(buffer.take());
        System.out.println(buffer.take());
        System.out.println(buffer.take());

        System.out.println(buffer.capacity());

    }
}
