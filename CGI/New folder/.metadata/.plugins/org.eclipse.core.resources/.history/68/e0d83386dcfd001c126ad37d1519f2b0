package com.cgi.stackroute;
import java.util.Scanner;
public class palindromec {
	public static void main(String[] args) {
		Scanner d=new Scanner(System.in);
		System.out.println("enter the string");
		String str=d.next();
		StringBuffer str1=new StringBuffer(str);
		str1.reverse();
		String data=str1.toString();
		if(str.equals(data)) {
			System.out.println("palindrome");
			StringBuffer stringBuffer = new StringBuffer(str);
			System.out.println("enter the charecter");
			char S=d.next().charAt(0);
			int n=str.length();
			for(int i=1;i<=n+2;i+=2)
			{
				stringBuffer.insert(i, S);
				
			}
			String NewString=stringBuffer.toString();
			System.out.println(NewString);
		}
		else
		{
			System.out.println("not a palindrome");
		}
	}

}

