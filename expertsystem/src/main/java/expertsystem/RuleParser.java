package expertsystem;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessOrder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.util.ArrayList;

public class RuleParser extends XMLParser{

    RuleRepository ruleRepository;

    public RuleParser(){
        getRuleRepository();
    }

    public RuleRepository getRuleRepository(){
        RuleRepository ruleRepository = new RuleRepository();
        XMLParser.loadXMLDocument("xmls/Rules.xml");
        Document doc = XMLParser.doc;
        NodeList nList = doc.getElementsByTagName("Rule");
        System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

        for (int i = 0; i < nList.getLength(); i++) {

            Node nNode = nList.item(i);
                    
            System.out.println("\nCurrent Element :" + nNode.getNodeName()); //for test
                    
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                
                Element eElement = (Element) nNode;

                String questionID = eElement.getAttribute("id");
                String questionName = eElement.getElementsByTagName("Question").item(0).getTextContent();

                

                System.out.println("Rule id : " + eElement.getAttribute("id")); //for test
                System.out.println("Question : " + eElement.getElementsByTagName("Question").item(0).getTextContent()); //for test
                Node nAnswer = eElement.getElementsByTagName("Answer").item(0);
                NodeList selection = ((Element) nAnswer).getElementsByTagName("Selection");
                for (int j = 0; j < selection.getLength(); j++) {

                    Answer answer = new Answer();

                    Boolean state = ((Element) selection.item(j)).getAttribute("value").equals("true"); //for test
                    Node x = selection.item(j);
                    Element xElement = (Element) x;

                    if(xElement.getElementsByTagName("SingleValue").getLength() > 0){
                    String valueName = ((Element) xElement.getElementsByTagName("SingleValue").item(0)).getAttribute("value");
                    Value value = new SingleValue(valueName ,state);
                    answer.addValue(value);

                    }else{

                    String valueName = ((Element) xElement.getElementsByTagName("MultipleValue").item(0)).getAttribute("value");

                    Value value = new MultipleValue(getValueList(valueName),state);
                    answer.addValue(value);
                    }
                
                    Question question = new Question(questionID, questionName, answer);
                    ruleRepository.addQuestion(question);
                }
               
            }
        }
    
        return ruleRepository;
    }

    private List<String> getValueList(String valueName){
        List<String> valueList = new ArrayList<String>();

        String[] splitedValue = valueName.split(",");
        for(int i = 0; i < splitedValue.length; i++){
            valueList.add(splitedValue[i]);
        }
        return valueList;
    }
    
}