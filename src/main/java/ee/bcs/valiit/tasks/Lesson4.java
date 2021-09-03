package ee.bcs.valiit.tasks;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Lesson4 {
    // Store account nr as a key and account balance as value
    // HashMap<String, Double> accountBalanceMap = new HashMap<>();

    static Map<String, Double> account = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("Vali tegevus:\n" +
                    "1 - Create account\n" +
                    "2 - Get balance\n" +
                    "3 - Deposit money\n" +
                    "4 - Withdraw money\n" +
                    "5 - Transfer between accounts\n" +
                    "6 - Exit");
            int line = scanner.nextInt();
            scanner.nextLine();
            if (line == 6) {
                break;
            } else if (line == 2) {
                getBalance();
            } else if (line == 1) {
                createAccount();
            } else if (line == 3) {
                depositMoney();
            } else if (line == 4) {
                withdrawMoney();
            } else if (line == 5) {
                transferBetweenAccounts();
            }


            // TODO 1
            // Add command: "createAccount ${accountNr}"
            // this has to store accountNr with 0 balance
            // TODO 2
            // Add command: "getBalance ${accountNr}"
            // this has to display account balance of specific acount
            // TODO 3
            // Add command: "depositMoney ${accountNr} ${amount}
            // this has to add specified amount of money to account
            // You have to check that amount is positive number
            // TODO 4
            // Add command: "withdrawMoney ${accountNr} ${amount}
            // This has to remove specified amount of money from account
            // You have to check that amount is positive number
            // You may not allow this transaction if account balance would become negative
            // TODO 5
            // Add command: "transfer ${fromAccount} ${toAccount} ${amount}
            // This has to remove specified amount from fromAccount and add it to toAccount
            // Your application needs to check that toAccount is positive
            // And from account has enough money to do that transaction
            else {
                System.out.println("Unknown command");
            }
        }
    }

    public static void createAccount() {
        System.out.println("Sisesta uue konto number:");
        String kontoNumber = scanner.nextLine();
        account.put(kontoNumber, 0.0);
        System.out.println("Konto " + kontoNumber + " lisatud.");

    }

    public static void getBalance() {
        System.out.println("Sisesta konto number");
        String kontoNumber = scanner.nextLine();
        while (account.get(kontoNumber) == null) {
            System.out.println("Sellist kontot ei eksisteeri. Sisesta õige number.");
            kontoNumber = scanner.nextLine();
        }
        System.out.println("Kontol on " + account.get(kontoNumber) + " eurot.");
    }

    public static void depositMoney() {
        System.out.println("Sisesta konto number.");
        String kontoNumber = scanner.nextLine();
        while (account.get(kontoNumber) == null) {
            System.out.println("Sellist kontot ei eksisteeri. Sisesta õige number.");
            kontoNumber = scanner.nextLine();
        }

        System.out.println("Sisesta summa.");
        Double summa = scanner.nextDouble();
        while (summa < 0) {
            System.out.println("Summa ei tohi olla negatiivne. Sisesta uus summa.");
            summa = scanner.nextDouble();
        }
        account.put(kontoNumber, (account.get(kontoNumber) + summa));
        System.out.println("Kontole " + kontoNumber + " lisatud " + summa + " eurot.");
    }

    public static void withdrawMoney() {
        System.out.println("Sisesta konto number.");
        String kontoNumber = scanner.nextLine();
        while (account.get(kontoNumber) == null) {
            System.out.println("Sellist kontot ei eksisteeri. Sisesta õige number.");
            kontoNumber = scanner.nextLine();
        }
        System.out.println("Sisesta summa.");
        Double summa = scanner.nextDouble();
        while (summa < 0 || ((account.get(kontoNumber) - summa) < 0)) {
            System.out.println("Summa ei tohi olla negatiivne või viie kontot miinusesse. Sisesta uus summa.");
            summa = scanner.nextDouble();
        }
        account.put(kontoNumber, (account.get(kontoNumber) - summa));
        System.out.println("Kontolt võetud " + summa + " eurot. Jääk on " + (account.get(kontoNumber)));
    }

    public static void transferBetweenAccounts() {
        System.out.println("Sisestsa konto millelt kantakse raha");
        String kontoNumberKust = scanner.nextLine();
        while (account.get(kontoNumberKust) == null) {
            System.out.println("Sellist kontot ei eksisteeri. Sisesta õige number.");
            kontoNumberKust = scanner.nextLine();
        }
        System.out.println("Sisesta konto kuhu kantakse raha");
        String kontoNumberKuhu = scanner.nextLine();
        while (account.get(kontoNumberKuhu) == null) {
            System.out.println("Sellist kontot ei eksisteeri. Sisesta õige number.");
            kontoNumberKuhu = scanner.nextLine();
        }

        System.out.println("Sisesta summa.");
        Double summa = scanner.nextDouble();
        while (summa < 0 || (account.get(kontoNumberKust) < summa)) {
            System.out.println("Summa on negatiivne või kontol pole piisavalt raha. Sisesta uus summa.");
            summa = scanner.nextDouble();
        }
        account.put(kontoNumberKust, (account.get(kontoNumberKust) - summa));
        account.put(kontoNumberKuhu, (account.get(kontoNumberKuhu) + summa));
        System.out.println("Kontolt " + kontoNumberKust + " võetud " + summa + " eurot.\n" +
                " ja lisatud kontole " + kontoNumberKuhu);

    }

}
