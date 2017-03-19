package com.xml.sax.test;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by yunfei on 2017/3/19.
 */
public class SaxWriteTest {
    public static void main(String[] args) {
        SAXTransformerFactory tff = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
        try {
            TransformerHandler handler = tff.newTransformerHandler();
            Transformer tr = handler.getTransformer();
            tr.setOutputProperty(OutputKeys.ENCODING,"utf-8");
            tr.setOutputProperty(OutputKeys.INDENT,"yes");
            File file = new File("saxBook.xml");
            if(!file.exists()){
                file.createNewFile();
            }
            Result result = new StreamResult(new FileOutputStream(file));
            handler.setResult(result);
            handler.startDocument();
            AttributesImpl attr = new AttributesImpl();
            handler.startElement("","","bookstore",attr);
            attr.clear();
            attr.addAttribute("","","id","","1");
            handler.startElement("","","book",attr);
            handler.endElement("","","book");
            handler.endElement("","","bookstore");
            handler.endDocument();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
