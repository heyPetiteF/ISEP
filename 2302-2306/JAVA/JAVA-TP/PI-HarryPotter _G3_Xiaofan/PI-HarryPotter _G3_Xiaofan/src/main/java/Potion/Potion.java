package main.java.Potion;

import main.java.BG.Background;
import main.java.Wizard.Wizard;
import main.java.House.House;

import java.util.Scanner;

public class Potion {

    public static int NumPotion = 1;

    public static void potion(){
        String sentence = "Congratulations on your acquisition of a magic potion.\n" +
                "This potion will help you to restore your Hit Points."+
                "\nYou now have 1 bottle of potion.\n";

        Background.print(sentence);
    }

    public static void ChoiceUse() {
        System.out.println("Rest ...... ");
        System.out.println("You could use a potion to restore your vitality.");
        System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------------------");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Now, your HP is: " + Wizard.HP);

        System.out.println("Use of potions or not (y/n): ");
        String choice = scanner.nextLine();
        Wizard myWizard = new Wizard();

        if (choice.equalsIgnoreCase("y")) { // 用户选择使用药水
            if (NumPotion < 1) {
                System.out.println("You have no potions.");
            } else {
                if (Wizard.getHP() > 80) {
                    System.out.println("Your current Hit Points is greater than 80, you do not need to use a potion!");
                } else {
                    usepotion(myWizard); // 执行使用药水的函数
                }
            }
        } else { // 用户选择不使用药水
            System.out.println("You choose not to use the potion.");
        }
    }


    public static void usepotion(Wizard wizard) {
        System.out.println("The potion is in effect ......");

        if(House.choice == 1){
            wizard.setHP(wizard.getHP() + 20);
            Potion.NumPotion -= NumPotion;
            System.out.println("As you belong to Hufflepuf, you are recovering HP significantly......");
        }
        if(House.choice == 2 || House.choice == 3||House.choice == 4){
            wizard.setHP(wizard.getHP() + 10);
            Potion.NumPotion -= NumPotion;
        }

        System.out.println("The potion has taken effect and your current HP is " + wizard.getHP());
        System.out.println("You now have "+ NumPotion + " bottle of potion left.");
    }

    public static void addpotion(){

        NumPotion += 1;
        System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Congratulations on passing the previous level.");
        System.out.println("As a reward, you get a potion");
        System.out.println("You now have "+ NumPotion + " bottle of potion left.");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");



    }

}
