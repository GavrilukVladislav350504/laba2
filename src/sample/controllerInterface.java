package sample;

/**
 * Created by Влад on 17.09.2015.
 */


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;


public class controllerInterface {
    @FXML
    private Button startFiz;
    @FXML
    private Label resultFiz;
    @FXML
    private Label resultJur;
    @FXML
    private TextField costFiz;
    @FXML
    private TextField valueFiz;
    @FXML
    private CheckBox checkOneFiz;
    @FXML
    private CheckBox checkTwoFiz;
    @FXML
    private CheckBox checkThreeFiz;

    @FXML
    private TextField costJur;
    @FXML
    private TextField valueJur;
    @FXML
    private CheckBox checkOneJur;
    @FXML
    private CheckBox checkTwoJur;
    @FXML
    private CheckBox checkThreeJur;
    @FXML
    private CheckBox Dt;
    @FXML
    private CheckBox Benz;
    @FXML
    private void calcFiz(ActionEvent event){
        if(checkOneFiz.isSelected()==true&&checkTwoFiz.isSelected()==true&&checkThreeFiz.isSelected()==false||
                checkOneFiz.isSelected()==true&&checkTwoFiz.isSelected()==false&&checkThreeFiz.isSelected()==true||
                checkOneFiz.isSelected()==false&&checkTwoFiz.isSelected()==true&&checkThreeFiz.isSelected()==true||
                checkOneFiz.isSelected()==false&&checkTwoFiz.isSelected()==false&&checkThreeFiz.isSelected()==false||
                checkOneFiz.isSelected()==true&&checkTwoFiz.isSelected()==true&&checkThreeFiz.isSelected()==true)
        {
            resultFiz.setText("Please create your information");
            return;
        }

        String costStrFiz=costFiz.getText();
        String valueStrFiz=valueFiz.getText();

        if(Main.checkString(costStrFiz)==false||Main.checkString(valueStrFiz)==false)
        {
            resultFiz.setText("Please create your information");
            return;
        }


        double costAuto=Integer.parseInt(costStrFiz);
        double valueAuto=Integer.parseInt(valueStrFiz);

        if(costAuto<=0||valueAuto<=0)
        {
            resultFiz.setText("Please create your information");
            return;
        }

        double costAutoResult=0;

        if(checkOneFiz.isSelected()==true&&checkTwoFiz.isSelected()==false&&checkThreeFiz.isSelected()==false)
        {
            costAutoResult=logic.Fiz1(costAuto,valueAuto, costAutoResult);
        }

        if(checkOneFiz.isSelected()==false&&checkTwoFiz.isSelected()==true&&checkThreeFiz.isSelected()==false)
        {
            costAutoResult=logic.Fiz2(valueAuto, costAutoResult);
        }

        if(checkOneFiz.isSelected()==false&&checkTwoFiz.isSelected()==false&&checkThreeFiz.isSelected()==true)
        {
            costAutoResult=logic.Fiz3(valueAuto, costAutoResult);
        }

        resultFiz.setText("Custom dues is "+Integer.toString((int) costAutoResult) +" euro");

    };

    @FXML
    private void calcJur(ActionEvent event){
        if(checkOneJur.isSelected()==true&&checkTwoJur.isSelected()==true&&checkThreeJur.isSelected()==false||
                checkOneJur.isSelected()==true&&checkTwoJur.isSelected()==false&&checkThreeJur.isSelected()==true||
                checkOneJur.isSelected()==false&&checkTwoJur.isSelected()==true&&checkThreeJur.isSelected()==true||
                checkOneJur.isSelected()==false&&checkTwoJur.isSelected()==false&&checkThreeJur.isSelected()==false||
                checkOneJur.isSelected()==true&&checkTwoJur.isSelected()==true&&checkThreeJur.isSelected()==true||
                Dt.isSelected()==true&&Benz.isSelected()==true||
                Dt.isSelected()==false&&Benz.isSelected()==false)
        {
            resultJur.setText("Please create your information");
            return;
        }

        String costStrJur=costJur.getText();
        String valueStrJur=valueJur.getText();

        if(Main.checkString(costStrJur)==false||Main.checkString(valueStrJur)==false)
        {
            resultJur.setText("Please create your information");
            return;
        }


        double costAuto=Integer.parseInt(costStrJur);
        double valueAuto=Integer.parseInt(valueStrJur);
        if(costAuto<=0||valueAuto<=0)
        {
            resultJur.setText("Please create your information");
            return;
        }

        double costAutoResult=0;


        if(Benz.isSelected()==true) {
            if (checkOneJur.isSelected() == true && checkTwoJur.isSelected() == false && checkThreeJur.isSelected() == false)
            {
                costAutoResult=logic.Jur1_benz(costAuto,valueAuto,costAutoResult);
            }

            if (checkOneJur.isSelected() == false && checkTwoJur.isSelected() == true && checkThreeJur.isSelected() == false)
            {
                costAutoResult=logic.Jur2_benz(costAuto, valueAuto, costAutoResult);
            }

            if (checkOneJur.isSelected() == false && checkTwoJur.isSelected() == false && checkThreeJur.isSelected() == true)
            {
                costAutoResult=logic.Jur3_benz(valueAuto, costAutoResult);
            }
            }

            if (Dt.isSelected()==true)
        {
            if (checkOneJur.isSelected() == true && checkTwoJur.isSelected() == false && checkThreeJur.isSelected() == false)
            {
                costAutoResult=logic.Jur1_diz(costAuto, valueAuto, costAutoResult);
            }

            if (checkOneJur.isSelected() == false && checkTwoJur.isSelected() == true && checkThreeJur.isSelected() == false)
            {
                costAutoResult=logic.Jur2_diz(costAuto, valueAuto,costAutoResult);
            }


            if (checkOneJur.isSelected() == false && checkTwoJur.isSelected() == false && checkThreeJur.isSelected() == true)
            {
                costAutoResult=logic.Jur3_diz(valueAuto, costAutoResult);
            }
        }
        resultJur.setText("Custom dues is "+Integer.toString((int) costAutoResult) +" euro");

    };
}
