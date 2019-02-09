package mx.mobilestudio.gato;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;


    public char[][] tablero = new char[3][3];

    public char jugador1= 'X';
    public char jugador2= 'O';


    public int contador =1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);

        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);




        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        int residuo =  contador % 2;





        switch (view.getId()){

            case R.id.button1:
                //[0,0]

                updateDashBoardUI(residuo,view,0,0);

                break;
            case R.id.button2:
                //[0,1]
                updateDashBoardUI(residuo,view,0,1);

                break;

            case R.id.button3:
                //[0,2]
                updateDashBoardUI(residuo,view,0,2);

                break;

            case R.id.button4:
                //[1,0]
                updateDashBoardUI(residuo,view,1,0);

                break;

            case R.id.button5:
                //[1,1]
                updateDashBoardUI(residuo,view,1,1);

                break;

            case R.id.button6:
                //[1,2]
                updateDashBoardUI(residuo,view,1,2);

                break;

            case R.id.button7:
                //[2,0]
                updateDashBoardUI(residuo,view,2,0);

                break;

            case R.id.button8:
                //[2,1]
                updateDashBoardUI(residuo,view,2,1);

                break;

            case R.id.button9:
                //[2,2]
                updateDashBoardUI(residuo,view,2,2);

                break;


        }

    }




    public void updateDashBoardUI(int residuo, View view, int X, int Y){

        if (residuo ==1 ){
            // Esta tirando el primer jugador
            if (((Button)view).getText().toString().isEmpty()){
                ((Button)view).setText("X");
                tablero[X][Y] = 'X';
                contador++;
                buscarGanador();
            }else {
                Toast.makeText(this,"Elige otra casilla", Toast.LENGTH_LONG).show();
            }


        }else if(residuo ==0){
            // Esta tirando el segundo jugador
            if (((Button)view).getText().toString().isEmpty()) {

                ((Button) view).setText("O");
                tablero[X][Y] = 'O';
                contador++;
                buscarGanador();

            }else {
                Toast.makeText(this,"Elige otra casilla", Toast.LENGTH_LONG).show();
            }

        }
    }


    public void buscarGanador(){

        //[ij]

        //[00,01,02]
        //[10,11,12]
        //[20,21,22]
        int contadorGanarHorizontalX = 0;
        int contadorGanarHorizontalY = 0;

        for (int i=0 ; i<3 ; i++ ){

            for (int j=0 ; j<3 ; j++ ){
                //TODO investigar ++ J

                if(tablero[i][j] == 'X' ){
                    contadorGanarHorizontalX++;
                    if(contadorGanarHorizontalX==3){
                        Toast.makeText(this, "Hay un Ganador X",Toast.LENGTH_LONG).show();
                    }
                }

                if (tablero[i][j] == 'O'){
                    contadorGanarHorizontalY++;
                    if(contadorGanarHorizontalY==3) {
                        Toast.makeText(this, "Hay un Ganador O",Toast.LENGTH_LONG).show();

                    }


                }

            }
            contadorGanarHorizontalX =0;
            contadorGanarHorizontalY =0;

        }



    }
}
