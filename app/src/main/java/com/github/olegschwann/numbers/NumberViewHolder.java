package com.github.olegschwann.numbers;

import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.github.olegschwann.homework1.R;

class NumberViewHolder extends RecyclerView.ViewHolder {
    private Button numberButton;
    private int number;

    NumberViewHolder(@NonNull View itemView, final OnNumberClickListener onNumberClickListener) {
        super(itemView);
        numberButton = itemView.findViewById(R.id.numberButton);
        numberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberClickListener.onNumberClick(number, getColor(number));
            }
        });
    }

    void bind(int num) {
        this.number = num;
        numberButton.setText(String.valueOf(number));
        numberButton.setTextColor(getColor(number));
    }

    @ColorInt
    private static int getColor(int num) {
        // Чётные числа должны быть написаны красным шрифтом, нечетные - синим.
        if (num % 2 == 0) {
            return Color.RED;
        }
        return Color.BLUE;
    }
}
