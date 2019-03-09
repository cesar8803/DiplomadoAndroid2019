package mx.mobilestudio.placefinder.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import mx.mobilestudio.placefinder.R;
import mx.mobilestudio.placefinder.model.Venue;

public class ListFourSquareAdapter extends RecyclerView.Adapter {

    private ArrayList<Venue> venues;


    //Creamos un metodo constructor que requiere una lista de información para inicializar el objeto
    public ListFourSquareAdapter(ArrayList<Venue> venues) {
        this.venues = venues;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // Aqui decidimos que template (xml) utilizaremos para la lista, el xml hay que generarlo

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.foursquare_result_item,null);


        // El viewholder guarda las referencias a los datos dinamicos, estos son los que van cambiando de celda en celda con respecto a la posición

        MyFourSquareViewHolder viewHolder = new MyFourSquareViewHolder(view);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ((MyFourSquareViewHolder) holder).venue_name.setText(venues.get(position).name);
        ((MyFourSquareViewHolder) holder).venue_city.setText(venues.get(position).location.city); // primer cambio

    }

    @Override
    public int getItemCount() {
        //Tenemos que indicar el tamaño (conteo) del arreglo (Venues)
        return venues.size();
    }


    public class MyFourSquareViewHolder extends RecyclerView.ViewHolder{

        public TextView venue_name;
        public TextView venue_city; // Tercer  cambio


        public MyFourSquareViewHolder(View itemView) {
            super(itemView);

            venue_name = itemView.findViewById(R.id.venue_name);
            venue_city = itemView.findViewById(R.id.venue_city);// Cuarto  cambio


        }
    }

}
