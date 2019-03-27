package com.github.olegschwann.homework1;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class OneNumberFragment extends Fragment {
    public static final String TAG = "OneNumberFragment";
    private int number = 0;
    @ColorInt
    private int color = Color.BLACK;
    @Nullable
    private TextView numberView;

    public OneNumberFragment() {
    }

    public void setNumber(int number, @ColorInt int color) {
        Bundle bundle = new Bundle();
        bundle.putInt("number", number);
        bundle.putInt("color", color);
        setArguments(bundle);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle == null) {
            return;
        }

        this.number = bundle.getInt("number");
        this.color = bundle.getInt("color");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_view_single_number, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        numberView = view.findViewById(R.id.numberView);

        numberView.setText(String.valueOf(this.number));
        numberView.setTextColor(this.color);
    }
}
