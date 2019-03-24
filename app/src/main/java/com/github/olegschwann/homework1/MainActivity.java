package com.github.olegschwann.homework1;

import android.support.annotation.ColorInt;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.github.olegschwann.numbers.OnNumberClickListener;

public class MainActivity extends AppCompatActivity implements OnNumberClickListener {
    private OneNumberFragment oneNumberFragment;
    private NumbersFragment numbersFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        oneNumberFragment = (OneNumberFragment) getSupportFragmentManager().findFragmentByTag(OneNumberFragment.TAG);
        numbersFragment = (NumbersFragment) getSupportFragmentManager().findFragmentByTag(NumbersFragment.TAG);

        if (oneNumberFragment == null) {
            oneNumberFragment = new OneNumberFragment();
        }

        if (numbersFragment == null) {
            numbersFragment = new NumbersFragment();
        }

        showNumbersFragment();
    }


    @Override
    public void onNumberClick(int num, @ColorInt int color) {
        showOneNumberFragment(num, color);
    }

    private void showOneNumberFragment(int number, @ColorInt int color) {
        oneNumberFragment.setNumber(number, color);

        if(getSupportFragmentManager().findFragmentByTag(OneNumberFragment.TAG) != null) {
            Log.wtf(MainActivity.class.toString(), "oneNumberFragment execute twice");
            return;
        }

        getSupportFragmentManager().beginTransaction()
            .replace(R.id.content, oneNumberFragment, OneNumberFragment.TAG)
            .addToBackStack(OneNumberFragment.TAG)
            .commit();
    }

    private void showNumbersFragment() {
        if(getSupportFragmentManager().findFragmentByTag(NumbersFragment.TAG) != null) {
            return;
        }

        getSupportFragmentManager().beginTransaction()
            .add(R.id.content, numbersFragment, NumbersFragment.TAG)
            // Не надо добавлять в историю первое состояние после запуска приложения,
            // когда фрагмент вставляется в пустую activity.
            .commit();
    }

}
