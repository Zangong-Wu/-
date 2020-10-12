package service;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Counter {
	
	    public static String counter(String expression) throws ScriptException {
	    	
	        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
	        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("nashorn");
	        String list=replace(expression);
	        String result = String.valueOf(scriptEngine.eval(list));
            System.out.println(result);
            return result;
	    
	    }  
	    
	    
	    public static String replace(String list) {
	    char[] stringarr=list.toCharArray();
	    	for(int i=0;i<list.length();i++) {
	    	 if(stringarr[i]=='¡Â') {	
	    		stringarr[i]='/';
	         }
	        }  	
	    	return new String(stringarr);
	  }
	    
	   
	    
}


