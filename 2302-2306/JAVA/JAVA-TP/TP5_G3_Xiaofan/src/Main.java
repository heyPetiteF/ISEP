import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Random;

import static java.lang.Integer.SIZE;

public class Main {
    public static void main(String[] args) {

        int[] tableau = new int[Integer.MAX_VALUE/100];

        initialiserTableau();

        int[] tableauSelection = new int[SIZE];
        // arraycopy(src, startIndex, dest, startIndex, size)
        System.arraycopy(tableau, 0, tableauSelection, 0, SIZE);

        triSelection(tableau);
        triInsertion(tableau);
        triBulles(tableau);
        quicksort(tableau,0,tableau.length - 1);
        triJava(tableau);

    }

/*-----------------------------3.1.2 Debut d’initialisation----------------------------*/
    public static void initialiserTableau() {

        int []tableau = new int[Integer.MAX_VALUE/100];

        Instant start = Instant.now();
        System.out.println("\n------------------------Debut d’initialisation------------------------");
        Random random = new Random();
        for (int i = 0; i < tableau.length; i++) {
            tableau[i] = random.nextInt(SIZE);
        }
        Instant end = Instant.now();
        long duration = Duration.between(start, end).toMillis();

        System.out.println("Pour les tableaux contenant [Integer.MAX_VALUE/100] données");
        System.out.println("L’initialisation a pris " + duration + " ms");
    }


/*-----------------------------3.1.4 Tri par sélection---------------------------------*/
    public static void triSelection(int[] tableau){
        //copie de tableau
        int []tableauCopie1 = new int[tableau.length/100];
        for(int i = 0; i < tableauCopie1.length; i++){
            tableauCopie1[i] = tableau[i];
        }

        int minIndex;

        Instant start1 = Instant.now();
        // Des instructions qui peuvent prendre du temps

        for(int i = 0;i < tableauCopie1.length;i++) {

            minIndex = i;
            //遍历找出未排序中的元素中最小值下标
            for(int j = i;j < tableauCopie1.length;j++) {

                if(tableauCopie1[j] < tableauCopie1[minIndex]) {
                    minIndex = j;
                }
            }

            //若最小值下标与未排序中最左侧下标不一致则交换
            if(minIndex != i) {
                int temp = tableauCopie1[i];
                tableauCopie1[i] = tableauCopie1[minIndex];
                tableauCopie1[minIndex] = temp;
            }
        }

        Instant end1 = Instant.now();
        // duration va donc contenir, en ms, la duree ecoulee entre end et start
        long duration1 = Duration.between(start1, end1).toMillis();

        System.out.println("\n------------------------Tri par sélection-----------------------------");
        System.out.println("Pour les tableaux contenant [Integer.MAX_VALUE/10 000] données");
        System.out.println("La durée écoulée lors du tri par sélection est "+ duration1 + "ms");
    }


/*---------------------------------3.1.5 Tri par insertion---------------------------------*/
    public static void triInsertion(int[] tableau) {

        int[] tableauCopie2 = new int[tableau.length / 10000];
        for (int i = 0; i < tableauCopie2.length; i++) {
            tableauCopie2[i] = tableau[i];
        }

        Instant start2 = Instant.now();
        // Des instructions qui peuvent prendre du temps

        for (int i = 1; i < tableauCopie2.length; i++) {

            //为a[i]在前面的a[0...i-1]有序区间中找一个合适的位置
            for (int j = i - 1; j >= 0; j--) {
                if (tableauCopie2[j] < tableauCopie2[i])
                    break;
                //如找到了一个合适的位置
                if (j != i - 1) {
                    //将比a[i]大的数据向后移
                    int temp = tableauCopie2[i];
                    for (int k = i - 1; k > j; k--) {
                        tableauCopie2[k + 1] = tableauCopie2[k];
                        //将a[i]放到正确位置上
                        tableauCopie2[k + 1] = temp;
                    }
                }
            }
        }

            Instant end2 = Instant.now();
            // duration va donc contenir, en ms, la duree ecoulee entre end et start
            long duration2 = Duration.between(start2, end2).toMillis();

            System.out.println("\n------------------------Tri par insertion-----------------------------");
            System.out.println("Pour les tableaux contenant [Integer.MAX_VALUE/1 000 000] données");
            System.out.println("La durée écoulée lors du tri par insertion est " + duration2 + "ms");
        }

/*---------------------------------3.1.6 Tri à bulles---------------------------------*/

    public static void triBulles(int[] tableau){
        int[] tableauCopie3 = new int[tableau.length];
        for (int i = 0; i < tableauCopie3.length; i++) {
            tableauCopie3[i] = tableau[i];
        }

        Instant start3 = Instant.now();
        // Des instructions qui peuvent prendre du temps

        int temp;
        for (int i = 0; i < tableauCopie3.length - 1; i++) {
            boolean F = false; // 是否发生交换。没有交换，提前跳出外层循环
            for (int j = 0; j < tableauCopie3.length - 1 - i; j++) {
                if (tableauCopie3[j] > tableauCopie3[j + 1]) {
                    temp = tableauCopie3[j];
                    tableauCopie3[j] = tableauCopie3[j + 1];
                    tableauCopie3[j + 1] = temp;
                    F = true;
                }
            }
            if (!F)
            {
                break;
            }
        }

        Instant end3 = Instant.now();
        // duration va donc contenir, en ms, la duree ecoulee entre end et start
        long duration3 = Duration.between(start3, end3).toMillis();

        System.out.println("\n------------------------Tri à bulles----------------------------------");
        System.out.println("Pour les tableaux contenant [Integer.MAX_VALUE/100] données");
        System.out.println("La durée écoulée lors du tri à bulles est " + duration3 + "ms");
    }

/*---------------------------------3.1.7 Quick sort---------------------------------*/
    public static void quicksort(int[] tableau, int indGauche, int indDroit) {

        int[] tableauCopie4 = new int[tableau.length/100];
        for (int i = 0; i < tableauCopie4.length; i++) {
            tableauCopie4[i] = tableau[i];
        }

        Instant start4 = Instant.now();
        // Des instructions qui peuvent prendre du temps

        int k = tableau[indDroit];
        int i = indGauche - 1;
        for (int j = indGauche; j < indDroit; j++) {
            if (tableau[j] < k) {
                i++;
                int temp = tableau[i];
                tableau[i] = tableau[j];
                tableau[j] = temp;
            }
        }
        int temp = tableau[i + 1];
        tableau[i + 1] = tableau[indDroit];
        tableau[indDroit] = temp;

        Instant end4 = Instant.now();
        // duration va donc contenir, en ms, la duree ecoulee entre end et start
        long duration4 = Duration.between(start4, end4).toMillis();

        System.out.println("\n------------------------Quick sort------------------------------------");
        System.out.println("Pour les tableaux contenant [Integer.MAX_VALUE/10 000] données");
        System.out.println("La durée écoulée lors du tri en Quick Sort est " + duration4 + "ms");

    }

/*---------------------------------3.1.8 Tri natif de Java---------------------------------*/

    public static void triJava(int[] tableau){

        int[] tableauCopie5 = new int[tableau.length];
        for (int i = 0; i < tableauCopie5.length; i++) {
            tableauCopie5[i] = tableau[i];
        }

        Instant start5 = Instant.now();
        // Des instructions qui peuvent prendre du temps

        Arrays.sort(tableauCopie5);
        Instant end5 = Instant.now();
        // duration va donc contenir, en ms, la duree ecoulee entre end et start
        long duration5 = Duration.between(start5, end5).toMillis();

        System.out.println("\n------------------------Le double pivot quick sort--------------------");
        System.out.println("Pour les tableaux contenant [Integer.MAX_VALUE/100] données");
        System.out.println("La durée écoulée lors du tri en double pivot quick sort est " + duration5 + "ms");


    }

}
