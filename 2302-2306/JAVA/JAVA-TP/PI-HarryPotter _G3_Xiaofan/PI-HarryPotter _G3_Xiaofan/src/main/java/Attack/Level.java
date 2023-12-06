package main.java.Attack;

import main.java.BG.Background;
import main.java.House.House;
import main.java.Potion.Potion;
import main.java.Wizard.Wizard;

import java.util.Random;
import java.util.Scanner;

public class Level {

    static int HP1 = 100;
    private static int Judgement;

    public static void play(){
        level1();
        if (Judgement == 1){
            Potion.addpotion();
            level2();
            if (Judgement == 1){
                Potion.addpotion();
                level3();
                if (Judgement == 1){
                    Potion.addpotion();
                    level4();
                    if (Judgement == 1){
                        Potion.addpotion();
                        level5();
                        if (Judgement == 1){
                            Potion.addpotion();
                            level6();
                            if (Judgement == 1){
                                Potion.addpotion();
                                level7();
                                if (Judgement == 1){
                                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                                    String Final = "\n!!!THE BIGGEST CONGRATULATIONS!!!"+
                                    "\nYOU HAVE DOMINATED THE WIZARDING WORLD\n";
                                    Background.print(Final);
                                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                                }
                                if (Judgement == 0){
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

    //444444444444444444444444
    public static void level4(){

        Potion.ChoiceUse();

        System.out.println("\n---------------------------------------------LEVEL 4---------------------------------------------");

        String sentence = "\nYou have arrived 【Cimetière de Little Hangleton】......\n" +
                "Here you will use and be subject to attacks of AP.\n" +
                "To survive, you must stay close to Portkey\n" +
                "Watch out for dodging your opponent's attacks!\n" +
                "Are you ready to fight?\n" +
                "!!!Voldemort and Peter Pettigrew are coming!!!\n";

        Background.print(sentence);

        HP1 = 100;
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        System.out.println("###################################################");
        System.out.println("Choose your method of movement: \n1. Jump \n2. Magic Flight");
        System.out.println("###################################################");

        while (HP1 > 0) {
            int choice = input.nextInt();
            int probability = random.nextInt(10);  // 生成0-9的随机数
            if (House.choice == 4) {
                if (probability >= 1) { // 10%的概率无效
                    switch (choice) {
                        case 1:
                            HP1 -= 50;
                            Wizard.HP -= 15;
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
            if (House.choice == 2){
                if (probability >= 3) { // 30%的概率无效
                    switch (choice) {
                        case 1:
                            HP1 -= 50;
                            Wizard.HP -= 50;
                            break;
                        case 2:
                            HP1 -= 100;
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
                            Wizard.HP -= 25;
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
