package com.example.atividadesala02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

public class LivrosBaseAdapter extends BaseAdapter {

    Context ctx;
    List<Livro> lista;

    public LivrosBaseAdapter(Context ctx, List<Livro> lista){
        this.ctx = ctx;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return lista.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //View view = View.inflate(ctx, R.layout.livro_layout, parent);

        LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.livro_layout, null);

        TextView textView = (TextView) view.findViewById(R.id.tituloText);
        TextView autorView = (TextView) view.findViewById(R.id.autorText);

        Livro l = lista.get(position);
        textView.setText(l.getTitulo());
        autorView.setText(l.getAutor());

        return view;
    }
}
