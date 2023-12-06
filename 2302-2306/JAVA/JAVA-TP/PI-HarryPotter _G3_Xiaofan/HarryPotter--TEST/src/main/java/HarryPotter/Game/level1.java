package HarryPotter.Game;

import HarryPotter.Background.Background;
import HarryPotter.House.House;
import HarryPotter.Wizard.Wizard;

import java.util.Random;
import java.util.Scanner;

import static HarryPotter.Game.Level.Dodge;
import static HarryPotter.Game.Level.HP1;

public class level1 {

    //111111111111111111111111
    public static void level1() {

        System.out.println("\n---------------------------------------------LEVEL 1---------------------------------------------");

        String sentence = "\nYou have arrived 【Toilettes du donjon】......\n" +
                "Here you will use and be subject to attacks of ATN.\n" +
                "You can throw things at your enemies.\n" +
                "Watch out for dodging your opponent's attacks!\n" +
                "Are you ready to fight?\n" +
                "!!!Troll is coming!!!\n";

        Background.print(sentence);

        HP1 = 100;
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        while (HP1 > 0) {
            System.out.println("###################################################");
            System.out.println("Please select the items you want to throw: \n1. mirror\n2. sink\n3. toilet\n4. toilet roll");
            System.out.println("###################################################");

            int choice = input.nextInt();
            int probability = random.nextInt(10);  // 生成0-9的随机数

            if (House.choice == 4) {
                if (probability >= 1) { // 10%的概率无效
                    switch (choice) {
                        case 1:
                            HP1 -= 30;
                            Wizard.HP -= 5;
                            break;
                        case 2:
                            HP1 -= 60;
                            Wizard.HP -= 5;
                            break;
                        case 3:
                            HP1 -= 100;
                            Wizard.HP -= 5;
                            break;
                        case 4:
                            HP1 -= 15;
                            Wizard.HP -= 5;
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
                            HP1 -= 30;
                            Wizard.HP -= 5;
                            break;
                        case 2:
                            HP1 -= 60;
                            Wizard.HP -= 5;
                            break;
                        case 3:
                            HP1 -= 100;
                            Wizard.HP -= 5;
                            break;
                        case 4:
                            HP1 -= 15;
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
