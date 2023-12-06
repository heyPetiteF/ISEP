//TP1

import java.util.Scanner;
import static java.lang.String.valueOf;

public class Main {
    public static void main(String[]args) {
        Scanner scanner = new Scanner(System.in);
//QUESTION4
        System.out.println("Entrez un entiers et un nombre arbitraire:");

        int unEntier = scanner.nextInt();
        float unReel = scanner.nextFloat();

        System.out.println("J’ai recupere un entier: " + unEntier);
        System.out.println("J’ai aussi recupere un reel: " + unReel);



//QUESTION4.1
        System.out.println("la prochaine operation est:");
        String operation = scanner.nextLine();

        System.out.println("Bonjour, quel est votre prénom?");

        Scanner name = new Scanner(System.in);
        String prenom = name.nextLine();

        System.out.println("Bonjour, " + prenom);

//QUESTION5.1
        System.out.println("Enter pour la prochaine operation:");
        operation = scanner.nextLine();
        somme();

//QUESTION5.2
        System.out.println("Enter pour la prochaine operation:");
        operation = scanner.nextLine();
        division();

//QUESTION5.3
        System.out.println("Enter pour la prochaine operation:");
        operation = scanner.nextLine();
        volume();

        System.out.println("C'est fini!" );
    }
    public static void somme() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Veuillez saisir le premier entier");
        int premierEntier = scanner.nextInt();
        System.out.println("Veuillez saisir le deuxieme entier");
        int deuxiemeEntier = scanner.nextInt();

        int somme = premierEntier + deuxiemeEntier;
        System.out.println("La somme de " + premierEntier + " avec " + deuxiemeEntier + " est egale a " + somme);
    }

    public static void division() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Veuillez saisir le premier entier");
        int premierEntier = scanner.nextInt();
        System.out.println("Veuillez saisir le deuxieme entier");
        int deuxiemeEntier = scanner.nextInt();


        float value = (float) premierEntier / (float) deuxiemeEntier;
        System.out.println("Le resultat de " + premierEntier + " par " + deuxiemeEntier + " est " + value);
    }

    public static void volume(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Veuillez saisir la longueur");
        float longueur = scanner.nextFloat();
        System.out.println("Veuillez saisir la largeur");
        float largeur = scanner.nextFloat();
        System.out.println("Veuillez saisir la hauteur");
        float hauteur = scanner.nextFloat();

        float volume = longueur * largeur * hauteur;
        System.out.println("Le valume de le pave droit est " + volume);
    }
}
