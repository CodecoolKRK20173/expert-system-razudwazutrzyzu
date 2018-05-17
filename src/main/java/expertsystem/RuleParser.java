package expertsystem;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessOrder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.util.ArrayList;

public class RuleParser extends XMLParser{

    public RuleRepository getRuleRepository(){
        RuleRepository ruleRepository = new RuleRepository();
        XMLParser.loadXMLDocument("src/main/java/expertsystem/xmls/Rules.xml");
        Document doc = XMLParser.doc;
        NodeList nList = doc.getElementsByTagName("Rule");

        for (int i = 0; i < nList.getLength(); i++) {
            Element nNode = (Element) nList.item(i);
                    
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Question question = createQuestion(nNode);
                ruleRepository.addQuestion(question);
            }
        }
        return ruleRepository;
    }

    private Question createQuestion(Element eElement){
        String questionID = eElement.getAttribute("id");
        String questionName = eElement.getElementsByTagName("Question").item(0).getTextContent();
        Node nAnswer = eElement.getElementsByTagName("Answer").item(0);
        NodeList selection = ((Element) nAnswer).getElementsByTagName("Selection");
        Answer answer = new Answer();

        for (int j = 0; j < selection.getLength(); j++) {
            Value value = addValueToAnswer(selection.item(j));
            answer.addValue(value);
        }
        Question question = new Question(questionID, questionName, answer);
        return question;
    }

    private Value addValueToAnswer(Node selectionItem){
        Value value;
        Boolean state = ((Element) selectionItem).getAttribute("value").equals("true");
        Element selectionElement = (Element) selectionItem;

        if(selectionElement.getElementsByTagName("SingleValue").getLength() > 0){
            NodeList nSelection = selectionElement.getElementsByTagName("SingleValue");
            String valueName = ((Element) nSelection.item(0)).getAttribute("value");
            value = new SingleValue(valueName ,state);
        }else{
            NodeList nSelection = selectionElement.getElementsByTagName("MultipleValue");
            String valueName = ((Element) nSelection.item(0)).getAttribute("value");
            value = new MultipleValue(getValueList(valueName),state);
        }
        return value;
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