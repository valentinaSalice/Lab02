package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {
	
	private AlienDictionary dizionario=new AlienDictionary();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtWord;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;

    @FXML
    void doReset(ActionEvent event) {
    	
    	dizionario.resetDizionario();
    	txtResult.clear();

    }

    @FXML
    void doTranslate(ActionEvent event) {
    	
    	String testo=txtWord.getText();
    	int spazio=testo.indexOf(" ");
    	String alienText=null;
    	String traduzione=null;
    	if(spazio!=-1) {
    		
    		alienText=testo.substring(0,spazio).toLowerCase();
    		traduzione=testo.substring(spazio+1).toLowerCase();
    	}
    	else
    		alienText=testo;
    	    
    	
    		
    	
    	
    	if(traduzione!=null) {
    		
    		if(alienText.matches("[a-zA-Z]+") && traduzione.matches("[a-zA-Z]+")) {
    			
    			dizionario.addWord(alienText, traduzione);
    			txtWord.clear();
    		
    		
    	}

    	}
    	
    	else {
    		
    		if(alienText.matches("[a-zA-Z]+")) {
    			
    			String risultato=dizionario.translateWord(alienText);
    			if(risultato!=null) {
    				
    				txtResult.clear();
    			    txtResult.appendText("La traduzione della parola "+alienText+" e' "+risultato+"\n");
    			    txtWord.clear();
    			}
    			else {
    				
    				txtResult.clear();
    				txtResult.appendText("La parola "+alienText+" non e' presente nel dizionario\n");
    				txtWord.clear();
    			}
    			
    		}
    	}
    	
    }

    @FXML
    void initialize() {
        assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";

    }
}
