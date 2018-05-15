package expertsystem;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Fact{

    private String id;
    private String description;
    private Set<String> ids;
    private Map<String, Boolean> values = new HashMap<>();

    public Fact(String id, String description){
        this.id = id;
        this.description = description;
    }

    public boolean getValueById(String id) {
        return this.values.get(id).booleanValue();
    }

    public void setFactValueById(String id, boolean value){
        this.values.put(id, value);
        this.ids.add(id);
    }


}