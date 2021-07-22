package InConsole;

import java.util.Scanner;
import java.util.Arrays;

public class Main {
    private static int[] array1;
    private static int[] array2;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int arrLength = in.nextInt();
        setLength(arrLength);

        System.out.println("Array length is: " + arrLength);

        for (int i = 0; i < arrLength; i++) {
            int num = in.nextInt();
            fillArray1(i, num);
        }

        for (int i = 0; i < arrLength; i++) {
            int num = in.nextInt();
            fillArray2(i, num);
        }

        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i] + " ");
        }

        System.out.println();

        for (int i = 0; i < array2.length; i++) {
            System.out.print(array2[i] + " ");
        }

        System.out.println();

        if(compareArr1and2() == true){
            System.out.println("They are equal!");
        }else{
            System.out.println("They are not equal!");
        }

        in.close();
    }


    private static void setLength(int length) {
        if (1 <= length && length <= 20) {
            array1 = new int[length];
            array2 = new int[length];
        } else {
            System.out.println("ERROR");
        }
    }

    private static void fillArray1(int index, int number) {
        if (index >= array1.length || index < 0) {
            System.out.println("ERROR");
        } else {
            array1[index] = number;
        }
    }

    private static void fillArray2(int index, int number) {
        if (index >= array2.length || index < 0) {
            System.out.println("ERROR");
        } else {
            array2[index] = number;
        }
    }

    private static void compareArray1and2() {
        if(Arrays.equals(array1, array2)) {
            System.out.println("They are equal!");
        } else {
            System.out.println("They are not equal!");
        }
    }

    private static boolean compareArr1and2(){
        for(int i = 0; i < array1.length; i++){
           if(array1[i] != array2[i]){
              return false;
           }
        }
        return true;
    }
}

