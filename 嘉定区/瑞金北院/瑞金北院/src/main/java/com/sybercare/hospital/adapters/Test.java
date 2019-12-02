package com.sybercare.hospital.adapters;

import com.sybercare.hospital.health.entity.Patientinfo;
import org.dom4j.*;
import org.dom4j.xpath.DefaultXPath;
import org.xml.sax.Attributes;
import org.xml.sax.EntityResolver;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.soap.SOAPElement;
import java.io.IOException;
import java.util.*;

public class Test {
    public static void main(String[] args) throws DocumentException, ParserConfigurationException, SAXException, IOException {
        String string="<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<string xmlns=\"http://ESB.Service/\"><ActionResult><Success>True</Success><Data>\n" +
                "<xs:schema id=\"NewDataSet\" xmlns=\"\" xmlns:xs=\"http://www.w3.org/2001/XMLSchema\" xmlns:msdata=\"urn:schemas-microsoft-com:xml-msdata\">\n" +
                "  <xs:element name=\"NewDataSet\" msdata:IsDataSet=\"true\" msdata:UseCurrentLocale=\"true\">\n" +
                "    <xs:complexType>\n" +
                "      <xs:choice minOccurs=\"0\" maxOccurs=\"unbounded\">\n" +
                "        <xs:element name=\"Table\">\n" +
                "          <xs:complexType>\n" +
                "            <xs:sequence>\n" +
                "              <xs:element name=\"zylsh\" type=\"xs:string\" minOccurs=\"0\" />\n" +
                "              <xs:element name=\"xm\" type=\"xs:string\" minOccurs=\"0\" />\n" +
                "              <xs:element name=\"xb\" type=\"xs:string\" minOccurs=\"0\" />\n" +
                "              <xs:element name=\"cwmc\" type=\"xs:string\" minOccurs=\"0\" />\n" +
                "              <xs:element name=\"zyh\" type=\"xs:string\" minOccurs=\"0\" />\n" +
                "              <xs:element name=\"ylkh\" type=\"xs:string\" minOccurs=\"0\" />\n" +
                "              <xs:element name=\"zjlx\" type=\"xs:string\" minOccurs=\"0\" />\n" +
                "              <xs:element name=\"zjh\" type=\"xs:string\" minOccurs=\"0\" />\n" +
                "              <xs:element name=\"rysj\" type=\"xs:dateTime\" minOccurs=\"0\" />\n" +
                "              <xs:element name=\"cysj\" type=\"xs:dateTime\" minOccurs=\"0\" />\n" +
                "            </xs:sequence>\n" +
                "          </xs:complexType>\n" +
                "        </xs:element>\n" +
                "      </xs:choice>\n" +
                "    </xs:complexType>\n" +
                "  </xs:element>\n" +
                "</xs:schema>\n" +
                "</Data>\n" +
                "</ActionResult>\n" +
                "</string>";

       Document  document=DocumentHelper.parseText(string);
       // System.out.println(root.element("ActionResult").element("Data").element("schema").element("element").element("complexType"));
       /* Element sequence2= sequence1.element("schema");
        Element sequence3 = sequence2.element("element");
        Element sequence4 = sequence3.element("complexType");
        Element sequence5 = sequence4.element("choice");
        Element sequence6 = sequence5.element("element");
        Element sequence7 = sequence6.element("complexType");
        Element sequence8  = sequence7.element("sequence");
        System.out.println(sequence8);*/
        getNodes(document);
    }
   static void getNodes(Document document) {
       //递归遍历当前节点所有的子节点

      Map map = new HashMap();

       XPath x = document.createXPath("/*/*/*/*/*/*/*/*/*/*/*");
       List<Element> nodelist = x.selectNodes(document);
       for (Element element : nodelist) {
           map.put(element.attribute("name").getValue(),element.attribute("minOccurs").getValue());
       }
       System.out.println(map);
      // List<Element> listElement = node.elements();//所有一级子节点的list
      /* for (Element e : listElement) {//遍历所有一级子节点
           if (e.getName().equals("sequence")) {
               List<Element> listElements = e.elements();
               for (Element es : listElements) {
                   List<Attribute> listAttr = es.attributes();
                   String key = es.attribute("name").getValue();
                   String value = es.attribute("minOccurs").getValue();
                   map.put(key, value);
               }
              System.out.println(map);
               break;
           }
           getNodes(e);//递归}
       }*/
   }}
