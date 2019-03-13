package it.polito.tdp.alien;

import java.util.*;

public class AlienDictionary {
	
	private List<Word>dizionario;
	
	
	
	
	public AlienDictionary() {
		
		dizionario=new LinkedList<Word>();
	}




	public void addWord(String alienWord, String translation) {
		
		Word w=new Word(alienWord,translation);
		
		int flag=0;
		
		 for(int i=0;i<dizionario.size();i++) {
				
				if(dizionario.get(i).equals(w)) {
					
					dizionario.get(i).setTranslation(translation);
					flag=1;
					break;
				}
			}
			
		
		if(flag==0) 
			dizionario.add(w);
		
			
		
	}
	
	public String translateWord(String alienWord) {
	
		Word w=new Word(alienWord,null);
		
		for(int i=0;i<dizionario.size();i++) {
			
			if(dizionario.get(i).equals(w))
				return dizionario.get(i).getTranslation();

		}
		
		return null;
	}
	
	public void resetDizionario() {
		
		dizionario.clear();
	}
	

}
