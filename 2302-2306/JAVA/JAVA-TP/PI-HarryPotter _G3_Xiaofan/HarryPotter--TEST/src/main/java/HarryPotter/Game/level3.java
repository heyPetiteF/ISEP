package HarryPotter.Game;

import HarryPotter.Background.Background;
import HarryPotter.House.House;
import HarryPotter.Potion.Potion;
import HarryPotter.Wizard.Wizard;

import java.util.Random;
import java.util.Scanner;

import static HarryPotter.Game.Level.Dodge;
import static HarryPotter.Game.Level.HP1;

public class level3 {

    //333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333
    public static void level3(){

        Potion.ChoiceUse();

        System.out.println("\n---------------------------------------------LEVEL 3---------------------------------------------");

        String sentence = "\nYou have arrived 【Lac dans la Forêt Interdite】......\n" +
                "Here you will use and be subject to attacks of AP.\n" +
                "You must learn the spell and defeat Detractors.\n" +
                "Watch out for dodging your opponent's attacks!\n" +
                "Are you ready to fight?\n" +
                "!!!Detractors are coming!!!\n";

        Background.print(sentence);

        HP1 = 100;
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        System.out.println("###################################################");
        System.out.println("Enter 1 to learn a new spell and use it!");
        System.out.println("###################################################");

        while (HP1 > 0) {
            int choice = input.nextInt();
            int probability = random.nextInt(10);  // 生成0-9的随机数

            if (House.choice == 4) {
                if (probability >= 1) { // 10%的概率无效
                    switch (choice) {
                        case 1:
                            HP1 -= 50;
                            Wizard.HP -= 10;
                            break;
                        default:
                            System.out.println("An error was entered, please reselect the item: ");
                            continue;
                    }
                    HP1();
                }else{
                    Dodge();System.out.println("Enter 1 to learn a new spell and use it!");
                }
            }
            if (House.choice == 2){
                if (probability >= 3) { // 30%的概率无效
                    switch (choice) {
                        case 1:
                            HP1 -= 50;
                            Wizard.HP -= 20;
                            break;
                        default:
                            System.out.println("An error was entered, please reselect the item: ");
                            continue;
                    }
                    HP1();
                }else{
                    Dodge();
                }
            }else{
                if (probability >= 3) { // 30%的概率无效
                    switch (choice) {
                        case 1:
                            HP1 -= 50;
                            Wizard.HP -= 10;
                            break;
                        default:
                            System.out.println("An error was entered, please reselect the item: ");
                            continue;
                    }
                    HP1();
                }else{
                    Dodge();
                }
            }
        }
    }

}
