package com.example.ins.chachachachi;

import android.os.AsyncTask;

import com.mysql.jdbc.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 * Created by Inés on 12/06/2018.
 */

public class ConsultaTareas extends AsyncTask<Object, Object, String> {
    private ArrayList<String> tareas = null;

    @Override
    protected String doInBackground(Object... params) {

        ConnectionClass conexion = new ConnectionClass();
        if (conexion.conectar() == null) {
            System.out.println("Estableciendo conexión...");

        } else {
            System.out.println("Conexión reutilizada.");
        }

        if (conexion == null) {
            System.out.println("Error al conectar a la base de datos.");
            return "Error al conectar a la base de datos.";
        }

        String sq1 = "SELECT t.texto\n" +
                "FROM tarea t, empleado e, empleado_sala_tarea est\n" +
                "WHERE e.P_empleado = est.A_empleado AND est.A_tarea = t.P_tarea\n" +
                "AND e.usuario = '" + params[1] + "' AND DATE(est.fecha) = CURDATE() AND est.A_sala = " + params[2] + "";
    /*SELECT e.nombre, t.texto, est.A_sala , est.fecha
" +
                "FROM tarea t, empleado e, empleado_sala_tarea est, sala s\n" +
                "WHERE e.P_empleado = est.A_empleado AND est.A_tarea = t.P_tarea\n" +
                "AND e.nombre = 'Ignacio' AND est.fecha= '2018-05-28'"*/

        tareas = new ArrayList<>();

        try {
            java.sql.PreparedStatement ps1 = conexion.conectar().prepareStatement(sq1);
            System.out.println(ps1);
            ResultSet rs1 = ps1.executeQuery();

            while (rs1.next()) {
                String tarea = rs1.getString("texto");
                tareas.add(tarea);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String error) {
        if (error != null) {
            System.out.println(error);
            return;
        }

        Object[] datos = new Object[2];
        datos[0] = 0;
        datos[1] = tareas;

    }
}