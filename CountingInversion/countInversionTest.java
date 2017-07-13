package CountingInversion;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by CalvinNguyen on 7/12/17.
 */
public class countInversionTest {
    @Test
    public void countInv() throws Exception {

    }

    @Test
    public void mergeSort() throws Exception {
        countInversion testA = new countInversion(6);
        countInversion testB = new countInversion(8);
        int[] a = new int[]{1,3,5,2,4,6};
        int[] b = new int[]{7,4,1,5,2,8,6,3};
        b = testB.mergeSort(b);
        a = testA.mergeSort(a);
        for (int i :
             b) {
            System.out.println(i);
        }
        assertEquals(14, testB.getNumberInv());
        assertEquals(3, testA.getNumberInv());



    }
    @Test
    public void countSplitInv() throws Exception {

    }

    @Test
    public void sortAndCount() throws Exception {

    }

}