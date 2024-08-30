package org.example;

public class BendingSpoons {


    public static int fo(int n){
        int c = 0;
        while(n >= 0){
            System.out.println("n = " + n);
            System.out.println("n - 2 = " + (n - 2));
            System.out.println("n - 4 = " + (n - 4));
            n = n - 2;
            c = c + n - 2;
            System.out.println("c = " + c);
            System.out.println("----");
        }
        System.out.println("----");
        return c;
    }

}
