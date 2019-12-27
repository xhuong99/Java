package data;

import data.Phone;
import java.util.Scanner;
import java.util.*;
import util.MyToys;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author leehe
 */
public class Cabinet {
    private static Scanner sc = new Scanner(System.in);
    private ArrayList<Phone> list = new ArrayList();
    
    public void addNewPhone() {
        String id, model, camera;
        double price;
        Phone x;
        do {
            id = MyToys.getString("Input Phone ID: ", "Phone ID is required!","^\\d{6}$");
            x = searchPhoneObjbyID(id);
            if (x != null){
                System.out.println("Phone ID had already!");
            }
        } while (x != null);
        model = MyToys.getString("Input Phone model: ", "Input again!");
        camera = MyToys.getString("Input phone camera: ", "Input again!");
        price = MyToys.getDouble("Input phone price: ", "Input again!");
        list.add(new Phone(id, model, camera, price));
        System.out.println("Added!!!");
    }
    
    public Phone searchPhoneObjbyID(String id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equalsIgnoreCase(id)) 
                return list.get(i);            
        }
        return null;
    }
    
    public void doSearch() {
        String n;
        Phone x;
        n = MyToys.getString("Input Phone ID you want to search: ", "Try again!");
        x = searchPhoneObjbyID(n);
        if (x != null) {
            System.out.println("Founded!");
            x.showDetailed();
        }
        else System.out.println("Not found!");
    }
    
    public void removePhone() {
        String n;
        Phone x;
        n = MyToys.getString("Input Phone ID you want to remove: ", "Try again!");
        x = searchPhoneObjbyID(n);
        if (x != null) {
            list.remove(x);
            System.out.println("Removed!");
        }
        else System.out.println("Not found!");
    }
    
    public void printAscending () {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i; j < list.size(); j++) {
                if (list.get(i).getId().compareToIgnoreCase(list.get(j).getId()) > 0) {
                    Phone tmp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, tmp);
                }
            }
        }
    }
    
    public void printList() {
        System.out.println("Print!");
        for (Phone x : list) {
            x.showDetailed();
        }
    }
}
