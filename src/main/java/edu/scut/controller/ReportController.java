package edu.scut.controller;

import edu.scut.body.ReportBody;
import edu.scut.dao.ReportDao;
import edu.scut.model.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/report")
@CrossOrigin
public class ReportController {
    @Autowired
    ReportDao reportDao;
    @PostMapping("/add")
    public void addReport(ReportBody reportBody)
    {
        //response.addHeader("Access-Control-Allow-Origin", "*");
        //response.addHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");

        reportDao.save(Report.builder()
                        .street(reportBody.getStreet())
                        .location(reportBody.getLocation())
                        .size(reportBody.getSize())
                        .district(reportBody.getDistrict())
                        //.priority(reportBody.getPriority())
                        .phone(reportBody.getPhone())
                        .address(reportBody.getAddress())
                        .build()
        );

        System.out.println(reportBody);
    }
    @GetMapping("/all")
    public List<Report> findAll()
    {
        List<Report> all = reportDao.findAll();
        return all;
    }

}
