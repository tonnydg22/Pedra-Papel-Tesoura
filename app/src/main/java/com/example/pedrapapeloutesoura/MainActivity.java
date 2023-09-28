package com.example.pedrapapeloutesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra(View view){
        this.escolhaUsuario("pedra");
    }

    public void selecionadoPapel(View view){
        this.escolhaUsuario("papel");
    }

    public void selecionadoTesoura(View view){
        this.escolhaUsuario("tesoura");
    }

    public void escolhaUsuario(String escolhaUsuario){

        ImageView imagemResultado = findViewById(R.id.imageResultado);
        TextView textoResultado = findViewById(R.id.textResultado);

        int numero = new Random().nextInt(3); //0 1 2
        String[] opcoes = {"pedra", "papel","tesoura"}; // 0 1 2
        String escolhaMaquina = opcoes[numero];// puxando numero sorteado

        switch (escolhaMaquina){
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
        ){// Maquina Ganhador
            textoResultado.setText("Você Perdeu!!");
        } else if (
                (escolhaUsuario == "tesoura" && escolhaMaquina == "papel") ||
                (escolhaUsuario == "pedra" && escolhaMaquina == "tesoura") ||
                (escolhaUsuario == "papel" && escolhaMaquina == "pedra")
        ) {//  Usuario Ganhador
            textoResultado.setText("Você Ganhouu!!");

        }else {//  Empate
            textoResultado.setText("Você Empatou!!");
        }



    }
}