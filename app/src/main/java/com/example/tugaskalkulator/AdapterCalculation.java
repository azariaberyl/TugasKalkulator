package com.example.tugaskalkulator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class AdapterCalculation extends RecyclerView.Adapter<AdapterCalculation.ViewHolder> {
    ArrayList<Hasil> hasilArrayList;
    Context cont;

    public AdapterCalculation(ArrayList<Hasil> hasilArrayList, Context cont) {
        this.hasilArrayList = hasilArrayList;
        this.cont = cont;
    }

    @Override
    public AdapterCalculation.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        cont = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(cont);
        ViewHolder viewHolder = new ViewHolder(inflater.inflate(R.layout.adapter_calculation, parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AdapterCalculation.ViewHolder holder, int position) {
        Hasil hasil = hasilArrayList.get(position + (position * -2)+hasilArrayList.size()-1);     // position + (position * -2)+hasilArraylist.size()-1
        holder.tvNum1.setText(hasil.getNum1());
        holder.tvNum2.setText(hasil.getNum2());
        holder.tvHasil.setText(hasil.getResult());
        holder.tvOperand.setText(hasil.getOperand());
    }

    @Override
    public int getItemCount() {
        return hasilArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNum1, tvOperand, tvNum2, tvHasil;

        public ViewHolder(View itemView) {
            super(itemView);
            this.tvNum1 = itemView.findViewById(R.id.tv_num1);
            this.tvOperand = itemView.findViewById(R.id.tv_operand);
            this.tvNum2 = itemView.findViewById(R.id.tv_num2);
            this.tvHasil = itemView.findViewById(R.id.tv_result);
        }

    }
}
