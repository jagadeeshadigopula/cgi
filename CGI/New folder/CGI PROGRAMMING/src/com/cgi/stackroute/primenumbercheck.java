package com.cgi.stackroute;
import java.util.Scanner;
public class primenumbercheck {
	   public static void main(String args[])
	   {		
		int temp;
		boolean Prime=true;
		Scanner scan= new Scanner(System.in);
		System.out.println("Enter a number:");
		int num=scan.nextInt();
	        scan.close();
		for(int i=2;i<=num/2;i++)
		{
	           temp=num%i;
		   if(temp==0)
		   {
		      Prime=false;
		      break;
		   }
		}
		if(Prime)
		   System.out.println(num + " is a Prime Number");
		else
		   System.out.println(num + " is not a Prime Number");
	   }
	}
