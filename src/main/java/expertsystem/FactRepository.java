package expertsystem;

import java.util.ArrayList;
import java.util.Iterator;

public class FactRepository{

    private ArrayList<Fact> facts = new ArrayList<>();

    public void addFact(Fact fact) {
        this.facts.add(fact);
    }

    public Iterator<Fact> getIterator(){
        return new FactIterator(this.facts);
    }


}