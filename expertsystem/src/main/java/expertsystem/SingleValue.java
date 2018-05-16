package expertsystem;

import java.util.List;

class SingleValue extends Value {
    private boolean selectionType;

    public SingleValue(String param, boolean selectionType){
        this.selectionType = selectionType;
    }

    public  List<String> getInputPattern(){
        
    }    

    public  boolean getSelectionType(){
        return this.selectionType;
    }


}