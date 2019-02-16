package mx.mobilestudio.placefinder;


import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    public SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configureToolbar();
    }

    public void configureToolbar(){

        Toolbar toolbar = findViewById(R.id.toolbar);

        //Método que llamámos setSupportActionBar para configurar el Toolbar

        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();


        //actionBar.setHomeAsUpIndicator(android.R.drawable.ic_menu_add);
        //actionBar.setHomeAsUpIndicator(android.R.drawable.ic_menu_agenda);
        //actionBar.setHomeAsUpIndicator(android.R.drawable.ic_menu_gallery);
        actionBar.setHomeAsUpIndicator(android.R.drawable.ic_menu_view);

        searchView = findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(this);

        actionBar.setDisplayHomeAsUpEnabled(true);


    }

    @Override
    public boolean onQueryTextSubmit(String query) {

        //Toast.makeText(this, query, Toast.LENGTH_LONG).show(); *probar*
        return false;
    }

    @Override


    public boolean onQueryTextChange(String newText) {

        Toast.makeText(this, newText, Toast.LENGTH_LONG).show();
        return false;
    }
}
