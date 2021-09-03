package ee.bcs.valiit.tasks;


import java.util.Scanner;

// TODO kasuta if/else. Ära kasuta Math librarit
public class Lesson1 {
    public static void main(String[] args) {
        // Siia sisse võid sa kirjutada koodi, et testida kas su meetodid töötavad ilusti
        // Katseta IntelliJ shortcuti. Olles intelliJ kirjuta "sout" ja siis vajuta enter

        System.out.println("Millist meetodit soovid valida: 1 - tagasta kahe arvu väikseim väärtus\n" +
                "2 - tagasta kahe arvu suurim väärtus\n" +
                "3 - tagasta absoluutarv\n" +
                "4 - kontrolli kas arv on paarisarv\n" +
                "5 - tagasta kolmest arvust väiksem arv\n" +
                "6 - tagasta kolmest arvust suurim arv");
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        scanner.nextLine();

        if (x == 1) {
            System.out.println("Sisesta kaks arvu:");
            int mina = scanner.nextInt();
            scanner.nextLine();
            int minb = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Väikseim on " + min(mina, minb));

        }

        if (x == 2) {
            System.out.println("Sisesta kaks arvu;");
            int maxa = scanner.nextInt();
            scanner.nextLine();
            int maxb = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Suurim on " + max(maxa, maxb));
        }

        if (x == 3) {
            System.out.println("Sisesta arv");
            int absa = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Absoluutväärtus on " + abs(absa));
        }

        if (x == 4) {
            System.out.println("Sisesta arv");
            int paara = scanner.nextInt();
            if(isEven(paara)) {
                System.out.println(paara + " on paarisarv");
            } else System.out.println(paara + " ei ole paarisarv");
        }

        if (x == 5) {
            System.out.println("sisesta kolm arvu");
            int min3a = scanner.nextInt();
            scanner.nextLine();
            int min3b = scanner.nextInt();
            scanner.nextLine();
            int min3c = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Väikseim on " + min3(min3a, min3b, min3c));
        }

        if (x == 6) {
            System.out.println("sisesta kolm arvu");
            int max3a = scanner.nextInt();
            scanner.nextLine();
            int max3b = scanner.nextInt();
            scanner.nextLine();
            int max3c = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Suurim on " + max3(max3a, max3b, max3c));
        }
    }

    // TODO
    //  Tagasta string mille väärtus oleks "\"\\""
    //  Trüki muutuja sisu välja
    public static String someString() {
        System.out.println("\"\\\"\\\\\"\"");
        return "\"\\\"\\\\\"\"";
    }

    // TODO tagasta a ja b väikseim väärtus
    public static int min(int a, int b) {
        if (a < b) {
            return a;
        } else {
            return b;
        }
    }


    // TODO tagasta a ja b suurim väärtus
    public static int max(int a, int b) {
        int x = 0;
        if (a > b) {
            x = a;
        } else if (b > a) {
            x = b;
        }
        return x;
    }

    // TODO tagasta a absoluut arv
    public static int abs(int a) {
        if (a >= 0) {
            return a;
        } else {
            return (a - (2 * a));
        }
    }

    // TODO tagasta true, kui a on paaris arv
    // tagasta false kui a on paaritu arv
    public static boolean isEven(int a) {
        int x = 0;
        x = a % 2;
        if(x == 0) {
            return true;
        } else {
            return false;
        }

    }

    // TODO tagasta kolmest arvust kõige väiksem
    public static int min3(int a, int b, int c) {
        if(a <= b && a < c) {
            return a;
        } else if(b<a && b<=c) {
            return b;
        } else if(c<=a && c<b) {
            return c;
        } else return 0;
    }

    // TODO tagasta kolmest arvust kõige suurem
    public static int max3(int a, int b, int c) {
//        if(a>=b && a>c) {
//            return a;
//        } else if(b>a && b>=c) {
//            return b;
//        } else if(c>= a && c>b) {
//            return c;
//        } else return 0;
        return max(a, max(b, c));
    }



}
