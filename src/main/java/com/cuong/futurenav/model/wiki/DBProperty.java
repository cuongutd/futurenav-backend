package com.cuong.futurenav.model.wiki;

/**
 * Created by Cuong on 11/23/2015.
 */
public class DBProperty {
    String type;

    String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public String getTrimValue(){
    	
    	int poundIdx = value.lastIndexOf('#');
    	int slashIdx = value.lastIndexOf('/');
    	
    	int idx = Math.max(poundIdx, slashIdx);
    	
    	return value.substring(idx+1);
    	
    }
}
