package expertsystem;

public class Main {

    public static void main(String[] args) {

        FactParser factParser = new FactParser();
        RuleParser ruleParser = new RuleParser();

        ESProvider esProvider = new ESProvider(factParser, ruleParser);
        
        esProvider.collectAnswers();
        System.out.println(esProvider.evaluate());    
    }
}