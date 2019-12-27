/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.*;
import java.util.Scanner;

/**
 *
 * @author leehe
 */
public class MyToys {
    private static Scanner sc = new Scanner(System.in);
    
    public static int getAnIntegerInRange(String inputMsg, String errorMsg, int low, int up) {
        int n, temp;
        if (low > up){
            temp = low;
            low = up;
            up = temp;          
        }
        while(true){
            try {
                System.out.print(inputMsg);
                n = Integer.parseInt(sc.nextLine());
                if (n < low || n > up)
                    throw new Exception();
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }
    
    public static double getDouble(String inputMsg, String errorMsg) {
        double n;
        while(true){
            try {
                System.out.print(inputMsg);
                n = Integer.parseInt(sc.nextLine());
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }
    
    public static String getString (String inputMsg, String errorMsg) {
        String n;
        while(true) {
            System.out.print(inputMsg);
            n = sc.nextLine().trim();
            if (n.isEmpty() || n.length() == 0)
                return errorMsg;
            else return n;
        }
    }
    
    public static String getString (String inputMsg, String errorMsg, String format) {
        String n;
        boolean chk;
        while(true) {
            System.out.print(inputMsg);
            n = sc.nextLine().trim();
            chk = n.matches(format);
            if (n.isEmpty() || n.length() == 0 || chk == false)
                return errorMsg;
            else return n;
        }
    }
}
