package com.daming.bootstring.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONArray;
import com.daming.bootstring.model.Paper;
import sun.misc.Cleaner;
import sun.nio.ch.DirectBuffer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;


/**
 * @ClassName : com.daming.bootstring.service.ReadJsonFile
 * 221801332
 */
public class ReadJsonFile {
    private static String ECCV_ROOT = "D://Tencent Files/论文数据/论文数据/ECCV（2016至2020，3033份）";
    private static String ICCV_ROOT = "D://Tencent Files/论文数据/论文数据/ICCV（2001年至2019年，3196篇）";
    private static String CVPR_ROOT = "D://Tencent Files/论文数据/论文数据/CVPR（2000年至2020年，6916篇";
    private static int i = 1;
    /**
     * 文件读入，使用mmap
     *
     * @param file 输入文件
     * @return 文件内容，如果空则为""
     */
    public static String readMMAP(File file){
        RandomAccessFile raf = null;
        MappedByteBuffer mbb = null;
        try {
            raf = new RandomAccessFile(file, "r");
            mbb = raf.getChannel().map(FileChannel.MapMode.READ_ONLY, 0, file.length());
            if (mbb != null){
                return StandardCharsets.UTF_8.decode(mbb).toString();
            } else {
                return "";
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (mbb != null){
                Cleaner var1 = ((DirectBuffer)mbb).cleaner();
                if (var1 != null) {
                    var1.clean();
                }
            }
            if (raf != null){
                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "";
    }

    //读取文件及转化为paper列表
    public static List<Paper> readECCV() {
        File root = new File(ECCV_ROOT);
        File[] files = root.listFiles();
        List<Paper> papers = new ArrayList<>(4096);
        for (File file : files) {

            JSONObject jsonObject = JSON.parseObject(readMMAP(file));
            Paper paper = new Paper();
            paper.setTitle(jsonObject.getString("论文名称"));
            paper.setPaperAbstract(jsonObject.getString("摘要"));
            paper.setUrl(jsonObject.getString("原文链接"));
            paper.setMeeting("ECCV");
            paper.setYear(jsonObject.getString("会议和年份").split(" ")[1]);
            JSONArray keys = jsonObject.getJSONArray("关键词");
            StringBuilder sb = new StringBuilder();
            for (Object key : keys) {
                sb.append(key).append(",");
            }
            paper.setKeyWords(sb.toString());
            papers.add(paper);
        }
        return papers;
    }

    public static List<Paper> readICCV() {
        File root = new File(ICCV_ROOT);
        File[] files = root.listFiles();
        List<Paper> papers = new ArrayList<>(4096);
        for (File file : files) {
            String ori = readMMAP(file);

            JSONObject jsonObject = JSON.parseObject(ori.substring(0, ori.length()-1));
            Paper paper = new Paper();
            paper.setTitle(jsonObject.getString("title"));
            paper.setPaperAbstract(jsonObject.getString("abstract"));
            paper.setUrl(jsonObject.getString("doiLink"));
            paper.setMeeting("ICCV");
            paper.setYear(jsonObject.getString("publicationYear"));
            if (jsonObject.getJSONArray("keywords")==null)
            {
                continue;
            }
            if(jsonObject.getJSONArray("keywords").getJSONObject(0)==null)
            {
                continue;
            }
            if (jsonObject.getJSONArray("keywords").getJSONObject(0).getJSONArray("kwd")==null)
            {
                continue;
            }
            JSONArray keys = jsonObject.getJSONArray("keywords").getJSONObject(0).getJSONArray("kwd");
            StringBuilder sb = new StringBuilder();
            for (Object key : keys) {
                sb.append(key).append(",");
            }
            paper.setKeyWords(sb.toString());
            papers.add(paper);
        }
        return papers;
    }

    public static List<Paper> readCVPR() {
        File root = new File(CVPR_ROOT);
        File[] files = root.listFiles();
        List<Paper> papers = new ArrayList<>(7000);
        for (File file : files) {
            String ori = readMMAP(file);
            JSONObject jsonObject = JSON.parseObject(ori.substring(0, ori.length()-1));
            Paper paper = new Paper();
            paper.setTitle(jsonObject.getString("title"));
            paper.setPaperAbstract(jsonObject.getString("abstract"));
            paper.setUrl(jsonObject.getString("doiLink"));
            paper.setMeeting("CVPR");
            paper.setYear(jsonObject.getString("publicationYear"));
            if (jsonObject.getJSONArray("keywords")==null)
            {
                continue;
            }
            if(jsonObject.getJSONArray("keywords").getJSONObject(0)==null)
            {
                continue;
            }
            if (jsonObject.getJSONArray("keywords").getJSONObject(0).getJSONArray("kwd")==null)
            {
                continue;
            }
            JSONArray keys = jsonObject.getJSONArray("keywords").getJSONObject(0).getJSONArray("kwd");
            StringBuilder sb = new StringBuilder();
            for (Object key : keys) {
                sb.append(key).append(",");
            }
            paper.setKeyWords(sb.toString());
            papers.add(paper);
        }
        return papers;
    }



}
