package ee.bcs.valiit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class RandomGameController {

    Random random = new Random();
    int i = random.nextInt(100);
    int count = 0;

    @GetMapping("randomGame/{a}")
    public String guess(@PathVariable("a") int n) {
        if (n < i) {
            count = count + 1;
            return "Vale. Number on suurem";
        } else if (n > i) {
            count = count + 1;
            return "Vale. Number on väiksem";

        } else {
            return "Õige. Sul kulus " + count + " katset.";
        }
    }

}
