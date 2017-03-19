package com.xml.dom4j.test;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.*;

/**
 * Created by yunfei on 2017/3/19.
 */
public class Dom4jWriteTest {
    public static void main(String[] args) {
        Document document = DocumentHelper.createDocument();
        Element rss = document.addElement("rss");
        rss.addAttribute("version","2.0");
        Element channel = rss.addElement("channel");
        Element title = channel.addElement("title");
        title.setText("新闻订阅");
        OutputFormat format = OutputFormat.createPrettyPrint();
//        format.setEncoding("GBK");
        File file = new File("dom4jBook.xml");
        XMLWriter writer = null;
        try {
            writer = new XMLWriter(new FileOutputStream(file),format);
            //设置是否转义
            writer.setEscapeText(false);
            writer.write(document);
            writer.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
