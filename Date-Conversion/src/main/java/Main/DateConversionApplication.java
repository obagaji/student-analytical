package Main;

import java.util.Arrays;

public class DateConversionApplication {

    public static void main(String ...args)
    {

        DigitWord digitWord = new DigitWord();
      int x=  digitWord.getHour();
       int y= digitWord.getMinutes();
        digitWord.displayTime(x,y);

        int [][] testValue = {{1,2,5,2,2},{8,7,2,3,4,5}};
        DuplicateRemoval duplicateRemoval = new DuplicateRemoval();
        int [][]result=duplicateRemoval.removingDuplicate(testValue);
        System.out.println(Arrays.deepToString(result));
        RecursionCalculation recursionCalculation = new RecursionCalculation();
    }
}
