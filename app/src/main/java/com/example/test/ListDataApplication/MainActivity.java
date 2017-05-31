package com.example.test.ListDataApplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.test.ListDataApplication.Utils.APIContants;
import com.example.test.ListDataApplication.adapters.CustomListAdapter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ListView mListView;
    ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.list_view_item);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);

        mProgressBar.setVisibility(View.VISIBLE);
        sendRequest();
    }

    @Override
    public void onClick(View v) {

    }

    /**
     * Api request for getting url data.
     *
     */
    public void sendRequest(){
        StringRequest stringRequest = new StringRequest(APIContants.GET_JSON_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        mProgressBar.setVisibility(View.INVISIBLE);
                        showJSON(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        mProgressBar.setVisibility(View.INVISIBLE);
                        Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                }
        );

        // add the request object to the queue to be executed
        ApplicationController.getInstance().addToRequestQueue(stringRequest);

    }

    /**
     * Parse json data and call adapter class for display.
     *
     * @param json
     */

    public void showJSON(String json){
        ParseJSON parseJSON = new ParseJSON(json);
        parseJSON.parseJSONData();
        CustomListAdapter customListAdapter = new CustomListAdapter(this, R.layout.list_view_lyout, parseJSON.getNewsList());
        mListView.setAdapter(customListAdapter);
        customListAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
