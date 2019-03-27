package com.github.olegschwann.homework1;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.github.olegschwann.numbers.NumberAdapter;
import com.github.olegschwann.numbers.OnNumberClickListener;

public class NumbersFragment extends Fragment implements OnNumberClickListener {
    public static final String TAG = "NumbersFragment";

    private RecyclerView recyclerView;
    private NumberAdapter mAdapter;
    private Button addNumberButton;
    private int maxNumber = 101;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_of_numbers, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            maxNumber = savedInstanceState.getInt("max_number", 101);
        }

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        int orientation = view.getContext().getResources().getConfiguration().orientation;
        int numberOfColumns;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            numberOfColumns = 4;
        } else {
            numberOfColumns = 3;
        }
        recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(), numberOfColumns));

        mAdapter = new NumberAdapter(maxNumber, this);
        recyclerView.setAdapter(mAdapter);

        addNumberButton = view.findViewById(R.id.addNumber);
        addNumberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maxNumber = mAdapter.getMaxNumber() + 1;
                mAdapter.setMaxNumber(maxNumber);
            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("max_number", maxNumber);
    }

    @Override
    public void onNumberClick(int num, @ColorInt int color) {
        if (getActivity() == null || !(getActivity() instanceof OnNumberClickListener)) {
            return;
        }
        ((OnNumberClickListener) getActivity()).onNumberClick(num, color);
    }
}
