package Main;

/*import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extension;*/

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.*;
//@ExtendWith(value = Extension.class)
class DigitWordTest {

    @Test
    void testHashMap()
    {
        HashMap<Integer,String> timeMap = new HashMap<>();
        timeMap.put(0, "O'Clock");
        timeMap.put(1, "one");
        timeMap.put(2, "two");
        timeMap.put(3, "three");
        timeMap.put(4, "four");
        timeMap.put(5, "five");
        timeMap.put(6, "six");
        timeMap.put(7, "seven");
        timeMap.put(8, "eight");
        timeMap.put(9, "nine");
        timeMap.put(10, "ten");
        timeMap.put(11, "eleven");
        timeMap.put(12, "twelve");
        timeMap.put(13, "thirteen");
        timeMap.put(14, "fourteen");
        timeMap.put(15,"quarter pass");
        timeMap.put(16, "sixteen");
        timeMap.put(17, "seventeen");
        timeMap.put(18, "eighteen");
        timeMap.put(19, "nineteen");
        timeMap.put(20, "twenty");
        timeMap.put(21, "twenty-one");
        timeMap.put(22, "twenty-two");
        timeMap.put(23, "twenty-three");
        timeMap.put(24, "twenty-four");
        timeMap.put(25, "twenty-five");
        timeMap.put(26, "twenty-six");
        timeMap.put(27, "twenty-seven");
        timeMap.put(28, "twenty-eight");
        timeMap.put(29, "twenty-nine");
        timeMap.put(30, "half pass");
        timeMap.put(45, "quarter to");
        assertEquals(32,timeMap.size());


    }
    @Test
    void testDisplayTime()
    {
        DigitWord digitWord = new DigitWord();

        int hr = 2;
        int mins = 59;
        String values =digitWord.displayTime(hr,mins);
        StringBuilder builder = new StringBuilder(values);
        String b = builder.toString();
        assertSame("one minute to three", b);

        int h = 6;
        int min = 0;
        String value =digitWord.displayTime(h,min);
        assertSame("six O'Clock", value);


    }

}