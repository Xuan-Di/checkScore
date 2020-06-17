package com.wzxlq.score;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ScoreApplicationTests {

    @Test
    void contextLoads() {
        String name = "2017级软件工程一班";
        System.out.println(name.substring(0,name.length()-2));
    }

}
