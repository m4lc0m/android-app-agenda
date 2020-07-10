package com.musto.agendatest;


import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.musto.agendatest.R;


public class CreaEvento extends AppCompatActivity {

    public String nome = null;
    public String data = null;
    public String ora = null;
    public String luogo = null;
    public String descrizione = null;
    public String noteAggiuntive = null;
    EditText editNome = null;
    EditText editData = null;
    EditText editOra = null;
    EditText editLuogo = null;
    EditText editDescrizione = null;
    EditText editNoteAggiuntive = null;
    ImageButton salva = null;
    ImageButton annulla = null;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crea_evento);

        editNome = (EditText)findViewById(R.id.editNome);
        editData = (EditText)findViewById(R.id.editData);
        editOra = (EditText)findViewById(R.id.editOra);
        editLuogo = (EditText)findViewById(R.id.editLuogo);
        editDescrizione = (EditText)findViewById(R.id.editDescrizione);
        editNoteAggiuntive = (EditText)findViewById(R.id.editNote);
        editData.setText("formato AAAA-MM-GG");
        editOra.setText("formato 00.00");

        salva = (ImageButton)findViewById(R.id.imageButtonSalva);
        annulla = (ImageButton)findViewById(R.id.imageButtonAnnulla);

        salva.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                nome = editNome.getText().toString();
                data = editData.getText().toString();
                ora = editOra.getText().toString();
                luogo = editLuogo.getText().toString();
                descrizione = editDescrizione.getText().toString();
                noteAggiuntive = editNoteAggiuntive.getText().toString();

                if(data.length()>10 && ora.length()>4){
                    Toast.makeText(getBaseContext(), "Errore inserimento data/ora rispettare il formato", Toast.LENGTH_LONG).show();
                    Intent wrong = new Intent(CreaEvento.this, MainActivity.class);
                    setResult(Activity.RESULT_CANCELED,wrong);
                    finish();
                }
                Intent result = new Intent(CreaEvento.this, MainActivity.class);
                result.putExtra("nome",nome);
                result.putExtra("data",data);
                result.putExtra("ora",ora);
                result.putExtra("descrizione",descrizione);
                result.putExtra("luogo",luogo);
                result.putExtra("noteAggiuntive",noteAggiuntive);
                setResult(Activity.RESULT_OK,result);
                finish();
            }
        });

        annulla.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent result = new Intent(CreaEvento.this, MainActivity.class);
                setResult(Activity.RESULT_CANCELED,result);
                finish();
            }
        });
    }


}
