package com.example.agustin.lab03c2016;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemLongClickListener{
    private ListView ofertas;
    private AdapterOfertas adapterLvOfertas;
    private Trabajo[] trabajos;
    private MenuInflater menuInflater;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ofertas = (ListView) findViewById(R.id.lvOfertas);
        trabajos=Trabajo.TRABAJOS_MOCK;
        adapterLvOfertas = new AdapterOfertas(this, Arrays.asList(trabajos));
        ofertas.setAdapter(adapterLvOfertas);
        ofertas.setOnItemLongClickListener(this);

        /** Menu Contextual **/
        registerForContextMenu(ofertas);
        /** Action bar **/
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case R.id.action_ppal: break;
            case R.id.action_add: {
                Intent intent = new Intent(this, ActivityOferta.class);
                startActivityForResult(intent,1);
                break;
            }
            default: break;
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1: {
                if(resultCode != 0) { //Si no hubo errores:
                    Trabajo res = (Trabajo)data.getSerializableExtra("agregado");
                    //TODO agregar trabajo nuevo a la list view
                }
                break;
            }
            default: break;
        }
    }

    /**
     *
     * @param parent
     * @param view = the id of the item in our view (List/Grid) that we clicked
     * @param position = the id of the item that we have clicked
     * @param id = if we didn't assign any id for the Object this arg value is 0
     */
    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id)
    {
      //  Toast.makeText(getApplicationContext(), "You clicked on position : " + position + " and id : " + id, Toast.LENGTH_SHORT).show();
        return false;
    }

    /**
     * Crea el menu contextual
     * @param menu menuContextual a crear
     * @param v
     * @param menuInfo
     */
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu,v,menuInfo);
        menu.setHeaderTitle(R.string.menu_tvAcciones);
        menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_contextual,menu);
    }

    /**
     * Analiza que opcion del menu contextual se selecciono y ejecuta la accion correspondiente
     * @param item
     * @return
     */
    @Override
    public boolean onContextItemSelected(MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.MnuPostularse:
            {
                accionMenuPostularse();
                return true;
            }
            case R.id.MnuCompartir:
            {
                accionMenuCompartir();
                return true;
            }
            default:
            {
                return super.onOptionsItemSelected(item);
            }
        }
    }


    /**
     * Accion que se realiza cuando se selecciona la opcion de postularse en el menu contextual
     */
    private void accionMenuPostularse()
    {
        Toast.makeText(getApplicationContext(), "Tu postulacion se registro correctamente", Toast.LENGTH_LONG).show();
    }

    /**
     * Accion que se realiza cuando se selecciona la opcion de compartir en el menu contextual
     */
    private void accionMenuCompartir()
    {

    }

}
