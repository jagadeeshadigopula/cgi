package com.cgi.stackroute;

import java.util.Scanner;

public class Multiple {
	public static void  main(String[] args)
	{
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter the no of values");
		int n = kb.nextInt();
		int arr[]=new int[n];
		int n1=0,n2=0;
		System.out.print("Enter the array values");
		for(int i=0;i<n;i++) {
			arr[i]=kb.nextInt();
		}
		for(int k=0;k<n;k++) {
			if (arr[k]%3==0)
			{
				n1 +=(int)Math.pow(arr[k], 3);
			}
			else {
				n2 +=(int)Math.pow(arr[k],2);
			}
		}
		int s=n1+n2;
		System.out.print(s);
		
		
		
	}

}
