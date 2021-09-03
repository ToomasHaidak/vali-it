package ee.bcs.valiit.tasks;

import java.util.Arrays;

public class Lesson2 {
    public static void main(String[] args) {
        // TODO siia saab kirjutada koodi testimiseks
        System.out.println("Hello");
        System.out.println(Arrays.toString(decreasingArray(0)));

    }

    // TODO tagasta massiiv milles oleks numbrid 1,2,3,4,5
    public static int[] sampleArray() {
        int[] array = {1, 2, 3, 4, 5};
        return array;
    }

    // TODO tagasta n esimest arvu alates 1-st
    // näiteks
    // sisend: 5
    // trüki välja: 1 2 3 4 5
    public static int[] firstN(int n) {
        int[] array = new int[n];
        for (int i = 1; i <= n; i++) {
            array[i - 1] = i;
        }
        return array;
    }

    // TODO loo massiiv mis saab sisendiks n ja tagastab massiivi suurusega n
    // Kus esimene element on 1 ja iga järnev arv on 1 võrra suurem
    // näiteks:
    // sisend: 5
    // vastus: {1, 2, 3, 4, 5}
    public static int[] generateArray(int n) {
        int[] array = new int[n];
        for (int i = 1; i <= n; i++) {
            array[i - 1] = i;
        }
        return array;
    }

    // TODO
    // Tagastada massiiv kus oleks numbrid n-ist 0 ini
    // Näiteks: sisend: 5
    // Väljund: 5, 4, 3, 2, 1, 0
    // Näide2: siend: -3
    // Väljund: -3, -2, -1, 0
    public static int[] decreasingArray(int n) {
        if (n > 0) {
            int[] array = new int[n+1];
            for (int i = 0; i < array.length; i++) {
                array[i] = n;
                n--;
            }
            return array;
        }

        if (n < 0) {
            int[] array = new int[n*-1+1];
            for (int i = 0; i < array.length; i++) {
                array[i] = n;
                n++;
            }
            return array;

        }
        return new int[] {0};
    }

    // TODO
    // tagasta massiiv pikkusega n, mille kõigi elementide väärtused on 3
    public static int[] yl3(int n) {
        int[] array= new int[n];
        for(int i = 0; i < array.length; i++) {
            array[i] = 3;
        }
        return array;
    }

}