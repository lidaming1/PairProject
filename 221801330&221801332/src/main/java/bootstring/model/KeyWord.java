package com.daming.bootstring.model;

/**
 * @ClassName : com.daming.bootstring.model.KeyWord
 * 221801332
 */
public class KeyWord {
    private String word;
    private String year;
    private Integer frequency;

    public KeyWord(String word, String year, Integer frequency) {
        this.word = word;
        this.year = year;
        this.frequency = frequency;
    }

    public KeyWord(String word, Integer frequency) {
        this.word = word;
        this.frequency = frequency;
    }

    public KeyWord() {
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }
}
