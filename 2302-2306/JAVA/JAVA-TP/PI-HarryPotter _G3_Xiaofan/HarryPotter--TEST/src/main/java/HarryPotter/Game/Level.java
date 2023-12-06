package HarryPotter.Game;

import HarryPotter.Background.Background;
import HarryPotter.House.House;
import HarryPotter.PlayGame.Game;
import HarryPotter.Potion.Potion;
import HarryPotter.Wizard.Wizard;

import java.util.Random;
import java.util.Scanner;

public class Level {

    public static int HP1 = 100;
    private static int Judgement;

    public static void play(){
        level1.level1();
        if (Judgement == 1){
            Potion.addpotion();
            level2.level2();
            if (Judgement == 1){
                Potion.addpotion();
                level3.level3();
                if (Judgement == 1){
                    Potion.addpotion();
                    level4.level4();
                    if (Judgement == 1){
                        Potion.addpotion();
                        level5.level5();
                        if (Judgement == 1){
                            Potion.addpotion();
                            level6.level6();
                            if (Judgement == 1){
                                Potion.addpotion();
                                level7.level7();
                                if (Judgement == 1){
                                    System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                                    String Final = "----!!!THE BIGGEST CONGRATULATIONS!!!----"+
                                            "\n--YOU HAVE DOMINATED THE WIZARDING WORLD--\n";
                                    Background.print(Final);
                                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                                }else {
                                    System.out.println("Avada Kedavra is too powerful...");
                                    System.out.println("Game over......");
                                }
                            }else {
                                System.out.println("Game over......");
                            }
                        }else {
                            System.out.println("Game over......");
                        }
                    }else {
                        System.out.println("Game over......");
                    }
                }else {
                    System.out.println("Game over......");
                }
            }else {
                System.out.println("Game over......");
            }
        }else {
            System.out.println("Game over......");
        }
    }

    public static void HP1(){
        while (Wizard.HP <= 0) {
            Judgement = 0;
            System.out.println("Oops ...... You have been defeated by the enemy......");
            break;
        }
        while (Wizard.HP > 0) {
            if(HP1 > 0) {
                System.out.println("Enemy is alive, it now has HP of " + HP1 + ".\nKeep fighting!");
            }
            if(HP1 <= 0) {
                Judgement = 1;
                System.out.println("Congratulations !!!The enemy has been defeated by you!!! \n");
                System.out.println("You are moving on to the next level......");
            }
            break;
        }
    }

    public static void Dodge(){
        System.out.println("The enemy dodged your attack!");
        System.out.println("Please attack again!");
        Wizard.HP -= 5;
    }
}