package expertsystem;

public class RuleParser {

    RuleRepository ruleRepository;

    public RuleParser(){
        getRuleRepository();
    }

    public RuleRepository getRuleRepository(){
        return this.ruleRepository;
    }
    
}