package expertsystem;

public class Question {

    String id;
    public Question(String id, String answer, Answer answer){

    }

    private String getId(){
        return this.id;
    }
    
    private String getQuestion(){
        return null;
    }

    private Answer getAnswer(){
        return null;
    }

    private boolean getEvaluatedAnswer(String input){
        return true;
    }
}