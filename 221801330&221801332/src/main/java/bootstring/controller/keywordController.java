package com.daming.bootstring.controller;

import com.daming.bootstring.model.KeyWord;
import com.daming.bootstring.model.Paper;
import com.daming.bootstring.service.PapersService;
import com.daming.bootstring.service.ReadJsonFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName : com.daming.bootstring.controller.keywordController
 * 221801332
 */
@RestController
@RequestMapping("/paper")
public class keywordController {

    @Autowired
    private PapersService papersService;

    @GetMapping("/paper")
    public String create(){
        ReadJsonFile readJsonFile = new ReadJsonFile();
        Paper paper = new Paper();
        List<Paper> papers = new ArrayList<>();
        papers = ReadJsonFile.readCVPR();
        for (int i = 0;i < papers.size(); i++){
            papersService.insertMessage(papers.get(i));
        }
//        ArrayList<Paper> papers = papersService.getKwd();
////        for (int i = 0 ; i < papers.size() ; i++){
////            System.out.println(papers.get(i).getKeyWords());
////        }
//        //获取
//        HashMap<String, Integer> map = papersService.getKeyWords( papers );
//        //获取前十个热词
//        HashMap<String, Integer> sortedMap = papersService.sortMap(map);
//        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
//            System.out.println(entry.getKey() + " value " + entry.getValue());
//        }
//        ArrayList<KeyWord> keyWords = papersService.getKwdFrequency(sortedMap);
        return "city";
    }

}
