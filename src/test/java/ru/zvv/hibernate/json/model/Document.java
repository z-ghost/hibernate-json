package ru.zvv.hibernate.json.model;

import java.util.List;

/**
 * Created by z-ghost on 08.12.2014.
 */
public class Document {
    String name;

    List<Chapter> chapterList;

    public String getName() {
        return name;
    }

    public void setChapterList(List<Chapter> chapterList) {
        this.chapterList = chapterList;
    }

    public List<Chapter> getChapterList() {
        return chapterList;
    }
}
