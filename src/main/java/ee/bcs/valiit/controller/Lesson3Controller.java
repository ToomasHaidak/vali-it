package ee.bcs.valiit.controller;

import ee.bcs.valiit.tasks.Lesson3;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Lesson3Controller {

    @GetMapping("lesson3/factorial/{a}")
    public int factorial(@PathVariable("a") int x) {
        return Lesson3.factorial(x);
    }

    @GetMapping("lesson3/reverseString")
    public String reverseString(@RequestParam("a") String x) {
        return Lesson3.reverseString(x);
    }

    @GetMapping("lesson3/isPrime")
    public boolean isPrime(@RequestParam("a") int x) {
        return Lesson3.isPrime(x);
    }

    @GetMapping("lesson3/sortArray")
    public int[] sortArray(int[] x) {
        return Lesson3.sort(x);
    }

    @GetMapping("lesson3/evenFibonacci/{a}")
    public int evenFibonassi(@PathVariable("a") int x) {
        return Lesson3.evenFibonacci(x);
    }

    @GetMapping("lesson3/morseCode")
    public String morseCode(String x) {
        return Lesson3.morseCode(x);
    }
}
