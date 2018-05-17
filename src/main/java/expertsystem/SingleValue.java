package expertsystem;

import java.util.ArrayList;
import java.util.List;

class SingleValue extends Value {
    private boolean selectionType;
    private String param;

    public SingleValue(String param, boolean selectionType){
        this.selectionType = selectionType;
        this.param = param;
    }

    public  List<String> getInputPattern(){
        List<String> patt = new ArrayList<>();
        patt.add(this.param);
        
        return patt;
    }    

    public  boolean getSelectionType(){
        return this.selectionType;
    }


}