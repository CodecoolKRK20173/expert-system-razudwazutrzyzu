package expertsystem;

public class RuleParser extends XMLParser{

    RuleRepository ruleRepository;

    public RuleParser(){
        getRuleRepository();
    }

    public RuleRepository getRuleRepository(){
        RuleRepository ruleRepository = new RuleRepository();
        
        Document doc = XMLParser.doc;
        NodeList nList = doc.getElementsByTagName("Rule");
        System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

        for (int i = 0; i < nList.getLength(); i++) {

            Node nNode = nList.item(i);
                    
            System.out.println("\nCurrent Element :" + nNode.getNodeName()); //for test
                    
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
    
                Element eElement = (Element) nNode;
                
                System.out.println("Rule id : " + eElement.getAttribute("id")); //for test
                System.out.println("Question : " + eElement.getElementsByTagName("Question").item(0).getTextContent()); //for test
                Node answer = eElement.getElementsByTagName("Answer").item(0);
                NodeList selection = ((Element) answer).getElementsByTagName("Selection");
                for (int j = 0; j < selection.getLength(); j++) {
                    System.out.println(((Element) selection.item(j)).getAttribute("value")); //for test
                }
            }
        }
    }
    
}