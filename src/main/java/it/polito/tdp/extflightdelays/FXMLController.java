package it.polito.tdp.extflightdelays;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.extflightdelays.model.Model;
import it.polito.tdp.extflightdelays.model.StringWithVeivoli;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnCreaGrafo;

    @FXML
    private ComboBox<String> cmbBoxStati;

    @FXML
    private Button btnVisualizzaVelivoli;

    @FXML
    private TextField txtT;

    @FXML
    private TextField txtG;

    @FXML
    private Button btnSimula;

    @FXML
    void doCreaGrafo(ActionEvent event) {
    	try {
    		model.creaGrafo();
    		txtResult.setText(String.format("Il grafo è stato creato. Contiene %d vertici e %d archi", model.getGrafo().vertexSet().size(), model.getGrafo().edgeSet().size()));
    		cmbBoxStati.getItems().clear();
    		cmbBoxStati.getItems().addAll(model.getGrafo().vertexSet());
    		
    	} catch (Exception e) {
    		txtResult.setText(e.getMessage());
    	}
    }

    @FXML
    void doSimula(ActionEvent event) {
    	txtResult.clear();
    	
    	try {
    		for (StringWithVeivoli w : model.visualizzaVeivoli(cmbBoxStati.getSelectionModel().getSelectedItem()))
    			txtResult.appendText(w + "\n");
    	} catch (Exception e) {
    		txtResult.setText(e.getMessage());
    	}
    }

    @FXML
    void doVisualizzaVelivoli(ActionEvent event) {
    	txtResult.clear();
    	
    	try {
    		for (StringWithVeivoli w : model.visualizzaVeivoli(cmbBoxStati.getSelectionModel().getSelectedItem()))
    			txtResult.appendText(w + "\n");
    	} catch (Exception e) {
    		txtResult.setText(e.getMessage());
    	}
    }

    @FXML
    void initialize() {
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'ExtFlightDelays.fxml'.";
        assert btnCreaGrafo != null : "fx:id=\"btnCreaGrafo\" was not injected: check your FXML file 'ExtFlightDelays.fxml'.";
        assert cmbBoxStati != null : "fx:id=\"cmbBoxStati\" was not injected: check your FXML file 'ExtFlightDelays.fxml'.";
        assert btnVisualizzaVelivoli != null : "fx:id=\"btnVisualizzaVelivoli\" was not injected: check your FXML file 'ExtFlightDelays.fxml'.";
        assert txtT != null : "fx:id=\"txtT\" was not injected: check your FXML file 'ExtFlightDelays.fxml'.";
        assert txtG != null : "fx:id=\"txtG\" was not injected: check your FXML file 'ExtFlightDelays.fxml'.";
        assert btnSimula != null : "fx:id=\"btnSimula\" was not injected: check your FXML file 'ExtFlightDelays.fxml'.";

    }

	public void setModel(Model model) {
		this.model = model;
	}
}
