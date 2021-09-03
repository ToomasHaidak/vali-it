package ee.bcs.valiit.tasks;

public class LessonA {
    public static int e1(int a) {
        return -a;
    }

    public static int e2(int a, int b) {
        // tagasta kahe arvu keskmine
        return (a+b)/2;
    }

    public static int e3(int x) {
        // lahuta sisendist 5 ja siis korruta 99
        return (x-5)*99;
    }

    public static int e4(int a1, int b1, int a2, int b2, int a3, int b3) {
        // korruta a1 b1-ga, a2 b2-ga jne. Ning siis liida saadud numbrid
        return (a1*b1) + (a2*b2) + (a3*b3);
    }

    public static int e5() {
        // return the answer to the Life, the Universe, and Everything.
        return 42;
    }

    public static boolean e6(int x) {
        // Kas arv on liigaasta
        // Wikipeediast:
        // Iga aasta, mis jagub neljaga, on liigaasta (kui ta samal ajal ei jagu sajaga). Kui aasta jagub sajaga ja ei jagu neljasajaga siis ta ei ole liigaasta. Aasta, mis jagub neljasajaga, on alati liigaasta.
        //See tähendab näiteks, et aastad 1984 ja 2000 olid liigaastad, 1900 aga mitte.

        if(x % 400 == 0) {
            return true;
        }

        if(x % 100 == 0) {
            return false;
        }

        if(x % 4 == 0) {
            return true;
        }

        return false;

    }

    public static boolean e7(boolean x) {
        boolean y = !x;
        return y;
    }

    public static boolean e8(boolean x1, boolean x2) {
        // tagasta true kui ainult 1 sisend muutujatest on true
//        if((x1 == true && x2 != true) || (x1 != true && x2 == true)) {
//            return true;
//        } else {
        return x1 != x2;

    }

    public static boolean e9(boolean x1, boolean x2, boolean x3, boolean x4) {
        // tagasta true kui paaritu arv sisend muutujatest on true
//        if(x1 == true && (x2 == false && x3 == false && x4 == false)) {
//        return true;
//        }
//
//        if(x2 == true && (x1 == false && x3 == false && x4 == false)) {
//            return true;
//        }
//
//        if(x3 == true && (x1 == false && x2 == false && x4 == false)) {
//            return true;
//        }
//
//        if(x4 == true && (x1 == false && x2 == false && x3 == false)) {
//            return true;
//        }
//
//        if(x1 == false && (x2 == true && x3 == true && x4 == true)) {
//            return true;
//        }
//
//        if(x2 == false && (x1 == true && x3 == true && x4 == true)) {
//            return true;
//        }
//
//        if(x3 == false && (x1 == true && x2 == true && x4 == true)) {
//            return true;
//        }
//
//        if(x4 == false && (x1 == true && x2 == true && x3 == true)) {
//            return true;
//        }

        int x = 0;

        if(x1 == true) {
            x++;
        }

        if(x2 == true) {
            x++;
        }

        if(x3 == true) {
            x++;
        }

        if(x4 == true) {
            x++;
        }

        return x % 2 == 1;

    }

    public static void e10(int x[]) {
        // muuda sisend massiivi nii et kõik elemendid oleksid 2x suuremad
        for(int i = 0; i < x.length; i++) {
            x[i] = x[i]*2;
        }
    }

    public static void e11(int x[]) {
        // määra sisend massiivi teine element (index 1) 0-iks
        x[1] = 0;
    }

    public static void e12(int x[]) {
        // vaheta massiivi esimene ja teine element omavahel
        int temp;
        temp = x[0];
        x[0] = x[1];
        x[1] = temp;
    }

    public static void e13(int x[]) {
        // määra massiivi teise elemendi väärtuseks sama mis esimesel elemendil
        x[1] = x[0];
    }

    public static void e14(int x[]) {
        // määra massiivi teise elemendi väärtuseks sama mis esimesel elemendil
        // määra massiivi neljanda elemendi väärtuseks sama mis kolmandal elemendil
        // määra massiivi kuuenda elemendi väärtuseks sama mis viiendal elemendil
        // määra massiivi kaheksanda elemendi väärtuseks sama mis seitsmendal elemendil
        for(int i = 1; i < 9; i = i+2) {
            x[i] = x[i-1];
        }
    }

    public static void e15(int x[]) {
        // määra iga teine (indeksid 1, 3, jne) element massiivis samaks, mis oli talle eelnenud elemendi väärtus
        for(int i = 1; i < x.length; i = i+2) {
            x[i] = x[i-1];
        }
    }

}
