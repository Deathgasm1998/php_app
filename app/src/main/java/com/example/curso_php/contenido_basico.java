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

import curso_basico.activitys.tema1;

public class contenido_basico extends AppCompatActivity implements RecyclerAdapter.RecyclerItemClick, SearchView.OnQueryTextListener {

    private RecyclerView rvLista;
    private SearchView svSearch;
    private RecyclerAdapter adapter;
    private List<ItemList> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contenido_basico);

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
        adapter = new RecyclerAdapter(this, items);
        rvLista.setAdapter(adapter);
    }

    private void initListener() {
        svSearch.setOnQueryTextListener(this);
    }

    private List<ItemList> getItems() {
        List<ItemList> itemLists = new ArrayList<>();
        itemLists.add(new ItemList("Introducción", "¿Qué es php?...", R.drawable.transparent_b));
        itemLists.add(new ItemList("Sintaxis básica", "Descripcion del tema a ver.", R.drawable.transparent_b));
        itemLists.add(new ItemList("Programa ''Hola Mundo'' ", "Descripcion del tema basico 2", R.drawable.transparent_b));
        itemLists.add(new ItemList("Variables", "Descripcion del tema a ver.", R.drawable.transparent_b));
        itemLists.add(new ItemList("Operadores", "Descripcion del tema a ver.", R.drawable.transparent_b));
        itemLists.add(new ItemList("Arreglos", "Descripcion del tema a ver.", R.drawable.transparent_b));
        itemLists.add(new ItemList("tema 7", "Descripcion del tema a ver.", R.drawable.transparent_b));
        itemLists.add(new ItemList("tema 8", "Descripcion del tema a ver.", R.drawable.transparent_b));
        itemLists.add(new ItemList("tema 9", "Descripcion del tema a ver.", R.drawable.transparent_b));
        itemLists.add(new ItemList("tema 10", "Descripcion del tema a ver.", R.drawable.transparent_b));
        itemLists.add(new ItemList("tema 11", "Descripcion del tema a ver.", R.drawable.transparent_b));
        itemLists.add(new ItemList("tema 12", "Descripcion del tema a ver.", R.drawable.transparent_b));
        itemLists.add(new ItemList("tema 13", "Descripcion del tema a ver.", R.drawable.transparent_b));
        itemLists.add(new ItemList("tema 14", "Descripcion del tema a ver.", R.drawable.transparent_b));
        itemLists.add(new ItemList("tema 15", "Descripcion del tema a ver.", R.drawable.transparent_b));
        itemLists.add(new ItemList("tema 16", "Descripcion del tema a ver.", R.drawable.transparent_b));
        itemLists.add(new ItemList("tema 17", "Descripcion del tema a ver.", R.drawable.transparent_b));
        itemLists.add(new ItemList("tema 18", "Descripcion del tema a ver.", R.drawable.transparent_b));
        itemLists.add(new ItemList("tema 19", "Descripcion del tema a ver.", R.drawable.transparent_b));
        itemLists.add(new ItemList("tema 20", "Descripcion del tema a ver.", R.drawable.transparent_b));

        return itemLists;
    }


    @Override
    public void itemClick(ItemList item) {
        Intent intent = new Intent(this, tema1.class);
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

}


