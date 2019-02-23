package mx.mobilestudio.placefinder;

import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import mx.mobilestudio.placefinder.model.ApiFourSquareResponse;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener , Response.Listener , Response.ErrorListener {

    public SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configureToolBar();
    }


    public void configureToolBar(){

        Toolbar toolbar = findViewById(R.id.toolbar);
        //Metodo que llamamos setActionBar para poder configurar el ToolBar
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();

        actionBar.setHomeAsUpIndicator(android.R.drawable.ic_menu_add);

        searchView = findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(this);


        actionBar.setDisplayHomeAsUpEnabled(true);

    }


    @Override
    public boolean onQueryTextSubmit(String query) {

        //Toast.makeText(this, query, Toast.LENGTH_LONG).show();

        callFourSquareApi(query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {


        return false;
    }


    public void callFourSquareApi(String query){

        String location = "19.395209"+","+"-99.1544203"; // HARDCODE

        RequestQueue queue = Volley.newRequestQueue(this);

        String URL = Uri.parse("https://api.foursquare.com/v2/venues/search").buildUpon()
                     .appendQueryParameter("client_id","HOSIY11XMXHWFADXIPQTF5HRZA3YIWIFGRAOA5NIGXOY3CWI")
                     .appendQueryParameter("client_secret","OGATJNY0E0JY15PRXYD5MQ2WW3EMFLRAWFHLAOQYSTMVKMHM")
                     .appendQueryParameter("v","20130815")
                     .appendQueryParameter("ll","19.433997,-99.146006")
                     .appendQueryParameter("query",query).build().toString();


        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL ,this,this);


        queue.add(stringRequest);

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this, error.getMessage(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onResponse(Object response) {

        Toast.makeText(this, response.toString(), Toast.LENGTH_LONG).show();

        Gson gson = new Gson();

        ApiFourSquareResponse apiFourSquareResponse = gson.fromJson((String) response, ApiFourSquareResponse.class);


        Toast.makeText(this,  apiFourSquareResponse.response.venues.get(0).name, Toast.LENGTH_LONG).show();
        Toast.makeText(this,  String.valueOf(apiFourSquareResponse.response.venues.get(0).location.lat), Toast.LENGTH_LONG).show();
        Toast.makeText(this,  String.valueOf(apiFourSquareResponse.response.venues.get(0).location.lng), Toast.LENGTH_LONG).show();


    }
}
