package com.xml.dom.test;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 * Created by yunfei on 2017/3/19.
 */
public class DomWriteTest {
    public static void main(String[] args) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;
        try {
            db = dbf.newDocumentBuilder();
            Document document = db.newDocument();
            document.setXmlStandalone(true);
            Element bookstore = document.createElement("bookstore");
            Element book = document.createElement("book");
            Element name = document.createElement("name");
            name.setTextContent("小王子");
            book.appendChild(name);
            book.setAttribute("id","1");
            bookstore.appendChild(book);
            document.appendChild(bookstore);

            TransformerFactory tff = TransformerFactory.newInstance();
            Transformer tf = tff.newTransformer();
            tf.setOutputProperty(OutputKeys.INDENT,"yes");
            tf.transform(new DOMSource(document),new StreamResult(new File("book1.xml")));
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
