/*
Jordan Wilson - jwilson160@cnm.edu
WilsonP4
Controller
 */
package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;

import javax.swing.*;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    //form features
    @FXML private ComboBox<String> cbxWeight;
    @FXML private TextField tbxName;
    @FXML private TextField tbxEmail;
    @FXML private Slider sldrLength;
    @FXML private RadioButton rbtFull;
    @FXML private ToggleGroup corkGrp;
    @FXML private RadioButton rbtHalf;
    @FXML private RadioButton rbtCigar;
    @FXML private RadioButton rbtBamboo;
    @FXML private ToggleGroup matGrp;
    @FXML private RadioButton rbtGlass;
    @FXML private RadioButton rbtGraphite;
    @FXML private CheckBox ckLine;
    @FXML private CheckBox ckThread;
    @FXML private CheckBox ckReel;
    @FXML private Button btnSave;
    @FXML private Button btnSum;
    @FXML private TextArea txtSum;
    @FXML private Slider sldrPrice;

    //data class
    Data data;
    //combo box list
    ObservableList<String> cbList = FXCollections.observableArrayList("3wt", "4wt", "5wt", "6wt", "7wt", "8wt");
    //save event
    @FXML
    void onActionSave(ActionEvent event) {
        if(tbxName != null && tbxEmail != null) {
            //saving file
            FileChooser fileChooser = new FileChooser();
            fileChooser.setInitialDirectory(new File("."));
            File file = fileChooser.showSaveDialog(null);
            if (file != null) {
                data.writeFile(file);
            }
        }if(tbxName == null || tbxEmail == null){
            JOptionPane.showMessageDialog(null, "Name and Email fields must be filled in.");
        }
    }
    //summary event
    @FXML
    void onActionSum(ActionEvent event) {
        //not sure why these if statements dont work
        if(tbxName != null && tbxEmail != null){
            //setting data and showing save button
            btnSave.setVisible(true);
            data.buildExtras();
            String name = tbxName.getText();
            String email = tbxEmail.getText();
            String weight = cbxWeight.getValue();
            double length = sldrLength.getValue();
            data.setName(name);
            data.setEmail(email);
            data.setWeight(weight);
            data.setLength(length);
            data.setPrice(sldrPrice.getValue());
            txtSum.setText(data.toString());
        }if(tbxName == null || tbxEmail == null){
            JOptionPane.showMessageDialog(null, "Name and Email fields must be filled in.");
        }
    }

    @FXML
    void HandleCbx(ActionEvent event) {
        int index = cbxWeight.getSelectionModel().getSelectedIndex();
    }

    @FXML
    void handleCorkCigar(ActionEvent event) {
        if(rbtCigar.isSelected()){
            data.setCork(rbtCigar.getText());
        }
    }

    @FXML
    void handleCorkFull(ActionEvent event) {
        if(rbtFull.isSelected()){
            data.setCork(rbtFull.getText());
        }
    }

    @FXML
    void handleCorkHalf(ActionEvent event) {
        if(rbtHalf.isSelected()){
            data.setCork(rbtHalf.getText());
        }
    }

    @FXML
    void handleExtraLine(ActionEvent event) {
        if(ckLine.isSelected()){
            data.setExtras("Include Line");
        }
    }

    @FXML
    void handleExtraReel(ActionEvent event) {
        if(ckLine.isSelected()){
            //only the reel option isnt working?
            data.setExtras("Include Reel");
        }
    }

    @FXML
    void onActionThread(ActionEvent event) {
        String color = JOptionPane.showInputDialog(null, "Desired Color: ");
        data.setExtras("Thread color: " + color);
    }

    @FXML
    void handleMatBam(ActionEvent event) {
        if(rbtBamboo.isSelected()){
            data.setMaterial(rbtBamboo.getText());
        }
    }

    @FXML
    void handleMatGlass(ActionEvent event) {
        if(rbtGlass.isSelected()){
            data.setMaterial(rbtGlass.getText());
        }
    }

    @FXML
    void handleMatGraph(ActionEvent event) {
        if(rbtGraphite.isSelected()){
            data.setMaterial(rbtGraphite.getText());
        }
    }
    //mouse events
    @FXML
    void onMouseEnter(MouseEvent event) {
        btnSave.setFont(Font.font("Rockwell", FontWeight.BOLD, 18));
    }

    @FXML
    void onMouseExit(MouseEvent event) {
        btnSave.setFont(Font.font("Rockwell",FontWeight.BOLD, 14));
    }

    @FXML
    void onEnterSum(MouseEvent event) {
        btnSum.setFont(Font.font("Rockwell", FontWeight.BOLD, 18));
    }

    @FXML
    void onExitSum(MouseEvent event) {
        btnSum.setFont(Font.font("Rockwell", FontWeight.BOLD, 14));
    }

    //initializing form
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        data = new Data();

        cbxWeight.setValue("3");
        cbxWeight.setItems(cbList);
        btnSave.setVisible(false);
        rbtGraphite.setSelected(true);
        rbtFull.setSelected(true);
        tbxName.setText(null);
        tbxEmail.setText(null);
    }
}
