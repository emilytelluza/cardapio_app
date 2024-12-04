package br.edu.uniritter.cardapio;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Obtém o nome da categoria enviada pela Intent da tela anterior
        String category = getIntent().getStringExtra("category");

        // Configuração do layout principal como LinearLayout (vertical)
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(16, 16, 16, 16);

        // Título que exibe o nome da categoria
        TextView tvTitle = new TextView(this);
        tvTitle.setText("Itens na categoria: " + category); // Mostra a categoria recebida
        tvTitle.setTextSize(18); // Tamanho do texto maior para o título
        layout.addView(tvTitle); // Adiciona o título ao layout

        // Adiciona os itens específicos da categoria no layout
        String[] items = getItemsForCategory(category);
        for (String item : items) {
            TextView tvItem = new TextView(this);
            tvItem.setText("- " + item); // Mostra cada item com um marcador
            layout.addView(tvItem); // Adiciona o item ao layout
        }

        // Define o layout criado como o conteúdo da Activity
        setContentView(layout);
    }

    // Retorna os itens da categoria com base no nome recebido
    private String[] getItemsForCategory(String category) {
        switch (category) {
            case "Entradas":
                return new String[]{"Salada Caesar", "Sopa de Legumes", "Tábua de Queijos"};
            case "Pratos Principais":
                return new String[]{"Filé com Fritas", "Peixe Grelhado", "Lasanha"};
            case "Sobremesas":
                return new String[]{"Pudim", "Torta de Limão", "Sorvete"};
            default:
                return new String[]{}; // Retorna vazio se a categoria não for reconhecida
        }
    }
}
