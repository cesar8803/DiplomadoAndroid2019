package mx.mobilestudio.promohunters.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import mx.mobilestudio.promohunters.R;
import mx.mobilestudio.promohunters.model.Promo;


public class PromoHunterAdapter extends RecyclerView.Adapter {

    private ArrayList<Promo> promos;

    //Creamos un metodo constructor que requiere una lista de información para inicializar el objeto
    public PromoHunterAdapter(ArrayList<Promo> promos) {
        this.promos = promos;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType ) {

        // Aqui decidimos que template (xml) utilizaremos para la lista, el xml hay que generarlo

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.promohunter_resul_item,null);


        // El viewholder guarda las referencias a los datos dinamicos, estos son los que van cambiando de celda en celda con respecto a la posición

        MyPromoHunterViewHolder viewHolder = new MyPromoHunterViewHolder(view);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int i) {


        ((MyPromoHunterViewHolder) holder).description.setText(promos.get(i).getDescription());
        ((MyPromoHunterViewHolder) holder).link.setText(promos.get(i).getLink());
        ((MyPromoHunterViewHolder) holder).price.setText(String.valueOf(promos.get(i).getPrice()));
        ((MyPromoHunterViewHolder) holder).title.setText(promos.get(i).getTitle());


    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyPromoHunterViewHolder extends RecyclerView.ViewHolder{

        public TextView description;
        public TextView link; // Tercer  cambio
        public TextView price;
        public TextView title;


        public MyPromoHunterViewHolder(View itemView) {
            super(itemView);

            description = itemView.findViewById(R.id.description);
            link = itemView.findViewById(R.id.link);// Cuarto  cambio
            price = itemView.findViewById(R.id.price);
            title = itemView.findViewById(R.id.title);


        }
    }



}
