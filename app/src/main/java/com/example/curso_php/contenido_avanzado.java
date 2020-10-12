package com.example.curso_php;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import curso_avanzado.activitys.tema1avaActivity;

public class contenido_avanzado extends AppCompatActivity implements RecyclerAdapter3.RecyclerItemClick, SearchView.OnQueryTextListener {

    private RecyclerView rvLista;
    private SearchView svSearch;
    private RecyclerAdapter3 adapter;
    private List<ItemList> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contenido_avanzado);

        initViews();
        initValues();
        initListener();
    }


    private void initViews(){
        rvLista = findViewById(R.id.rvLista);
        svSearch = findViewById(R.id.svSearch);
    }

    private void initValues(){
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rvLista.setLayoutManager(manager);

        items = getItems();
        //adapter = new RecyclerAdapter(items,this);
        adapter = new RecyclerAdapter3(this, items);
        rvLista.setAdapter(adapter);
    }

    private void initListener() {
        svSearch.setOnQueryTextListener(this);
    }
    private List<ItemList> getItems() {
        List<ItemList> itemLists = new ArrayList<>();
        itemLists.add(new ItemList("Tema 1", "Descripcion del tema 1 ", R.drawable.transparent_b));
        itemLists.add(new ItemList("Tema 2", "Descripcion del tema 2.", R.drawable.transparent_b));
        itemLists.add(new ItemList("Tema 3", "Descripcion del tema 3.", R.drawable.transparent_b));
        itemLists.add(new ItemList("Tema 4", "Descripcion del tema 4.", R.drawable.transparent_b));
        itemLists.add(new ItemList("Tema 5", "Descripcion del tema 5.", R.drawable.transparent_b));
        itemLists.add(new ItemList("Tema 6", "Descripcion del tema 6.", R.drawable.transparent_b));
        itemLists.add(new ItemList("Tema 7", "Descripcion del tema 7.", R.drawable.transparent_b));
        itemLists.add(new ItemList("Tema 8", "Descripcion del tema 8.", R.drawable.transparent_b));
        itemLists.add(new ItemList("Tema 9", "Descripcion del tema 9.", R.drawable.transparent_b));
        itemLists.add(new ItemList("Tema 10", "Descripcion del tema 10.", R.drawable.transparent_b));
        itemLists.add(new ItemList("Tema 11", "Descripcion del tema a ver.", R.drawable.transparent_b));
        itemLists.add(new ItemList("Tema 12", "Descripcion del tema a ver.", R.drawable.transparent_b));
        itemLists.add(new ItemList("Tema 13", "Descripcion del tema a ver.", R.drawable.transparent_b));
        itemLists.add(new ItemList("Tema 14", "Descripcion del tema a ver.", R.drawable.transparent_b));
        itemLists.add(new ItemList("Tema 15", "Descripcion del tema a ver.", R.drawable.transparent_b));
        itemLists.add(new ItemList("Tema 16", "Descripcion del tema a ver.", R.drawable.transparent_b));
        itemLists.add(new ItemList("Tema 17", "Descripcion del tema a ver.", R.drawable.transparent_b));
        itemLists.add(new ItemList("Tema 18", "Descripcion del tema a ver.", R.drawable.transparent_b));
        itemLists.add(new ItemList("Tema 19", "Descripcion del tema a ver.", R.drawable.transparent_b));
        itemLists.add(new ItemList("Tema 20", "Descripcion del tema a ver.", R.drawable.transparent_b));
         /* itemLists.add(new ItemList("Tema 21", "Descripcion del tema a ver.", R.drawable.transparent_b));
        itemLists.add(new ItemList("Tema 22", "Descripcion del tema a ver.", R.drawable.transparent_b));
        itemLists.add(new ItemList("Tema 23", "Descripcion del tema a ver.", R.drawable.transparent_b));
        itemLists.add(new ItemList("Tema 24", "Descripcion del tema a ver.", R.drawable.transparent_b));
        itemLists.add(new ItemList("Tema 25", "Descripcion del tema a ver.", R.drawable.transparent_b));
        itemLists.add(new ItemList("Tema 26", "Descripcion del tema a ver.", R.drawable.transparent_b));
        itemLists.add(new ItemList("Tema 27", "Descripcion del tema a ver.", R.drawable.transparent_b));
        itemLists.add(new ItemList("Tema 28", "Descripcion del tema a ver.", R.drawable.transparent_b));
        itemLists.add(new ItemList("Tema 29", "Descripcion del tema a ver.", R.drawable.transparent_b));
        itemLists.add(new ItemList("Tema 30", "Descripcion del tema a ver.", R.drawable.transparent_b));*/

        return itemLists;
    }



    @Override
    public void itemClick(ItemList item) {
        Intent intent = new Intent(this, tema1avaActivity.class);
        startActivity(intent);
    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        adapter.filter(newText);
        return false;
    }

    //--------------------------------------------------------------------------
    public void Anterior(View view) {
        Intent anterior = new Intent(this, Curso.class);
        startActivity(anterior);
        finish();
    }



    //--------------------------------------------------------------------------
    public void playlist(View view) {
        Intent playlist = new Intent(this, multi_avanzado.class);
        startActivity(playlist);
        finish();
    }
}
