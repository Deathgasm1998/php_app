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

import curso_avanzado.temaa_1;

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
        itemLists.add(new ItemList("Tema 1", "Descripcion del tema avanzado 1 ", R.drawable.transparent_b));
        /*itemLists.add(new ItemList("Tema 2", "Descripcion del tema avanzado 2.", R.drawable.transparent_b));
        itemLists.add(new ItemList("Tema 3", "Descripcion del tema a ver.", R.drawable.transparent_b));
        itemLists.add(new ItemList("Tema 4", "Descripcion del tema a ver.", R.drawable.transparent_b));
        itemLists.add(new ItemList("Titulo del Tema", "Descripcion del tema a ver.", R.drawable.transparent_b));
        itemLists.add(new ItemList("Titulo del Tema", "Descripcion del tema a ver.", R.drawable.transparent_b));
        itemLists.add(new ItemList("Titulo del Tema", "Descripcion del tema a ver.", R.drawable.transparent_b));
        itemLists.add(new ItemList("Titulo del Tema", "Descripcion del tema a ver.", R.drawable.transparent_b));
        itemLists.add(new ItemList("Titulo del Tema", "Descripcion del tema a ver.", R.drawable.transparent_b));
        itemLists.add(new ItemList("Titulo del Tema", "Descripcion del tema a ver.", R.drawable.transparent_b));
        itemLists.add(new ItemList("Titulo del Tema", "Descripcion del tema a ver.", R.drawable.transparent_b));
        itemLists.add(new ItemList("Titulo del Tema", "Descripcion del tema a ver.", R.drawable.transparent_b));*/

        return itemLists;
    }



    @Override
    public void itemClick(ItemList item) {
        Intent intent = new Intent(this, temaa_1.class);
        startActivity(intent);
    }




    //--------------------------------------------------------------------------
    public void Anterior(View view) {
        Intent anterior = new Intent(this, Curso.class);
        startActivity(anterior);
        finish();
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
}
