package com.musto.agendatest;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TimeUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;


import com.musto.agendatest.R;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


public class Login extends AppCompatActivity {

    public String username = null;
    public String password = null;
    public EditText editUser = null;
    public EditText editPass = null;
    public Button bLog = null;
    public boolean control = false;
    public RelativeLayout login_layout = null;
    public String error_message = null;
    public TextView tw = null;
    //For Travis CI
    //private static final String SERVICE_URL_LOGIN = "http://10.0.2.2:8080/AgendaRestServer/rest/login";
    private static final String SERVICE_URL_LOGIN = "http://172.16.49.49:8080/AgendaRestServer/rest/login";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_layout = (RelativeLayout)findViewById(R.id.layout_login);




        tw = (TextView) findViewById(R.id.errorMessage);
        tw.setVisibility(View.INVISIBLE);

        editUser = (EditText)findViewById(R.id.editUsername);
        editPass = (EditText)findViewById(R.id.editPass);

        bLog = (Button)findViewById(R.id.buttonLogin);

        bLog.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                username = editUser.getText().toString();
                password = editPass.getText().toString();

                    login();

            }
        });
    }


    public void back(boolean bool){
        if(bool){
            Intent log = new Intent(Login.this, MainActivity.class);
            log.putExtra("username", username);
            log.putExtra("password", password);
            setResult(Activity.RESULT_OK, log);
            finish();
        }else{
            Intent log = new Intent(Login.this, MainActivity.class);
            setResult(Activity.RESULT_CANCELED, log);
            finish();
        }
    }


    public void login(){
        final WebServiceTask wst_log = new WebServiceTask(WebServiceTask.POST_TASK,this,"Login...");

     /*   new CountDownTimer(10000, 1000){
            public void onTick(long millisUntilFinished){

            }
            public void onFinish(){
                wst_log.cancel(true);
                login_layout.setVisibility(View.INVISIBLE);
                error_message = "Impossibile connettersi con il server";
                tw.setText(error_message);
                error_layout.setVisibility(View.VISIBLE);

                back.setOnClickListener(new View.OnClickListener() {

                    public void onClick(View v) {
                        Intent log = new Intent(Login.this, Login.class);
                        setResult(Activity.RESULT_CANCELED, log);
                        finish();
                    }
                });

            }
        }.start(); */
        wst_log.addNameValuePair("username",username);
        wst_log.addNameValuePair("password",password);
        try {
            wst_log.execute(new String[]{SERVICE_URL_LOGIN});
        }catch (Exception e){
            System.out.println("--------->");
            tw.setVisibility(View.VISIBLE);
        }

    }


    public void handleResponse(String response) {

        if (response.equalsIgnoreCase("ok")) {
            control = true;
            error_message = "Connessione al server riuscita";
            tw.setText(error_message);
            back(control);
        }else{
            control = false;
            Toast.makeText(getBaseContext(), "Errore: username o password non corretti", Toast.LENGTH_LONG).show();
            error_message = "Errore: username o password non corretti";
            tw.setText(error_message);
            back(control);
        }
    }


    private void hideKeyboard() {

        InputMethodManager inputManager = (InputMethodManager) Login.this
                .getSystemService(Context.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(
                Login.this.getCurrentFocus()
                        .getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
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
            pDlg.setCancelable(true);

          /*  new CountDownTimer(10100, 1000){
                public void onTick(long millisUntilFinished){

                }
                public void onFinish(){
                    pDlg.cancel();
                }
            }.start(); */
            pDlg.show();

        }

        protected void onPreExecute() {

            hideKeyboard();
            showProgressDialog();

        }

        protected String doInBackground(String... urls) {

            String url = urls[0];
            String result = "";

            HttpResponse response = doResponse(url);

            if (response == null) {
              /*  login_layout.setVisibility(View.INVISIBLE);
                error_message = "Impossibile connettersi con il server";
                tw.setText(error_message);
                error_layout.setVisibility(View.VISIBLE);
                */
                return result;
            } else {

                try {

                    result = inputStreamToString(response.getEntity().getContent());

                }catch (IllegalStateException e) {
                    Log.e(TAG, e.getLocalizedMessage(), e);

                } catch (IOException e) {
                    Log.e(TAG, e.getLocalizedMessage(), e);
                }

            }

            return result;

        }

        protected void onPostExecute(String response) {

            handleResponse(response);
            pDlg.dismiss();
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


/*
    public void postRequest( String url) throws IOException {

        MediaType MEDIA_TYPE = MediaType.parse("application/json");
     //   String url = "https://cakeapi.trinitytuts.com/api/add";

        OkHttpClient client = new OkHttpClient();

        JSONObject postdata = new JSONObject();
        try {
            postdata.put("username", "admin");
            postdata.put("password", "admin");
        } catch(JSONException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        RequestBody body = RequestBody.create(MEDIA_TYPE, postdata.toString());

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                String mMessage = e.getMessage().toString();
                Log.w("failure Response", mMessage);
                //call.cancel();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String mMessage = response.body().string();
                System.out.println("-------> "+mMessage);
            }
        });
    }
    */
}

