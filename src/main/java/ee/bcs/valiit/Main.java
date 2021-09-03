package ee.bcs.valiit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int [] x = new int[20];

        List a  = new ArrayList();
        for (int i : x) {
            a.add(i);
        }

        a.toArray();
    }


}
