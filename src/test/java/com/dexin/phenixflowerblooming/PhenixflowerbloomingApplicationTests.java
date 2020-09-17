package com.dexin.phenixflowerblooming;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PhenixflowerbloomingApplicationTests {

    @Test
    void contextLoads() {
        Double b = 0.3;
        String c = "0.3";
        BigDecimal a = new BigDecimal(b);
        BigDecimal sd = new BigDecimal(c);
        System.out.println(a);
        System.out.println(sd);
    }

}
