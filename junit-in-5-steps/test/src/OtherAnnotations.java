import org.junit.jupiter.api.*;

public class OtherAnnotations {
    @BeforeAll
    static public void beforeAll(){
        System.out.println("Before All");
    }
    @BeforeEach
    public void beforeEach(){
        System.out.println("Before Each");
    }
    @Test
    public void test(){
        System.out.println("Test");
    }
    @Test
    public void test2(){
        System.out.println("Test2");
    }
    @Test
    public void test3(){
        System.out.println("Test3");
    }
    @AfterEach
    public void afterEach(){
        System.out.println("After Each");
    }
    @AfterAll
    static public void afterAll(){
        System.out.println("After All");
    }
}
