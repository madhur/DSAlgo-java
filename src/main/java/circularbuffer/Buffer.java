package circularbuffer;

public class Buffer {

    int[] buffer = new int[10];
    int start;
    int end;
    int capacity;

    public Buffer() {
        start = 0;
        end =0;
        capacity = buffer.length;
    }

    public void produce(Integer n) {

        if(end == buffer.length) {
            end = 0;
        }
        if(start == buffer.length) {
            start = 0;
        }
        if(start < buffer.length) {
            buffer[end++] = n;

            if(capacity > 0) {
                --capacity;
            }

        }
    }

    public Integer consume() {

        // Nothing to consume
        if(capacity == buffer.length) {
            return null;
        }

        if(capacity < buffer.length) {
            ++capacity;
        }

        if(end > start) {
            return buffer[start++];
        }
        else
            return buffer[end++];


    }

    public String capacity() {
        return "capacity: " + (capacity);
    }

}
