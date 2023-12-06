import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Objects;

public class SafeScanner {

        Scanner sc;

/*-----------------------------------------------Listing 7: Scanner class----------------------------------------------*/

    /*


    public SafeScanner(){
        sc = new Scanner(System.in);
    }
    public int getInt() {
        boolean inputValid = false;
        int answer = 0;

        while(!inputValid) {
            try {
                answer = sc.nextInt();
                inputValid = true;
            } catch (InputMismatchException var4) {
                System.out.println("Wrong input! Please re-enter your age:");
                sc.next();
            }
        }
        return answer;
    }


    public void closeScanner(){
        this.sc.close();
    }

 */



/*----------------------------------Listing 9: Scanner with more flexible InputStream----------------------------------*/


        public SafeScanner(InputStream is){
            this.sc = new Scanner(System.in);
        }
        public int getInt() {
            boolean inputValid = false;
            int answer = 0;

            while(!inputValid) {
                try {
                    answer = this.sc.nextInt();
                    inputValid = true;
                } catch (InputMismatchException var4) {
                    System.out.println("Wrong input! Please re-enter your age:");
                    this.sc.next();
                }
            }
            return answer;
        }


        public void closeScanner(){
            this.sc.close();
        }

/*---------------------------------------------------------------------------------------------------------------------*/

}



