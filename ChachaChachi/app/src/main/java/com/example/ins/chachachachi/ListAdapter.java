package com.example.ins.chachachachi;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;


import com.estimote.coresdk.recognition.packets.Beacon;

import java.util.ArrayList;
import java.util.List;


public class ListAdapter extends BaseAdapter {
    protected Activity activity;
    private ArrayList<ElementoBeacon> lista = new ArrayList<>();
    private Beacon beacon;
    ConsultaTareas consultaTareas = new ConsultaTareas();
    TextView tarea;
    CheckBox check;
    String user;
    int sala;


   // private ListView lista;
    //private ImageView img;
    //int i = 0;
  //  Random random = new Random();

    private final Activity context;
    //Lista de beacons
    List<ElementoBeacon> beacons;

    public ListAdapter(Activity context, List<ElementoBeacon> beacons, String user, int sala) {
        this.context = context;
        this.beacons = beacons;
        this.user = user;
        this.sala = sala;


    }

/* if (beacon.getProximityUUID().toString() == "B9407F30-F5F8-466E-AFF9-25556B57FE6D" || beacon.getMajor() == 100 || beacon.getMinor() == 100){
            sala = 1;
            consultaTareas.execute(user, sala);
            System.out.println("100:100");
        }else if (beacon.getProximityUUID().toString() == "B9407F30-F5F8-466E-AFF9-25556B57FE6D" || beacon.getMajor() == 53583 || beacon.getMinor() == 12200){
            sala = 2;
            consultaTareas.execute(user, sala);
        }else if (beacon.getProximityUUID().toString() == "B9407F30-F5F8-466E-AFF9-25556B57FE6D" || beacon.getMajor() == 29158 || beacon.getMinor() == 64580){
            sala = 3;
            consultaTareas.execute(user, sala);
        }*/

    @Override
    public int getCount() {
        return beacons.size();
    }

    @Override
    public Object getItem(int position) {
        return beacons.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    //Método para mostrar los datos de los beacons en TextFields
    @SuppressLint("ResourceAsColor")
    @Override
    public View getView(int position, View view, ViewGroup parent) {



        LayoutInflater inflater = LayoutInflater.from(context);
        View rowView = inflater.inflate(R.layout.lista_beacons, null, true);
        tarea = (TextView) rowView.findViewById(R.id.txtTareas);
        //img = (ImageView) rowView.findViewById(R.id.imagen);
        check = (CheckBox) rowView.findViewById(R.id.check);
        tarea.setText(beacons.get(position).toString());
        //txtNombre.setText(beacons.get(position).getMacAddress().toString().replace("[]", ""));

        //TextView txtMajorMinor = (TextView) rowView.findViewById(R.id.txtMajorMinor);
        //txtMajorMinor.setText("Major: " + beacons.get(position).getMajor() + " Minor: " + beacons.get(position).getMinor());

        return rowView;
    }
}
