package ru.zvv.hibernate.json.model;

/**
 * Created by z-ghost on 08.12.2014.
 */
public class Chapter {
    private int number;
    private String title;
    private String content;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
