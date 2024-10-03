package dk.easv.tiktakoleksandr;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import java.awt.*;

public class HelloController {

    @FXML
    private Label welcomeText;
    char nowSyn = 'x';
    private char gameField [] [] = new char[3][3];
    private boolean isGame = true;

    @FXML
    void btnClick(ActionEvent event) {


        if(!isGame) return;
        Button btn = ((Button)event.getSource());
        if (!isGame || btn.getText() != "") return;

        int rowIndex = GridPane.getRowIndex(btn) == null ? 0 : GridPane.getRowIndex(btn);
        int columnIndex = GridPane.getColumnIndex(btn) == null ? 0 : GridPane.getColumnIndex(btn);

        System.out.println(rowIndex);
        System.out.println(columnIndex);

        gameField[rowIndex][columnIndex]=nowSyn;
        if(gameField[0][0] == gameField[0][1] && gameField[0][0] == gameField [0][2] && (gameField[0][0]== 'x' || gameField [0] [0] == 'o')){
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "We have Winner " + btn.getText() + " " , ButtonType.OK );
            alert.showAndWait();
            isGame = false;
        }else if(gameField[1][0] == gameField[1][1] && gameField[1][0] == gameField [1][2] && (gameField[1][0]== 'x' || gameField [1] [0] == 'o')) {
            isGame = false;
        }else if(gameField[2][0] == gameField[2][1] && gameField[2][0] == gameField [2][2] && (gameField[2][0]== 'x' || gameField [2] [0] == 'o')) {
            isGame = false;
        }else if(gameField[0][0] == gameField[1][0] && gameField[0][0] == gameField [2][0] && (gameField[0][0]== 'x' || gameField [0] [0] == 'o')) {
            isGame = false;
        }else if(gameField[0][1] == gameField[1][1] && gameField[2][1] == gameField [0][1] && (gameField[0][1]== 'x' || gameField [0] [1] == 'o')) {
            isGame = false;
        }else if(gameField[0][2] == gameField[1][2] && gameField[0][2] == gameField [2][2] && (gameField[0][2]== 'x' || gameField [0] [2] == 'o')) {
            isGame = false;
        }else if(gameField[0][0] == gameField[1][2] && gameField[0][0] == gameField [2][2] && (gameField[0][0]== 'x' || gameField [0] [0] == 'o')) {
            isGame = false;
        }else if(gameField[2][2] == gameField[1][1] && gameField[2][2] == gameField [0][2] && (gameField[2][2]== 'x' || gameField [2] [2] == 'o')) {
            isGame = false;
        }

        btn.setText(String.valueOf(nowSyn));
        //change symbol
        nowSyn = nowSyn == 'x' ? 'o' : 'x';

    }


}
