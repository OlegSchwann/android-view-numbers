package com.github.olegschwann.numbers;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.olegschwann.homework1.R;

public class NumberAdapter extends RecyclerView.Adapter<NumberViewHolder> {
    private OnNumberClickListener listener;
    private int maxNumber;

    public NumberAdapter(int maxNumber, OnNumberClickListener listener) {
        this.listener = listener;
        this.maxNumber = maxNumber;
    }

    @NonNull
    @Override
    public NumberViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_number_button,
                viewGroup, false);
        return new NumberViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull NumberViewHolder numberViewHolder, int i) {
        numberViewHolder.bind(i);
    }

    public void setMaxNumber(int maxNumber) {
        this.maxNumber = maxNumber;
        notifyDataSetChanged();
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    @Override
    public int getItemCount() {
        return maxNumber;
    }
}
