package expertsystem;

import java.util.ArrayList;
import java.util.List;


public class MultipleValue extends Value{
    
    private boolean selectionType;
    private List<String> parameters;

    public MultipleValue(List<String> parameters, boolean selectionType){
        this.selectionType = selectionType;
        this.parameters = parameters;
    }

    public  List<String> getInputPattern(){
        return this.parameters;
    }    

    public  boolean getSelectionType(){
        return this.selectionType;
    }


}