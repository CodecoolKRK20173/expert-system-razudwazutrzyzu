package expertsystem;

import java.util.List;
import java.util.Iterator; 

public class QuestionIterator implements Iterator<Question> {

    private List<Question> questions;
    private int index;

    public QuestionIterator(List<Question> questions){
        this.questions = questions;
        this.index = 0;
    }

    public boolean hasNext(){
        return index < questions.size();
    }

    public Question next(){
        if (this.hasNext()){
            System.out.println(questions.get(index).getQuestion());
            return questions.get(index++);
        }
        else
            return null;
    }
}