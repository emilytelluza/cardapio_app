package br.edu.uniritter.cardapio;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Obter a categoria da Intent
        String category = getIntent().getStringExtra("category");

        // Layout principal
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(16, 16, 16, 16);

        // Título
        TextView tvTitle = new TextView(this);
        tvTitle.setText("Itens na categoria: " + category);
        tvTitle.setTextSize(18);
        layout.addView(tvTitle);

        // Adicionar itens da categoria
        String[] items = getItemsForCategory(category);
        for (String item : items) {
            TextView tvItem = new TextView(this);
            tvItem.setText("- " + item);
            layout.addView(tvItem);
        }

        setContentView(layout);
    }

    private String[] getItemsForCategory(String category) {
        switch (category) {
            case "Entradas":
                return new String[]{"Salada Caesar", "Sopa de Legumes", "Tábua de Queijos"};
            case "Pratos Principais":
                return new String[]{"Filé com Fritas", "Peixe Grelhado", "Lasanha"};
            case "Sobremesas":
                return new String[]{"Pudim", "Torta de Limão", "Sorvete"};
            default:
                return new String[]{};
        }
    }
}
