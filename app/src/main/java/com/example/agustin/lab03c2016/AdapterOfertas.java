package com.example.agustin.lab03c2016;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by Agustin on 9/8/2016.
 */
public class AdapterOfertas extends BaseAdapter {
    private LayoutInflater inflater;
    private TextView nombreEmpresa,nombreTrabajo,cantHoras,ingresoPorHora,fecha;
    private ImageView banderaPais;
    private View row;
    private List<Trabajo> items;
    public AdapterOfertas(Context context, List<Trabajo> items)
    {
       //super(context, R.layout.row_trabajos,items);
        super();
        this.items = items;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Object getItem(int position)
    {

        return items.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        Object algo = this.getItem(position);

        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        DecimalFormat df = new DecimalFormat("#.##");

        row = convertView;
        if(row == null)
        {
            row = inflater.inflate(R.layout.row_trabajos,parent,false);
        }
        cargarVariables();
        //llenarAdapter(position);
        ((TextView)row.findViewById(R.id.tvRolTrabajo)).setText( "DIGO ALGOOOO");

        /**
         * ACA HACER LOGICA PARA BANDERITA Y ETC
         */
        return(row);
    }
    private void cargarVariables()
    {
        nombreEmpresa = (TextView) row.findViewById(R.id.tvNombreEmpresa);
        nombreTrabajo = (TextView) row.findViewById(R.id.tvRolTrabajo);
        cantHoras = (TextView) row.findViewById(R.id.tvCantHoras);
        ingresoPorHora = (TextView) row.findViewById(R.id.tvIngresoPorHora_plata);
        fecha = (TextView) row.findViewById(R.id.tvFecha);
        banderaPais = (ImageView) row.findViewById(R.id.imageViewBanderaPais);
    }
    private void llenarAdapter(int position)
    {
       // nombreEmpresa.setText( (Trabajo) this.getItem(position).getD() );
        nombreTrabajo.setText ( ((Trabajo) this.getItem(position)).getCategoria().getDescripcion());
        /*
        cantHoras = (TextView) this.getItem(position);
        ingresoPorHora = (TextView) this.getItem(position);
        fecha = (TextView) this.getItem(position);
        banderaPais = (ImageView) this.getItem(position);
        */
    }

}
