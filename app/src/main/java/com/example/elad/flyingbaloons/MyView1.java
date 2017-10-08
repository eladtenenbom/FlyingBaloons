package com.example.elad.flyingbaloons;

import android.view.View;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.AsyncTask;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * Created by elad on 16/05/2017.
 */

public class MyView1 extends View {


    public MyView1(Context context) {

        super(context);

    }
    int stepY = 0;
    int stepX = 0;
    float x=0,y=0;
    int color;
    List<Baloon> l1 = new ArrayList<Baloon>(300);
    Random rnd=new Random();


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint pn1 = new Paint();
        //pn1.setColor(Color.GREEN);
        //   pn1.setStrokeWidth(15);
        //  canvas.drawLine(0,100,200,300,pn1);
        //  pn1.setColor(Color.GREEN);
        // canvas.drawCircle(x,y,40,pn1);
        Paint pn2 = new Paint();
        pn2.setTextSize(40);
        pn2.setColor(Color.BLACK);
        canvas.drawText(l1.size() + "", 100, 100, pn2);

        for (int i = 0; i < l1.size(); i++) {
            int NewColor = l1.get(i).getColor() + 1000;
            l1.get(i).setColor(NewColor);
            pn1.setColor((l1.get(i).getColor()));
            canvas.drawCircle(l1.get(i).x, l1.get(i).y, 40, pn1);

            l1.get(i).setY(l1.get(i).getY() + l1.get(i).getStepY());
            l1.get(i).setX(l1.get(i).getX() + l1.get(i).getStepX());

            if (l1.get(i).getX() > canvas.getWidth() + 1000 ||
                    l1.get(i).getX() < 0 - 1000 ||
                    l1.get(i).getY() > canvas.getHeight() + 1000 ||
                    l1.get(i).getY() < 0 - 1000) {

                l1.remove(i);

            }

        }

    }



    @Override
    public boolean onTouchEvent(MotionEvent event) {
        for (int i=0;i<10;i++) {

            Creation(event);
        }
        return super.onTouchEvent(event);
    }

    public void Creation(MotionEvent event) {

            x = event.getX();
            y = event.getY();
            color = 0 - ((int) (Math.random() * 16777216) + 1);
           do {
               stepX = 10 - ((int) (Math.random() * 20));
               stepY = 10 - ((int) (Math.random() * 20));
           }while (stepX==0 && stepY==0);

            Baloon mp1 = new Baloon(x, y, color, stepX, stepY);
            l1.add(mp1);
            task1 t1 = new task1();
            invalidate();
            t1.execute();
        }


            // calling function onDraw of the system



    class  task1 extends AsyncTask<Integer,Void,Void>
    {

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
            invalidate();
        }


        boolean flag = true;
        @Override
        protected Void doInBackground(Integer... params) {
            try {
                while (flag)
                {


                    publishProgress();
                    Thread.sleep(20);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }
    }

}