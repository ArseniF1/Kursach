package com.hfad.kursach;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClicked(View view) {
        Intent intent = new Intent(this, AnalyticalChemistry.class);
        startActivity(intent);
    }

    public void onOrganicClicked(View view) {
        Intent intent = new Intent(this, OrganicChemistry.class);
        startActivity(intent);
    }

    public void onInorganicClicked (View view) {
        Intent intent = new Intent(this, InorganicChemistry.class);
        startActivity(intent);
    }

    public void onKrystallClicked (View view) {
        Intent intent = new Intent(this, KrystallChemistry.class);
        startActivity(intent);
    }



}
