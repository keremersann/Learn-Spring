import junit.MyMath;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class MyMathTest {
    MyMath myMath = new MyMath();
    @Test
    void test(){
        assertEquals(6, myMath.calculateSum(new int[] {1,2,3}));
    }
    @Test
    void test2(){
        assertEquals(0, myMath.calculateSum(new int[] {}));
    }
}
