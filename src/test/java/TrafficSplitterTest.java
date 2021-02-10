import org.junit.Assert;
import org.junit.Test;
import trafficsplitter.BucketInfo;
import trafficsplitter.Distributor;

import java.util.ArrayList;
import java.util.List;

public class TrafficSplitterTest {

    @Test
    public void splitTest() {
        List<BucketInfo> bucketInfoList = new ArrayList<>();
        bucketInfoList.add(new BucketInfo('a', 5));
        bucketInfoList.add(new BucketInfo('b', 2));
        bucketInfoList.add(new BucketInfo('c', 3));

        Distributor distributor = new Distributor(bucketInfoList);
        int aBucketCount = 0, bBucketCount = 0, cBucketCount = 0;
        for(int i=0;i<100;++i) {
            char bucket = distributor.getNextBucket();
            switch (bucket) {
                case 'a':
                    aBucketCount++;
                    break;
                case 'b':
                    bBucketCount++;
                    break;
                case 'c':
                    cBucketCount++;
                    break;
            }
        }
        Assert.assertEquals(50, aBucketCount);
        Assert.assertEquals(20, bBucketCount);
        Assert.assertEquals(30, cBucketCount);

    }
}
