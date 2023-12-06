package HarryPotter.Game;

import HarryPotter.Background.Background;
import HarryPotter.House.House;
import HarryPotter.Potion.Potion;
import HarryPotter.Wizard.Wizard;

import java.util.Random;
import java.util.Scanner;

import static HarryPotter.Game.Level.Dodge;
import static HarryPotter.Game.Level.HP1;

public class level6 {

    //66666666666666666666666666
    public static void level6() {

        Potion.ChoiceUse();

        System.out.println("\n---------------------------------------------LEVEL 6---------------------------------------------");

        String sentence = "\nYou have arrived 【Tour d’astronomie】......\n" +
                "Here you will use and be subject to attacks of ATN.\n" +
                "You must defeat Mangemorts or join them.\n" +
                "Watch out for dodging your opponent's attacks!\n" +
                "Are you ready to fight?\n" +
                "!!!Mangemorts are coming!!!\n";

        Background.print(sentence);

        HP1 = 100;
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        System.out.println("###################################################");
        System.out.println("Choose your attack: \n1. Direct attack \n2. Join to become a traitor");
        System.out.println("###################################################");

        while (HP1 > 0) {
            int choice = input.nextInt();
            int probability = random.nextInt(10);  // 生成0-9的随机数

            if (House.choice == 4) {
                if (probability >= 1) { // 10%的概率无效
                    switch (choice) {
                        case 1:
                            HP1 -= 50;
                            Wizard.HP -= 5;
                            break;
                        case 2:
                            HP1 -= 100;
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
            }else{
                if (probability >= 3) { // 30%的概率无效
                    switch (choice) {
                        case 1:
                            HP1 -= 50;
                            Wizard.HP -= 5;
                            break;
                        case 2:
                            HP1 -= 100;
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
