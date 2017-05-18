package com.example.aalam.dashboardapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class AlreadyRegisteredActivity extends AppCompatActivity {
    TextView getCodeButton;
    EditText mEmailView;
    String userEmailId;
    Boolean isEmailValid =false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_already_registered);
        mEmailView= (EditText) findViewById(R.id.email_textview);
        mEmailView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                userEmailId = mEmailView.getText().toString().trim();


                if (userEmailId.matches(android.util.Patterns.EMAIL_ADDRESS.toString()) && s.length() > 0) {
                    isEmailValid = true;

                } else {
                    isEmailValid = false;

                }



            }
        });

        getCodeButton = (TextView) findViewById(R.id.getCode);
        getCodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isEmailValid) {
                   // getResetCodeFromApi();
                    try {
                        getResetCode();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    Intent intent = new Intent(AlreadyRegisteredActivity.this, VerifyActivity.class);
                    startActivity(intent);
                } else{
                    showAlertDialog("Email invalid");
                }
            }
        });
        CalligraphyConfig.initDefault(
                new CalligraphyConfig.Builder()
                        .setDefaultFontPath("fonts/HelveticaNeueThin.ttf")
                        .setFontAttrId(R.attr.fontPath)
                        .build());
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));

    }
    public void showAlertDialog(String title) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);

        // Setting Dialog Title
        alertDialog.setTitle(title);

        // Setting Dialog Message
        alertDialog.setMessage("Please enter correct email address");
        alertDialog.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alertDialog.show();

    }
    // this method is for String request
    public void getResetCodeFromApi() {
        RequestQueue queue = Volley.newRequestQueue(this);
       // String url = "http://web2rk.ainfo.io/api/getcode";
        String url="https://phendo.ainfo.io/api/getcode" ;
       //String url= "http://httpbin.org/post";
        StringRequest getCodePostRequest =
                new StringRequest(Request.Method.POST, url,
                                         new Response.Listener<String>() {
                                             @Override
                                             public void onResponse(String response) {
                                                 Log.i("respose","" +response);
                                                 Toast.makeText(AlreadyRegisteredActivity.this, "response   " +response, Toast.LENGTH_SHORT).show();
                                             }
                                         }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("errorResponse"," " +error);
                        Toast.makeText(getApplicationContext(), "Request failed   " +error, Toast.LENGTH_SHORT).show();


                    }
                }){

                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("email", userEmailId);
                        return params;
                      }
                    };

        queue.add(getCodePostRequest);
    }

    // this method is for json request
    public void getResetCode() throws JSONException {
        RequestQueue queue = Volley.newRequestQueue(this);
       String url = "http://web2rk.ainfo.io:9090/api/getcode";
       // String url="https://phendo.ainfo.io/api/getcode" ;
       // String url= "http://httpbin.org/post";
        Map<String, String> params = new HashMap<String, String>();
        params.put("email", userEmailId);

        JsonObjectRequest jsonArrReq = new JsonObjectRequest(Request.Method.POST, url, new JSONObject(params),
                                                                    new Response.Listener<JSONObject>() {
                                                                        @Override
                                                                        public void onResponse(JSONObject response) {
                                                                            Log.i("respose in jsonobject","" +response);
                                                                            Toast.makeText(AlreadyRegisteredActivity.this, "response   " +response, Toast.LENGTH_SHORT).show();


                                                                        }



                                                                  }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("errorResponse"," " +error);
                Toast.makeText(getApplicationContext(), "Request failed   " +error, Toast.LENGTH_SHORT).show();



            }
        }) {
          /*  @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("email", userEmailId);
                return params;
            }*/
        };


        queue.add(jsonArrReq);

    }

}
