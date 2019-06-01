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

    ArrayList<Promo> promos;

    //Creamos constructor que requiere una lista de información para inicializar el objeto
    public PromoHunterAdapter(ArrayList<Promo> promos) {
        this.promos = promos;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType ) {

        // Aqui decidimos que template (xml) utilizaremos para la lista, el xml hay que generarlo

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.promohunter_resul_item,null, false);


        // El viewholder guarda las referencias a los datos dinamicos, estos son los que van cambiando de celda en celda con respecto a la posición

        //porsi MyPromoHunterViewHolder viewHolder = new MyPromoHunterViewHolder(view);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int i) {


        ((ViewHolder) holder).description.setText(promos.get(i).getDescription());
        ((ViewHolder) holder).link.setText(promos.get(i).getLink());
        ((ViewHolder) holder).price.setText(String.valueOf(promos.get(i).getPrice()));
        ((ViewHolder) holder).title.setText(promos.get(i).getTitle());



        }

    @Override
    public int getItemCount() {
        return promos.size();
    }

    /*public class MyPromoHunterViewHolder extends RecyclerView.ViewHolder{




        public MyPromoHunterViewHolder(View itemView) {
            super(itemView);

            description = itemView.findViewById(R.id.description);
            link = itemView.findViewById(R.id.link);// Cuarto  cambio
            price = itemView.findViewById(R.id.price);
            title = itemView.findViewById(R.id.title);


        }
    }
*/
//Dif
    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView dato;

        public TextView description;
        public TextView link;
        public TextView price;
        public TextView title;

    public ViewHolder(@NonNull View itemView) {

        super(itemView);

        dato= itemView.findViewById(R.id.description);



    }
}

}
