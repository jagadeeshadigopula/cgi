package com.cgi.stackroute;
import java.util.Scanner;
public class Fibonacci {

    public static void main(String[] args) {
    	Scanner kb= new Scanner(System.in);
    	System.out.print(" Enter how many numbers u want in sequence ");
    	int c = kb.nextInt();
        int num1 = 0, num2 = 1;
        System.out.print("Fibonacci Series of "+c+" numbers:");

        for (int i = 1; i <= c; ++i)
        {
            System.out.print(num1+" ");
            int sumOfPrevTwo = num1 + num2;
            num1 = num2;
            num2 = sumOfPrevTwo;
        }
    }
}