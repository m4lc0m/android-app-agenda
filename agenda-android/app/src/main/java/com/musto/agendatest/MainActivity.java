package com.musto.agendatest;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private static final String SERVICE_URL = "http://10.0.2.2:8080/AgendaRestServer/rest/add_evento";
    private static final String SERVICE_URL_EDIT = "http://10.0.2.2:8080/AgendaRestServer/rest/edit_evento";
    private static final String SERVICE_URL_LOAD = "http://10.0.2.2:8080/AgendaRestServer/rest/load_eventi";
    private static final String SERVICE_URL_REMOVE = "http://10.0.2.2:8080/AgendaRestServer/rest/remove_evento";

    private static final String TAG = "MainActivity";

    public RelativeLayout main = null;
    public RelativeLayout content = null;
    public RelativeLayout content_d = null;
    public RelativeLayout content_casa = null;
    public RelativeLayout content_casa_details = null;
    public RelativeLayout content_amici = null;
    public RelativeLayout content_amici_details = null;
    public RelativeLayout content_tempo_libero = null;
    public RelativeLayout content_tempo_libero_details = null;
    public RelativeLayout content_sport = null;
    public RelativeLayout content_sport_details = null;
    public RelativeLayout content_family = null;
    public RelativeLayout content_family_details = null;
    public RelativeLayout content_lavoro = null;
    public RelativeLayout content_lavoro_details = null;
    public RelativeLayout content_modifica = null;
    public TextView textWelcome = null;
    public TextView textSelezione = null;
    public ArrayList<Evento> eventi = null;
    public ArrayList<Evento> eventiCasa = null;
    public ArrayList<Evento> eventiAmici = null;
    public ArrayList<Evento> eventiTempoLibero = null;
    public ArrayList<Evento> eventiSport = null;
    public ArrayList<Evento> eventiFamiglia = null;
    public ArrayList<Evento> eventiLavoro = null;
    public ListView lista = null;
    public ListView listaCasa = null;
    public ListView listaAmici = null;
    public ListView listaTempoLibero = null;
    public ListView listaSport = null;
    public ListView listaFamiglia = null;
    public ListView listaLavoro = null;
    public ArrayList<String> convert = null;
    public ArrayList<String> convertHome = null;
    public ArrayList<String> convertAmici = null;
    public ArrayList<String> convertTempoLibero = null;
    public ArrayList<String> convertSport = null;
    public ArrayList<String> convertFamily = null;
    public ArrayList<String> convertLavoro = null;
    public ArrayAdapter<String> adp = null;
    public ArrayAdapter<String> adp_home = null;
    public ArrayAdapter<String> adp_amici = null;
    public ArrayAdapter<String> adp_tempo_libero = null;
    public ArrayAdapter<String> adp_sport = null;
    public ArrayAdapter<String> adp_family = null;
    public ArrayAdapter<String> adp_lavoro = null;
    public String nome = null;
    public String data = null;
    public String ora = null;
    public String descrizione = null;
    public String luogo = null;
    public String tempoStimato = "test";
    public String noteAggiuntive = null;
    public String item = null;
    public Evento evento = null;
    public String nome_categoria = "firstTest";
    public boolean control = false;
    public int id_evento = 0;
    public int id_lista_size = 0;
    public int id = 0;
    public int id_img = 0;
    public int restOperation = 0;
    public View view_for_send = null;
    public View view_for_receive = null;
    public int anno_evento = 0;
    public int mese_evento = 0;
    public int giorno_evento = 0;
    public int ora_evento = 0;
    public int min_evento = 0;
    private JobScheduler jobScheduler;
    public int jobYear = 0;
    public int jobMonth = 0;
    public int jobDay = 0;
    public int jobHour = 0;
    public int jobMin = 0;
    public int sizeListJob = 0;
    public int idListJob = 0;
    public String username = null;
    public String password = null;
    public TextView textEventi = null;
    public TextView viewDettagli = null;
    public TextView viewNomeEvento = null;
    public TextView viewDataEvento = null;
    public TextView viewOraEvento = null;
    public TextView viewDescrizioneEvento = null;
    public TextView viewLuogoEvento = null;
    public TextView viewTempoStimatoEvento = null;
    public TextView viewNoteEvento = null;
    public EditText editNomeEvento = null;
    public EditText editDataEvento = null;
    public EditText editOraEvento = null;
    public EditText editDescrizioneEvento = null;
    public EditText editLuogoEvento = null;
    public EditText editNoteAggiuntive = null;
    public ImageButton buttonAdd = null;
    public ImageButton buttonRef = null;
    public ImageButton buttonBack = null;
    public ImageButton buttonEdit = null;
    public ImageButton buttonSaveEdit = null;
    public ImageButton buttonAnnulaEdit = null;
    public ImageButton buttonRemove = null;

    @SuppressLint("NewApi")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        main = findViewById(R.id.layout_main);
        main.setVisibility(View.VISIBLE);
        content_casa = findViewById(R.id.contentHomeLayout);
        content_casa.setVisibility(View.INVISIBLE);
        content_casa_details = findViewById(R.id.content_home_details);
        content_casa_details.setVisibility(View.INVISIBLE);
        content_amici = findViewById(R.id.contentAmiciLayout);
        content_amici.setVisibility(View.INVISIBLE);
        content_amici_details = findViewById(R.id.content_amici_details);
        content_amici_details.setVisibility(View.INVISIBLE);
        content_tempo_libero = findViewById(R.id.contentTempoLiberoLayout);
        content_tempo_libero.setVisibility(View.INVISIBLE);
        content_tempo_libero_details = findViewById(R.id.content_tempoLibero_details);
        content_tempo_libero_details.setVisibility(View.INVISIBLE);
        content_sport = findViewById(R.id.contentSportLayout);
        content_sport.setVisibility(View.INVISIBLE);
        content_sport_details =  findViewById(R.id.content_sport_details);
        content_sport_details.setVisibility(View.INVISIBLE);
        content_family =  findViewById(R.id.contentFamilyLayout);
        content_family.setVisibility(View.INVISIBLE);
        content_family_details = findViewById(R.id.content_family_details);
        content_family_details.setVisibility(View.INVISIBLE);
        content_lavoro = findViewById(R.id.contentLavoroLayout);
        content_lavoro.setVisibility(View.INVISIBLE);
        content_lavoro_details = findViewById(R.id.content_lavoro_details);
        content_lavoro_details.setVisibility(View.INVISIBLE);
        content_modifica = findViewById(R.id.content_modifica);
        content_modifica.setVisibility(View.INVISIBLE);

        if(username == null || password == null) {
            callLogin();
        }
        textWelcome = findViewById(R.id.textViewPrincipale);
        textWelcome.setVisibility(View.VISIBLE);
        textSelezione = findViewById(R.id.textViewSecondaria);
        textSelezione.setVisibility(View.VISIBLE);


        listaCasa = findViewById(R.id.listView_home);
        listaAmici = findViewById(R.id.listView_amici);
        listaTempoLibero = findViewById(R.id.listView_tempoLibero);
        listaSport = findViewById(R.id.listView_sport);
        listaFamiglia = findViewById(R.id.listView_family);
        listaLavoro = findViewById(R.id.listView_lavoro);

        eventi = new ArrayList<>();
        eventiCasa = new ArrayList<>();
        eventiAmici = new ArrayList<>();
        eventiTempoLibero = new ArrayList<>();
        eventiSport = new ArrayList<>();
        eventiFamiglia = new ArrayList<>();
        eventiLavoro = new ArrayList<>();


        convert = new ArrayList<>();
        convertHome = new ArrayList<>();
        convertAmici = new ArrayList<>();
        convertTempoLibero = new ArrayList<>();
        convertSport = new ArrayList<>();
        convertFamily = new ArrayList<>();
        convertLavoro = new ArrayList<>();

        if (convertHome != null) {
            adp_home = new ArrayAdapter<>(this, R.layout.element_list, R.id.textViewListElement, convertHome);
            adp_home.setNotifyOnChange(true);
        }
        if (convertAmici != null) {
            adp_amici = new ArrayAdapter<>(this, R.layout.element_list, R.id.textViewListElement, convertAmici);
            adp_amici.setNotifyOnChange(true);
        }
        if (convertTempoLibero != null) {
            adp_tempo_libero = new ArrayAdapter<>(this, R.layout.element_list, R.id.textViewListElement, convertTempoLibero);
            adp_tempo_libero.setNotifyOnChange(true);
        }
        if (convertSport != null) {
            adp_sport = new ArrayAdapter<>(this, R.layout.element_list, R.id.textViewListElement, convertSport);
            adp_sport.setNotifyOnChange(true);
        }
        if (convertFamily != null) {
            adp_family = new ArrayAdapter<>(this, R.layout.element_list, R.id.textViewListElement, convertFamily);
            adp_family.setNotifyOnChange(true);
        }
        if (convertLavoro != null) {
            adp_lavoro = new ArrayAdapter<>(this, R.layout.element_list, R.id.textViewListElement, convertLavoro);
            adp_lavoro.setNotifyOnChange(true);
        }

        jobScheduler = (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        supportInvalidateOptionsMenu();
        int id_add = id - 1;
        NavigationView nv = (NavigationView) findViewById(R.id.nav_view);
        menu = nv.getMenu();

        if (control) {
            switch (id_img) {
                case 0:
                    menu.add(R.id.group, id_add, 0, nome_categoria).setIcon(R.drawable.ic_music).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
                    control = false;
                    break;
                case 1:
                    menu.add(R.id.group, id_add, 0, nome_categoria).setIcon(R.drawable.ic_news).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
                    control = false;
                    break;
                case 2:
                    menu.add(R.id.group, id_add, 0, nome_categoria).setIcon(R.drawable.ic_box).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
                    control = false;
                    break;
                case 3:
                    menu.add(R.id.group, id_add, 0, nome_categoria).setIcon(R.drawable.ic_idea).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
                    control = false;
                    break;
                case 4:
                    menu.add(R.id.group, id_add, 0, nome_categoria).setIcon(R.drawable.ic_rating).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
                    control = false;
                    break;
            }

        }
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    public boolean onNavigationItemSelected(MenuItem item) {

        id = item.getItemId();
        view_for_receive = item.getActionView();

        if (id == R.id.nav_home) {
            nome_categoria = "CASA";
            restOperation = 1;
            idListJob = 0;
            carica(view_for_receive);
            test();
        } else if (id == R.id.nav_amici) {
            nome_categoria = "AMICI";
            restOperation = 1;
            idListJob = 0;
            carica(view_for_receive);
            test();
        } else if (id == R.id.nav_tempolibero) {
            nome_categoria = "TEMPO LIBERO";
            restOperation = 1;
            idListJob = 0;
            carica(view_for_receive);
            test();
        } else if (id == R.id.nav_sport) {
            nome_categoria = "SPORT";
            restOperation = 1;
            idListJob = 0;
            carica(view_for_receive);
            test();
        } else if (id == R.id.nav_family) {
            nome_categoria = "FAMIGLIA";
            restOperation = 1;
            idListJob = 0;
            carica(view_for_receive);
            test();
        } else if (id == R.id.nav_work) {
            nome_categoria = "LAVORO";
            restOperation = 1;
            idListJob = 0;
            carica(view_for_receive);
            test();
        } else if (id == R.id.nav_add) {
            aggiungi();
        } else if (id == R.id.nav_remove) {
            rimuovi();
        }

        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void test(){

        main.setBackgroundColor(Color.WHITE);
        textWelcome.setVisibility(View.INVISIBLE);
        textSelezione.setVisibility(View.INVISIBLE);

        content_casa.setVisibility(View.INVISIBLE);
        content_casa_details.setVisibility(View.INVISIBLE);
        content_amici.setVisibility(View.INVISIBLE);
        content_amici_details.setVisibility(View.INVISIBLE);
        content_tempo_libero.setVisibility(View.INVISIBLE);
        content_tempo_libero_details.setVisibility(View.INVISIBLE);
        content_sport.setVisibility(View.INVISIBLE);
        content_sport_details.setVisibility(View.INVISIBLE);
        content_family.setVisibility(View.INVISIBLE);
        content_family_details.setVisibility(View.INVISIBLE);
        content_lavoro.setVisibility(View.INVISIBLE);
        content_lavoro_details.setVisibility(View.INVISIBLE);
        content_modifica.setVisibility(View.INVISIBLE);

        editNomeEvento = findViewById(R.id.edit_nome);
        editDataEvento = findViewById(R.id.edit_data);
        editOraEvento = findViewById(R.id.edit_ora);
        editDescrizioneEvento = findViewById(R.id.edit_descrizione);
        editLuogoEvento = findViewById(R.id.edit_luogo);
        editNoteAggiuntive = findViewById(R.id.edit_note);
        buttonSaveEdit = findViewById(R.id.buttonSalvaModifica);
        buttonAnnulaEdit = findViewById(R.id.buttonAnnullaModifica);

        if(nome_categoria == "CASA"){
            content = content_casa;
            content_d = content_casa_details;
            textEventi = findViewById(R.id.textViewEventi);
            viewDettagli = findViewById(R.id.textViewDettagli);
            viewNomeEvento = findViewById(R.id.viewNome);
            viewDataEvento = findViewById(R.id.viewData);
            viewOraEvento = findViewById(R.id.viewOra);
            viewDescrizioneEvento = findViewById(R.id.viewDescrizione);
            viewLuogoEvento = findViewById(R.id.viewLuogo);
            viewTempoStimatoEvento = findViewById(R.id.viewTimeLeft);
            viewNoteEvento = findViewById(R.id.viewNote);


            buttonAdd = findViewById(R.id.imageButtonAdd);
            buttonRef = findViewById(R.id.imageButtonRefresh);
            buttonBack = findViewById(R.id.imageButtonBack);
            buttonEdit = findViewById(R.id.imageButtonEdit);
            buttonRemove = findViewById(R.id.imageButtonRemove);
            eventi = new ArrayList<>();
            eventi = copia(eventiCasa);
            convert = convertHome;

            adp = adp_home;
            if (convertHome != null)
                listaCasa.setAdapter(adp_home);
            lista = listaCasa;

        }else if (nome_categoria == "AMICI"){
            content = content_amici;
            content_d = content_amici_details;
            textEventi = findViewById(R.id.textViewEventiAmici);
            viewDettagli = findViewById(R.id.textViewDettagliAmici);
            viewNomeEvento = findViewById(R.id.viewNomeAmici);
            viewDataEvento = findViewById(R.id.viewDataAmici);
            viewOraEvento = findViewById(R.id.viewOraAmici);
            viewDescrizioneEvento = findViewById(R.id.viewDescrizioneAmici);
            viewLuogoEvento = findViewById(R.id.viewLuogoAmici);
            viewTempoStimatoEvento = findViewById(R.id.viewTimeLeftAmici);
            viewNoteEvento = findViewById(R.id.viewNoteAmici);
            buttonAdd = findViewById(R.id.imageButtonAddAmici);
            buttonRef = findViewById(R.id.imageButtonRefreshAmici);
            buttonBack =  findViewById(R.id.imageButtonBackAmici);
            buttonEdit = findViewById(R.id.imageButtonEditAmici);
            buttonRemove = findViewById(R.id.imageButtonRemoveAmici);
            eventi = new ArrayList<>();
            eventi = copia(eventiAmici);
            convert = convertAmici;

            adp = adp_amici;
            if (convertAmici != null)
                listaAmici.setAdapter(adp_amici);
            lista = listaAmici;

        }else if (nome_categoria == "TEMPO LIBERO"){
            content = content_tempo_libero;
            content_d = content_tempo_libero_details;
            textEventi = findViewById(R.id.textViewEventiTempoLibero);
            viewDettagli = findViewById(R.id.textViewDettagliTempoLibero);
            viewNomeEvento = findViewById(R.id.viewNomeTempoLibero);
            viewDataEvento = findViewById(R.id.viewDataTempoLibero);
            viewOraEvento = findViewById(R.id.viewOraTempoLibero);
            viewDescrizioneEvento = findViewById(R.id.viewDescrizioneTempoLibero);
            viewLuogoEvento = findViewById(R.id.viewLuogoTempoLibero);
            viewTempoStimatoEvento = findViewById(R.id.viewTimeLeftTempoLibero);
            viewNoteEvento = findViewById(R.id.viewNoteTempoLibero);
            buttonAdd = findViewById(R.id.imageButtonAddTempoLibero);
            buttonRef =  findViewById(R.id.imageButtonRefreshTempoLibero);
            buttonBack = findViewById(R.id.imageButtonBackTempoLibero);
            buttonEdit = findViewById(R.id.imageButtonEditTempoLibero);
            buttonRemove = findViewById(R.id.imageButtonRemoveTempoLibero);
            eventi = new ArrayList<Evento>();
            eventi = copia(eventiTempoLibero);
            convert = convertTempoLibero;
            adp = adp_tempo_libero;
            if (convertTempoLibero != null)
                listaTempoLibero.setAdapter(adp_tempo_libero);
            lista = listaTempoLibero;

        }else if (nome_categoria == "SPORT"){
            content = content_sport;
            content_d = content_sport_details;
            textEventi = findViewById(R.id.textViewEventiSport);
            viewDettagli = findViewById(R.id.textViewDettagliSport);
            viewNomeEvento = findViewById(R.id.viewNomeSport);
            viewDataEvento = findViewById(R.id.viewDataSport);
            viewOraEvento = findViewById(R.id.viewOraSport);
            viewDescrizioneEvento = findViewById(R.id.viewDescrizioneSport);
            viewLuogoEvento = findViewById(R.id.viewLuogoSport);
            viewTempoStimatoEvento = findViewById(R.id.viewTimeLeftSport);
            viewNoteEvento = findViewById(R.id.viewNoteSport);
            buttonAdd = findViewById(R.id.imageButtonAddSport);
            buttonRef = findViewById(R.id.imageButtonRefreshSport);
            buttonBack = findViewById(R.id.imageButtonBackSport);
            buttonEdit = findViewById(R.id.imageButtonEditSport);
            buttonRemove = findViewById(R.id.imageButtonRemoveSport);
            eventi = new ArrayList<>();
            eventi = copia(eventiSport);
            convert = convertSport;
            adp = adp_sport;
            if (convertSport != null)
                listaSport.setAdapter(adp_sport);
            lista = listaSport;

        }else if (nome_categoria == "FAMIGLIA"){
            content = content_family;
            content_d = content_family_details;
            textEventi = findViewById(R.id.textViewEventiFamily);
            viewDettagli = findViewById(R.id.textViewDettagliFamily);
            viewNomeEvento = findViewById(R.id.viewNomeFamily);
            viewDataEvento = findViewById(R.id.viewDataFamily);
            viewOraEvento = findViewById(R.id.viewOraFamily);
            viewDescrizioneEvento = findViewById(R.id.viewDescrizioneFamily);
            viewLuogoEvento = findViewById(R.id.viewLuogoFamily);
            viewTempoStimatoEvento = findViewById(R.id.viewTimeLeftFamily);
            viewNoteEvento = findViewById(R.id.viewNoteFamily);
            buttonAdd = findViewById(R.id.imageButtonAddFamily);
            buttonRef = findViewById(R.id.imageButtonRefreshFamily);
            buttonBack = findViewById(R.id.imageButtonBackFamily);
            buttonEdit = findViewById(R.id.imageButtonEditFamily);
            buttonRemove = findViewById(R.id.imageButtonRemoveFamily);
            eventi = new ArrayList<>();
            eventi = copia(eventiFamiglia);
            convert = convertFamily;
            adp = adp_family;
            if (convertFamily != null)
                listaFamiglia.setAdapter(adp_family);
            lista = listaFamiglia;

        }else if (nome_categoria == "LAVORO"){
            content = content_amici;
            content_d = content_amici_details;
            textEventi = findViewById(R.id.textViewEventiLavoro);
            viewDettagli = findViewById(R.id.textViewDettagliLavoro);
            viewNomeEvento = findViewById(R.id.viewNomeLavoro);
            viewDataEvento = findViewById(R.id.viewDataLavoro);
            viewOraEvento = findViewById(R.id.viewOraLavoro);
            viewDescrizioneEvento = findViewById(R.id.viewDescrizioneLavoro);
            viewLuogoEvento = findViewById(R.id.viewLuogoLavoro);
            viewTempoStimatoEvento = findViewById(R.id.viewTimeLeftLavoro);
            viewNoteEvento = findViewById(R.id.viewNoteLavoro);
            buttonAdd = findViewById(R.id.imageButtonAddLavoro);
            buttonRef = findViewById(R.id.imageButtonRefreshLavoro);
            buttonBack = findViewById(R.id.imageButtonBackLavoro);
            buttonEdit = findViewById(R.id.imageButtonEditLavoro);
            buttonRemove = findViewById(R.id.imageButtonRemoveLavoro);
            eventi = new ArrayList<>();
            eventi = copia(eventiLavoro);
            convert = convertAmici;
            adp = adp_amici;
            if (convertLavoro != null)
                listaLavoro.setAdapter(adp_lavoro);
            lista = listaLavoro;
        }

        content.setVisibility(View.VISIBLE);
        content_d.setVisibility(View.INVISIBLE);

        int size = eventi.size();
        if (size < 1) {
            String s = "Nessun evento";
            textEventi.setText(s);
        } else {
            textEventi.setText("Eventi disponibili: " + size);
        }

        buttonAdd.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                view_for_send = v;
                Intent crea = new Intent(MainActivity.this, CreaEvento.class);
                startActivityForResult(crea, 1);
            }
        });

        buttonRef.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                restOperation = 1;
                idListJob = 0;
                carica(view_for_receive);
            }
        });

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                item = (String) lista.getItemAtPosition(position);
                for (Evento e : eventi) {
                    if (e.getNomeEvento().equalsIgnoreCase(item)) {
                        viewDettagli.setText("DETTAGLI EVENTO " + e.getNomeEvento());
                        viewNomeEvento.setText("Nome: " + e.getNomeEvento());
                        viewDataEvento.setText("Data: " + e.getDataEvento());
                        viewOraEvento.setText("Ora: " + e.getOraEvento());
                        viewDescrizioneEvento.setText("Descrizione: " + e.getDescrizione());
                        viewLuogoEvento.setText("Luogo: " + e.getLuogoEvento());
                        viewTempoStimatoEvento.setText(e.getTempoStimato());
                        viewNoteEvento.setText("Note aggiuntive: " + e.getNoteAggiuntive());
                        id_evento = e.getId();
                        content.setVisibility(View.INVISIBLE);
                        content_d.setVisibility(View.VISIBLE);
                    }
                }
                buttonBack.setOnClickListener(new View.OnClickListener() {

                    public void onClick(View v) {
                        test();
                    }
                });

                buttonRemove.setOnClickListener(new View.OnClickListener() {

                    public void onClick(View v) {
                        for (Evento e : eventi) {
                            if (e.getNomeEvento().equalsIgnoreCase(item)) {
                                id_evento = e.getId();
                                eventi.remove(e);
                                convert.remove(e.getNomeEvento());
                                view_for_send = v;
                                restOperation=4;
                                removeData(view_for_send);
                            }
                        }
                    }
                });

                buttonEdit.setOnClickListener(new View.OnClickListener() {

                    public void onClick(View v) {
                        content.setVisibility(View.INVISIBLE);
                        content_d.setVisibility(View.INVISIBLE);
                        content_modifica.setVisibility(View.VISIBLE);
                        for (Evento e : eventi) {
                            if (e.getNomeEvento().equalsIgnoreCase(item)) {
                                editNomeEvento.setText(e.getNomeEvento());
                                editDataEvento.setText(e.getDataEvento());
                                editOraEvento.setText(e.getOraEvento());
                                editDescrizioneEvento.setText(e.getDescrizione());
                                editLuogoEvento.setText(e.getLuogoEvento());
                                editNoteAggiuntive.setText(e.getNoteAggiuntive());
                            }
                        }

                        buttonSaveEdit.setOnClickListener(new View.OnClickListener() {

                            public void onClick(View v) {


                                nome = editNomeEvento.getText().toString();
                                data = editDataEvento.getText().toString();
                                ora = editOraEvento.getText().toString();
                                descrizione = editDescrizioneEvento.getText().toString();
                                luogo = editLuogoEvento.getText().toString();
                                noteAggiuntive = editNoteAggiuntive.getText().toString();

                                for (Evento e : eventi) {
                                    if (e.getNomeEvento().equalsIgnoreCase(item)) {

                                        if (!nome.equalsIgnoreCase(e.getNomeEvento()) && nome != "") {
                                            e.setNomeEvento(nome);
                                            convert.set(position, nome);
                                        }
                                        if (!data.equalsIgnoreCase(e.getDataEvento()) && data != "") {
                                            e.setDataEvento(data);
                                        }
                                        if (!ora.equalsIgnoreCase(e.getOraEvento()) && ora != "") {
                                            e.setOraEvento(ora);
                                        }
                                        if (!descrizione.equalsIgnoreCase(e.getDescrizione()) && descrizione != "") {
                                            e.setDescrizione(descrizione);
                                        }
                                        if (!luogo.equalsIgnoreCase(e.getLuogoEvento()) && luogo != "") {
                                            e.setLuogoEvento(luogo);
                                        }
                                        if (!noteAggiuntive.equalsIgnoreCase(e.getNoteAggiuntive()) && noteAggiuntive != "") {
                                            e.setNoteAggiuntive(noteAggiuntive);
                                        }
                                    }
                                }
                                restOperation = 3;

                                editData(v);
                            }
                        });
                        buttonAnnulaEdit.setOnClickListener(new View.OnClickListener() {

                            public void onClick(View v) {
                                test();
                            }
                        });
                    }
                });

            }
        });

    }


    public ArrayList<Evento> copia(ArrayList<Evento> eventi){
        ArrayList<Evento>listEvents = new ArrayList<Evento>();
        for (Evento e : eventi) {
                String n = e.getNomeEvento();
                String d = e.getDataEvento();
                String o = e.getOraEvento();
                String de = e.getDescrizione();
                String l = e.getLuogoEvento();
                String t = e.getTempoStimato();
                String na = e.getNoteAggiuntive();
                Evento ev = new Evento(n,d,o,de,l,t,na);
                listEvents.add(ev);
        }
        return listEvents;
    }


    public void aggiungi() {

        Intent i = new Intent(MainActivity.this, CreaCategoria.class);
        startActivityForResult(i, 7);
    }

    public void rimuovi() {

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent i) {

        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                nome = i.getStringExtra("nome");
                data = i.getStringExtra("data");
                ora = i.getStringExtra("ora");
                descrizione = i.getStringExtra("descrizione");
                luogo = i.getStringExtra("luogo");
                noteAggiuntive = i.getStringExtra("noteAggiuntive");
                restOperation=2;
                postData(view_for_send);
            }

        }
        if (requestCode == 7) {
            if (resultCode == Activity.RESULT_OK) {
                nome_categoria = i.getStringExtra("nome_categoria");
                String s = i.getStringExtra("id");
                Toast.makeText(getBaseContext(), "Categoria Salvata", Toast.LENGTH_LONG).show();
                id_img = Integer.parseInt(s);
                control = true;
            }
        }
        if(requestCode == 8){
            if(resultCode == Activity.RESULT_OK){
                username = i.getStringExtra("username");
                password = i.getStringExtra("password");
                Toast.makeText(getBaseContext(), "Autenticato", Toast.LENGTH_LONG).show();
            }else{
                callLogin();
            }
        }


    }

    public void postData(View vw) {

        if (nome.equals("") || data.equals("") || ora.equals("") || descrizione.equals("") || luogo.equals("") || noteAggiuntive.equals("")) {
            Toast.makeText(this, "Please enter in all required fields.",
                    Toast.LENGTH_LONG).show();
            return;
        }
        WebServiceTask wst_add = new WebServiceTask(WebServiceTask.POST_TASK, this, "Salvataggio...");

        wst_add.addNameValuePair("nome_categoria", nome_categoria);
        wst_add.addNameValuePair("nomeEvento", nome);
        wst_add.addNameValuePair("dataEvento", data);
        wst_add.addNameValuePair("oraEvento", ora);
        wst_add.addNameValuePair("descrizioneEvento", descrizione);
        wst_add.addNameValuePair("luogoEvento", luogo);
        wst_add.addNameValuePair("noteAggiuntiveEvento", noteAggiuntive);

        wst_add.execute(new String[]{SERVICE_URL});

    }

    public void editData(View vw){
        if (nome.equals("") || data.equals("") || ora.equals("") || descrizione.equals("") || luogo.equals("") || tempoStimato.equals("") || noteAggiuntive.equals("")) {
            Toast.makeText(this, "Please enter in all required fields.",
                    Toast.LENGTH_LONG).show();
            return;
        }

        String convert_id = Integer.toString(id_evento);
        WebServiceTask wst_edit = new WebServiceTask(WebServiceTask.POST_TASK, this, "Modifica...");

        wst_edit.addNameValuePair("nome_categoria", nome_categoria);
        wst_edit.addNameValuePair("id_evento", convert_id);
        wst_edit.addNameValuePair("nomeEvento", nome);
        wst_edit.addNameValuePair("dataEvento", data);
        wst_edit.addNameValuePair("oraEvento", ora);
        wst_edit.addNameValuePair("descrizioneEvento", descrizione);
        wst_edit.addNameValuePair("luogoEvento", luogo);
        wst_edit.addNameValuePair("noteAggiuntiveEvento", noteAggiuntive);

        wst_edit.execute(new String[]{SERVICE_URL_EDIT});
    }

    public void removeData(View vw){
        WebServiceTask wst_rem = new WebServiceTask(WebServiceTask.POST_TASK, this, "Eliminazione...");
        String convert_id = Integer.toString(id_evento);
        wst_rem.addNameValuePair("nome_categoria", nome_categoria);
        wst_rem.addNameValuePair("id_evento", convert_id);
        wst_rem.execute(new String[]{SERVICE_URL_REMOVE});
    }

    public void handleResponse(String response) {

        //CARICAMENTO LISTA EVENTI DAL DB
        if (restOperation == 1) {
            String casa = "CASA";
            String amici = "AMICI";
            String tempoLibero = "TEMPO LIBERO";
            String sport = "SPORT";
            String famiglia = "FAMIGLIA";
            String lavoro = "LAVORO";
            try {
                //JSONObject jso = new JSONObject(response);
                //JSONArray ja = jso.getJSONArray("evento");
                JSONArray ja = new JSONArray(response);
                id_lista_size = ja.length();
                sizeListJob = id_lista_size*6;
                String[] list = new String[sizeListJob];
                for(int i=0;i<id_lista_size;i++){
                    JSONObject item = ja.getJSONObject(i);
                    nome = item.getString("nomeEvento");
                    data = item.getString("dataEvento");
                    ora = item.getString("oraEvento");
                    descrizione = item.getString("descrizioneEvento");
                    luogo = item.getString("luogoEvento");
                    noteAggiuntive = item.getString("noteAggiuntiveEvento");
                    tempoStimato = calcolaTempoStimato(data, ora);
                    evento = new Evento(nome, data, ora, descrizione, luogo, tempoStimato, noteAggiuntive);
                    String annoForJob = Integer.toString(jobYear);
                    String meseForJob = Integer.toString(jobMonth);
                    String giornoForJob = Integer.toString(jobDay);
                    String oraForJob = Integer.toString(jobHour);
                    String minutoForJob = Integer.toString(jobMin);

                    list[idListJob] = nome;
                    idListJob = idListJob+1;
                    list[idListJob] = annoForJob;
                    idListJob = idListJob+1;
                    list[idListJob] = meseForJob;
                    idListJob = idListJob+1;
                    list[idListJob] = giornoForJob;
                    idListJob = idListJob+1;
                    list[idListJob] = oraForJob;
                    idListJob = idListJob+1;
                    list[idListJob] = minutoForJob;
                    if(idListJob < sizeListJob) {
                        idListJob = idListJob + 1;
                    }
                    evento.setId(item.getInt("id"));
                    boolean control_presenza = false;

                  if(nome_categoria.equals(casa)){
                        eventi = new ArrayList<Evento>();
                        eventi = copia(eventiCasa);
                        convert = convertHome;
                    }else if(nome_categoria.equals(amici)){
                        eventi = new ArrayList<Evento>();
                        eventi = copia(eventiAmici);
                        convert = convertAmici;
                    }else if(nome_categoria.equals(tempoLibero)){
                        eventi = new ArrayList<Evento>();
                        eventi = copia(eventiTempoLibero);
                        convert = convertTempoLibero;
                    }else if(nome_categoria.equals(sport)){
                        eventi = new ArrayList<Evento>();
                        eventi = copia(eventiSport);
                        convert = convertSport;
                    }else if(nome_categoria.equals(famiglia)){
                        eventi = new ArrayList<Evento>();
                        eventi = copia(eventiFamiglia);
                        convert = convertFamily;
                    }else if(nome_categoria.equals(lavoro)){
                        eventi = new ArrayList<Evento>();
                        eventi = copia(eventiLavoro);
                        convert = convertLavoro;
                    }
                    for(Evento e : eventi){
                        if(e.getNomeEvento().equalsIgnoreCase(nome)){
                                e.setId(id_evento);
                                e.setNomeEvento(nome);
                                e.setDataEvento(data);
                                e.setOraEvento(ora);
                                e.setDescrizione(descrizione);
                                e.setLuogoEvento(luogo);
                                e.setTempoStimato(tempoStimato);
                                e.setNoteAggiuntive(noteAggiuntive);
                                convert.set(i,nome);
                                control_presenza = true;
                        }
                    }
                    if(control_presenza == false){
                        eventi.add(evento);
                        convert.add(nome);
                    }



                 if (nome_categoria.equals(casa)) {

                        for(Evento e : eventiCasa){
                            if(e.getNomeEvento().equalsIgnoreCase(nome)){
                                e.setId(id_evento);
                                e.setNomeEvento(nome);
                                e.setDataEvento(data);
                                e.setOraEvento(ora);
                                e.setDescrizione(descrizione);
                                e.setLuogoEvento(luogo);
                                e.setTempoStimato(tempoStimato);
                                e.setNoteAggiuntive(noteAggiuntive);
                                convertHome.set(i, nome);
                                control_presenza = true;
                            }
                        }
                        if(control_presenza==false) {
                            eventiCasa.add(evento);
                            convertHome.add(nome);
                        }
                    } else if (nome_categoria.equals(amici)) {

                        for(Evento e : eventiAmici) {
                            if(e.getNomeEvento().equalsIgnoreCase(nome)){
                                e.setNomeEvento(nome);
                                e.setDataEvento(data);
                                e.setOraEvento(ora);
                                e.setDescrizione(descrizione);
                                e.setLuogoEvento(luogo);
                                e.setTempoStimato(tempoStimato);
                                e.setNoteAggiuntive(noteAggiuntive);
                                convertAmici.set(i, nome);
                                control_presenza = true;
                            }
                        }
                        if(control_presenza == false) {
                            eventiAmici.add(evento);
                            convertAmici.add(nome);
                        }
                    } else if (nome_categoria.equals(tempoLibero)) {
                        for(Evento e : eventiTempoLibero) {
                            if (e.getNomeEvento().equalsIgnoreCase(nome)) {
                                e.setNomeEvento(nome);
                                e.setDataEvento(data);
                                e.setOraEvento(ora);
                                e.setDescrizione(descrizione);
                                e.setLuogoEvento(luogo);
                                e.setTempoStimato(tempoStimato);
                                e.setNoteAggiuntive(noteAggiuntive);
                                convertTempoLibero.set(i, nome);
                                control_presenza = true;
                            }
                        }
                        if(control_presenza == false) {
                            eventiTempoLibero.add(evento);
                            convertTempoLibero.add(nome);
                        }
                    } else if (nome_categoria.equals(sport)) {
                        for(Evento e : eventiSport) {
                            if (e.getNomeEvento().equalsIgnoreCase(nome)) {
                                e.setNomeEvento(nome);
                                e.setDataEvento(data);
                                e.setOraEvento(ora);
                                e.setDescrizione(descrizione);
                                e.setLuogoEvento(luogo);
                                e.setTempoStimato(tempoStimato);
                                e.setNoteAggiuntive(noteAggiuntive);
                                convertSport.set(i, nome);
                                control_presenza = true;
                            }
                        }
                        if(control_presenza == false) {
                            eventiSport.add(evento);
                            convertSport.add(nome);
                        }
                    } else if (nome_categoria.equals(famiglia)) {
                        for (Evento e : eventiFamiglia) {
                            if (e.getNomeEvento().equalsIgnoreCase(nome)) {
                                e.setNomeEvento(nome);
                                e.setDataEvento(data);
                                e.setOraEvento(ora);
                                e.setDescrizione(descrizione);
                                e.setLuogoEvento(luogo);
                                e.setTempoStimato(tempoStimato);
                                e.setNoteAggiuntive(noteAggiuntive);
                                convertFamily.set(i, nome);
                                control_presenza = true;
                            }
                        }
                        if (control_presenza == false) {
                            eventiFamiglia.add(evento);
                            convertFamily.add(nome);
                        }

                    } else if (nome_categoria.equals(lavoro)) {
                        for(Evento e : eventiLavoro) {
                            if (e.getNomeEvento().equalsIgnoreCase(nome)) {
                                e.setNomeEvento(nome);
                                e.setDataEvento(data);
                                e.setOraEvento(ora);
                                e.setDescrizione(descrizione);
                                e.setLuogoEvento(luogo);
                                e.setTempoStimato(tempoStimato);
                                e.setNoteAggiuntive(noteAggiuntive);
                                convertLavoro.set(i, nome);
                                control_presenza = true;
                            }
                        }
                        if(control_presenza == false) {
                            eventiLavoro.add(evento);
                            convertLavoro.add(nome);
                        }
                    }
                }

                onStartJobs(list);

            }catch(JSONException e){
                e.printStackTrace();
            }

            //AGGIUNTA DI UN EVENTO NEL  DB
        } else if (restOperation == 2 && response!= null){
            try {
                String casa = "CASA";
                String amici = "AMICI";
                String tempoLibero = "TEMPO LIBERO";
                String sport = "SPORT";
                String famiglia = "FAMIGLIA";
                String lavoro = "LAVORO";

                JSONObject jso = new JSONObject(response);
                nome = jso.getString("nomeEvento");
                data = jso.getString("dataEvento");
                ora = jso.getString("oraEvento");
                descrizione = jso.getString("descrizioneEvento");
                luogo = jso.getString("luogoEvento");
                noteAggiuntive = jso.getString("noteAggiuntiveEvento");
               // tempoStimato = calcolaTempoStimato(data,ora);
                evento = new Evento(nome, data, ora, descrizione, luogo, tempoStimato, noteAggiuntive);
                evento.setId(id_lista_size+1);
                if (nome_categoria.equals(casa)) {
                    if(eventiCasa.contains(evento)){
                        test();
                    }else{
                        eventiCasa.add(evento);
                        convertHome.add(nome);
                    }
                } else if (nome_categoria.equals(amici)) {
                    if(eventiAmici.contains(evento)){
                        test();
                    }else {
                        eventiAmici.add(evento);
                        convertAmici.add(nome);
                    }
                } else if (nome_categoria.equals(tempoLibero)) {
                    if(eventiTempoLibero.contains(evento)){
                        test();
                    }else {
                        eventiTempoLibero.add(evento);
                        convertTempoLibero.add(nome);
                    }
                } else if (nome_categoria.equals(sport)) {
                    if(eventiSport.contains(evento)){
                        test();
                    }else {
                        eventiSport.add(evento);
                        convertSport.add(nome);
                    }
                } else if (nome_categoria.equals(famiglia)) {
                    if(eventiFamiglia.contains(evento)){
                        test();
                    }else {
                        eventiFamiglia.add(evento);
                        convertFamily.add(nome);
                    }
                } else if (nome_categoria.equals(lavoro)) {
                    if (eventiLavoro.contains(evento)) {
                        test();
                    } else {
                        eventiLavoro.add(evento);
                        convertLavoro.add(nome);
                    }
                }
                String s = "Evento salvato";
                Toast.makeText(getBaseContext(), s, Toast.LENGTH_LONG).show();
            } catch (Exception e) {
                Log.e(TAG, e.getLocalizedMessage(), e);
            }
            //MODIFICA DI UN EVENTO NEL  DB
        }else if (restOperation == 3) {
            int ok = Integer.parseInt(response);
            if(ok == 1) {
                String s = "Evento modificato";
                Toast.makeText(getBaseContext(), s, Toast.LENGTH_LONG).show();
               test();
            }else{
                String s = "Errore ";
                Toast.makeText(getBaseContext(), s, Toast.LENGTH_LONG).show();
            }
            //RIMOZIONE DI UN EVENTO NEL  DB
        }else if(restOperation == 4) {
            int ok = Integer.parseInt(response);
            if (ok == 1) {
                String s = "Evento rimosso";
                Toast.makeText(getBaseContext(), s, Toast.LENGTH_LONG).show();
                test();
            } else {
                String s = "Errore ";
                Toast.makeText(getBaseContext(), s, Toast.LENGTH_LONG).show();
            }
        }
    }


    private class WebServiceTask extends AsyncTask<String, Integer, String> {

        public static final int POST_TASK = 1;
        public static final int GET_TASK = 2;

        private static final String TAG = "WebServiceTask";

        private int taskType = GET_TASK;
        private Context mContext = null;
        private String processMessage = "Processing...";

        private ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();

        private ProgressDialog pDlg = null;

        public WebServiceTask(int taskType, Context mContext, String processMessage) {

            this.taskType = taskType;
            this.mContext = mContext;
            this.processMessage = processMessage;
        }

        public void addNameValuePair(String name, String value) {

            params.add(new BasicNameValuePair(name, value));
        }

        private void showProgressDialog() {

            pDlg = new ProgressDialog(mContext);
            pDlg.setMessage(processMessage);
            pDlg.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            pDlg.setCancelable(false);
            pDlg.show();

        }

        protected void onPreExecute() {
            showProgressDialog();

        }

        protected String doInBackground(String... urls) {

            String url = urls[0];
            String result = "";

            HttpResponse response = doResponse(url);

            if (response == null) {
                return result;
            } else {

                try {

                    result = inputStreamToString(response.getEntity().getContent());

                } catch (IllegalStateException e) {
                    Log.e(TAG, e.getLocalizedMessage(), e);

                } catch (IOException e) {
                    Log.e(TAG, e.getLocalizedMessage(), e);
                }

            }

            return result;

        }

        @Override
        protected void onPostExecute(String response) {

            handleResponse(response);
            pDlg.dismiss();
                test();
        }

        private HttpResponse doResponse(String url) {

            HttpClient httpclient = new DefaultHttpClient();

            HttpResponse response = null;

            try {
                switch (taskType) {

                    case POST_TASK:
                        HttpPost httppost = new HttpPost(url);
                        httppost.setEntity(new UrlEncodedFormEntity(params));

                        response = httpclient.execute(httppost);
                        break;
                    case GET_TASK:
                        HttpGet httpget = new HttpGet(url);
                        response = httpclient.execute(httpget);
                        break;
                }
            } catch (Exception e) {

                Log.e(TAG, e.getLocalizedMessage(), e);

            }

            return response;
        }

        private String inputStreamToString(InputStream is) {

            String line = "";
            StringBuilder total = new StringBuilder();

            BufferedReader rd = new BufferedReader(new InputStreamReader(is));

            try{
                while ((line = rd.readLine()) != null) {
                    total.append(line);
                }
            } catch (IOException e) {
                Log.e(TAG, e.getLocalizedMessage(), e);
            }

            return total.toString();

        }
    }


    public void carica(View vw) {
        WebServiceTask wst = new WebServiceTask(WebServiceTask.POST_TASK, this, "Caricamento eventi...");
        wst.addNameValuePair("nome_categoria", nome_categoria);
        wst.execute(new String[]{SERVICE_URL_LOAD});
    }

    public String calcolaTempoStimato(String data, String ora){

        String subDataYear = data.substring(0,4);
        anno_evento = Integer.parseInt(subDataYear);
        String subDataMonth = data.substring(5,7);
        mese_evento = Integer.parseInt(subDataMonth);
        String subDataDay = data.substring(8,10);
        giorno_evento = Integer.parseInt(subDataDay);
        String subOraHour = ora.substring(0,2);
        ora_evento = Integer.parseInt(subOraHour);
        String subOraMin = ora.substring(3, 4);
        min_evento = Integer.parseInt(subOraMin);

        Calendar c = Calendar.getInstance();
        int anni = c.get(Calendar.YEAR);
        int mesi = c.get(Calendar.MONTH)+1;
        int giorni = c.get(Calendar.DAY_OF_MONTH);
        int ore = c.get(Calendar.HOUR_OF_DAY)+2;
        int minuti = c.get(Calendar.MINUTE);

        anno_evento = anno_evento-anni;

        if(mesi<=mese_evento) {
            mese_evento = mese_evento - mesi;
        }else {
            mesi = 12-mesi;
            mese_evento = mesi + mese_evento;
        }
        if(giorni<=giorno_evento){
            giorno_evento = giorno_evento - giorni;
        }else{
            giorni = getGiorni(mese_evento,anno_evento)-giorni;
            giorno_evento = giorni + giorno_evento;
        }
        if(ore<=ora_evento){
            ora_evento = ora_evento-ore;
        }else {
            ore = 24-ore;
            ora_evento = ore+ora_evento;
        }
        if(minuti<=min_evento) {
            min_evento = minuti - min_evento;
        }else{
            minuti = 60-minuti;
            min_evento = minuti + min_evento;
        }

        jobYear = anno_evento;
        jobMonth = mese_evento;
        jobDay = giorno_evento;
        jobHour = ora_evento;
        jobMin = min_evento;

        if(jobYear != 0)
        {
            tempoStimato = "year:"+jobYear+" month:"+jobMonth+" day:"+jobDay+" hour:"+jobHour+" min:"+jobMin;
        }
        else if(jobMonth != 0)
        {
            tempoStimato = "month:"+jobMonth+" day:"+jobDay+" hour:"+jobHour+" min:"+jobMin;
        }
        else if(jobDay != 0)
        {
            tempoStimato = "day:"+jobDay+" hour:"+jobHour+" min:"+jobMin;
        }
        else if(jobHour != 0)
        {
            tempoStimato = "hour:"+jobHour+" min:"+jobMin;
        }
        else {
            tempoStimato = "min:"+jobMin;
        }
        return tempoStimato;
    }

    public int getGiorni(int mese, int anno){
        int day = 0;
        if(mese==4 || mese == 6 || mese == 9 || mese==11){
            day = 30;
        }else if(mese == 2){
            if(anno%4 != 0){
                day = 28;
            }else{
                day = 29;
            }
        }else{
            day = 31;
        }
        return day;
    }




    private void  onStartJobs(String[] list) {
        PersistableBundle extras = new PersistableBundle();

        extras.putString("categoria",nome_categoria);
        extras.putStringArray("list", list);
        JobInfo.Builder builder = new JobInfo.Builder(1, new ComponentName(getPackageName(), ControlloScadenze.class.getName()));
        builder.setPeriodic(5000);
        builder.setExtras(extras);
        jobScheduler.schedule(builder.build());
    }

    protected void onPause() {
        super.onPause();
        jobScheduler.cancelAll();
    }

    private View.OnClickListener onStopJobs() {
        return new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                jobScheduler.cancelAll();
                Toast.makeText(MainActivity.this, "cancel job", Toast.LENGTH_SHORT).show();
            }
        };
    }

    public void callLogin(){
        Intent i_log = new Intent(MainActivity.this,Login.class);
        startActivityForResult(i_log,8);
    }

}