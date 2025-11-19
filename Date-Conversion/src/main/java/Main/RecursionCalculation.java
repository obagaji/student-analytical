package Main;

public class RecursionCalculation {

    public RecursionCalculation()
    {

    }
    /*
    * This method returns the value of the calculated Recursive call.
    * The Parameter is a String, that hold the values to be converted.
    * A conversion to a char array is done through the string to Char Array method.
    * The actual recursive method is a method that is called inside this method. the char array generated is
    *  passed to this method and argument.
    * The return type is a call to the utility firstCalculationRecursive method.
    * */
    public int calculateRecursion(String value)
    {
        char[] arrayValue = value.toCharArray();
        int [] intValue = new int[arrayValue.length];
        for (int i=0; i<arrayValue.length; i++)
        {
            intValue[i]= Character.getNumericValue(arrayValue[i]);
        }
        return firstCalculationRecursion(intValue, intValue.length);
    }
    /*
    * This method actually make the recursive call to generate the solution.
    * The parameter passed are the int array, and the index length to work with.
    * The base case is generated from the state of the index.
    * */
    private int firstCalculationRecursion(int [] value, int index)
    {
        int result = 0 ;
        if (index == 0 )
         return result;
        --index;
                result += value[index];

        return result + firstCalculationRecursion( value, index);
    }
    public int furtherRecursiveCalculation( int valueAnswer)
    {
        while(valueAnswer>10)
        {
            String reValue = Integer.toString(valueAnswer);
             valueAnswer = calculateRecursion(reValue);
        }
        return valueAnswer;
    }

}
