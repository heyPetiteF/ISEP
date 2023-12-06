import java.util.Scanner;

public class ASCIArt {

    public static void main(String[] args){

        Scanner sc  = new Scanner(System.in);
        System.out.println("Please enter an odd number for the height:");
        int h = sc.nextInt();
        System.out.println("Please enter an odd number for the width:");
        int w = sc.nextInt();
        if(h>0 && w>0 && h%2 != 0 && w/2 != 0){
            Cats(h,w);
        }
        else {
            System.out.println("!--Height and Width must be an odd number greater than zero--!");
        }

    }

    public static void Cats(int h, int w){

/*-----------------------Head-----------------------*/

        System.out.printf("|"+"\\");

        for (int i = w; i > 0; i--){
            System.out.printf("-");
        }

        System.out.println("/"+"|");

/*-----------------------Face-----------------------*/

        for (int j = h; j > 0; j--){

            System.out.printf("|");

            while (j != (h+1) / 2) {
                for (int k = w + 2; k > 0; k--) {
                    System.out.format(" ");
                }
            break;
            }

            while (j == (h+1) / 2){

                System.out.printf(" "+"0");

                for (int n = w - 2; n > 0; n--) {
                    System.out.printf("_");
                }

                System.out.printf("0"+" ");
            break;
            }

        System.out.println("|");
        }

/*-----------------------Foots-----------------------*/

        System.out.printf(" "+"\\"+"_");

        for (int z = w-2; z > 0; z--){
            System.out.printf("^");
        }

        System.out.printf("_"+"/");
    }

}
