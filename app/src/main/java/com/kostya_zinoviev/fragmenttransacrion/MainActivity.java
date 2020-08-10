package com.kostya_zinoviev.fragmenttransacrion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import fragment.OneFragment;
import fragment.TreeFragment;
import fragment.TwoFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button buttonOne;
    private Button buttonTwo;
    private Button buttonThree;
    private Button buttonFour;
    private Fragment mainFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        buttonOne.setOnClickListener(this);
        buttonTwo.setOnClickListener(this);
        buttonThree.setOnClickListener(this);
        buttonFour.setOnClickListener(this);
    }
    private void init(){
        buttonOne = findViewById(R.id.one);
        buttonTwo = findViewById(R.id.two);
        buttonThree = findViewById(R.id.three);
        buttonFour = findViewById(R.id.four);
        mainFragment = new OneFragment();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        Fragment fragment = null;
        Intent intent = null;
        FragmentTransaction ft;
        switch (id) {
            case R.id.one:
                fragment = new OneFragment();
            break;
            case R.id.two:
                fragment = new TwoFragment();
                break;
            case R.id.three:
                fragment = new TreeFragment();
                break;
            case R.id.four:
                intent = new Intent(this,SecondActivity.class);
                intent.putExtra("INT",4);
                startActivity(intent);
                break;
        }
            ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.container,fragment);
            ft.commit();
    }

}
