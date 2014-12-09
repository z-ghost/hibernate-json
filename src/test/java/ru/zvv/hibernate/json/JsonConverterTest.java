package ru.zvv.hibernate.json;

import org.junit.Assert;
import org.junit.Test;
import ru.zvv.hibernate.json.model.Chapter;
import ru.zvv.hibernate.json.model.Document;

import java.util.Arrays;

import static org.junit.Assert.*;

public class JsonConverterTest {

    public static final String JSON = "{\"chapterList\":[{\"title\":\"Test title\",\"number\":1,\"content\":\"Test content\"}],\"name\":\"Doc\"}";

    @Test
    public void testToJson() throws Exception {
        Document document = new Document();
        document.setName("Doc");
        Chapter chapter = new Chapter();
        chapter.setNumber(1);
        chapter.setTitle("Test title");
        chapter.setContent("Test content");
        document.setChapterList(Arrays.asList(chapter));

        Assert.assertEquals(JSON, new JsonConverter().toJson(document));
    }

    @Test
    public void testFromJson() throws Exception {
        Document doc = (Document)new JsonConverter().fromJson(JSON, Document.class);
        Assert.assertEquals("Doc", doc.getName());
        Assert.assertEquals(1, doc.getChapterList().size());
        Chapter chapter = doc.getChapterList().get(0);
        Assert.assertEquals(1, chapter.getNumber());
        Assert.assertEquals("Test title", chapter.getTitle());
        Assert.assertEquals("Test content", chapter.getContent());

    }
}