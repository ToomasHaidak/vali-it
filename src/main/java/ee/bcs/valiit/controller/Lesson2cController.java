package ee.bcs.valiit.controller;

import ee.bcs.valiit.tasks.Lesson2c;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Lesson2cController {

    @GetMapping("lesson2c/sequence3n")
    public int sequence(@RequestParam("a") int x, @RequestParam("b") int y) {
        return Lesson2c.sequence3n(x, y);
    }
}
