package expertsystem;

public class RuleParser extends XMLParser{

    RuleRepository ruleRepository;

    public RuleParser(){
        getRuleRepository();
    }

    public RuleRepository getRuleRepository(){
        return this.ruleRepository;
    }
    
}