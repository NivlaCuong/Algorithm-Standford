import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by CalvinNguyen on 7/8/17.
 */
public class integerMulTest {
    @Test
    public void mul() throws Exception {
        integerMul obj = new integerMul();
        assertTrue(obj.mul("1","1").equals("1"));
        assertTrue(obj.mul("12","34").equals("408"));
        assertTrue(obj.mul("123","456").equals("56088"));
        assertTrue(obj.mul("182472","124821").equals("22776337512"));
        assertTrue(obj.mul("1800024","8704821").equals("15668886715704"));
        assertTrue(obj.mul("3141592653589793","2718281828459045").equals("15668886715704"));
        assertTrue(obj.mul("1800024","8704821").equals("15668886715704"));
        assertTrue(obj.mul("1800024","8704821").equals("15668886715704"));
        assertTrue(obj.mul("1800024","8704821").equals("15668886715704"));



    }


}