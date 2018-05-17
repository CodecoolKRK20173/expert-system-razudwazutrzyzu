package expertsystem;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class FactParser extends XMLParser{

    public FactRepository getFactRepository(){
        FactRepository factRepository = new FactRepository();
        XMLParser.loadXMLDocument("src/main/java/expertsystem/xmls/Facts.xml");
        Document doc = XMLParser.doc;
        NodeList nList = doc.getElementsByTagName("Fact");

        for (int i = 0; i < nList.getLength(); i++) {
            Element eElement = (Element) nList.item(i);
                        
            if (eElement.getNodeType() == Node.ELEMENT_NODE) {
                Fact fact = createFact(eElement);
                factRepository.addFact(fact);
            }
        }
        return factRepository;
    }

    private Fact createFact(Element element){
        String id = element.getAttribute("id");
        String description = ((Element) element.getElementsByTagName("Description").item(0)).getAttribute("value");
        Fact fact = new Fact(id, description);
        
        Node evals = element.getElementsByTagName("Evals").item(0);
        NodeList selection = ((Element) evals).getElementsByTagName("Eval");

        for (int j = 0; j < selection.getLength(); j++) {
            String value = ((Element) selection.item(j)).getAttribute("id");
            Boolean state = ((Element)selection.item(j)).getTextContent().equals("true");
            fact.setFactValueById(value, state);
        }
        return fact;
    }
}