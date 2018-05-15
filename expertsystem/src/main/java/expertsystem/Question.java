package expertsystem;

public class Question {

    private String id;
    private String question;
    private Answer answer;

    public Question(String id, String question, Answer answer){
        this.id = id;
        this.question = question;
        this.answer = answer;
    }

    private String getId(){
        return this.id;
    }
    
    private String getQuestion(){
        return this.question;
    }

    private Answer getAnswer(){
        return this.answer;
    } 

    private boolean getEvaluatedAnswer(String input){
        return true;
    }
}