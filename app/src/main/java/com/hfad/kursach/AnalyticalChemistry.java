package com.hfad.kursach;


import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.view.View;
import android.widget.Toast;
import android.content.Intent;

public class AnalyticalChemistry extends ListActivity {

    final String[] typs = new String[] {
            "Кислотно-основное равновесие",
            "Комплексообразование",
            "Окислительно-восстановительные равновесие",
            "Равновесие в системе осадок-раствор",
            "Органические реагенты"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, typs);
        setListAdapter(adapter);
    }

@Override
protected void onListItemClick(ListView l, View v, int position, long id ) {
    super.onListItemClick(l, v, position, id);
    if(position != 0) {
        Toast.makeText(getApplicationContext(), "В процессе разработки", Toast.LENGTH_LONG).show();
    }
    else {
        Intent intent = new Intent(this, ChemicalBalance.class);
        startActivity(intent);
    }

}


}
