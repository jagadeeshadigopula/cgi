package com.cgi.stackroute;
import java.util.Scanner;
public class simpleinterest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float p, r, t, sinterest;
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the Principal : ");
        p = scan.nextFloat();
        System.out.print("Enter the Rate of interest : ");
        r = scan.nextFloat();
        System.out.print("Enter the Time period : ");
        t = scan.nextFloat();
        sinterest = (p * r * t) / 100;
        System.out.print("Simple Interest is: " +sinterest);

	}

}
