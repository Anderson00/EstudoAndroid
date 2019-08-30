package com.example.atividadesala02;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_ADD = 1;
    public static final int REQUEST_EDIT = 2;


    List<Livro> livros = new ArrayList<Livro>();
    LivrosBaseAdapter adapter;
    int idSelected = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText idEditText = (EditText) findViewById(R.id.idEditText);
        ListView listView = (ListView) findViewById(R.id.listView);
        adapter = new LivrosBaseAdapter(this, livros);
        listView.setAdapter(adapter);

        Button addButton = (Button) findViewById(R.id.addButton);
        Button editButton = (Button) findViewById(R.id.editButton);


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("segundaActivity");
                startActivityForResult(intent, REQUEST_ADD);
            }
        });

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                idSelected = Integer.parseInt(idEditText.getText().toString());
                if(idSelected < livros.size() && idSelected >= 0) {
                    Intent intent = new Intent("segundaActivity");
                    Livro livro = livros.get(idSelected);
                    intent.putExtra("titulo", livro.getTitulo());
                    intent.putExtra("autor", livro.getAutor());
                    startActivityForResult(intent, REQUEST_EDIT);
                }else {
                    Toast.makeText(MainActivity.this, "Id não existe", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_ADD){
            if(resultCode == RESULT_OK){
                int id = data.getIntExtra("id", -1);
                String titulo = data.getStringExtra("titulo");
                String autor = data.getStringExtra("autor");

                this.livros.add(new Livro(titulo, autor));
            }
        }else if(requestCode == REQUEST_EDIT){
            if(resultCode == RESULT_OK){
                Livro livro = this.livros.get(idSelected);
                livro.setTitulo(data.getStringExtra("titulo"));
                livro.setAutor(data.getStringExtra("autor"));
                adapter.notifyDataSetChanged();
            }
        }
    }
}
