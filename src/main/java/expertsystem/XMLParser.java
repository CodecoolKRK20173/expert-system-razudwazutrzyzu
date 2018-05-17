package expertsystem;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import java.io.File;

public abstract class XMLParser{
    public static Document doc;

    public void loadXMLDocument(String xmlPath){

        try{
        File fXmlFile = new File(xmlPath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        this.doc = dBuilder.parse(fXmlFile);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}