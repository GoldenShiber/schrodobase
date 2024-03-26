package com.schrodobase.schrodobert.controller;

import com.schrodobase.schrodobert.queries.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*
    Should include the rest APIs which are to be called by the main application component later.
 */
@Controller
public class CharacterController {

    @Autowired
    private QueryService queryService;

    @GetMapping("/")
    @ResponseBody
    @Transactional(readOnly = true)
    public String helloWorld(){
        return this.queryService.findByName("Kalle").name();
    }
}
