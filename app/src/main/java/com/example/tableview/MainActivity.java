package com.example.tableview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> brandsList = new ArrayList<>();
        brandsList.add("Samsung");
        brandsList.add("LG");
        brandsList.add("Sony");
        brandsList.add("Acer");

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        BrandsAdapter mAdapter = new BrandsAdapter(brandsList);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

    }

    public class BrandViewHolder extends RecyclerView.ViewHolder {
        TextView txt;
        public BrandViewHolder(View itemView) {
            super(itemView);
            txt = itemView.findViewById(android.R.id.text1);
        }
    } // BrandsViewHolder

    public class BrandsAdapter extends RecyclerView.Adapter<BrandViewHolder>{
        ArrayList<String> data;

        public BrandsAdapter(ArrayList<String> input) {
            data = input;
        }

        public BrandViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View item = LayoutInflater.from(parent.getContext()).inflate(
                    android.R.layout.simple_list_item_1,
                    parent,
                    false);
            return new BrandViewHolder(item);
        }

        public void onBindViewHolder(BrandViewHolder holder, int position) {
            String s = data.get(position);
            holder.txt.setText(s);
        }

        public int getItemCount() {
            return data.size();
        }
    } // BrandsAdapter

}  // MainActivity