package HarryPotter.Game;

import HarryPotter.Background.Background;
import HarryPotter.House.House;
import HarryPotter.Potion.Potion;
import HarryPotter.Wizard.Wizard;

import java.util.Random;
import java.util.Scanner;

import static HarryPotter.Game.Level.Dodge;
import static HarryPotter.Game.Level.HP1;

public class level2 {

    //2222222222222222222222222222222222222222222222222222222222222222222222222222
    public static void level2(){

        Potion.ChoiceUse();

        System.out.println("\n---------------------------------------------LEVEL 2---------------------------------------------");

        String sentence = "\nYou have arrived 【Chambre des secrets】......\n" +
                "Here you will use and be subject to attacks of ATN.\n" +
                "You must defeat Basilic in your own way.\n" +
                "Watch out for dodging your opponent's attacks!\n" +
                "Are you ready to fight?\n" +
                "!!!Basilic is coming!!!\n";

        Background.print(sentence);

        HP1 = 100;
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        while (HP1 > 0) {
            if (House.choice == 3) {
                System.out.println("###################################################");
                System.out.println("Choose your attack: \n1. call upon the legendary sword of Godric Gryffindor \n2. Attack Basilic's teeth");
                System.out.println("###################################################");
                int choice = input.nextInt();
                int probability = random.nextInt(10);  // 生成0-9的随机数
                if (probability >= 3) { // 30%的概率无效
                    switch (choice) {
                        case 1:
                            HP1 -= 100;
                            Wizard.HP -= 0;
                            break;
                        case 2:
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
            if (House.choice == 4) {
                System.out.println("###################################################");
                System.out.println("Enter 1 to attack Basilic's teeth");
                System.out.println("###################################################");
                int choice = input.nextInt();
                int probability = random.nextInt(10);  // 生成0-9的随机数
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
                    Dodge();
                }
            }
            if(House.choice == 1 || House.choice == 2){
                System.out.println("###################################################");
                System.out.println("Enter 1 to attack Basilic's teeth");
                System.out.println("###################################################");
                int choice = input.nextInt();
                int probability = random.nextInt(10);  // 生成0-9的随机数
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
