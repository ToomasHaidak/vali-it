package ee.bcs.valiit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Lesson4Controller {

    static Map<String, Double> account = new HashMap<>();

    @GetMapping("lesson4/kuvaMenüü")
    public String kuvaMenüü() {
        return " Vali tegevus lesson4/valitegevus/#    1 - Create account; 2 - Get balance; 3 - Deposit money; 4 - Withdraw money; 5 - Transfer between accounts; 6 - Exit";
    }

    @GetMapping("/lesson4/valiTegevus/{a}")
    public String valiTegevus(@PathVariable("a") int x) {
        if (x == 1) {
              return "Sisesta konto number /lesson4/createAccount/####";
        } else if(x==2) {
            return "Sisesta konto number /lesson4/getBalance/####";
        } else if(x==3) {
             return "Sisesta konto number ja summa /lesson4/depositMoney/####/####";
        } else if(x==4) {
          return "Sisesta konto number ja summa /lesson4/withdrawMoney/####/####";
        } else if(x==5) {
          return "Sisesta konto number kust kanda, kuuhu kanda ja kui palju kanda /lesson4/transferFrom/####/####/####";
        } else return "Programm lõpetatud";
    }

    @GetMapping("lesson4/createAccount/{a}")
    public String createAccount(@PathVariable("a") String kontoNumber){
        account.put(kontoNumber, 0.0);
        return "Konto nr " + kontoNumber + " loodud";
    }

    @GetMapping("lesson4/getBalance/{a}")
    public String getBalance(@PathVariable("a") String kontoNumber){
        if(account.get(kontoNumber) == null) {
            return "Kntot ei eksisteeri";
        } else {
        return "Kontol on " + account.get(kontoNumber) + " eurot";
        }
    }

    @GetMapping("lesson4/depositMoney/{a}/{b}")
    public String depositMoney(@PathVariable("a") String kontoNumber, @PathVariable("b") double summa){
        if(account.get(kontoNumber) == null) {
            return "Kntot ei eksisteeri";
        } else if(summa < 0) {
            return "Lisatav summa ei tohi olla väiksem kui 0";
        } else {
            account.put(kontoNumber, (account.get(kontoNumber) + summa));
            return "Kontole nr " + kontoNumber + " on lisatud " + summa + " eurot. Jääk on " + account.get(kontoNumber) + " eurot";
        }
    }

    @GetMapping("lesson4/withdrawMoney/{a}/{b}")
    public String withdrawMoney(@PathVariable("a") String kontoNumber, @PathVariable("b") double summa){
        if(account.get(kontoNumber) == null) {
            return "Kntot ei eksisteeri";
        } else if(summa < 0) {
            return "Välja võetav summa ei tohi olla väiksem kui 0";
        } else {
            account.put(kontoNumber, (account.get(kontoNumber) - summa));
            return "Kontol nr " + kontoNumber + " jääk on " + account.get(kontoNumber) + " eurot";
        }
    }

    @GetMapping("lesson4/transferMoney/{a}/{b}/{c}")
    public String transferMoney(@PathVariable("a") String kontoNumber, @PathVariable("b") String sihtKontoNumber, @PathVariable("c") double summa){
        if(account.get(kontoNumber) == null || account.get(sihtKontoNumber) == null) {
            return "Kontot ei eksisteeri";
        } else if(summa < 0) {
            return "Üle kantav summa ei tohi olla väiksem kui 0";
        } else {
            account.put(kontoNumber, (account.get(kontoNumber) - summa));
            account.put(sihtKontoNumber, (account.get(sihtKontoNumber) + summa));
            return "Kontolt nr " + kontoNumber + " kantud kontole " + sihtKontoNumber + summa + " eurot.";
        }
    }


}
