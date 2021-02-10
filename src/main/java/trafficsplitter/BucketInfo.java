package trafficsplitter;

public class BucketInfo {
    private final int weight;
    private final char bucketId;

    public BucketInfo(char bucketId, int weight) {
        this.bucketId = bucketId;
        this.weight = weight;
    }
    public char getBucketId() {
        return bucketId;
    }
    public int getWeight() {
        return weight;
    }
}
