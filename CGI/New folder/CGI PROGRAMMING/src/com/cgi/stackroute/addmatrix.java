package com.cgi.stackroute;

import java.util.Scanner;
public class addmatrix
{
    private static Scanner s;

	public static void main(String[] args) 
    {
        int p, q, m, n;
        s = new Scanner(System.in);
        p = s.nextInt();
        q = s.nextInt();
        m = s.nextInt();
        n = s.nextInt();
        int a[][] = new int[p][q];
        int b[][] = new int[m][n];
        int c[][] = new int[m][n];
        for (int i = 0; i < p; i++) 
          {
             for (int j = 0; j < q; j++) 
              {
                    a[i][j] = s.nextInt();
              }
          }
          for (int i = 0; i < m; i++) 
          {
              for (int j = 0; j < n; j++) 
              {
                   b[i][j] = s.nextInt();
              }
          }
          System.out.println("First Matrix:");
          for (int i = 0; i < p; i++) 
          {
              for (int j = 0; j < q; j++) 
              {
                System.out.print(a[i][j]+" ");
              }
                System.out.println("");
          }
          System.out.println("Second Matrix:");
          for (int i = 0; i < m; i++) 
          {
             for (int j = 0; j < n; j++) 
             {
                  System.out.print(b[i][j]+" ");
             }
                  System.out.println("");
          }
          for (int i = 0; i < p; i++) 
          {
              for (int j = 0; j < n; j++) 
              {4
                for (int k = 0; k < q; k++) 
                    {
                        c[i][j] = a[i][j] + b[i][j];
                    }
              }
          }
          System.out.println("Matrix after addition:");
          for (int i = 0; i < p; i++) 
            {
               for (int j = 0; j < n; j++) 
               {
                    System.out.print(c[i][j]+" ");
               }
               System.out.println("");
            }
        }
       
    }