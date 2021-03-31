package com.daming.bootstring.model;

/**
 * @ClassName : com.daming.bootstring.model.Paper
 * 221801332
 */
public class Paper {
    private String keyWords;
    private int id;
    private String paperAbstract;
    private String meeting;
    private String title;
    private String url;
    private String year;

    public Paper(String keyWords, int id, String paperAbstract, String meeting, String title, String url) {
        this.keyWords = keyWords;
        this.id = id;
        this.paperAbstract = paperAbstract;
        this.meeting = meeting;
        this.title = title;
        this.url = url;
    }

    public Paper(String keyWords) {
        this.keyWords = keyWords;
        this.id = 0;
        this.paperAbstract = "a";
        this.meeting = "meeting";
        this.title = "title";
        this.url = "url";
    }

    public Paper(String keyWords, int id, String paperAbstract, String meeting, String title, String url, String year) {
        this.keyWords = keyWords;
        this.id = id;
        this.paperAbstract = paperAbstract;
        this.meeting = meeting;
        this.title = title;
        this.url = url;
        this.year = year;
    }

    public Paper() {

    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPaperAbstract() {
        return paperAbstract;
    }

    public void setPaperAbstract(String paperAbstract) {
        this.paperAbstract = paperAbstract;
    }

    public String getMeeting() {
        return meeting;
    }

    public void setMeeting(String meeting) {
        this.meeting = meeting;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
