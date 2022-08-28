package com.curso_simulaciones.componentes;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.view.View;

public class Pizarra extends View {
    //constructor
    public Pizarra(Context context) {
        super(context);
    }
    //método para dibujar
    protected void onDraw(Canvas canvas) {
        Paint pincel = new Paint();
        pincel.setAntiAlias(true);

        /*Tamaño del texto*/
        pincel.setColor(Color.RED);
        pincel.setTextSize(40f);
/*texto que comienza a escribirse en (20,30) de tamaño de letra 40 pixeles y de
color rojo */
        canvas.drawText("Hola Jóvenes, bienvenidos a sus primeros dibujos", 20f, 50f,
                pincel);


        pincel.setStyle(Paint.Style.STROKE);
        RectF rectF = new RectF(50, 200, 300, 450);
        pincel.setColor(Color.MAGENTA);
        canvas.drawArc(rectF, 90, 135, false, pincel);
        /*
Dibujar sector circular inscrito en rectángulo
con esquina superior izquierda en (50,400)
y esquina inferior derecha en (300,650),
no relleno, de espesor de línea 0.5 y de color negro,
con inicio en 90 grados y desplazándose
135 grados (el arco es de 135 grados).
*/
        RectF rectF_1 = new RectF(50, 400, 300, 650);
        pincel.setStrokeWidth(0.5f);
        pincel.setColor(Color.BLACK);
        canvas.drawArc(rectF_1, 90, 135, true, pincel);
        /*
Dibujar sector circular inscrito en rectángulo
con esquina superior izquierda en (250,400)
y esquina inferior derecha en (500,650),
relleno, de color negro con inicio en 90 grados
y desplazándose 135 grados (el arco es de 135 grados)

         */
    }
}