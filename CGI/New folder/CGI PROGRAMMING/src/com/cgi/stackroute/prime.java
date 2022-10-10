package com.cgi.stackroute;

public class prime {

	public static void main(String[] args) {
        int i,sum,n;
        for(n=2;n<=50;n++)
        {
        	sum=0;
        	for(i=2;i<=n-1;i++)
        	{
        		if(n%i==0)
        		{
        			sum=sum+1;
        			break;
        		}
        	}
        	if(sum==0)
        		System.out.print(n+" ");
        }
	}
}
        	
 