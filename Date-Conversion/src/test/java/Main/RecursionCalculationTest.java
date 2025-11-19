package Main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecursionCalculationTest {

    @Test
    void calculateRecursion() {
        RecursionCalculation recursionCalculation= new RecursionCalculation();
        String re = "1234445123444512344451234445123444512344451234445";
        String sec = "1234445";
       int x= recursionCalculation.calculateRecursion(re);
        int y= recursionCalculation.calculateRecursion(sec);
        assertEquals(161,x);
        assertEquals(23,y);
    }

    @Test
    void furtherRecursiveCalculation() {
        RecursionCalculation recursionCalculation= new RecursionCalculation();
        String re = "1234445123444512344451234445123444512344451234445";
        int x= recursionCalculation.calculateRecursion(re);
        assertEquals(161,x);
        recursionCalculation.furtherRecursiveCalculation(x);
    }
}