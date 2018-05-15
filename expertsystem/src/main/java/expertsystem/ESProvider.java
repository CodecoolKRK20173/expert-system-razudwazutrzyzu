package expertsystem;

public class ESProvider {

    FactRepository factRepository;

    public ESProvider(FactParser factParser, RuleParser ruleParser){
        factRepository = getFactRepository();
    }

    private void collectAnswers(){
    }

    private boolean getAnswerByQuestion(String questionID){
        return true;
    }

    private String evaluate(){
        return null;
    }

    
}