package ee.bcs.valiit.controller;

import ee.bcs.valiit.tasks.Lesson1;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class RandomGameHard {

    int lastNumber = 0;
    int beforeLastNumber = 0;
    int count = 0;

    @GetMapping("randomGameHard/{a}")
    public String guess(@PathVariable("a") int n) {
        if (count == 0) {
            if (n < 50 && n >= 0) {
                lastNumber = n;
                count++;
                return "Vale. Number on suurem";
            } else if (n > 50 && n < 100) {
                lastNumber = n;
                count++;
                return "Vale. Number on väiksem.";
            } else {
                return "Number on lubatud vahemikust väljas.";
            }

        } else if (count == 1) {
            if (lastNumber > 50) {
                beforeLastNumber = 0;
                if (n > lastNumber) {
                    return "See arv on lubatud vahemikust väljas. Proovi uuesti.";
                } else if (Lesson1.abs(n - beforeLastNumber) < Lesson1.abs(n - lastNumber)) {
                    beforeLastNumber = lastNumber;
                    lastNumber = n;
                    count++;
                    return "Vale. Number on suurem";
                } else if (Lesson1.abs(n - beforeLastNumber) > Lesson1.abs(n - lastNumber)) {
                    beforeLastNumber = beforeLastNumber;
                    lastNumber = n;
                    count++;
                    return "Vale. Number on väiksem.";
                } else if (Lesson1.abs(n - beforeLastNumber) > 1) {
                    beforeLastNumber = lastNumber;
                    lastNumber = n;
                    count++;
                    return "Vale. Number on suurem";
                }
            } else {
                beforeLastNumber = 100;
                if (Lesson1.abs(n - beforeLastNumber) < Lesson1.abs(n - lastNumber)) {
                    beforeLastNumber = lastNumber;
                    lastNumber = n;
                    count++;
                    return "Vale. Number on väiksem";

                } else if (Lesson1.abs(n - beforeLastNumber) > Lesson1.abs(n - lastNumber)) {
                    beforeLastNumber = beforeLastNumber;
                    lastNumber = n;
                    count++;
                    return "Vale. Number on suurem.";
                } else if (Lesson1.abs(n - beforeLastNumber) > 1) {
                    beforeLastNumber = lastNumber;
                    lastNumber = n;
                    count++;
                    return "Vale. Number on väiksem";
                }

            }


        } else {
            if (lastNumber < beforeLastNumber) {
                if (n < lastNumber || n > beforeLastNumber) {
                    return "See number on lubatud vahemikust väljas. Proovi uuesti";
                }
                if (Lesson1.abs(n - beforeLastNumber) < Lesson1.abs(n - lastNumber)) {
                    beforeLastNumber = lastNumber;
                    lastNumber = n;
                    count++;
                    return "Vale. Number on väiksem";
                }

                if (Lesson1.abs(n - beforeLastNumber) > Lesson1.abs(n - lastNumber)) {
                    beforeLastNumber = beforeLastNumber;
                    lastNumber = n;
                    count++;
                    return "Vale. Number on suurem.";
                }

                if (Lesson1.abs(n - beforeLastNumber) > 1) {
                    beforeLastNumber = lastNumber;
                    lastNumber = n;
                    count++;
                    return "Vale. Number on väiksem";
                }

            }

            if (lastNumber > beforeLastNumber) {
                if (n > lastNumber || n < beforeLastNumber) {
                    return "See number on lubatud vahemikust väljas. Proovi uuesti";
                }
                if (Lesson1.abs(n - beforeLastNumber) < Lesson1.abs(n - lastNumber)) {
                    beforeLastNumber = lastNumber;
                    lastNumber = n;
                    count++;
                    return "Vale. Number on suurem";
                }
                if (Lesson1.abs(n - beforeLastNumber) > Lesson1.abs(n - lastNumber)) {
                    beforeLastNumber = beforeLastNumber;
                    lastNumber = n;
                    count++;
                    return "Vale. Number on väiksem.";
                }

                if (Lesson1.abs(n - beforeLastNumber) > 1) {
                    beforeLastNumber = beforeLastNumber;
                    lastNumber = n;
                    count++;
                    return "Vale. Number on väiksem";
                }

            }
        }
        return "Õige. Sul kulus " + count + " katset.";
    }
}