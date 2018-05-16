package expertsystem;

import java.util.List;
import java.util.ArrayList;

public class Answer {

    List<String> patterns = new ArrayList<>();

    private boolean evaluatedAnswerByInput(String input){
        this.patterns.getInputPattern();
        for(String pattern: patterns ){
            if(input.equals(pattern)){
                return true;
            }
        }
        return false;
    }
    
    private void addValue(Value value){

    }
}