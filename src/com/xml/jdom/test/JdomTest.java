package com.xml.jdom.test;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by yunfei on 2017/3/18.
 */
public class JdomTest {
    public static void main(String[] args) {
        SAXBuilder saxBuilder = new SAXBuilder();
        try {
            InputStream is = new FileInputStream("E:\\java\\xml\\books.xml");
            Document document = saxBuilder.build(is);
            Element rootElement = document.getRootElement();
            List<Element> childElement = rootElement.getChildren();
            for (Element child:childElement){
                System.out.println("开始解析" + (childElement.indexOf(child)+1));
                List<Attribute> lists = child.getAttributes();
                for (Attribute list: lists){
                    System.out.println(list.getName() + "---" +  list.getValue());
                }
                List<Element> bookChilds = child.getChildren();
                for (Element bookChild: bookChilds){
                    System.out.println(bookChild.getName() + "---" + bookChild.getValue());
                }
                System.out.println("结束解析" + (childElement.indexOf(child)+1));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
