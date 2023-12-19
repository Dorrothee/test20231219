package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Boruk Daryna");

        Scanner scanner = new Scanner(System.in);
        int n, a, d, l, sum;

        //Input the number of terms for arithmetic progression
        System.out.print("Enter the number of terms (n): ");
        //Read the next integer from the screen
        n = scanner.nextInt();
        if (n<=0){
            System.out.print("Incorrect value of n input. It must be greater then 0");
        }

        System.out.print("Enter the first term in the sequence (a): ");
        a = scanner.nextInt();

        System.out.print("Enter the common difference between terms (d): ");
        d = scanner.nextInt();

        l = a+d*(n-1);
        sum = ((a+l)*n)/2;

        System.out.print("Your Inputs: n - " + n + ", a - " + a + ", d - " + d + ", l - " + l);
        System.out.print("\nSum of a term of A.P. - " + sum);

    }
}