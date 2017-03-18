package com.xml.dom.test;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created by yunfei on 2017/3/18.
 */
public class DomTest {
    public static void main(String[] args) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse("books.xml");
            NodeList bookList = document.getElementsByTagName("book");
            System.out.println(bookList.getLength());
            for (int i = 0;i<bookList.getLength();i++){
                Node book = bookList.item(i);
                NamedNodeMap attrs = book.getAttributes();
                System.out.println("第" + (i+1)+"本书共有" + attrs.getLength()+"节点");
                for (int j =0;j<attrs.getLength();j++){
                    Node attr = attrs.item(j);
                    System.out.print("属性名：" + attr.getNodeName());
                    System.out.println("属性值：" + attr.getNodeValue());

                }
                /*Element book = (Element) bookList.item(i);
                String attrValue = book.getAttribute("id");
                System.out.println(attrValue);*/
                NodeList childNode = book.getChildNodes();
                System.out.println("第"+(i+1)+"本书共有"+childNode.getLength()+"节点");
                for (int k = 0;k<childNode.getLength();k++){
                    if(childNode.item(k).getNodeType() == Node.ELEMENT_NODE){
                        System.out.println(childNode.item(k).getNodeName());
                        System.out.println(childNode.item(k).getFirstChild().getNodeValue());
                        System.out.println(childNode.item(k).getTextContent());

                    }
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
