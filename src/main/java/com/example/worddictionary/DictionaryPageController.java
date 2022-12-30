package com.example.worddictionary;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.Locale;

public class DictionaryPageController {
    private DictionarySaver db;

@FXML
    TextField search;
@FXML
    TextField newword;
@FXML
    TextField meaning;
@FXML
    TextField findword;
@FXML
    public  void searchButton(MouseEvent event ) throws ClassNotFoundException, IOException {
    try {
        db = new DictionarySaver();
        db.deserializeHashMap();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Dictionary");
        Alert alert2 = new Alert(Alert.AlertType.ERROR);
        alert2.setHeaderText("Dictionary");
        if(search.getText().equals("")){
            alert2.setContentText("Plese Enter a word to search");
            alert2.showAndWait();
        }
        else if (db.getDictionaryList().containsKey(search.getText().toLowerCase())) {
                alert.setContentText("Word is Present in the Dictionary");
                alert.showAndWait();
        }
        else {
                alert2.setContentText("Word is not present in the Dictionary");
                alert2.showAndWait();
             }
        search.clear();
    }
    catch(IOException ex){
        db.serializeHashMap();
    }

}
@FXML
    public  void Add(MouseEvent event ) throws IOException, ClassNotFoundException {
    db=new DictionarySaver();
    db.deserializeHashMap();
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setHeaderText("Dictionary");
    Alert alert2 = new Alert(Alert.AlertType.ERROR);
    alert2.setHeaderText("Dictionary");
    if(newword.getText().equals("")||meaning.getText().equals("")){
        alert2.setContentText("Please check Word/Meaning Field is absent");
        alert2.showAndWait();
    }
    else if(db.getDictionaryList().containsKey(newword.getText().toLowerCase())){
        alert2.setContentText("Word is Already Present in Dictionary");
        alert2.showAndWait();
    }
    else {
        db.getDictionaryList().put(newword.getText().toLowerCase(), meaning.getText());
        db.serializeHashMap();
        alert.setContentText("Word is Added to the Dictionary");
        alert.showAndWait();
         }
    newword.clear();
    meaning.clear();
}
@FXML
    public  void Meaning(MouseEvent event ) throws IOException, ClassNotFoundException {
    db=new DictionarySaver();
    db.deserializeHashMap();

    Alert alert=new Alert(Alert.AlertType.INFORMATION);
    alert.setHeaderText("Meaning");
    Alert alert2 = new Alert(Alert.AlertType.ERROR);
    alert2.setHeaderText("Dictionary");
    if(findword.getText().equals("")){
        alert2.setContentText("Please Enter the word to search");
        alert2.showAndWait();
    }
    else if(db.getDictionaryList().containsKey(findword.getText().toLowerCase())){
        alert.setContentText(db.getDictionaryList().get(findword.getText().toLowerCase()));
        alert.showAndWait();
    }
    else{
        alert2.setContentText("The Word in not Present in the Dictionary");
        alert2.showAndWait();
    }
    findword.clear();
    }
}
