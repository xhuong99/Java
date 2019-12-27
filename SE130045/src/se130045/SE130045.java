/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se130045;

import ui.Menu;
/**
 *
 * @author leehe
 */
import data.Cabinet;
public class SE130045 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Menu menu = new Menu("New Age Shop");
        menu.addNewMenu("1. Add a phone to the list");
        menu.addNewMenu("2. Search a phone by ID");
        menu.addNewMenu("3. Update a phone by ID");
        menu.addNewMenu("4. Remove a phone by ID");
        menu.addNewMenu("5. Print the list of phone in the ascending order of ID");
        menu.addNewMenu("6. Quit");
        
        int choice;
        Cabinet cage = new Cabinet();
        do {
            menu.printMenu();
            choice = menu.getChoice();
            switch(choice){
                case 1:{
                    cage.addNewPhone();
                    break;
                }
                case 2:{
                    cage.doSearch();
                    break;
                }
                case 3:
                    break;
                case 4:{
                    cage.removePhone();
                    break;
                }
                case 5:{
                    cage.printAscending();
                    cage.printList();
                    break;
                }
                case 6: { 
                    System.out.println("Bye~");
                    break;
                }
            }
        } while (choice != 6);
        
    }
    
}
