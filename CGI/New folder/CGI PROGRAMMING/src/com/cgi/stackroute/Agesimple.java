package com.cgi.stackroute;
import java.util.Scanner;
public class Agesimple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float simple;
		System.out.println("enter the principle amount ,age and time");
		Scanner c= new Scanner(System.in);
		float a = c.nextFloat();
		float d = c.nextFloat();
		float e = c.nextFloat();
		
		float si;
		if(d<18)
		{
			si=((a*6*e)/100);
		}
		else if(a>=18 && a<=60)
		{
			si=((a*8*e)/100);
		}
		else 
		{
			si=((a*10*e)/100);
		}
		System.out.println("simple interst by age="+si);

	}

}
