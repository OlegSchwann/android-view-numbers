package com.github.olegschwann.numbers;

import android.graphics.Color;
import androidx.annotation.ColorInt;

public class NumberDescription {
    public int num;
    @ColorInt public int color;

    public NumberDescription(int num) {
        this.num = num;

        // Чётные числа должны быть написаны красным шрифтом, нечетные - синим.
        if (num % 2 == 0) {
            this.color = Color.RED;
        } else {
            this.color = Color.BLUE;
        }
    }
}
