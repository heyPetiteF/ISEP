package HarryPotter.House;

import HarryPotter.Background.Background;
import HarryPotter.Wizard.Wizard;

import java.util.Scanner;


public class House {

    public static int choice;

    //该函数被Wizard调用
    public static void Choice(){

        String sentence = "\nPlease select the house you wish to move into. "+
                "\nNote that by choosing a house you are choosing the college you will join. "+
                "\n### You have one and only one chance to choose ###\nPlease choose carefully!\n";
        Background.print(sentence);

        Scanner scanner = new Scanner(System.in);
        choice = 0;

        while (true) {
            System.out.println("###################################################");
            System.out.println("Please select the HOUSE you would like to stay at:");
            System.out.println("1. Hufflepuff\n2. Slytherin\n3. Gryffindor\n4. Ravenclaw");
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
            Wizard.HP = 100;
            Wizard.DEF = 100;
            Wizard.SA = 70;
            System.out.println("\nYou have chosen the College: 1. Hufflepuff" );
            System.out.println("Congratulations, you have gained a yellow wand!" );
        }
        else if(choice == 2 ){
            Wizard.HP = 100;
            Wizard.DEF = 100;
            Wizard.SA = 70;
            System.out.println("\nYou have chosen the College: 2. Slytherin" );
            System.out.println("Congratulations, you have gained a silver wand!" );
        }
        else if (choice == 3) {
            Wizard.HP = 100;
            Wizard.DEF = 140;
            Wizard.SA = 70;
            System.out.println("\nYou have chosen the College: 3. Gryffindor" );
            System.out.println("Congratulations, you have gained a red wand!" );
        }
        else if (choice == 4) {
            Wizard.HP = 100;
            Wizard.DEF = 100;
            Wizard.SA = 90;
            System.out.println("\nYou have chosen the College: 4. Ravenclaw" );
            System.out.println("Congratulations, you have gained a bleu wand!" );
        }
        System.out.println("For now, you have an initial Hit Points of " + Wizard.HP + "; an initial Defence of: " + Wizard.DEF + "; and a Skill Accuracy of: "+ Wizard.SA);
    }
}