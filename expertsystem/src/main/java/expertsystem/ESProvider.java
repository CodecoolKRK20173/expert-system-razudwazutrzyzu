package expertsystem;

import java.util.Map;
import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Iterator;
import java.util.Set;

public class ESProvider {

    private Scanner reader = new Scanner(System.in);
    private String userInput;
    private Map<String, Boolean> pairsOfMatches;

    private RuleRepository ruleRepository;
    private FactRepository factRepository;

    public ESProvider(FactParser factParser, RuleParser ruleParser){
        
        this.ruleRepository = ruleParser.getRuleRepository();
        this.factRepository = factParser.getFactRepository();
    }

    public void collectAnswers(){
        this.pairsOfMatches = new HashMap<>();
        Iterator<Question> iterator = this.ruleRepository.getIterator();

        while(iterator.hasNext()){    
            Question currentQuestion = iterator.next();
            boolean wrongInput = true;

            while(wrongInput){
                userInput = reader.nextLine();
                try{
                    pairsOfMatches.put(currentQuestion.getId(), currentQuestion.getEvaluatedAnswer(userInput));
                    wrongInput = false;
                }catch(InvalidParameterException e){
                    System.out.println("There is no option like that, try again.");
                    wrongInput = true;
                }
            }
            
        }
    }

    private boolean getAnswerByQuestion(String questionID){
        return pairsOfMatches.get(questionID).booleanValue();
    }

    public String evaluate(){
        Iterator<Fact> fIterator = factRepository.getIterator();

        while(fIterator.hasNext()){
            Fact fact = fIterator.next();
            Set<String> idList = fact.getIdSet();
            boolean valuespairsOfMatches = true;

            for(String id : idList){
                if(getAnswerByQuestion(id) != fact.getValueById(id)){
                    valuespairsOfMatches = false;
                }
            }

            if(valuespairsOfMatches){
                return fact.getDescription();
            }
        }
        return "\nSadly but language for you doesn't exist.";
    }   
}