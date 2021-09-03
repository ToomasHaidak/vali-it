package ee.bcs.valiit.tasks;

import java.util.Arrays;

public class Lesson2b {

    public static void main(String[] args) {
        // TODO siia saab kirjutada koodi testimiseks
        int [] inputArray = {1, 2, 3, 4};
        int [] printArray = reverseArray(inputArray);
        System.out.println(Arrays.toString(printArray));
        System.out.println("===============");
//        System.out.println(Arrays.toString(fibonacci(10)));
        System.out.println(fibonacci(15));
        System.out.println("===============");
        multiplyTable(3, 4);
        System.out.println("================");
        System.out.println(sequence3n(10, 30));
        System.out.println("=================");
        multiplyTable(5,5);

    }

    // TODO loe funktsiooni sisendiks on täisarvude massiiv
    // TODO tagasta massiiv mille elemendid on vastupidises järiekorras
    public static int[] reverseArray(int[] inputArray) {

        int [] returnArray = new int[inputArray.length];
        for(int i = 0; i < inputArray.length; i++) {
            int temp = inputArray[inputArray.length - i - 1];
            returnArray[i] = temp;
        }
        return returnArray;
    }

    // TODO tagasta massiiv mis sisaldab n esimest paaris arvu
    // Näide:
    // Sisend 5
    // Väljund 2 4 6 8 10
    public static int[] evenNumbers(int n) {
        int [] array = new int [n];
        int j = 2;
        for (int i = 0; i < n; i++){
            array[i] = j;
            j = j + 2;
        }
        return array;
    }

    // TODO, leia massiivi kõige väiksem element
    public static int min(int[] x){
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < x.length; i++) {
            if(x[i] < min) {
                min = x[i];
            }
        }
        return min;
    }

    // TODO, leia massiivi kõige suurem element
    public static int max(int[] x){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < x.length; i++) {
            if(x[i] > max) {
                max = x[i];
            }
        }
        return max;
    }

    // TODO, leia massiivi kõigi elementide summa
    public static int sum(int[] x){
        int sum = 0;
        for(int i = 0; i < x.length; i++) {
            sum = sum + x[i];
        }
        return sum;
    }

    // TODO trüki välja korrutustabel mis on x ühikut lai ja y ühikut kõrge
    // TODO näiteks x = 3 y = 3
    // TODO väljund
    // 1 2 3
    // 2 4 6
    // 3 6 9
    // TODO 1 trüki korrutustabeli esimene rida (numbrid 1 - x)
    // TODO 2 lisa + " " print funktsiooni ja kasuta print mitte println
    // TODO 3 trüki seda sama rida y korda
    // TODO 4 Kuskile võiks kirjutada System.out.println(),
    //  et saada taebli kuju
    // TODO 5 võrdle ridu. Kas on mingi seaduspärasus ridade vahel,
    // mis on ja mis võiks olla. Äkki tuleb mõni idee
    public static void multiplyTable(int x, int y) {
//        int [][] table = new int [x][y];
//        for(int i = 0; i < x; i++) {
//            for(int j = 0; j < y; j++) {
//                table [i][j] = (i+1)*(j+1);
//            }
//        }

        for(int i = 1; i <= x; i++) {
            for(int j = 1; j <= y; j++) {
                if(j < y) {
                    System.out.print(i*j + " ");
                } else {
                    System.out.println(i*j);
                }

            }
        }
    }

    // TODO
    // Fibonacci jada on fib(n) = fib(n-1) + fib(n-2);
    // 0, 1, 1, 2, 3, 5, 8, 13, 21
    // Tagasta fibonacci jada n element. Võid eeldada, et n >= 0
    public static  int fibonacci(int n) {
//        int [] array = new int [n+1];
//        if(n == 0) {
//            array[0] = 0;
//            return array[0];
//        }
//        if(n == 1) {
//            array[1] = 1;
//            return array[1];
//        } else {
//        array[0] = 0;
//        array[1] = 1;
//        for (int i = 2; i < n+1; i++) {
//            array[i] = array[i-2] + array[i-1];
//        }
//
//        return array[n];
//        }
        int yeelmine = 0;
        int eelmine = 1;
        int vastus = 0;

        if(n == 0) {
            return 0;
        }

        if(n ==1) {
            return 1;
        }

        for(int i = 1; i < n; i++) {
            vastus = yeelmine + eelmine;
            yeelmine = eelmine;
            eelmine = vastus;

        }

        return vastus;
    }

    // TODO
    // Kujutame ette numbrite jada, kus juhul kui number on paaris arv siis me jagame selle 2-ga
    // Kui number on paaritu arv siis me korrutame selle 3-ga ja liidame 1. (3n+1)
    // Seda tegevust teeme me niikaua kuni me saame vastuseks 1
    // Näiteks kui sisend arv on 22, siis kogu jada oleks:
    // 22 -> 11 -> 34 -> 17 -> 52 -> 26 -> 13 -> 40 -> 20 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1
    // Sellise jada pikkus on 16
    // Kirjutada programm, mis peab leidma kõige pikema jada pikkuse mis jääb kahe täis arvu vahele
    // Näiteks:
    // Sisend 10 20
    // Siis tuleb vaadata, kui pikk jada tuleb kui esimene numbr on 10. Järgmisen tuleb arvutada number 11 jada pikkus.
    // jne. kuni numbrini 20
    // Tagastada tuleb kõige pikem number
    // Näiteks sisendi 10 ja 20 puhul on vastus 20

    public static int sequence3n(int x, int y) {

        int[] array = new int [y-x+1];
        int count = 1;
        for (int j = x; j <= y; j++) {
            int a = j;
            while (a != 1) {
                if (a % 2 == 0) {
                    a = a / 2;
                } else {
                    a = a * 3 + 1;
                }
                count++;
            }
            array[j-x] = count;
            count = 1;
        }

        System.out.println(Arrays.toString(array)); // See on testimiseks

        int max = 0;
        for(int i = 0; i < (y-x+1); i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }


}
