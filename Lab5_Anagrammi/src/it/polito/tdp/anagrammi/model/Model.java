package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

public class Model {
	
	List <String> anagrammi;
	AnagrammaDAO aD;
	
	public Model() {
		super();
		anagrammi = new ArrayList <String>();
		aD = new AnagrammaDAO();
	}
	
	/**
	 * @return the anagrammi
	 */
	public List<String> getAnagrammi() {
		return anagrammi;
	}

	public void addAnagramma(String anagramma){
		anagrammi.add(anagramma);
	}

	/*public int numeroAnagrammiParola(String parola){
		int num=1;
		for(int i=parola.length(); i>=0; i--){
			num=num*i;
		}
		return num;
	}*/
	
	public void ricorsivo(String parziale, int livello, String parola){ 
		
		if(parziale.length() >= parola.length()){
			this.addAnagramma(parziale);
		}
		
		for (int i=0; i<parola.length(); i++){
			if(!parziale.contains(""+parola.charAt(i))){
				// B
				parziale+=parola.charAt(i);
				// C
				ricorsivo(parziale, livello+1, parola);
				// D
				parziale = parziale.substring(0, parziale.length()-1);
			}
		}
		
	}
	
	public void risolvi(String parola){
		String parziale = "";
		ricorsivo(parziale, 0, parola);
	}
	
	public boolean isCorretto(String anagramma){
		return aD.isCorrect(anagramma);
	}

}
