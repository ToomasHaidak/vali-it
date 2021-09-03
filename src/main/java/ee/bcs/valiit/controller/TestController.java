package ee.bcs.valiit.controller;

import ee.bcs.valiit.tests.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @PostMapping("employee")
    public void addWorker(@RequestBody Worker worker) {
        String sql = "INSERT INTO employee (name, adress) VALUES (:employeeName, :employeeAdress)";
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("employeeName", worker.getName());
        paramMap.put("employeeAdress", worker.getAdress());
        jdbcTemplate.update(sql, paramMap);
//        workers.add(worker);
    }

    @PutMapping("employee/{a}")
    public void replaceWorker(@PathVariable("a") int x, @RequestBody Worker worker) {
        String sql = "update employee set name = :employeeName where id = :y";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("employeeName", worker.getName());
        paramMap.put("y", x);
        jdbcTemplate.update(sql, paramMap);
//        workers.add(x, worker);
    }

    @DeleteMapping("employee/{a}")
    public void deleteWorker(@PathVariable("a") int x) {
        String sql = "delete from employee where id = :jrkNumber";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("jrkNumber", x);
        jdbcTemplate.update(sql, paramMap);
//        workers.remove(x);
    }


    @GetMapping("test")
    public String getHelloWorld() {
        return "Hello World";
    }

    //    http://www.localhost:8080/test2/John
    @GetMapping("test2/{name}")
    public String test2(@PathVariable("name") String nimi) {
        return "Hello " + nimi;
    }

// http://www.localhost:8080/test3?name=Siim

    @GetMapping("test3")
    public String test3(@RequestParam("name") String nimi) {
        return "Hello " + nimi;
    }

    @GetMapping("test4")
    public String test4(String nimi) {
        return "Hello " + nimi;
    }

    @GetMapping("test5")
    public Worker test5() {
        Worker worker = new Worker();
        worker.setName("Toomas");
        worker.setAdress("Tallinn");
        return worker;
    }

    @PostMapping("test5")
    public Worker test5Post(@RequestBody Worker worker) {
        return worker;
    }

    List<Worker> workers = new ArrayList<>();

    @GetMapping("employee")
    public List<Worker> getWorkers() {
        return workers;
    }


    @GetMapping("employee/{a}")
    public String getWorker(@PathVariable("a") int x) {
        String sql = "select name from employee where id = :y";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("y", x);
        return jdbcTemplate.queryForObject(sql, paramMap, String.class);

//        return workers.get(x);
    }


    @GetMapping("employee/test3/{id}")
    public Worker test3(@PathVariable("id") int id) {
        String sql = "select * from employee where id = :id";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        Worker vastus = jdbcTemplate.queryForObject(sql, paramMap, new WorkerRowMapper());
        return vastus;
    }

    @GetMapping("employee/test4")
    public List<Worker> test4() {
        String sql = "select * employee";
        Map<String, Object> paramMap = new HashMap<>();
        List<Worker> vastus = jdbcTemplate.query(sql, paramMap, new WorkerRowMapper());
        return vastus;
    }

    public static class WorkerRowMapper implements RowMapper<Worker> {

        @Override
        public Worker mapRow(ResultSet resultSet, int i) throws SQLException {
            Worker result = new Worker();
            result.setId(resultSet.getInt("id"));
            result.setName(resultSet.getString("name"));
            result.setAdress(resultSet.getString("adress"));
            return result;
        }
    }
}
