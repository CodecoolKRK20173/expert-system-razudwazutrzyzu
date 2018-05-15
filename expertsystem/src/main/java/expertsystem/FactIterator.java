package expertsystem;

import java.util.ArrayList;
import java.util.Iterator;

public class FactIterator implements Iterator<Fact>{
    private int index;
    private ArrayList<Fact> facts;

    public FactIterator(ArrayList<Fact> facts){
        this.index = 0;
        this.facts = facts;
    }

    @Override
    public boolean hasNext() {
        return index < this.facts.size();
    }


}