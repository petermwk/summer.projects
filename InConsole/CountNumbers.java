/**
 * Write a description of class CountNumbers here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Random;


public class CountNumbers
{
    public int[] randomNumber(int min, int max)
    {
        int[] numbers = new int[max];

        Random random = new Random();

        for(int i = 0; i < numbers.length; i++)
        {
            int randomNum = min + random.nextInt(max - min + 1);
            numbers[i] = randomNum;
        }
        return numbers;
    }

    public int checkNumbers(int x, int[] numbers)
    {
        int t = 0;
        for(int i = 0; i < numbers.length; i++)
        {
            if(x == numbers[i])
            {
                t++;  
            }
        }

        return t;
    }
}
