package com.example.myrvapp;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;




public class MainActivity extends AppCompatActivity {

    private ArrayList<DataModel> dataset;
    private RecyclerView recyclerView;
    private EditText searchEditText;

    private LinearLayoutManager linearLayoutManager;
    private CustomeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.resView); //find the recyclerView for using
        searchEditText = findViewById(R.id.editTextText);//find the searchText(id:editTextText) for using

        dataset=new ArrayList<>();//"add" without declare -->null pointer!!
        linearLayoutManager= new LinearLayoutManager(this); //will give the ability of the recyclerView to move from up to down
        recyclerView.setLayoutManager(linearLayoutManager);//set recyclerView to move from up to down
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //add data to the array instead DB
        for(int i=0; i <MyData.drawableArray.length; i++){
            dataset.add(new DataModel(
                    MyData.nameArray[i],
                    MyData.descriptionArray[i],
                    MyData.drawableArray[i]
            ) );
        }

        adapter=new CustomeAdapter(dataset);
        recyclerView.setAdapter(adapter);
        //add the option of searching

        // Set up TextWatcher for EditText
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString()); // Call filter method when text changes
            }
        });


    }

    private void filter(String text) {
        ArrayList<DataModel> filteredList = new ArrayList<>();
        for (DataModel item : dataset) {
            if (item.getCharacterName().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }
        adapter.filterList(filteredList); // Update adapter with filtered list
    }



}