package com.daming.bootstring.mapper;

import com.daming.bootstring.model.Paper;

import java.util.ArrayList;

public interface PapersMapper {
    void insertMessage(Paper paper);
    ArrayList<Paper> getKwd();
    ArrayList<Paper> getYearByKwd(Paper paper);
}
