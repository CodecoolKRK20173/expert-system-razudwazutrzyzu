package expertsystem;

import java.util.List;
import java.util.ArrayList;
import java.security.InvalidParameterException;
public class Answer {

    List<String> patterns = new ArrayList<>();
    List<Value> values = new ArrayList<>();

    
    public boolean evaluateAnswerByInput(String userInput) {
        for (Value value : this.values) {
            for (String pattern : value.getInputPattern()) {
                if (userInput.equals(pattern)) {
                    return value.getSelectionType();
                }
            }
        }
        throw new InvalidParameterException("Wrong input");
    }
    
    public void addValue(Value value){
        this.values.add(value);
    }
}