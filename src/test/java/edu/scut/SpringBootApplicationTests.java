package edu.scut;

import edu.scut.dao.DamageDao;
import edu.scut.dao.DemoDao;
import edu.scut.dao.ReportDao;
import edu.scut.dao.WorkOrderDao;
import edu.scut.model.Damage;
import edu.scut.model.Report;
import edu.scut.model.WorkOrder;
import edu.scut.service.ReportService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.powermock.api.mockito.PowerMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@org.springframework.boot.test.context.SpringBootTest
public class SpringBootApplicationTests {
    @Autowired
    private DemoDao demoDao;

    @Autowired
    private ReportDao reportDao;

    @Autowired
    private WorkOrderDao workOrderDao;

    @Autowired
    private DamageDao damageDao;

    @Autowired
    ReportService reportService;

    @Test
    @Transactional
    @Rollback(value = false)
    void test()
    {

        Integer size = 11;
        String location = "middle";
        String street = "A";
        String district = "B";
        boolean expected = false;
        boolean actual = reportService.verifyReport(size,location,street,district);
        Assert.assertEquals("pass",expected,actual);


        size = 5;
        location = "ccc";
        street = "A";
        district = "C";
        Assert.assertEquals(false,reportService.verifyReport(size,location,street,district));

        size = 5;
        location = "middle";
        street = "A";
        district = "C";
        Assert.assertEquals(false,reportService.verifyReport(size,location,street,district));

        size = 5;
        location = "middle";
        street = "A";
        district = "B";
        Assert.assertEquals(true,reportService.verifyReport(size,location,street,district));
        //System.out.println(reportService.verifyReport(size, location, street, district));
    }

    @Test
    void t()
    {
        System.out.println(reportService.verifyReport(5, "middle", "A", "B"));
        //System.out.println(reportService.getStreet_district());
    }


}
