package com.cgi.stackroute;

public class Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int sum = 0;
		double avg = 0;

		for(int x: nums)
		{
		   sum = sum + x;
		   avg=sum/10;
		}
		System.out.print("sum="+sum);
		System.out.print("\n"+"average="+avg);

	}

}
