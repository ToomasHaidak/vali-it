package ee.bcs.valiit.controller;

import ee.bcs.valiit.tasks.Lesson2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Lesson2Controller {

    @GetMapping("lesson2/sampleArray")
    public int[] sampleArray() {
        return Lesson2.sampleArray();
    }

    @GetMapping("lesson2/firstN/{a}")
    public int[] firstN(@PathVariable("a") int n) {
        return Lesson2.firstN(n);
    }

    @GetMapping("lesson2/generateArray")
    public int[] generateArray(@RequestParam("a") int n) {
        return Lesson2.generateArray(n);
    }

    @GetMapping("lesson2/decreasingArray/{a}")
    public int[] decreasingArray(@PathVariable("a") int n) {
        return Lesson2.decreasingArray(n);
    }

    @GetMapping("lesson2/yl3")
    public int[] yl3(@RequestParam("a") int n) {
        return Lesson2.yl3(n);
    }

}
