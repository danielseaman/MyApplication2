package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView)findViewById(R.id.textView2);
        final Button button = findViewById(R.id.button);
        GPSTracker gpsTracker = new GPSTracker(this);
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //volleyPost();

                String postUrl = "https://reqres.in/api/users";

                String stringLatitude = String.valueOf(gpsTracker.latitude);



                String stringLongitude = String.valueOf(gpsTracker.longitude);

                textView.setText(stringLatitude+" "+stringLongitude);
                JSONObject postData = new JSONObject();
                try {
                    postData.put("lat", stringLatitude);
                    postData.put("long", stringLongitude);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

    }
    public void volleyPost(){
        GPSTracker gpsTracker = new GPSTracker(this);
        String postUrl = "https://reqres.in/api/users";
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String stringLatitude = String.valueOf(gpsTracker.latitude);



        String stringLongitude = String.valueOf(gpsTracker.longitude);

        textView.setText(stringLatitude+" "+stringLongitude);
        JSONObject postData = new JSONObject();
        try {
            postData.put("lat", stringLatitude);
            postData.put("long", stringLongitude);

        } catch (JSONException e) {
            e.printStackTrace();
        }
/*
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, postUrl, postData, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                System.out.println(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        requestQueue.add(jsonObjectRequest);*/

    }
}