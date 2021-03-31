package com.daming.bootstring.controller;

import com.daming.bootstring.model.Paper;
import com.daming.bootstring.service.PapersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : com.daming.bootstring.controller.PaperListController
 * 221801332
 */
@Controller
public class PaperListController {
    @Autowired
    private PapersService papersService;
    private ArrayList<Paper> papers = new ArrayList<>();

    @ResponseBody
    @RequestMapping("/getTable")
    public ArrayList<Paper> getPaper(String name){
//        ArrayList<Paper> papers = papersService.getKwd();
        if (papers.size() > 0){

        }else{
            papers = papersService.getKwd();
        }
        return papers;
    }
}
