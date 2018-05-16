package expertsystem;

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class ESProvider {

    FactRepository factRepository;
    private Scanner reader = new Scanner(System.in);
    private String input;
    private Map<String, Boolean> matches;

    public ESProvider(FactParser factParser, RuleParser ruleParser){
        this.factRepository.getFactRepository();
    }

    private void collectAnswers(){
        this.matches = new HashMap<>();

        while(questions.hasNext()){
            System.out.println(next().getQuestion());
            input = reader.nextLine();
            
            if(evaluateAnswerByInput(input)){
                matches.put(questions.next().getId(), odpowiadającaMuValue);
                break;
            }
            
        }
    }

    private boolean getAnswerByQuestion(String questionID){
        return true;
    }

    private String evaluate(){
        return null;
    }   
}