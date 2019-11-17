package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Recuperiamo il riferimento all'oggetto ListView
        ListView listView = (ListView) findViewById(R.id.list_view);

        // Recupera l'array di stringhe
        String[] planets = getResources().getStringArray(R.array.sistema_solare);

        // Crea un oggetto arrayadapter usando l'elenco delle stringhe
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.simple_list_item_1, planets);

        // Assegna l'adapter alla listView
        listView.setAdapter(adapter);

        // Assegna evebntule click
        listView.setOnItemClickListener(mioClick);

        // Assegnao il long click
        listView.setOnItemLongClickListener(clickProlungato);


    }

    /**
     * Implementazione interfaccia per il click
     *
     */
    private AdapterView.OnItemClickListener mioClick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            String valore = adapterView.getItemAtPosition(position).toString();
            Log.d("MIO", "Fatto click su " + position + " con valore " + valore);
        }
    };

    /**
     * Implementazione interfaccia per il click prolungato
     *
     */
    private AdapterView.OnItemLongClickListener clickProlungato = new AdapterView.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
            Log.d("MIO", "Click prolungato su " + position);
            view.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            return false;
        }
    };

}
