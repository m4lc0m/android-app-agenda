package com.musto.agendatest;


import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.musto.agendatest.R;

public class CreaCategoria extends AppCompatActivity {

    public EditText edit = null;
    public ImageButton salva = null;
    public ImageButton annulla = null;
    public ListView listaIcone = null;
    public String nome_categoria = null;
    public int id_img = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crea_categoria);

        final String[] stringhe = {
                "Musica",
                "News",
                "Box",
                "Idea",
                "Rating",
        };

        Integer[] imageId = {
                R.drawable.ic_music,
                R.drawable.ic_news,
                R.drawable.ic_box,
                R.drawable.ic_idea,
                R.drawable.ic_rating,
        };

        edit = (EditText) findViewById(R.id.editNomeCategoria);
        salva = (ImageButton) findViewById(R.id.imageButtonSalva);
        annulla = (ImageButton) findViewById(R.id.imageButtonAnnulla);


        CustomList adapter = new CustomList(CreaCategoria.this, stringhe, imageId);
        listaIcone = (ListView) findViewById(R.id.listViewIcone);
        listaIcone.setAdapter(adapter);
        listaIcone.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                id_img = position;
                Toast.makeText(CreaCategoria.this, "You Clicked at " + stringhe[+position], Toast.LENGTH_SHORT).show();

            }
        });

        salva.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                nome_categoria = edit.getText().toString();
                Intent result = new Intent(CreaCategoria.this, MainActivity.class);
                result.putExtra("nome_categoria", nome_categoria);
                result.putExtra("id", Integer.toString(id_img));
                setResult(Activity.RESULT_OK, result);
                finish();
            }
        });

        annulla.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent result = new Intent(CreaCategoria.this, MainActivity.class);
                setResult(Activity.RESULT_CANCELED);
                finish();;
            }
        });
    }
}

