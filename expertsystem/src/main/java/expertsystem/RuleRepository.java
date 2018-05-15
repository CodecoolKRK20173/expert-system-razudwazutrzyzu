package expertsystem;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class RuleRepository {

    private QuestionIterator questionIterator;
    private List<Question> questions = new ArrayList<>();

    public RuleRepository(){
        this.questionIterator = new QuestionIterator(questions);
    }

    private void addQuestion(Question question){
        this.questions.add(question);
    }

    private Iterator<Question> getIterator(){
        return this.questionIterator;
    }
}