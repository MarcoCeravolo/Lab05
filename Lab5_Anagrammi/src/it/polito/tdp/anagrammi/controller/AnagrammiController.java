package it.polito.tdp.anagrammi.controller;

/**
 * Sample Skeleton for 'Anagrammi.fxml' Controller Class
 */

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AnagrammiController {
	
	Model model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtParola"
    private TextField txtParola; // Value injected by FXMLLoader

    @FXML // fx:id="btnCalcola"
    private Button btnCalcola; // Value injected by FXMLLoader

    @FXML // fx:id="txtCorretti"
    private TextArea txtCorretti; // Value injected by FXMLLoader

    @FXML // fx:id="txtErrati"
    private TextArea txtErrati; // Value injected by FXMLLoader

    @FXML // fx:id="btnReset"
    private Button btnReset; // Value injected by FXMLLoader

    @FXML
    void doCalcola(ActionEvent event) {
    	String parola = txtParola.getText();
    	model.risolvi(parola);
    	List <String> anagrammi = model.getAnagrammi();
    	List <String> anagrammiCorretti = new ArrayList<String>();
    	List <String> anagrammiErrati = new ArrayList<String>();
    	
    	for(String s : anagrammi){
    		if(model.isCorretto(s)){
    			anagrammiCorretti.add(s);
    		}
    		else
    			anagrammiErrati.add(s);
    	}
    	
    	String resC="";
    	int contC=0;
    	for(String s : anagrammiCorretti){
    		if(contC==anagrammiCorretti.size()-1)
    			resC += s+".";
    		else{
    			resC += s+", ";
    			contC++;
    		}
    	}
    	txtCorretti.setText(resC);
    	
    	String resE="";
    	int contE=0;
    	for(String s : anagrammiErrati){
    		if(contE==anagrammiErrati.size()-1)
    			resE += s+".";
    		else{
    			resE += s+", ";
    			contE++;
    		}
    	}
    	txtErrati.setText(resE);
    	
    }

    @FXML
    void doReset(ActionEvent event) {
    	
    	txtParola.clear();
    	txtCorretti.clear();
    	txtErrati.clear();

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnCalcola != null : "fx:id=\"btnCalcola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtCorretti != null : "fx:id=\"txtCorretti\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtErrati != null : "fx:id=\"txtErrati\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Anagrammi.fxml'.";

    }

	/**
	 * @param model the model to set
	 */
	public void setModel(Model model) {
		this.model = model;
	}
    
    
}

