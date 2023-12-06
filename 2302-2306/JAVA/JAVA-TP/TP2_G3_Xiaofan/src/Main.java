import javax.lang.model.util.ElementScanner6;
import java.net.PortUnreachableException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(
                "1. Discriminant\n" +
                "2. Parité d’un nombre\n" +
                "3. Calcul d’extremum\n" +
                "4. Égalité entre chaînes de caractères\n" +
                "5. Factorielle\n" +
                "6. Compte à rebous\n" +
                "7. Valeurs de carrés\n" +
                "8. Table de multiplication\n" +
                "9. Division d’entiers\n" +
                "10. Règle graduée\n" +
                "11. Nombres premiers\n" +
                "12. Manipulations sur un tableau\n"+
                "Quel exercice ? Saisissez :\n");

        int choix = scanner.nextInt();

        switch (choix){
            case 1:
                discriminant();
                break;
            case 2:
                parite();
                break;
            case 3:
                max();
                min();
                break;
            case 4:
                egaliteStr();
                break;
            case 5:
                factorielle();
                break;
            case 6:
                countdown();
                break;
            case 7:
                carres();
                break;
            case 8:
                tableMultiplication();
                break;
            case 9:
                division();
                break;
            case 10:
                regle();
                break;
            case 11:
                nombrePremier();
                break;
            case 12:
                initialisationTableau();
                int[] tableau = {1,3,5,7,9};
                inversetableau(tableau);
                break;
            default:
                System.out.println("default");
        }
    }

    //TP2-3.1.1 [1]Discriminant
    public static void discriminant() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("pour f(x) = a*x^2+b*x+c:");
        System.out.println("Quelle est la valeur de a ?");
        int a = scanner.nextInt();
        System.out.println("Quelle est la valeur de b ?");
        int b = scanner.nextInt();
        System.out.println("Quelle est la valeur de c ?");
        int c = scanner.nextInt();
        int delta = (int) (Math.pow(b, 2) - 4 * a * c);

        if (delta < 0) {
            System.out.println("Ce polynome n’a pas de racine reelle!");
            float b1 = (float) (-b) / (2 * a);
            float i1 = (float) (Math.sqrt(-delta)) / (2 * a);
            System.out.println("les racines complexes sont:");
            System.out.printf("X0 = " + String.valueOf(b1) + "+" + String.valueOf(i1) + "i");
            System.out.println();
            System.out.printf("X1 = " + String.valueOf(b1) + "-" + String.valueOf(i1) + "i");
        }
        if (delta == 0) {
            System.out.println("Ce polynome a une racine double!");
            System.out.println("la racine double est:");
            float x0 = (float) (-b / 2 * a);
            System.out.println(x0);
        }
        if(delta > 0){
            System.out.println("Ce polynome a deux racines!");
            float x0 = (float) ((-b) + (Math.sqrt(delta))) / (2 * a);
            float x1 = (float) ((-b) - (Math.sqrt(delta))) / (2 * a);
            System.out.printf("X0 = " + String.valueOf(x0));
            System.out.println();
            System.out.printf("X1 = " + String.valueOf(x1));
        }
    }

    //TP2-3.1.2 [2]Parité d’un nombre
    public static void parite() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisissez un nombre entier");
        int num = scanner.nextInt();
        float m = num / 2;
        if (m == 0) {
            System.out.println(num + " est pair");
        } else {
            System.out.println(num + " est impair");
        }
    }

    //TP2-3.1.3-2 [3]Calcul d’extremum
    public static void max() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisissez un nombre entier");
        int num1 = scanner.nextInt();
        System.out.println("Saisissez un autre nombre entier");
        int num2 = scanner.nextInt();

        if (num1 > num2) {
            System.out.println("la valeur du maximum est: " + num1);
        } else {
            System.out.println("la valeur du maximum est: " + num2);
        }
    }

    //TP2-3.1.3-2 [3]Calcul d’extremum
    public static void min() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisissez un nombre entier");
        int num1 = scanner.nextInt();
        System.out.println("Saisissez un autre nombre entier");
        int num2 = scanner.nextInt();

        if (num1 > num2) {
            System.out.println("la valeur du minimum est: " + num2);
        } else {
            System.out.println("la valeur du minimum est: " + num1);
        }
    }

    //TP2-3.1.4 [4]Égalité entre chaînes de caractères
    public static void egaliteStr() {
        Scanner chaine = new Scanner(System.in);
        System.out.println("saisissez un mot ou une phrase");
        String premierChaine = new String();
        premierChaine = chaine.nextLine();
        System.out.println("saisissez un mot ou une phrase");
        String deuxiemeChaine = new String();
        deuxiemeChaine = chaine.nextLine();

        boolean test = premierChaine.equals(deuxiemeChaine);

        if (test) {
            System.out.println("Ces chaines de caracteres sont egales");
        } else {
            System.out.println("Ces chaines de caracteres ne sont pas egales");
        }
    }

    //TP2-3.2 [5] Factorielle
    public static void factorielle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisir un entier positif ou nul");
        int n = scanner.nextInt();
        int factorielle = 1;
        for (int i = 1; i <= n; i++) {
            factorielle *= i;
        }
        System.out.println(n + "! = " + factorielle);
    }

    //TP2-3.2.1 [6]Compte à rebous
    public static void countdown() {
        for (int i = 10; i >= -1; i--) {
            if (i >= 0) {
                System.out.println(i);
            } else {
                System.out.println("BOOM!");
            }
        }
    }

    //TP2-3.2.2 [7]Valeurs de carrés
    public static void carres() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisir un entier positif ou nul");
        int num = scanner.nextInt();
        int num2 = num * num;
        System.out.println("l'entier et sa valeur au carre sont: " + num + "  " + num2);
    }

    //TP2-3.2.3 [8] Table de multiplication
    public static void tableMultiplication() {
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.print(i * j + "\t");
            }
            System.out.println();
        }
    }

    //TP2-3.2.5 [9]Division d’entiers
    public static void division() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisir un entier comme denominateur:");
        int num2 = scanner.nextInt();
        if (num2 == 0) {
            System.out.println("Saisir un entier non nul comme denominateur:");
            num2 = scanner.nextInt();
        }

        do {
            System.out.println("Saisir un entier comme diviseur:");
            int num1 = scanner.nextInt();
            float NUM = (float) num1 / num2;
            System.out.println("Le résultat de la division de deux nombres est: " + NUM);
            break;
        } while (num2 != 0);
    }

    //TP2-3.3.1 [10]Règle graduée
    public static void regle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisir un entier positif:");
        int num = scanner.nextInt();
        for (int i = 0; i < num; i++) {
            if (i % 10 == 0) {
                System.out.print("|");
            }
            System.out.print("-");
        }
    }

    //TP2-3.3.2 [11]Nombres premiers
    public static void nombrePremier() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisir un entier");
        int num = scanner.nextInt();
        int j = 0;

        if (num <= 1) {
            System.out.println(num + " n'est pas un nombre premier");
        } else {
            for (int i = 2; i < num; i++) {
                if (num % i == 0) {
                    j++;
                }
            }
            if (j == 0) {
                System.out.println(num + " est un nombre premier");
            } else {
                System.out.println(num + " n'est pas un nombre premier");
            }
        }

    }

//TP2-3.4.5 [12]Manipulations sur un tableau
    public static void initialisationTableau() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisir un entier positif comme longueur du tableau");
        int length = scanner.nextInt();
        int[] tableau = new int[length];

        for (int i = 0; i < tableau.length; i++) {
            System.out.println("Saisir le " + (i + 1) + "eme entier");
            int entier = scanner.nextInt();
            tableau[i] = entier;
        }

        int max = tableau[0];
        int min = tableau[0];
        int sum = 0;

        for (int j = 0; j < tableau.length; j++) {
            if (tableau[j] >= max) {
                max = tableau[j];
            }

            if (tableau[j] <= min) {
                min = tableau[j];
            }

            sum += tableau[j];
        }

        /*TEST CODE*/
        for (int j = 0; j < tableau.length; j++) {
            System.out.printf(tableau[j] + " ");
        }
        System.out.println();
        /*TEST CODE*/

        System.out.println("La valeur maximum est " + max);
        System.out.println("La valeur minimum est " + min);
        System.out.println("La somme de tous les nombres est " + sum);

        System.out.println("Nombre pair et son indice dans le tableau: ");
        for (int k = 0; k < tableau.length; k++) {
            if (tableau[k] % 2 == 0) {
                System.out.println(tableau[k] + "\tl'indice dans ce tableau est: " + k);
            }
        }

    }
    public static void inversetableau(int[] tableau) {
        for (int i = 0, j = tableau.length - 1 ; i <= j ;i++, j--){
        int num = tableau[i];
        tableau[i] = tableau[j];
        tableau[j] = num;
        }
        System.out.println("Inverser l'ordre de l'elements");
        for (int k = 0; k < tableau.length; k++) {
            System.out.print(tableau[k]+"\t");
        }
    }

}



