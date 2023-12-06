import java.io.InputStream;
import java.security.PublicKey;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Objects;
public class Main {

    public static void main(String[] args) {

/*------------------------------------------Listing 1: Basic use of a scanner------------------------------------------*/

        /*

        System.out.println("Listing 1: Basic use of a scanner");

        Scanner sc1 = new Scanner(System.in);
        System.out.println("What is your age?");
        int answer1 = sc1.nextInt();
        System.out.printf("Your age is %d \n", answer1);
        sc1.close();

         */

/*-------------------------------------------Listing 2: Try and catch blocks-------------------------------------------*/

        /*

        System.out.println("Listing 2: Try and catch blocks");

        Scanner sc2 = new Scanner(System.in);
        try {
            System.out.println("What is your age?");
            int answer2 = sc2.nextInt();
            System.out.printf("Your age is %d \n", answer2);
        }catch (InputMismatchException e){
            System.out.println("Wrong input!");
            sc2.nextLine();
        }

         */

/*--------------------------------------Listing 3: Use of the hasNextInt function--------------------------------------*/

        /*

        System.out.println("Listing 3: Use of the hasNextInt function");

        Scanner sc3 = new Scanner(System.in);
        System.out.println("What is your age?");
        while (sc3.hasNextInt()) {
            int answer3 = sc3.nextInt();
            System.out.printf("Your age is %d \n", answer3);
            break;
        }
        while (!sc3.hasNextInt()){
            System.out.println("Wrong input!");
            break;
            }

         */

/*--------------------------------------------Listing 4: try-with statement--------------------------------------------*/

        /*

        System.out.println("Listing 4: try-with statement");

        try(Scanner sc4 = new Scanner(System.in)){
            System.out.println("What is your age?");
            int answer4 = sc4.nextInt();
            System.out.printf("Your age is %d \n", answer4);
        }

         */

/*------------------------------------Listing 5: while loop to enforce proper input------------------------------------*/

        /*

        System.out.println("Listing 5: while loop to enforce proper input");

        Scanner sc5 = new Scanner(System.in);
        boolean inputValid = false;
        while (!inputValid){
            try{
                System.out.println("What is your age?");
                int answer5 = sc5.nextInt();
                System.out.printf("Your age is %d \n", answer5);
                inputValid = true;
            }catch (InputMismatchException e){
                System.out.println("Wrong input!");
                sc5.nextLine();
            }
        }

         */

/*----------------------------- Listing 6: Extracting the scanner routine into a function -----------------------------*/

        /*

        System.out.println("Listing 6: Extracting the scanner routine into a function");

        Scanner sc = new Scanner(System.in);
        int answer = getInt(sc);
        System.out.printf("Your age is %d \n", answer);
        sc.close();
    }

    public static int getInt(Scanner sc) {
        boolean inputValid = false;
        int answer = 0;

        while (!inputValid) {
            try {
                System.out.println("What is your age?");
                answer = sc.nextInt();
                inputValid = true;
            } catch (InputMismatchException var4) {
                System.out.println("Wrong input!");
                sc.next();
            }
        }
        return answer;
    }

        */

/*---------------------Listing 8: How to use our newly created SafeScanner class | (For Listing 7)---------------------*/

        /*


        SafeScanner safeScanner = new SafeScanner();
        System.out.println("What is your age?");
        int answer = safeScanner.getInt();
        System.out.printf("Your age is %d.%n", answer);
        safeScanner.closeScanner();

        */

/*----------------------------------Listing 9: Scanner with more flexible InputStream----------------------------------*/

        /*

        SafeScanner safeScanner = new SafeScanner(System.in);
        System.out.println("What is your age?");
        int answer = safeScanner.getInt();
        System.out.printf("Your age is %d.%n", answer);
        safeScanner.closeScanner();

        */

/*-----------------------------------Listing 10: Use of SafeScanner with a text file-----------------------------------*/

        SafeScanner safeScanner = new SafeScanner(
            Objects.requireNonNull(SafeScanner.class.getResourceAsStream("demo.txt"))
        );
            System.out.println("What is your age?");
            int answer = safeScanner.getInt();
            System.out.printf("Your age is %d.%n", answer);
            safeScanner.closeScanner();

/*---------------------------------------------------------------------------------------------------------------------*/

    }
}
