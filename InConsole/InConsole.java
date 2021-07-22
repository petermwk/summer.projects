
/**
 * Write a description of class InConsole here.
 *
 * @author (Peter Malinowski)
 * @version (1)
 */
import java.util.Scanner;

public class InConsole
{
    public static void main(String args[])
    {
        var countNumbers = new CountNumbers();

        Scanner in = new Scanner(System.in);

        int start = in.nextInt();
        int end = in.nextInt();

        int[] array = countNumbers.randomNumber(start, end);
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }

        int x = in.nextInt();
        System.out.println("You entered: " + x);

        in.close();


        int result = countNumbers.checkNumbers(x, array);
        System.out.println(x + " (" + result +" times)");
    }


}
