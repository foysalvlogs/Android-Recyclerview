package com.foysaldev.androidrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    int [] icon;
    String [] mymensinghDistrict , population;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerviewId);

        icon  = new int[]{R.drawable.bhaluka, R.drawable.trishal, R.drawable.haluaghat,
                R.drawable.muktagacha, R.drawable.dhobaura, R.drawable.fulbaria, R.drawable.gaffargaon,
                R.drawable.gauripur, R.drawable.ishwarganj, R.drawable.mymensingh_sadar, R.drawable.nandail,
                R.drawable.phulpur, R.drawable.tarakhanda};

        mymensinghDistrict = getResources().getStringArray(R.array.mymensingh_district);
        population = getResources().getStringArray(R.array.population);

        customAdapter = new CustomAdapter(this,mymensinghDistrict,population,icon);

        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        customAdapter.setOnItemClickListener(new CustomAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View view) {
                Toast.makeText(MainActivity.this, "on Item Click : "+position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(int position, View view) {
                Toast.makeText(MainActivity.this, "on Item Long Click"+position, Toast.LENGTH_SHORT).show();
            }
        });

    }
}