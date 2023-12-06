package HarryPotter.Wizard;
import HarryPotter.Background.Background;
import HarryPotter.House.House;
import HarryPotter.Pet.Pet;
import HarryPotter.Potion.Potion;

import java.util.Scanner;

public class Wizard {

    public static int HP;
    public static int DEF;
    public static int SA;

    public static void wizard(){

        Scanner input = new Scanner(System.in);
        int orHP=0 , orDEF=0, orSA=0;

        System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("\nDear Wizard, Please enter your name");
        String name = input.nextLine();
        String sentence1 = "\nHello dear " + name + "\nWelcome to the wizarding world!" +
                "\nYou have an initial Hit Points of 100; an initial Defence of 100; and a Skill Accuracy of 60."+
                "\nNow you need to make some choices, and every choice is important to you. So please make your choices carefully!!\n";
        Background.print(sentence1);

        Scanner scanner = new Scanner(System.in);
        System.out.println("# Press the ENTER to continue your journey #");
        scanner.nextLine();

        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
        House.Choice();
        System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------------------");
        Pet.ChoicePet();
        System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------------------");

        System.out.println("\nYou have completed your full selection!\n");
        Potion.potion();
        System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------------------");

        String sentence2 = "\nI hope you are able to succeed in this amazing world, but I have to say it is treacherous." +
                "\nGood luck!\n";
        Background.print(sentence2);

    }

    public static int getHP(){
        return HP;
    }

    public void setHP(int hp){
        this.HP = hp;
    }


}