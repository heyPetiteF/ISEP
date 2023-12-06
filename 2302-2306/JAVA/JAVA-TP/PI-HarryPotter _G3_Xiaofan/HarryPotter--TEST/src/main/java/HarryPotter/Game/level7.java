package HarryPotter.Game;

import HarryPotter.Background.Background;
import HarryPotter.House.House;
import HarryPotter.Potion.Potion;
import HarryPotter.Wizard.Wizard;

import java.util.Random;
import java.util.Scanner;

import static HarryPotter.Game.Level.Dodge;
import static HarryPotter.Game.Level.HP1;

public class level7 {

    //777777777777777777777777777
    public static void level7(){

        Potion.ChoiceUse();

        System.out.println("\n---------------------------------------------LEVEL 7---------------------------------------------");

        String sentence = "\nYou have arrived 【Poudlard】......\n" +
                "Here you will use and be subject to attacks of AP.\n" +
                "You need to use all your power to defeat your enemies\n" +
                "Watch out for dodging your opponent's attacks!\n" +
                "Are you ready to fight?\n" +
                "!!!Voldemort and Bellatrix Lestrange are coming!!!\n";

        Background.print(sentence);

        HP1 = 100;
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        System.out.println("###################################################");
        System.out.println("!!!Enter 1 for an all-out attack!!!");
        System.out.println("###################################################");

        while (HP1 > 0) {
            int choice = input.nextInt();
            int probability = random.nextInt(10);  // 生成0-9的随机数

            if (House.choice == 4) {
                if (probability >= 1) { // 10%的概率无效
                    switch (choice) {
                        case 1:
                            HP1 -= 100;
                            Wizard.HP -= 0;
                            break;
                        default:
                            System.out.println("An error was entered, please reselect the item: ");
                            continue;
                    }
                    HP1();
                }else{
                    switch (choice) {
                        case 1:
                            HP1 += 100;
                            Wizard.HP -= 100;
                            break;
                        default:
                            System.out.println("An error was entered, please reselect the item: ");
                            continue;
                    }
                    HP1();
                }
            }
            else {
                if (probability >= 3) { // 30%的概率无效
                    switch (choice) {
                        case 1:
                            HP1 -= 100;
                            Wizard.HP -= 0;
                            break;
                        default:
                            System.out.println("An error was entered, please reselect the item: ");
                            continue;
                    }
                    HP1();
                }else {
                    switch (choice) {
                        case 1:
                            HP1 += 100;
                            Wizard.HP -= 100;
                            break;
                        default:
                            System.out.println("An error was entered, please reselect the item: ");
                            continue;
                    }
                    HP1();
                }
            }
        }
    }

}
