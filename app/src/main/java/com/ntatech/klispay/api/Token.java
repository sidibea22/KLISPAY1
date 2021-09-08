package com.ntatech.klispay.api;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.ntatech.klispay.LoginActivity;
import com.ntatech.klispay.MainActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.HashMap;

public class Token extends AsyncTask<String,String,String> {

    String login = "cheicko92@gmail.com",password = "KLISPAY2021@!";

    Context context;

    ProgressDialog dialog;
    JSONParser parser = new JSONParser();
    String success="";
    int codelog;
    Array role;

    public  Token(Context context){
        this.context = context;
    }



    //Avant l'execution du Thread
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dialog = new ProgressDialog(context);
        dialog.setMessage("Patientez s'il vous plait "+success.length());
        dialog.show();
    }
    //l'execution du Thead
    @Override
    protected String doInBackground(String... strings) {

        HashMap<String,String> map=new HashMap<>();
        map.put("_email",login);
        map.put("_password",password);
        JSONObject object=parser.makeHttpRequest("http://92.222.22.159/public/api/login_check","POST",map);
        try {
            if(!object.getString("token").isEmpty())
                success = object.getString("token");
            Log.i("token", success);
            //codelog = object.getInt("code");
            //role = object.getJSONArray("roles");
            //Affichage du tableau de board
            //Dashborad pour agent ou superviseur

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
    //Apres l'execution du Thread
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        dialog.cancel();
        AlertDialog.Builder alert = new AlertDialog.Builder(context);
        if (success.length()>0){
            alert.setMessage("ok");
            alert.setNeutralButton("Ok",null);
        }
        else{
            alert.setMessage("Login ou Mot de passe incorrect");
            alert.setNeutralButton("OK",null);
        }
        alert.show();

    }
}
