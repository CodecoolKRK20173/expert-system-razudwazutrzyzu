package expertsystem;

import java.util.ArrayList;
import java.util.List;


public class MultipleValue extends Value{
    private boolean selectionType;
    private List<String> param;

    public MultipleValue(List<String> param, boolean selectionType){
        this.selectionType = selectionType;
        this.param = param;
    }

    public  List<String> getInputPattern(){
        return this.param;
    }    

    public  boolean getSelectionType(){
        return this.selectionType;
    }


}