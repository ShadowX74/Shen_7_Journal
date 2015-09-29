/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shen_7_evens;

/**
 *
 * @author ShadowX
 */
public class Shen_7_Evens {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int evens = 0;
        int odds = 0;
        for(int i = 0; i < 100; i++) {
            //What happens in the loop 
            //will happen again and again 
            //until the loop exits
            if(isEven(i)) {
                System.out.println(i + " is even!");
                evens++;
            } else if(isOdd(i)) {
                System.out.println(i + " is odd!");
                odds++;
            }
            if(isPrime(i)) {
                System.out.println(i + " is prime!");
            }
        }
        System.out.println("There are " + evens + " even numbers.");
        System.out.println("There are " + odds + " odd numbers.");
        /*
        A method is like a little program
        A method is an action you want to
        repeat frequently
        */
    }
    static boolean isEven (int somenumber) {
        return (somenumber % 2 == 0);
    }
    static boolean isOdd (int somenumber) {
        return (somenumber % 2 != 0);
    }
    static boolean isPrime (int somenumber) {
        int divisor = 0;
        for (int i = 2; i <somenumber; i++) {
            if (somenumber % i == 0){
                divisor++;
                }
            }
        return divisor == 0;
    }
}