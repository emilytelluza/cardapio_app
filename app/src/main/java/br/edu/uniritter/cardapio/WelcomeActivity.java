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

        // Configuração do layout principal como LinearLayout (vertical)
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(16, 16, 16, 16);

        // Botão para acessar a categoria "Entradas"
        Button btnEntradas = new Button(this);
        btnEntradas.setText("Entradas"); // Texto do botão
        layout.addView(btnEntradas); // Adiciona o botão ao layout

        // Botão para acessar a categoria "Pratos Principais"
        Button btnPratos = new Button(this);
        btnPratos.setText("Pratos Principais"); // Texto do botão
        layout.addView(btnPratos); // Adiciona o botão ao layout

        // Botão para acessar a categoria "Sobremesas"
        Button btnSobremesas = new Button(this);
        btnSobremesas.setText("Sobremesas"); // Texto do botão
        layout.addView(btnSobremesas); // Adiciona o botão ao layout

        // Configura a ação do botão "Entradas"
        btnEntradas.setOnClickListener(v -> openCategory("Entradas"));

        // Configura a ação do botão "Pratos Principais"
        btnPratos.setOnClickListener(v -> openCategory("Pratos Principais"));

        // Configura a ação do botão "Sobremesas"
        btnSobremesas.setOnClickListener(v -> openCategory("Sobremesas"));

        // Define o layout criado como o conteúdo da Activity
        setContentView(layout);
    }

    /**
     * Abre a tela de categorias, passando o nome da categoria selecionada.
     *
     * @param category Nome da categoria (Entradas, Pratos Principais, Sobremesas)
     */
    private void openCategory(String category) {
        // Cria um Intent para navegar para CategoryActivity
        Intent intent = new Intent(this, CategoryActivity.class);

        // Passa o nome da categoria selecionada como dado extra
        intent.putExtra("category", category);

        // Inicia a Activity de categorias
        startActivity(intent);
    }
}
