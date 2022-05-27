package com.example.calculatrice;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android. widget.*;

public class MainActivity extends AppCompatActivity {

    //On déclare toutes les variables dont on aura besoin
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button buttonPlus;
    Button buttonMoins;
    Button buttonDiv;
    Button buttondel;
    Button buttonMul;
    Button buttonC;
    Button buttonEgal;
    Button buttonPoint;
    TextView ecran;
    TextView ecran1;

    private double chiffre1;
    private boolean clicOperateur = false;
    private boolean update = false;
    private String operateur = "";
    private int operation =0;
   public static int nbrpoint=0;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //On récupère tous les éléments de notre interface graphique grâce aux ID
        button0 = (Button) findViewById (R. id.button0);
        button1 = (Button) findViewById (R. id.button1);
        button2 = (Button) findViewById (R. id.button2);
        button3 = (Button) findViewById (R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        buttonPoint = (Button) findViewById(R.id.buttonPoint);
        buttonPlus = (Button) findViewById(R.id.buttonPlus);
        buttonMoins = (Button) findViewById(R.id.buttonMoins);
        buttonDiv = (Button) findViewById(R.id.buttonDiv);
        buttondel = (Button) findViewById(R.id.buttondel);
        buttonMul = (Button) findViewById(R.id.buttonMul);
        buttonC = (Button) findViewById(R.id.buttonC);
        buttonEgal = (Button) findViewById(R.id.buttonEgal);
        ecran1 = (TextView) findViewById(R.id.text2);
        ecran = (TextView) findViewById(R.id.text1);

        //On attribue un écouteur d’évènement à tous les boutons
        buttonPlus. setOnClickListener (new View.OnClickListener() {
            public void onClick(View v) {
                nbrpoint=0;
                plusClick ();
                taille();
                chiffreClick("+");
            }
        });

        buttonMoins. setOnClickListener (new View.OnClickListener() {
            public void onClick(View v) {
                moinsClick ();
                nbrpoint=0;
                taille();
                chiffreClick("-");
            }
        });

        buttonDiv. setOnClickListener (new View.OnClickListener() {
            public void onClick(View v) {
                divClick();
                nbrpoint=0;
                taille();
                chiffreClick("/");
            }
        });

        buttonMul. setOnClickListener (new View.OnClickListener() {
            public void onClick(View v) {
                mulClick();
                nbrpoint=0;
                taille();
                chiffreClick("*");
            }
        });

        buttonC. setOnClickListener (new View.OnClickListener() {
            public void onClick(View v) {
                resetClick();
                nbrpoint=0;
                taille();
            }
        });

        buttonEgal. setOnClickListener (new View.OnClickListener() {
            public void onClick(View v) {
                egalClick();
                nbrpoint=0;
                taille();
            }
        });

        buttonPoint. setOnClickListener (new View.OnClickListener() {
            public void onClick(View v) {
                     if(nbrpoint ==1)
                         return;
                if(nbrpoint ==0){
                    nbrpoint = 1;
                    chiffreClick("0.");
                }else {
                    chiffreClick(".");

               }

            }
        });

        button0.setOnClickListener (new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("0");

            }
        });

        button1.setOnClickListener (new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("1");

            }
        });

        button2.setOnClickListener (new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("2");

            }
        });

        button3.setOnClickListener (new View.OnClickListener() {
            public void onClick(View v) {

                chiffreClick("3");
            }
        });

        button4.setOnClickListener (new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("4");
            }
        });

        button5.setOnClickListener (new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("5");
            }
        });

        button6.setOnClickListener (new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("6");
            }
        });

        button7.setOnClickListener (new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("7");
            }
        });

        button8.setOnClickListener (new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("8");
            }
        });

        button9.setOnClickListener (new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("9");
            }
        });
        buttondel.setOnClickListener (new View.OnClickListener() {
            public void onClick(View v) {
                delClick();
            }
        });

    }
     // voici la methode pour reduire la taille du text
    public void taille(){
        if((ecran.getText()).length()>=10)
            ecran.setTextSize(24F);
         else
            ecran.setTextSize(34F);
    }
    //voici la méthode qui est exécutée lorsqu’on clique sur un bouton chiffre
    public void chiffreClick (String str) {
        if(update){
            update = false;
        }else{
            if(! ecran. getText (). equals ("0"))
                str = ecran.getText() + str;
        }
        ecran. setText (str);

        taille();
    }

    //voici la méthode qui est  exécutée lorsqu’on clique sur le bouton +
    public void plusClick() {

        if(clicOperateur){
            calcul ();
            ecran. setText (String.valueOf(chiffre1));
        }else{
            chiffre1 = Double.valueOf(ecran.getText().toString()).doubleValue();
            clicOperateur = true;
        }
        operateur = "+";
        update = true;
        operation=1;
    }
    //voici la méthode qui est  exécutée lorsqu’on clique sur le bouton -
    public void delClick(){
        if(operation==0) {
            String del = (String) ecran.getText();
            String del1 = "";
            for (int i = 0; i < del.length() - 1; i++)
                del1 = del1 + del.charAt(i);
            ecran.setText(del1);
        }else{
            resetClick();
        }
    }

    //voici la méthode qui est  exécutée lorsqu’on clique sur le bouton -
    public void moinsClick() {
        if(clicOperateur){
            calcul ();
            ecran.setText(String.valueOf (chiffre1));
        }else{
            chiffre1 = Double.valueOf(ecran.getText().toString()).doubleValue();
            clicOperateur = true;
        }
        operateur = "-";
        update = true;
        operation=1;
    }

    //voici la méthode qui est  exécutée lorsqu’on clique sur le bouton *
    public void mulClick() {
        if(clicOperateur){
            calcul ();
            ecran.setText(String.valueOf (chiffre1));
        }else{
            chiffre1 = Double.valueOf(ecran.getText().toString()).doubleValue();
            clicOperateur = true;
        }
        operateur = "*";
        update = true;
        operation=1;
    }

    //voici la méthode qui est  exécutée lorsqu’on clique sur le bouton /
    public void divClick(){
        if(clicOperateur){
            calcul ();
            ecran.setText(String.valueOf (chiffre1));
        }else{
            chiffre1 = Double.valueOf(ecran.getText().toString()).doubleValue();
            clicOperateur = true;
        }
        operateur = "/";
        update = true;
        operation=1;
    }

    //voici la méthode qui est  exécutée lorsqu’on clique sur le bouton =
    public void egalClick() {
        calcul ();
        update = true;
        clicOperateur = false;

    }

    //voici la méthode qui est  exécutée lorsque l’on clique sur le bouton C
    public void resetClick() {
        clicOperateur = false;
        update = true;
        chiffre1 = 0;
        operateur = "";
        ecran. setText ("");
        ecran1. setText ("");
    }

    //Voici la méthode qui fait le calcul qui a été demandé par l’utilisateur
    private void calcul () {
        if (operateur. equals ("+")) {
            chiffre1 = chiffre1 + Double.valueOf(ecran. getText (). toString ()).doubleValue();
            ecran1.setText(String.valueOf (chiffre1));
        }

        if(operateur. equals ("-")){
            chiffre1 = chiffre1 - Double.valueOf (ecran. getText (). toString ()). doubleValue();
            ecran1.setText(String.valueOf (chiffre1));
        }

        if(operateur. equals ("*")){
            chiffre1 = chiffre1 * Double.valueOf (ecran. getText (). toString ()). doubleValue();
            ecran1.setText(String.valueOf (chiffre1));
        }

        if(operateur.equals("/")){
            try{
                chiffre1 = chiffre1 / Double.valueOf(ecran.getText().toString()).doubleValue();
                ecran1.setText(String.valueOf(chiffre1));
            }catch(ArithmeticException e){
                ecran1. setText ("0");
            }
            operation=1;
        }
    }
}