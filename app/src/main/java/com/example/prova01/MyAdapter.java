package com.example.prova01;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.CustomViewHolder> {

    private List<Sobremesa> dataList;

    public MyAdapter(List<Sobremesa> dataList){
        this.dataList = dataList;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        public final View myView;
        TextView txtProduto;
        TextView txtValor;
        ImageView img;

        CustomViewHolder(View itemView) {
            super(itemView);
            myView = itemView;
            txtProduto = myView.findViewById(R.id.prod_desc);
            txtValor = myView.findViewById(R.id.valor);
            img = myView.findViewById(R.id.img_prod);
        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_layout2, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.txtProduto.setText(dataList.get(position).getProduto() + " - " + dataList.get(position).getDescricao());
        holder.txtValor.setText(dataList.get(position).getValor());

        switch (holder.txtValor.getText().toString()) {
            case "10":
                holder.img.setImageResource(R.drawable.donut_circle);
                break;
            case "20":
                holder.img.setImageResource(R.drawable.icecream_circle);
                break;
            case "30":
                holder.img.setImageResource(R.drawable.froyo_circle);
                break;
        }


    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
