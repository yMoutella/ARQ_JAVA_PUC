package br.com.aulas.projeto;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProjetoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testMain() {
        System.setProperty("spring.main.web-application-type", "none");
        ProjetoApplication.main(new String[]{});
    }
}
