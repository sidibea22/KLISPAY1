package com.ntatech.klispay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.ntatech.klispay.api.APIInterface;
import com.ntatech.klispay.model.Partner;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity {

    private String token;
    TextInputEditText txtEmail, txtPassword;
    Button btnconnexion;
    APIInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // AndroidNetworking.initialize(this);
        setContentView(R.layout.activity_login);
        btnconnexion = findViewById(R.id.btnConnexion);
        txtEmail = findViewById(R.id.txtEmail);
        txtPassword = findViewById(R.id.txtPassword);
        // implement setOnClickListener event on sign up Button
        btnconnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String login = "cheicko92@gmail.com", password = "KLISPAY2021@!";
                Toast.makeText(getApplicationContext(), "en cours", Toast.LENGTH_LONG).show();

                /**
                 Create new user
                 **/
                Partner partner = new Partner(login, password);
                Call<Partner> call1 = apiInterface.getToken(partner);
                call1.enqueue(new Callback<Partner>() {


                    @Override
                    public void onResponse(Call<Partner> call, Response<Partner> response) {
                        Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<Partner> call, Throwable t) {
                        call.cancel();
                    }
                });

            }
        });
    }
    private boolean validateEmail() {
        String email = txtEmail.getText().toString().trim();

        if (email.isEmpty() || !isValidEmail(email)) {
            txtEmail.setError("Email is not valid.");
            txtEmail.requestFocus();
            return false;
        }
        return true;
    }
    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean validate(TextInputEditText editText) {
        // check the lenght of the enter data in EditText and give error if its empty
        if (editText.getText().toString().trim().length() >= 8) {
            return true; // returns true if field is not empty
        }
        editText.setError("Please Fill This");
        editText.requestFocus();
        return false;
    }


   /* class Tokens extends AsyncTask<String,String,String> {

        String login = "cheicko92@gmail.com",password = "KLISPAY2021@!";



        ProgressDialog dialog;
        JSONParser parser = new JSONParser();
        String success="";
        int codelog;
        Array role;

        //Avant l'execution du Thread
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = new ProgressDialog(LoginActivity.this);
            dialog.setMessage("Patientez s'il vous plait "+success.length());
            dialog.show();
        }
        //l'execution du Thead
        @Override
        protected String doInBackground(String... strings) {

            AndroidNetworking.post("http://92.222.22.159/public/api/login_check")
                    .addBodyParameter("_email", login)
                    .addBodyParameter("_password", password)
                    .setTag("test")
                    .setPriority(Priority.MEDIUM)
                    .build()
                    .getAsJSONObject(new JSONObjectRequestListener() {
                        @Override
                        public void onResponse(JSONObject response) {
                            // do anything with response
                            Log.d("Token", response.toString());
                        }
                        @Override
                        public void onError(ANError error) {
                            // handle error
                        }
                    });

            return null;
        }
        //Apres l'execution du Thread
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            dialog.cancel();
            AlertDialog.Builder alert = new AlertDialog.Builder(LoginActivity.this);
            alert.setMessage("ok");

        }
    }*/



}

