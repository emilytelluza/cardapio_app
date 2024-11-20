package br.edu.uniritter.cardapio;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Layout Principal
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(16, 16, 16, 16);

        // Botão para Entradas
        Button btnEntradas = new Button(this);
        btnEntradas.setText("Entradas");
        layout.addView(btnEntradas);

        // Botão para Pratos Principais
        Button btnPratos = new Button(this);
        btnPratos.setText("Pratos Principais");
        layout.addView(btnPratos);

        // Botão para Sobremesas
        Button btnSobremesas = new Button(this);
        btnSobremesas.setText("Sobremesas");
        layout.addView(btnSobremesas);

        // Navegação
        btnEntradas.setOnClickListener(v -> openCategory("Entradas"));
        btnPratos.setOnClickListener(v -> openCategory("Pratos Principais"));
        btnSobremesas.setOnClickListener(v -> openCategory("Sobremesas"));

        // Define o layout como o conteúdo da atividade
        setContentView(layout);
    }

    private void openCategory(String category) {
        Intent intent = new Intent(this, CategoryActivity.class);
        intent.putExtra("category", category);
        startActivity(intent);
    }
}
