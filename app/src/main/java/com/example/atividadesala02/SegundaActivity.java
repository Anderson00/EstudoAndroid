package com.example.atividadesala02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SegundaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        final EditText tituloEdit = (EditText) findViewById(R.id.tituloEdit);
        final EditText autorEdit = (EditText) findViewById(R.id.autorEdit);

        Button ok = (Button) findViewById(R.id.okButton);

        if(getIntent().getStringExtra("titulo") != null){
            tituloEdit.setText(getIntent().getStringExtra("titulo"));
            autorEdit.setText(getIntent().getStringExtra("autor"));
        }

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent();
                data.putExtra("titulo", tituloEdit.getText().toString());
                data.putExtra("autor", autorEdit.getText().toString());
                setResult(RESULT_OK, data);
                finish();
            }
        });
    }
}
