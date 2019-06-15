package mx.mobilestudio.promohunters.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

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


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int i) {

        //Este método se encarga de llenar los valores del view holder para una posición en específico


        ((ViewHolder) holder).description.setText(promos.get(i).getDescription());
        ((ViewHolder) holder).link.setText(promos.get(i).getLink());
        ((ViewHolder) holder).price.setText(String.valueOf(promos.get(i).getPrice()));
        ((ViewHolder) holder).title.setText(promos.get(i).getTitle());

        String imageLink = promos.get(i).getImageLink();

        ImageView currentImageView = ((ViewHolder) holder).imagen;

        if(imageLink!=null && !imageLink.isEmpty()){

            Picasso.with(currentImageView.getContext()).load(imageLink).into(currentImageView);


        } else {

            currentImageView.setImageResource(android.R.drawable.ic_menu_camera);
    }


}



    @Override
    public int getItemCount() {
        return promos.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView dato;

        public TextView description;
        public TextView link;
        public TextView price;
        public TextView title;
        public ImageView imagen;


    public ViewHolder(@NonNull View itemView) {

        super(itemView);

        //Crucial
        description = itemView.findViewById(R.id.description);
        link = itemView.findViewById(R.id.link);
        price = itemView.findViewById(R.id.price);
        title = itemView.findViewById(R.id.title);
        imagen = itemView.findViewById(R.id.imagePromo);


    }
}

}
