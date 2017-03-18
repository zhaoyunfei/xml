package com.xml.dom4j.test;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.Iterator;
import java.util.List;

/**
 * Created by yunfei on 2017/3/18.
 */
public class Dom4jTest {
    public static void main(String[] args) {
        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read("E:\\java\\xml\\books.xml");
            Element rootElement = document.getRootElement();
            Iterator iterator = rootElement.elementIterator();
            while (iterator.hasNext()){
                Element book = (Element) iterator.next();
                List<Attribute> bookAttrs = book.attributes();
                for (Attribute attr: bookAttrs){
                    System.out.println(attr.getName() + "---" + attr.getValue());
                }
                Iterator itt = book.elementIterator();
                while (itt.hasNext()){
                    Element bookChild = (Element) itt.next();
                    System.out.println(bookChild.getName() + "---" + bookChild.getStringValue());
                }
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
