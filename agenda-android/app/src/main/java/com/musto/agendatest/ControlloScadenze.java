package com.musto.agendatest;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.PersistableBundle;
import android.widget.Toast;

import java.util.ArrayList;

public class ControlloScadenze extends JobService {

    private JobParameters params;
    public ArrayList<EventoInScadenza> eventi_casa = new ArrayList<EventoInScadenza>();
    public ArrayList<EventoInScadenza> eventi_amici = new ArrayList<EventoInScadenza>();
    public ArrayList<EventoInScadenza> eventi_tempo_libero = new ArrayList<EventoInScadenza>();
    public ArrayList<EventoInScadenza> eventi_sport = new ArrayList<EventoInScadenza>();
    public ArrayList<EventoInScadenza> eventi_famiglia = new ArrayList<EventoInScadenza>();
    public ArrayList<EventoInScadenza> eventi_lavoro = new ArrayList<EventoInScadenza>();
    public ArrayList<EventoInScadenza> listtest = null;
    public EventoInScadenza ev = null;
    public String categoria = null;
    public String nome = null;
    public String anno = null;
    public String mese = null;
    public String giorno = null;
    public String ora = null;
    public String minuto = null;
    public String jobName = null;
    public String[] list = null;
    public int jobYear = 0;
    public int jobMonth = 0;
    public int jobDay = 0;
    public int jobHour = 0;
    public int jobMin = 0;

    @Override
    public boolean onStartJob(JobParameters params) {
        this.params = params;
        PersistableBundle extras = new PersistableBundle();
        extras = params.getExtras();
        categoria = extras.getString("categoria");
        list = extras.getStringArray("list");
        int size = list.length;
        listtest = getList(categoria);
        int i = 0;
        while(i<=size-1){
            nome = list[i];
            i++;
            anno = list[i];
            i++;
            mese = list[i];
            i++;
            giorno = list[i];
            i++;
            ora = list[i];
            i++;
            minuto = list[i];
            if(i<size){
                i++;
            }
            ev = new EventoInScadenza(nome,anno,mese,giorno,ora,minuto);
            listtest.add(ev);
        }

        for(EventoInScadenza ev : listtest) {
            if (ev.getNome() != null) {
                jobName = ev.getNome();
            }
            if (ev.getAnno() != null) {
                jobYear = Integer.parseInt(ev.getAnno());
            }
            if (ev.getMese() != null) {
                jobMonth = Integer.parseInt(ev.getMese());
            }
            if (ev.getGiorno() != null) {
                jobDay = Integer.parseInt(ev.getGiorno());
            }
            if (ev.getOra() != null) {
                jobHour = Integer.parseInt(ev.getOra());
            }
            if (ev.getMinuto() != null) {
                jobMin = Integer.parseInt(ev.getMinuto());
            }

            if (jobYear == 0 && jobMonth == 0 && jobDay == 0 && jobHour == 0) {
                Toast.makeText(getApplicationContext(), "Evento: " + jobName + " in scadenza, tempo restante: " + jobMin + " min", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), "Controllo scadenze.. ", Toast.LENGTH_SHORT).show();
            }
        }

        return true;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }

    public ArrayList<EventoInScadenza> getList(String categoria){

        switch (categoria)
        {
            case "CASA" : return eventi_casa;
            case "AMICI" : return eventi_amici;
            case "TEMPO LIBERO" : return eventi_tempo_libero;
            case "SPORT" : return eventi_sport;
            case "FAMIGLIA" : return eventi_famiglia;
            case "LAVORO" : return eventi_lavoro;
            default: return eventi_casa;
        }

    }

}
