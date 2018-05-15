package expertsystem;

import java.util.List;
import java.util.Iterator; 

public class QuestionIterator implements Iterator<Question> {

    private List<Question> list;
    private int index;

    public QuestionIterator(List<Question> list){
        this.list = list;
    }

    public boolean hasNext(){
        return index < list.size();
    }

    public Question next(){
        if (this.hasNext())
            return list.get(this.index++);
        else
            return null;
    }
}