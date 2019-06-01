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


    public PromoHunterAdapter(ArrayList<Promo> promos) {
        this.promos = promos;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.promohunter_result_item,null);




        MyPromoHunterViewHolder viewHolder = new MyPromoHunterViewHolder(view);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ((MyPromoHunterViewHolder) holder).title.setText(promos.get(position).title);
        ((MyPromoHunterViewHolder) holder).price.setText(promos.get(position).precio);
        ((MyPromoHunterViewHolder) holder).link.setText(promos.get(position).link);
        ((MyPromoHunterViewHolder) holder).description.setText(promos.get(position).description);

    }

    @Override
    public int getItemCount() {
        return promos.size();
    }


    public class MyPromoHunterViewHolder extends RecyclerView.ViewHolder{

        public TextView title;
        public TextView price;
        public TextView link;
        public TextView description;


        public MyPromoHunterViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            price = itemView.findViewById(R.id.price);
            link = itemView.findViewById(R.id.link);
            description=itemView.findViewById(R.id.description);


        }
    }

}
