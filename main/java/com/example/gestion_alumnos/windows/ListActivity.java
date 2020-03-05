package com.example.gestion_alumnos.windows;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gestion_alumnos.R;
import com.example.gestion_alumnos.adapters.AdaptadorRecycler;
import com.example.gestion_alumnos.utils.UserUser;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        recyclerView = findViewById(R.id.recyclerView);
        fillUser();
        AdaptadorRecycler adaptador = new AdaptadorRecycler(users, getApplicationContext());
        recyclerView.setAdapter(adaptador);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false));
    }

    private void fillUser() {

        users = new ArrayList();
        users.add(new UserUser("Nombre 1","Apellido 1", 1111,android.R.drawable.sym_contact_card));
        users.add(new UserUser("Nombre 2","Apellido 2", 2222,android.R.drawable.sym_contact_card));
        users.add(new UserUser("Nombre 3","Apellido 3", 3333,android.R.drawable.sym_contact_card));
        users.add(new UserUser("Nombre 4","Apellido 4", 4444,android.R.drawable.sym_contact_card));
    }
}