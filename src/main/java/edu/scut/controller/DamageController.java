package edu.scut.controller;

import edu.scut.dao.DamageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DamageController {
    @Autowired
    private DamageDao damageDao;
}
