package com.xml.sax.test;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by yunfei on 2017/3/18.
 */
public class SaxParserHandler extends DefaultHandler {
    String value = null;
    Book book;
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        if(qName.equals("book")){
            book = new Book();
            /*String value = attributes.getValue("id");
            System.out.println(value);*/
            int num = attributes.getLength();
            for (int i = 0;i<num;i++){
                System.out.println(attributes.getQName(i) + "--" + attributes.getValue(i));
                if(attributes.getQName(i).equals("id")){
                    book.setId(attributes.getValue(i));
                }
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if(qName.equals("book")){
            System.out.println("遍历结束");
        }else if(qName.equals("name")){
            book.setName(value);
        }
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        System.out.println("sax解析开始");
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        System.out.println("sax解析结束");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        value = new String(ch,start,length);
        if(!value.trim().equals("")){
            System.out.println(value);
        }
    }
}
