package com.cuong.futurenav.util;

public class StringUtil {
    public static String getTrimValue(String value){
    	
    	int poundIdx = value.lastIndexOf('#');
    	int slashIdx = value.lastIndexOf('/');
    	
    	int idx = Math.max(poundIdx, slashIdx);
    	
    	return value.substring(idx+1);
    }
}
