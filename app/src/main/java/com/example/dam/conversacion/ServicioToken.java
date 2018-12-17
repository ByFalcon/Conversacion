package com.example.dam.conversacion;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class ServicioToken extends FirebaseInstanceIdService {

    private static final String TAG = "XYZYX";

    @Override
    public void onTokenRefresh() {
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Refreshed token: " + refreshedToken);
        saveRegistrationInSharedPreference(refreshedToken);
        sendRegistrationToServer(refreshedToken);
    }

    private void sendRegistrationToServer(String refreshedToken) {
        //enviar el token al servidor

    }

    private void saveRegistrationInSharedPreference(String refreshedToken) {
        SharedPreferences sharedPref = this.getSharedPreferences("file", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("token", refreshedToken);
        editor.commit();
    }
}
