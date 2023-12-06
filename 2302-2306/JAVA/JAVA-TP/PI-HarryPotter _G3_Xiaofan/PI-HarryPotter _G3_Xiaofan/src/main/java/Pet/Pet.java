package main.java.Pet;

import java.util.Scanner;

//此函数在Wizard中被调用

public class Pet {
    public static void ChoicePet(){

        System.out.println("\nPlease select your pet.");
        System.out.println("### You have one and only one chance to choose ###");

        Scanner scanner = new Scanner(System.in);
        var choice = 0;

        while (true) {
            System.out.println("###################################################");
            System.out.println("Please select the PET you would like to stay with:");
            System.out.println("1. OWL\n2. RAT\n3. CAT\n4. TOAD");
            System.out.println("###################################################");
            try {
                choice = scanner.nextInt();
                if (choice < 1 || choice > 4) {
                    System.out.println("Enter a number that does not match the requirement, please reselect it.");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Enter a number that does not match the requirement, please reselect it.");
                scanner.nextLine();
            }
        }
        if (choice == 1 ){
           System.out.println("\nNow, you have an owl to keep you company" );
        }
        else if(choice == 2 ){
            System.out.println("\nNow, you have a rat to keep you company" );
        }
        else if (choice == 3) {
            System.out.println("\nNow, you have a cat to keep you company" );
        }
        else if (choice == 4) {
            System.out.println("\nNow, you have a toad to keep you company" );
        }
    }
}
