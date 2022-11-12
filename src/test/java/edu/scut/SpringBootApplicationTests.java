package edu.scut;

import edu.scut.dao.DemoDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.boot.test.context.SpringBootTest
public class SpringBootApplicationTests {
    @Autowired
    private DemoDao demoDao;

    @Test
    void test()
    {
        System.out.println(demoDao.findByName("hx").toString());
    }
}
