package ee.bcs.valiit.tasks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Lesson3 {

    // TODO tagasta x faktoriaal.
    // Näiteks
    // x = 5
    // return 5*4*3*2*1 = 120
    public static int factorial(int x) {
        int sum = 1;
        for (int i = x; i > 0; i--) {
            sum = sum * i;
        }
        return sum;
    }

    // TODO tagasta string tagurpidi
    public static String reverseString(String a) {
//        a.charAt(0);
//        a.substring(0,1);
        char[] reverseArray = new char[a.length()];
        if (a.length() == 0) {
            return "";
        }
        for (int i = 0; i < a.length(); i++) {
            char temp = a.charAt(a.length() - i - 1);
            reverseArray[i] = temp;
        }
        return new String(reverseArray);
    }

    // TODO tagasta kas sisestatud arv on primaar arv (jagub ainult 1 ja iseendaga)
    public static boolean isPrime(int x) {
        int count = 0;

        for (int i = 1; i <= x; i++) {
            if (x % i == 0) {
                count++;
            }
        }
        if (count == 2) {
            return true;
        } else {
            return false;
        }
    }

    // TODO sorteeri massiiv suuruse järgi.
    // TODO kasuta tsükleid, ära kasuta ühtegi olemasolevat sort funktsiooni
    public static int[] sort(int[] a) {
        for (int j = 0; j < a.length - 1; j++) {
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                }
            }
        }
        return a;
    }

    public static int evenFibonacci(int x) {
        // TODO liida kokku kõik paaris fibonacci arvud kuni numbrini x
        // 0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597
        int yeelmine = 0;
        int eelmine = 1;
        int praegune = 0;
        int counter = 1;

        while (praegune < x) {
            praegune = yeelmine + eelmine;
            yeelmine = eelmine;
            eelmine = praegune;
            counter++;
        }

        yeelmine = 0;
        eelmine = 1;
        praegune = 0;
        int summa = 0;

        for (int i = 1; i < counter; i++) {
            praegune = yeelmine + eelmine;
            yeelmine = eelmine;
            eelmine = praegune;
            if (praegune % 2 == 0) {
                summa = summa + praegune;
            }
        }

        return summa;
    }


    public static String morseCode(String text) {
        // TODO kirjuta programm, mis tagastab sisestatud teksti morse koodis (https://en.wikipedia.org/wiki/Morse_code)
        // Kasuta sümboleid . ja - ning eralda kõik tähed tühikuga
//        String h = ".... ";
//        String e = ". ";
//        String l = ".-.. ";
//        String o = "--- ";
//        String s = "... ";
//        String morse = "";
//        for (int i = 0; i < text.length(); i++) {
//            char letter = text.charAt(i);
//            if(letter == 'h') {
//                morse = morse + ".... ";
//            }
//            if(letter == 'e') {
//                morse = morse + ". ";
//            }
//            if(letter == 'l') {
//                morse = morse + ".-.. ";
//            }
//            if(letter == 'o') {
//                morse = morse + "--- ";
//            }
//            if(letter == 's') {
//                morse = morse + "... ";
//            }
//
//        }
//        return morse.trim();

        Map<String, String> morsekood = new HashMap<>();
        morsekood.put("h", ".... ");
        morsekood.put("e", ". ");
        morsekood.put("l", ".-.. ");
        morsekood.put("o", "--- ");
        morsekood.put("s", "... ");
        String morse = "";

        for (int i = 0; i < text.length(); i++) {
            String letter = text.substring(i, i+1);
            morse = morse + morsekood.get(letter);
        }
        return morse.trim();
    }
}
