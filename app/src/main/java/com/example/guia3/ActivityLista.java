package com.example.guia3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import static com.example.guia3.MainActivity.Ln;

public class ActivityLista extends AppCompatActivity {
    private ListView LVn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("HS16-I04-001");
        }
        if (Ln == null || Ln.size() == 0) {
            Toast.makeText(this, "Lista Vacia", Toast.LENGTH_LONG).show();
        } else {
            LVn = findViewById(R.id.listGuia3);
            LVn.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Ln));
            LVn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                    if (position >= 0 && position < Ln.size()) {
                        Toast.makeText(ActivityLista.this, "El nombre es: " + Ln.get(position), Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }

}
