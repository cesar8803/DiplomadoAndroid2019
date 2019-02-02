package mx.mobilestudio.androidlayoutbasics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button botonInicial;
    private Button botonSecundario;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        botonInicial = findViewById(R.id.button1);

        botonSecundario = findViewById(R.id.button2);


        botonInicial.setOnClickListener(this);
        botonSecundario.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.button1:
                Toast.makeText(this , "Se dio click en el boton 1", Toast.LENGTH_LONG).show();

                break;
            case R.id.button2:
                Toast.makeText(this , "Se dio click en el boton 2", Toast.LENGTH_LONG).show();

                break;
        }

    }
}
