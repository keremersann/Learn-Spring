import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class MyAssertTest {

    List<String> todos = Arrays.asList("Cloud", "Microservices", "OOP");
    @Test
    public void assertTest(){
        boolean test = todos.contains("Cloud");
        boolean test2 = todos.contains("Calculus");
        assertTrue(test);
        assertFalse(test2);

        assertArrayEquals(new int[] {2,1}, new int[] {2,1});
        assertEquals(3, todos.size());
    }
}
