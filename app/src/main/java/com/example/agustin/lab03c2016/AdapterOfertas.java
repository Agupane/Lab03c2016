package com.example.agustin.lab03c2016;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by Agustin on 9/8/2016.
 */
public class AdapterOfertas extends BaseAdapter {
    private LayoutInflater inflater;
    private TextView nombreProyecto,nombreTrabajo,cantHoras,ingresoPorHora,fecha;
    private ImageView banderaPais;
    private View row;
    private List<Trabajo> listaTrabajos;
    private CheckBox cbRequiereIngles;
    private DecimalFormat decimalFormat;
    private SimpleDateFormat dateFormat;
    public AdapterOfertas(Context context, List<Trabajo> listaTrabajos)
    {
       //super(context, R.layout.row_trabajos,listaTrabajos);
        super();
        this.listaTrabajos = new ArrayList<Trabajo>();
        this.listaTrabajos.addAll(listaTrabajos);
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listaTrabajos.size();
    }

    @Override
    public Object getItem(int position)
    {
        return listaTrabajos.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        // ConvertView representa cada una de las filas del listview, asi que le asigno un oncliklistener y un inflator a cada una
        row = convertView;
        if(row == null)
        {
            row = inflater.inflate(R.layout.row_trabajos,parent,false);

        }
        cargarVariables();
        llenarAdapter(position);
        return(row);
    }

    /**
     * Inicializa la fila de listview correspondiente con los componentes
     */
    private void cargarVariables()
    {
        nombreProyecto = (TextView) row.findViewById(R.id.tvNombreEmpresa);
        nombreTrabajo = (TextView) row.findViewById(R.id.tvRolTrabajo);
        cantHoras = (TextView) row.findViewById(R.id.tvCantHoras);
        ingresoPorHora = (TextView) row.findViewById(R.id.tvIngresoPorHora_plata);
        fecha = (TextView) row.findViewById(R.id.tvFecha);
        banderaPais = (ImageView) row.findViewById(R.id.imageViewBanderaPais);
        cbRequiereIngles = (CheckBox) row.findViewById(R.id.checkBoxEnIngles);
    }

    /**
     * Carga los componentes de la fila position del listview
     * @param position
     */
    private void llenarAdapter(int position) {
        decimalFormat = new DecimalFormat("#.##");
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        int monedaPago = ((Trabajo) this.getItem(position)).getMonedaPago();
        Double precioMaximoHora = ( ((Trabajo) this.getItem(position)).getPrecioMaximoHora());
        Date fechaEntrega = ((Trabajo) this.getItem(position)).getFechaEntrega();

        nombreProyecto.setText(((Trabajo) this.getItem(position)).getDescripcion());
        nombreTrabajo.setText(((Trabajo) this.getItem(position)).getCategoria().getDescripcion());
        cantHoras.setText(" "+((Trabajo) this.getItem(position)).getHorasPresupuestadas().toString()+" ");
        ingresoPorHora.setText(" "+decimalFormat.format(precioMaximoHora));
        fecha.setText(" "+dateFormat.format(fechaEntrega));
        cbRequiereIngles.setChecked(((Trabajo) this.getItem(position)).getRequiereIngles() );
        setearBanderas(monedaPago);


    }

    public void agregarTrabajo(Trabajo nuevoTrabajo,Context context)
    {
        listaTrabajos.add(nuevoTrabajo);
        notifyDataSetChanged();

    }

    /**
     * Dado el tipo de moneda del trabajo, se setean las banderas del trabajo
     * @param tipoMoneda
     */
    private void setearBanderas(int tipoMoneda)
    {
        /** Logica de agregado de banderitas */
        switch(tipoMoneda)
        {
            case 1:
            {
                //banderaPais.setImageResource(R.drawable.banderaus);
                break;
            }
            case 2:
            {
                //banderaPais.setImageResource(R.drawable.banderaeu);
                break;
            }
            case 3:
            {
                //banderaPais.setImageResource(R.drawable.banderaargentina);
                break;
            }
            case 4:
            {
                //banderaPais.setImageResource(R.drawable.banderauk);
                break;
            }
            case 5:
            {
                //banderaPais.setImageResource(R.drawable.banderabrazil);
                break;
            }
            default:
            {
                //banderaPais.setImageResource(R.drawable.banderaargentina);
                break;
            }
        }
    }
}
