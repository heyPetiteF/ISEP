package HarryPotter.Game;

import HarryPotter.Background.Background;
import HarryPotter.House.House;
import HarryPotter.Potion.Potion;
import HarryPotter.Wizard.Wizard;

import java.util.Random;
import java.util.Scanner;

import static HarryPotter.Game.Level.Dodge;
import static HarryPotter.Game.Level.HP1;

public class level5 {

    //555555555555555555555555
    public static void level5(){

        Potion.ChoiceUse();

        System.out.println("\n---------------------------------------------LEVEL 5---------------------------------------------");

        String sentence = "\nYou have arrived 【Salle d’examen de Poudlard】......\n" +
                "Here you will use and be subject to attacks of AP.\n" +
                "You need to get and use fireworks to get Dolores Ombrage's attention\n" +
                "Watch out for dodging your opponent's attacks!\n" +
                "Are you ready to fight?\n" +
                "!!!Dolores Ombrage is coming!!!\n";

        Background.print(sentence);

        HP1 = 100;
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        System.out.println("###################################################");
        System.out.println("\nPlease select your tool to get BUSE: \n1. Pencil\n2. Pen\n3. Paper\n4. Notebook");
        System.out.println("###################################################");

        while (HP1 > 0) {
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
                            HP1 -= 40;
                            Wizard.HP -= 10;
                            break;
                        case 3:
                            HP1 -= 50;
                            Wizard.HP -= 5;
                            break;
                        case 4:
                            HP1 -= 80;
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
            if (House.choice == 2){
                if (probability >= 3) { // 30%的概率无效
                    switch (choice) {
                        case 1:
                            HP1 -= 30;
                            Wizard.HP -= 10;
                            break;
                        case 2:
                            HP1 -= 40;
                            Wizard.HP -= 20;
                            break;
                        case 3:
                            HP1 -= 50;
                            Wizard.HP -= 10;
                            break;
                        case 4:
                            HP1 -= 80;
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
                            HP1 -= 30;
                            Wizard.HP -= 5;
                            break;
                        case 2:
                            HP1 -= 40;
                            Wizard.HP -= 10;
                            break;
                        case 3:
                            HP1 -= 50;
                            Wizard.HP -= 5;
                            break;
                        case 4:
                            HP1 -= 80;
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
