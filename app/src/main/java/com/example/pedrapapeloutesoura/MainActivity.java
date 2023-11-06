package com.example.pedrapapeloutesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView limpaEscolhaDaMaq;
    TextView limpaTextoResultado;
    TextView numeroV;
    TextView numV, numD, numE;

    int contV = 0;
    int contD = 0;
    int contE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        limpaEscolhaDaMaq = findViewById(R.id.imageResultado);
        limpaTextoResultado = findViewById(R.id.textResultado);
        numeroV = findViewById(R.id.numV);
        numV = findViewById(R.id.numV);
        numD = findViewById(R.id.numD);
        numE = findViewById(R.id.numE);
    }


        public void selecionadoPedra (View view){
            this.escolhaUsuario("pedra");
        }

        public void selecionadoPapel (View view){
            this.escolhaUsuario("papel");
        }

        public void selecionadoTesoura (View view){
            this.escolhaUsuario("tesoura");
        }

        public void limpar (View view){

            limpaEscolhaDaMaq.setImageResource(R.drawable.padrao);
            limpaTextoResultado.setText("Escolha uma opção abaixo");

            numV.setText("0");
            numD.setText("0");
            numE.setText("0");

            contV = 0;
            contD = 0;
            contE = 0;

    }

        public void escolhaUsuario (String escolhaUsuario) {

            ImageView imagemResultado = findViewById(R.id.imageResultado);
            TextView textoResultado = findViewById(R.id.textResultado);



                int numero = new Random().nextInt(3); //0 1 2
                String[] opcoes = {"pedra", "papel", "tesoura"}; // 0 1 2
                String escolhaMaquina = opcoes[numero];// puxando numero sorteado

                // Placar



                switch (escolhaMaquina) {
                    case "pedra":
                        imagemResultado.setImageResource(R.drawable.pedra);
                        break;
                    case "papel":
                        imagemResultado.setImageResource(R.drawable.papel);
                        break;
                    case "tesoura":
                        imagemResultado.setImageResource(R.drawable.tesoura);
                        break;
                }
                  

                if (
                        (escolhaMaquina == "tesoura" && escolhaUsuario == "papel") ||
                                (escolhaMaquina == "pedra" && escolhaUsuario == "tesoura") ||
                                (escolhaMaquina == "papel" && escolhaUsuario == "pedra")
                ) {// Maquina Ganhador
                    textoResultado.setText("Você Perdeu!!");
                    ++contD;
                    numD.setText(""+contD);


                }
                else if (
                        (escolhaUsuario == "tesoura" && escolhaMaquina == "papel") ||
                                (escolhaUsuario == "pedra" && escolhaMaquina == "tesoura") ||
                                (escolhaUsuario == "papel" && escolhaMaquina == "pedra")
                ) {//  Usuario Ganhador
                    textoResultado.setText("Você Ganhouu!!");
                    ++contV;
                    numV.setText(""+contV);







                }
                else {//  Empate
                    textoResultado.setText("Você Empatou!!");
                    ++contE;
                    numE.setText(""+contE);

                }

        }





}