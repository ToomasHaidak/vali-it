package ee.bcs.valiit.controller;

import ee.bcs.valiit.tasks.Lesson2;
import ee.bcs.valiit.tasks.Lesson2b;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Lesson2bController {

    @GetMapping("lesson2b/reverseArray")
    public int[] reverseArray(int[] array) {
        return Lesson2b.reverseArray(array);
    }

    @GetMapping("lesson2b/evenNumbers/{a}")
    public int[] evenNumbers(@PathVariable("a") int n) {
        return Lesson2b.evenNumbers(n);
    }

    @GetMapping("lesson2b/min")
    public int min(int[] array) {
        return Lesson2b.min(array);
    }

    @GetMapping("lesson2b/max")
    public int max(int[] array) {
        return Lesson2b.max(array);
    }

    @GetMapping("lesson2b/sum")
    public int sum(int[] array) {
        return Lesson2b.sum(array);
    }

    @GetMapping("lesson2b/fibonacci/{a}")
    public int fibonacci(@PathVariable("a") int n) {
        return Lesson2b.fibonacci(n);
    }

    @GetMapping("lesson2b/sequence3n/{a}/{b}")
    public int sequence3n(@PathVariable("a") int x, @PathVariable("b") int y) {
        return Lesson2b.sequence3n(x, y);
    }
}
