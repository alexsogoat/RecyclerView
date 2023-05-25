package kr.co.company.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements
        MyAdapter.ItemClickListener {
    MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] data = new String[100];
        for (int i=1; i<=100; i++){
            data[i-1] = "friend #"+i;
        }
        RecyclerView recyclerView = findViewById(R.id.rview);
        int cols = 3;
        recyclerView.setLayoutManager(new GridLayoutManager(this, cols));
        adapter = new MyAdapter(this,data);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }
    @Override
    public void onItemClick(View v, int position){
        Log.i("TAG", "item: " + adapter.getItem(position+1) + "number :" + position);
    }
}