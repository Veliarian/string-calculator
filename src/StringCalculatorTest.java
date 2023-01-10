import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {

    StringCalculator calculator = new StringCalculator();
    @Test
    public void emptyStringTest(){
        assertEquals(0, calculator.add(""));
    }

    @Test
    public void oneValueTest(){
        assertEquals(1, calculator.add("1"));
        assertEquals(5, calculator.add("5"));
    }

    @Test
    public void twoValueWithComma(){
        assertEquals(3, calculator.add("1,2"));
    }

    @Test
    public void multiplyValues(){
        assertEquals(10, calculator.add("1,4,\n5"));
    }

    @Test
    public void uncorrectedSplitter(){
        assertEquals(1, calculator.add("1,\n"));
    }

    @Test
    public void customSplitter(){
        assertEquals(3, calculator.add("//[;]\n1;;;;2"));
    }

    @Test
    public void multiplySplitter(){
        assertEquals(10, calculator.add("//[;][%][*]\n1;;2%3***4"));
    }
}
