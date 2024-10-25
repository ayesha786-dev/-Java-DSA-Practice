package com.abstractfactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveSub {
    public List<String> removeSubfolders(String[] folder) {
    	
    	Set<String> set = new HashSet<>(Arrays.asList(folder));
    	ArrayList<String> list = new ArrayList<>();
    	
    	for (String string : folder) {
			
    		String subfolder = string;
    		boolean isSub = false;
    		while(!subfolder.isEmpty()) {
    			int pos = subfolder.lastIndexOf("/" );
    			subfolder=subfolder.substring(0,pos);
    			
    			if(set.contains(subfolder)) {
    				isSub =true;
    			}
    		}
    		if(!isSub) {
    			list.add(string);
    		}
		}
    	
		return list;
    }
    public static void main(String[] args) {
		String s[] = { "/a","/a/b","/c/d","/c/d/e","/c/f"};
		
		RemoveSub r = new RemoveSub();
		
		System.out.println(r.removeSubfolders(s));
	}
}
