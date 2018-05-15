package expertsystem;

public class Question {

    private String id;
    private String question;

    public Question(String id, String question, Answer answer){
        this.id = id;
        this.question = question;
    }

    private String getId(){
        return this.id;
    }
    
    private String getQuestion(){
        return this.question;
    }

    private Answer getAnswer(){
        return null;
    }

    private boolean getEvaluatedAnswer(String input){
        return true;
    }
}