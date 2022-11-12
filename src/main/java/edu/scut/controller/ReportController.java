package edu.scut.controller;

import edu.scut.dao.ReportDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportController {
    @Autowired
    ReportDao reportDao;

}
