package com.mycompany.cifrasdivisores;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class PrimaryController implements Initializable {

    @FXML private TextField txtNumero;
    @FXML private TextField txtCantCifras;
    @FXML private TextField txtSumaImpares;
    @FXML private TextField txtSumaPares;
    @FXML private TextField txtSumaTotal;
    @FXML private TextField txtMayor;
    @FXML private TextField txtMenor;
    @FXML private ListView<Integer> listaDivisores;

    @FXML
    private void analizarNumero(ActionEvent event) {
        int numero = Integer.parseInt(txtNumero.getText());
        int cantidadCifras = String.valueOf(numero).length();
        int sumaImpares = 0, sumaPares = 0, sumaTotal = 0;
        int mayor = 0, menor = 9;
        int copiaNumero = numero; 
        while (copiaNumero > 0) {
            int digito = copiaNumero % 10; 
            sumaTotal += digito;
            if (digito % 2 == 0) {
                sumaPares += digito;
            } else {
                sumaImpares += digito;
            }
            
            if (digito > mayor) mayor = digito;
            if (digito < menor) menor = digito;
            
            copiaNumero = copiaNumero / 10;
        }
        
        txtCantCifras.setText(String.valueOf(cantidadCifras));
        txtSumaImpares.setText(String.valueOf(sumaImpares));
        txtSumaPares.setText(String.valueOf(sumaPares));
        txtSumaTotal.setText(String.valueOf(sumaTotal));
        txtMayor.setText(String.valueOf(mayor));
        txtMenor.setText(String.valueOf(menor));
        ObservableList<Integer> divisores = FXCollections.observableArrayList();
        for (int i = 1; i <= numero; i++) {
            if (numero % i == 0) {
                divisores.add(i);
            }
        }
        listaDivisores.setItems(divisores);
    }

    @FXML
    private void limpiarCampos(ActionEvent event) {
        txtNumero.clear();
        txtCantCifras.clear();
        txtSumaImpares.clear();
        txtSumaPares.clear();
        txtSumaTotal.clear();
        txtMayor.clear();
        txtMenor.clear();
        listaDivisores.getItems().clear();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}
