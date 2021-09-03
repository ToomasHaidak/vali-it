package ee.bcs.valiit.controller;

import ee.bcs.valiit.tests.Konto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class Lesson5Controller {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    static Map<String, Konto> kontod = new HashMap<>();

    @GetMapping("lesson5/kuvaMenüü")
    public String kuvaMenüü() {
        return " Vali tegevus. Kirjuta URL-i # asemele vastava käsu number<br>" +
                "lesson5/valitegevus/# <br>" +
                "1 - Create account; 2 - Get balance; 3 - Deposit money; 4 - Withdraw money; 5 - Transfer between accounts; 6 - Lock account; 7 - Open account, 8 - Exit";
    }

    @GetMapping("/lesson5/valiTegevus/{a}")
    public String valiTegevus(@PathVariable("a") int x) {
        if (x == 1) {
            return "Sisesta konto number ja omaniku nimi <br> /lesson5/createAccount/####/aaaaa";
        } else if (x == 2) {
            return "Sisesta konto number /lesson5/getBalance/####";
        } else if (x == 3) {
            return "Sisesta konto number ja summa /lesson5/depositMoney/####/####";
        } else if (x == 4) {
            return "Sisesta konto number ja summa /lesson5/withdrawMoney/####/####";
        } else if (x == 5) {
            return "Sisesta konto number kust kanda, number kuhu kanda ja summa kui palju kanda /lesson5/transferFrom/####/####/####";
        } else if (x == 6) {
            return "Sisesta lukustatava konto number /lesson5/lockAccount/####";
        } else if (x == 7) {
            return "Sisesta avatava konto number /lesson5/unlockAccount/####";
        } else {
            return "Programm lõpetatud";
        }
    }

//    @GetMapping("lesson5/createAccount/{a}/{b}")
//    public String createAccount(@PathVariable("a") String kontoNumber, @PathVariable("b") String omanikuNimi) {
//        Konto konto = new Konto();
//        konto.setKontoNumber(kontoNumber);
//        konto.setOmanikuNimi(omanikuNimi);
//        kontod.put(kontoNumber, konto);
//        return "Konto nr " + kontoNumber + " loodud";
//    }

    @GetMapping("lesson5/createAccount/{a}/{b}")
    public String createAccount(@PathVariable("a") String kontoNumber, @PathVariable("b") String omanikuNimi) {
        String sql = "insert into bank(iban, name, balanss, lukus) values(:ibanivaartus, :nimevaartus, :balanssvaartus, :lukusvaartus)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("ibanivaartus", kontoNumber);
        paramMap.put("nimevaartus", omanikuNimi);
        paramMap.put("balanssvaartus", 0);
        paramMap.put("lukusvaartus", false);
        jdbcTemplate.update(sql, paramMap);
        return "Konto nr " + kontoNumber + " loodud";
    }

//    @GetMapping("lesson5/getBalance/{a}")
//    public String getBalance(@PathVariable("a") String kontoNumber) {
//        if (kontod.get(kontoNumber) == null) {
//            return "Kontot ei eksisteeri";
//        } else {
//            return "Kontol on " + kontod.get(kontoNumber).getBalanss() + " eurot";
//        }
//    }

    @GetMapping("lesson5/getBalance/{a}")
    public String getBalance(@PathVariable("a") String kontoNumber) {
        String sql = "select balanss from bank where iban = :kontonumber";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("kontonumber", kontoNumber);
        return "Kontol on " + jdbcTemplate.queryForObject(sql, paramMap, double.class) + " eurot.";
    }

//    @GetMapping("lesson5/depositMoney/{a}/{b}")
//    public String depositMoney(@PathVariable("a") String kontoNumber, @PathVariable("b") double summa) {
//        if (kontod.get(kontoNumber) == null) {
//            return "Kontot ei eksisteeri";
//        } else if (summa < 0) {
//            return "Lisatav summa ei tohi olla väiksem kui 0";
//        } else if (kontod.get(kontoNumber).isKasOnLukus() == true) {
//            return "Konto on lukus. Ei saa raha lisada";
//        } else {
//            kontod.get(kontoNumber).setBalanss(kontod.get(kontoNumber).getBalanss() + summa);
//            return "Kontole nr " + kontoNumber + " on lisatud " + summa + " eurot. Jääk on " + kontod.get(kontoNumber).getBalanss() + " eurot";
//        }
//    }

    @GetMapping("lesson5/depositMoney/{a}/{b}")
    public String depositMoney(@PathVariable("a") String kontoNumber, @PathVariable("b") double summa) {
        String sqlIban = "select iban from bank where iban = :kontonr";
        String sqlLukus = "select lukus from bank where iban = :kontonr";
        String sqlBalanss = "select balanss from bank where iban = :kontonr";
        String sqlBalanssPluss = "update bank set balanss = :uussumma where iban = :kontonr;";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("kontonr", kontoNumber);

        if (jdbcTemplate.queryForObject(sqlIban, paramMap, String.class) == null) {
            return "Kontot ei eksisteeri";
        } else if (summa < 0) {
            return "Lisatav summa ei tohi olla väiksem kui 0";
        } else if (jdbcTemplate.queryForObject(sqlLukus, paramMap, boolean.class) == true) {
            return "Konto on lukus. Ei saa raha lisada";
        } else {
            double uussumma = (jdbcTemplate.queryForObject(sqlBalanss, paramMap, double.class)) + summa;
            paramMap.put("uussumma", uussumma);
            jdbcTemplate.update(sqlBalanssPluss, paramMap);
            return "Kontole nr " + kontoNumber + " on lisatud " + summa + " eurot. Jääk on " + jdbcTemplate.queryForObject(sqlBalanss, paramMap, double.class);
        }
    }

//    @GetMapping("lesson5/withdrawMoney/{a}/{b}")
//    public String withdrawMoney(@PathVariable("a") String kontoNumber, @PathVariable("b") double summa) {
//        if (kontod.get(kontoNumber) == null) {
//            return "Kontot ei eksisteeri";
//        } else if (summa < 0) {
//            return "Välja võetav summa ei tohi olla väiksem kui 0";
//        } else if (kontod.get(kontoNumber).isKasOnLukus() == true) {
//            return "Konto on lukus. Ei saa raha lisada";
//        } else {
//            kontod.get(kontoNumber).setBalanss(kontod.get(kontoNumber).getBalanss() - summa);
//            return "Konto nr " + kontoNumber + " jääk on " + kontod.get(kontoNumber).getBalanss() + " eurot";
//        }
//    }

    @GetMapping("lesson5/withdrawMoney/{a}/{b}")
    public String withdrawMoney(@PathVariable("a") String kontoNumber, @PathVariable("b") double summa) {
        String sqlIban = "select iban from bank where iban = :kontonr";
        String sqlLukus = "select lukus from bank where iban = :kontonr";
        String sqlBalanss = "select balanss from bank where iban = :kontonr";
        String sqlBalanssMiinus = "update bank set balanss = :uussumma where iban = :kontonr;";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("kontonr", kontoNumber);

        if (jdbcTemplate.queryForObject(sqlIban, paramMap, String.class) == null) {
            return "Kontot ei eksisteeri";
        } else if (summa < 0) {
            return "Lisatav summa ei tohi olla väiksem kui 0";
        } else if (jdbcTemplate.queryForObject(sqlLukus, paramMap, boolean.class) == true) {
            return "Konto on lukus. Ei saa raha välja võtta";
        } else {
            double uussumma = (jdbcTemplate.queryForObject(sqlBalanss, paramMap, double.class)) - summa;
            paramMap.put("uussumma", uussumma);
            jdbcTemplate.update(sqlBalanssMiinus, paramMap);
            return "Kontolt nr " + kontoNumber + " võeti " + summa + " eurot. Jääk on " + jdbcTemplate.queryForObject(sqlBalanss, paramMap, double.class);
        }
    }

//    @GetMapping("lesson5/transferMoney/{a}/{b}/{c}")
//    public String transferMoney(@PathVariable("a") String kontoNumber, @PathVariable("b") String sihtKontoNumber, @PathVariable("c") double summa) {
//        if (kontod.get(kontoNumber) == null || kontod.get(sihtKontoNumber) == null) {
//            return "Kontot ei eksisteeri";
//        } else if (summa < 0) {
//            return "Üle kantav summa ei tohi olla väiksem kui 0";
//        } else if (kontod.get(kontoNumber).isKasOnLukus() == true || kontod.get(sihtKontoNumber).isKasOnLukus() == true) {
//            return "Üks või mõlemad kontod on lukus. Ei saa raha liigutada";
//        } else {
//            kontod.get(kontoNumber).setBalanss(kontod.get(kontoNumber).getBalanss() - summa);
//            kontod.get(sihtKontoNumber).setBalanss(kontod.get(sihtKontoNumber).getBalanss() + summa);
//            return "Kontolt nr " + kontoNumber + " kantud kontole " + sihtKontoNumber + summa + " eurot.";
//        }
//    }

    @GetMapping("lesson5/transferMoney/{a}/{b}/{c}")
    public String transferMoney(@PathVariable("a") String kontoNumber, @PathVariable("b") String sihtKontoNumber, @PathVariable("c") double summa) {
        String sqlIban = "select iban from bank where iban = :kontonr";
        String sqlIban2 = "select iban from bank where iban = :sihtkontonr";
        String sqlLukus = "select lukus from bank where iban = :kontonr";
        String sqlLukus2 = "select lukus from bank where iban = :sihtkontonr";
        String sqlBalanss = "select balanss from bank where iban = :kontonr";
        String sqlBalanss2 = "select balanss from bank where iban = :sihtkontonr";
        String sqlBalanssMiinus = "update bank set balanss = :uussummamiinus where iban = :kontonr;";
        String sqlBalanssPluss = "update bank set balanss = :uussummapluss where iban = :sihtkontonr;";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("kontonr", kontoNumber);
        paramMap.put("sihtkontonr", sihtKontoNumber);

        if (jdbcTemplate.queryForObject(sqlIban, paramMap, String.class) == null) {
            return "Kontot ei eksisteeri";
        } else if (summa < 0) {
            return "Üle kantav summa ei tohi olla väiksem kui 0";
        } else if (jdbcTemplate.queryForObject(sqlLukus, paramMap, boolean.class) == true) {
            return "Konto kust raha tahetakse võtta on lukus. Ei saa raha välja võtta";
        } else if (jdbcTemplate.queryForObject(sqlLukus2, paramMap, boolean.class) == true) {
            return "Konto kuhu raha tahetakse kanda on lukus. Ei saa raha lisada";
        } else {
            double uussummamiinus = (jdbcTemplate.queryForObject(sqlBalanss, paramMap, double.class)) - summa;
            paramMap.put("uussummamiinus", uussummamiinus);
            double uussummapluss = (jdbcTemplate.queryForObject(sqlBalanss2, paramMap, double.class)) + summa;
            paramMap.put("uussummapluss", uussummapluss);
            jdbcTemplate.update(sqlBalanssMiinus, paramMap);
            jdbcTemplate.update(sqlBalanssPluss, paramMap);
            return "Kontolt nr " + kontoNumber + " võeti " + summa + " eurot. Jääk on " + jdbcTemplate.queryForObject(sqlBalanss, paramMap, double.class) + "<br>" +
                    "Kontole nr " + sihtKontoNumber + " kanti " + summa + " eurot. Jääk on " + jdbcTemplate.queryForObject(sqlBalanss2, paramMap, double.class);
        }
    }

//    @GetMapping("lesson5/lockAccount/{a}")
//    public String lockAccount(@PathVariable("a") String kontoNumber) {
//        kontod.get(kontoNumber).setKasOnLukus(true);
//        return "Konto nr " + kontoNumber + " on lukustatud";
//    }

    @GetMapping("lesson5/lockAccount/{a}")
    public String lockAccount(@PathVariable("a") String kontoNumber) {
        String sql = "update bank set lukus = 'true' where iban = :kontoNr";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("kontoNr", kontoNumber);
        jdbcTemplate.update(sql, paramMap);
        return "Konto nr " + kontoNumber + " on lukustatud";
    }

//    @GetMapping("lesson5/openAccount/{a}")
//    public String openAccount(@PathVariable("a") String kontoNumber) {
//        kontod.get(kontoNumber).setKasOnLukus(false);
//        return "Konto nr " + kontoNumber + " on avatud";
//    }

    @GetMapping("lesson5/openAccount/{a}")
    public String openAccount(@PathVariable("a") String kontoNumber) {
        String sql = "update bank set lukus = 'false' where iban = :kontoNr";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("kontoNr", kontoNumber);
        jdbcTemplate.update(sql, paramMap);
        return "Konto nr " + kontoNumber + " on lukust avatud.";
    }

//    @GetMapping("lesson5/wholeTable/")
//    public String wholeTable() {
//        String sql = "select * from bank";
//        return jdbcTemplate.update(sql);
//    }

    @GetMapping("lesson5/tulp")
    public List<String> tulp() {
        String sql = "select name from bank";
        Map<String, Object> paramMap = new HashMap<>();
        List<String> vastus = jdbcTemplate.queryForList(sql, paramMap, String.class);
        return vastus;
    }

    @GetMapping("lesson5/kuvaKonto/{id}")
    public Konto kuvaKonto(@PathVariable("id") String id) {
        String sql = "select * from bank where iban = :id";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        Konto vastus = jdbcTemplate.queryForObject(sql, paramMap, new KontoRowMapper());
        return vastus;
    }

    @GetMapping("lesson5/koguTabel")
    public List<Konto> koguTabel() {
        String sql = "select * from bank";
        Map<String, Object> paramMap = new HashMap<>();
        List<Konto> vastus = jdbcTemplate.query(sql, paramMap, new KontoRowMapper());
        return vastus;
    }

    public static class KontoRowMapper implements RowMapper<Konto> {

        @Override
        public Konto mapRow(ResultSet resultSet, int i) throws SQLException {
            Konto result = new Konto();
            result.setKontoNumber(resultSet.getString("iban"));
            result.setOmanikuNimi(resultSet.getString("name"));
            result.setBalanss(resultSet.getDouble("balanss"));
            result.setKasOnLukus(resultSet.getBoolean("lukus"));
            return result;

        }
    }


}
