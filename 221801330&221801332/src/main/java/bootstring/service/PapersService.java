package com.daming.bootstring.service;

import com.daming.bootstring.mapper.PapersMapper;
import com.daming.bootstring.model.KeyWord;
import com.daming.bootstring.model.Paper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @ClassName : com.daming.bootstring.service.PapersService
 * 221801332
 */
@Service
public class PapersService {
    @Autowired
    private PapersMapper papersMapper;

    //将数据写入数据库中
    public void insertMessage(Paper paper){
        papersMapper.insertMessage(paper);
    }
    //获取数据库中所有论文数据 （select*
    public ArrayList<Paper> getKwd(){
        return papersMapper.getKwd();
    }
    //获取数据库中论文数据，根据keyword筛选
    public ArrayList<Paper> getYearByKwd(Paper paper){
        return papersMapper.getYearByKwd(paper);
    }

    //根据数据库查询到的论文，获取论文的关键词，并记录关键词频数
    //输入参数 论文列表 返回值 关键词：频数的hashmap列表
    public HashMap<String,Integer> getKeyWords(ArrayList<Paper> papers){
        HashMap<String,Integer> map = new HashMap<>();
        Paper paper;
        for (int i = 0; i < papers.size() ; i++){
            paper = papers.get(i);
            String[] words = paper.getKeyWords().split(",");
            for (String s:words) {
                if (map.containsKey(s)) {
                    //key存在
                    Integer value = map.get(s);
                    value++;
                    map.put(s, value);
                    //System.out.println(s);
                } else {
                    //key不存在
                    map.put(s, 1);
                }
            }
        }
        return map;
    }

    //根据 关键词：频数 排序hashmap中的论文数据，返回前十个 关键词：频数 的map信息
    public HashMap<String, Integer> sortMap( HashMap<String, Integer> map){
        List<Map.Entry<String, Integer>> list = new ArrayList<>();
        HashMap<String, Integer> topTenWords = new HashMap<>();
        Integer value ;
        String keyWord;
        //将map放入list中
        for (Map.Entry<String, Integer> entry : map.entrySet()){
            list.add(entry);
        }
        list.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();  //从大到小排列
            }
        });
        //将列表前十个存到hashmap
        for (int i = 0 ; i < 10 ; i ++ ){
            value = list.get(i).getValue();
            keyWord = list.get(i).getKey();
            System.out.println(value + " " + keyWord);
            topTenWords.put(keyWord, value);
        }
        return topTenWords;
    }

    //根据关键词获取到的论文列表 ， 根据 年份：频数存到map中
    //参数为前十的热词（topTenWords，返回值为keyword对象列表（keyWords
    public ArrayList<KeyWord> getKwdFrequency(HashMap<String, Integer> topTenWords){
        String word;
        ArrayList<KeyWord> keyWords = new ArrayList<>();
        for(HashMap.Entry<String, Integer> entry : topTenWords.entrySet()) {
            HashMap<String, Integer> wordsFrequency = new HashMap<>();
            word = entry.getKey();
            Paper paper = new Paper(word);
            //根据前10关键词获取论文集合
            ArrayList<Paper> papers = getYearByKwd(paper);
            //根据论文的年份计算该年热词频数
            for (int i = 0; i < papers.size() ; i++){
                paper = papers.get(i);
                if (wordsFrequency.containsKey(paper.getYear())) {
                    //key存在
                    Integer value = wordsFrequency.get(paper.getYear());
                    value++;
                    wordsFrequency.put(paper.getYear(), value);
                    //System.out.println(s);
                } else {
                    //key不存在
                    wordsFrequency.put(paper.getYear(), 1);
                }
            }
            //遍历HashMap，给Keyword对象赋值存到队列中
            for (HashMap.Entry<String, Integer> haEntry : wordsFrequency.entrySet()
                 ) {
                KeyWord keyWord = new KeyWord();
                keyWord.setFrequency(haEntry.getValue());
                keyWord.setWord(word);
                keyWord.setYear(haEntry.getKey());
                keyWords.add(keyWord);
                System.out.println(keyWord.getWord() + " " + keyWord.getYear() + " " + keyWord.getFrequency());
            }
        }
        return keyWords;
    }



}
