package com.curso_simulaciones;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.curso_simulaciones.componentes.GaugeSimple;

public class ActividadPrincipalMiQuintaApp extends Activity {
    private GaugeSimple tacometro_1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
/*llamada al método para crear los elementos de la interfaz
gráfica de usuario (GUI)*/
        crearElementosGui();

/*para informar cómo se debe adaptar la GUI a la pantalla del
dispositivo*/
        ViewGroup.LayoutParams parametro_layout_principal = new
                ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);

/*pegar al contenedor la GUI: en el argumento se está llamando
al método crearGui()*/
        this.setContentView(crearGui(), parametro_layout_principal);
    }

    /*crear los objetos de la interfaz gráfica de usuario (GUI)*/
    private void crearElementosGui() {

//crear objeto GaugeSimple
        tacometro_1=new GaugeSimple(this);
//cambiar atributos (propiedades)
//darle color blanco al lienzo antes de pega
        tacometro_1.setBackgroundColor(Color.BLACK);
//asignar las unidades
        tacometro_1.setUnidades("Unidad");
//asignar rangos
        tacometro_1.setRango(0,240);
//asignar la medida
        tacometro_1.setMedida(210f);
    }

    /*organizar la distribución de los objetos de de la GUI usando
    administradores de diseño*/
    private LinearLayout crearGui() {
//administrador de diseño
        LinearLayout linear_principal = new LinearLayout(this);
        linear_principal.setOrientation(LinearLayout.HORIZONTAL);
        linear_principal.setGravity(Gravity.CENTER_HORIZONTAL);

        linear_principal.setGravity(Gravity.FILL);
        linear_principal.setBackgroundColor(Color.rgb(250, 150, 50));
        linear_principal.setWeightSum(1);
        LinearLayout linear_izquierdo = new LinearLayout(this);
        linear_izquierdo.setOrientation(LinearLayout.VERTICAL);
        linear_izquierdo.setGravity(Gravity.CENTER_HORIZONTAL);
        linear_izquierdo.setGravity(Gravity.FILL);
        linear_izquierdo.setBackgroundColor(Color.WHITE);
        linear_izquierdo.setWeightSum(1);

//parametro para pegar los gauges
        LinearLayout.LayoutParams parametrosPegadaGauges= new
                LinearLayout.LayoutParams(android.view.ViewGroup.LayoutParams.MATCH_PARENT,0);
        parametrosPegadaGauges.setMargins(20, 20, 20, 20);
        parametrosPegadaGauges.weight = 1.0f;
//pegar gauges
        linear_izquierdo.addView(tacometro_1,parametrosPegadaGauges);

//parametro para pegar los linear al pricipal
        LinearLayout.LayoutParams parametrosPegadaLinear= new
                LinearLayout.LayoutParams(0,android.view.ViewGroup.LayoutParams.MATCH_PARENT);
        parametrosPegadaLinear.setMargins(20, 20, 20, 20);
        parametrosPegadaLinear.weight = 1.0f;
        linear_principal.addView(linear_izquierdo,parametrosPegadaLinear);
        return linear_principal;
    }

}