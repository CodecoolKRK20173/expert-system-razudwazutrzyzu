package expertsystem;

import java.util.List;
import java.util.Iterator; 

public class QuestionIterator implements Iterator<Question> {

    private List<Question> list;
    private int index;

    public QuestionIterator(List<Question> list){
        this.list = list;
        this.index = 0;
    }

    public boolean hasNext(){
        return index < list.size();
    }

    public Question next(){
        if (this.hasNext()){
            System.out.println(list.get(index).getQuestion());
            
            return list.get(index++);
        }
        else
            return null;
    }
}