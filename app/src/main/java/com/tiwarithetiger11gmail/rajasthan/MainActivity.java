package com.tiwarithetiger11gmail.rajasthan;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
       private RecyclerView recyclerView;
       private RecyclerView.LayoutManager layoutManager;
     private RecyclerAdapter adapter;
    private List<Modal> modals;
    private ApiInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView)findViewById(R.id.r_view);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        apiInterface=ApiClient.getApiClient().create(ApiInterface.class);
        Call <List<Modal>> call=apiInterface.getModal();
        call.enqueue(new Callback<List<Modal>>() {
            @Override
            public void onResponse(Call<List<Modal>> call, Response<List<Modal>> response) {
                modals=response.body();
                adapter=new RecyclerAdapter(modals,MainActivity.this);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<Modal>> call, Throwable t) {

            }
        });
    }

    public void stud(View view) {
        String url="http://10.0.2.2:3000/spack";
        Intent i=new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        this.startActivity(i);
    }

    public void trad(View view) {
        String url="http://10.0.2.2:3000/#traditional";
        Intent i=new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        this.startActivity(i);
    }
}
