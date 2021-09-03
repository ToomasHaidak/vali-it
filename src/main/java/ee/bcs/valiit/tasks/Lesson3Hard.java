package ee.bcs.valiit.tasks;

import java.util.Random;
import java.util.Scanner;

public class Lesson3Hard {

    // TODO kirjuta mäng mis leiab suvalise numbri 0-99, mille kasutaja peab ära arvama
    // iga kord pärast kasutaja sisestatud täis arvu peab programm ütlema kas number oli suurem või väiksem
    // ja kasutaja peab saama uuesti arvata
    // numbri ära aramise korral peab programm välja trükkima mitu katset läks numbri ära arvamiseks
    public static void main(String[] args) {
        Random random = new Random();
        int i = random.nextInt(100);
        System.out.println(i);
        Scanner scanner = new Scanner(System.in);
        boolean kontroll = false;
        int counter = 0;

        while (kontroll == false) {
            System.out.println("Sisesta number");
            int a = scanner.nextInt();
            if (a == i) {
                System.out.println("Tubli, viis, istu!");
                kontroll = true;
                counter ++;
            }
            if (a < i) {
                System.out.println("Vale. Vastus on suurem.");
                counter ++;
            }
            if (a > i) {
                System.out.println("Vale. Vastus on väiksem.");
                counter ++;
            }
        }

        System.out.println("Sul kulus " + counter + " katset.");
    }
}
