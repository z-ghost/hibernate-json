package ru.zvv.hibernate.json.model;

import org.hibernate.annotations.Columns;
import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * Created by z-ghost on 08.12.2014.
 */
@Entity
public class DocumentEntity {

    @Id
    @GeneratedValue
    private Integer id;

    @Type(type = "ru.zvv.hibernate.json")
    private Document document;

    public Integer getId() {
        return id;
    }

    public Document getDocument() {
        return document;
    }
}
