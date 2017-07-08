package IntegerMultiplication;

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

        assertTrue(obj.mul("3141592653589793","2718281828459045").equals("8539734222673565677848730527685"));


        assertTrue(obj.mul("3141592653589793238462643383279502884197169399375105820974944592","27182818284590452353602874713").equals("853973422267356706546355086916501913353778273604680490216"));


        assertTrue(obj.mul("3141592653589793238462643383279502884197169399375105820974944592","2718281828459045235360287471352662497757247093699959574966967627").equals(
                "8539734222673567065463550869546574495034888535765114961879601127067743044893204848617875072216249073013374895871952806582723184"));

    }


}