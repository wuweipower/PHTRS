package edu.scut.controller;

import edu.scut.dao.WorkOrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkOrderController {
    @Autowired
    WorkOrderDao workOrderDao;

}
