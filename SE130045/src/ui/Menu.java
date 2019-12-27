/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.*;
import java.util.Scanner;
import util.MyToys;

/**
 *
 * @author leehe
 */
public class Menu {
    private String appName;
    private static Scanner sc = new Scanner(System.in);
    private ArrayList<String> list = new ArrayList();

    public Menu(String appName) {
        this.appName = appName;
    }

    public void addNewMenu(String function) {
        list.add(function);
    }
    public void printMenu() {
        System.out.println("Welcome to " + appName + " - @2018 by <SE130045 "
                + "- Nguyen Ho Xuan Huong>");
        System.out.println("Select the options below:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
    
    public int getChoice() {
        int choice;
        String inputMsg = "Choose from 1 to " + list.size() + ": ";
        String errorMsg = "Please choose from 1 to " + list.size();
        return MyToys.getAnIntegerInRange(inputMsg, errorMsg, 1, 7);
    }
    
}
