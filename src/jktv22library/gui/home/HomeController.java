/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jktv22library.gui.home;

import LibraryGui.LibraryGui;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author pupil
 */
public class HomeController implements Initializable {

    private LibraryGui libraryGui;
    
    @FXML
    private AnchorPane content;
    
    @FXML
    private void showListBooks(){
        try{
            FXMLLoader loader = new FXMLLoader();
        }catch(Exception e){
            
        }
        
    }
   
    @Override
    public void initialize(URL location, ResourceBundle rb) {

    }
    
}
