package com.xml.jdom.test;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by yunfei on 2017/3/19.
 */
public class JdomWriteTest {
    public static void main(String[] args) {
        Element rss = new Element("rss");
        rss.setAttribute("version","2.0");
        Document document = new Document(rss);
        Element channel = new Element("channel");
        rss.addContent(channel);
        Element title = new Element("title");
        title.setText("订阅");
        channel.addContent(title);
        Format format = Format.getCompactFormat();
        format.setIndent("");
//        format.setEncoding("");
        XMLOutputter outputter = new XMLOutputter(format);
        try {
            outputter.output(document,new FileOutputStream(new File("jdomBook.xml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
