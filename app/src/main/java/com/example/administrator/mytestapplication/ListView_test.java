package com.example.administrator.mytestapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListView_test extends AppCompatActivity {
    private List<Fruit>  fruitList = new ArrayList<Fruit>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_test);
        initFruit();
        FruitAdapter adapter = new FruitAdapter(ListView_test.this, R.layout.fruit_item, fruitList);
        ListView listView = (ListView)findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit = fruitList.get(position);
                Toast.makeText(ListView_test.this, fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initFruit(){
        Fruit chengzi = new Fruit("chengzi", R.drawable.chengzi);
        fruitList.add(chengzi);

        Fruit caomei = new Fruit("caomei", R.drawable.caomei);
        fruitList.add(caomei);
        Fruit boluo = new Fruit("boluo", R.drawable.boluo);
        fruitList.add(boluo);
        Fruit manguo = new Fruit("manguo", R.drawable.manguo);
        fruitList.add(manguo);
        Fruit taozi = new Fruit("taozi", R.drawable.taozi);
        fruitList.add(taozi);
        Fruit xihongsi = new Fruit("xihongsi", R.drawable.xihongsi);
        fruitList.add(xihongsi);

    }
}
