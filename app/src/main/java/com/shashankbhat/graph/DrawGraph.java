package com.shashankbhat.graph;

import android.annotation.SuppressLint;
import android.graphics.*;
import android.graphics.drawable.BitmapDrawable;

import java.util.ArrayList;

public class DrawGraph {
    private ArrayList<Point> points;
    private Paint background,line,unitLine;
    private Bitmap bg;
    private Canvas canvas;
    private float max_x=0,max_y=0;

    public DrawGraph() {

        points = new ArrayList<>();

        background = new Paint();
        line = new Paint();
        unitLine = new Paint();

        background.setColor(Color.parseColor("#F0FAF7"));

        unitLine.setColor(Color.parseColor("#6DAE9A"));
        line.setColor(Color.parseColor("#718DAD"));
        unitLine.setStrokeWidth(20f);
        line.setStrokeWidth(30f);

    }

    public void addPoint(float x,float y){
        if(max_x > x && max_y > y)
            points.add(new Point(x,y));

        else {
            if(max_x < x)
                max_x = x;
            if(max_y < y)
                max_y = y;
            points.add(new Point(x,y));
        }
    }

    public void setBackgroundColor(String color){
        background.setColor(Color.parseColor(color));
    }
    public void setLineColor(String color){
        line.setColor(Color.parseColor(color));
    }

    public void setUnitLineWidht(Float widht){
        background.setStrokeWidth(widht);
    }
    public void setLineWidth(Float widht){
        line.setStrokeWidth(widht);
    }

    @SuppressLint("NewApi")
    public BitmapDrawable drawGraph(){

        recalculateXY();

        bg = Bitmap.createBitmap(5000,5000,Bitmap.Config.ARGB_8888);

        canvas = new Canvas(bg);
        canvas.translate(0,canvas.getHeight());
        canvas.scale(1,-1);

        //draw background
        canvas.drawRect(0, 0, canvas.getHeight(), canvas.getWidth(), background);

        UnitGraph(canvas);
        DrawContinuousLines(canvas);

        return new BitmapDrawable(bg);
    }

    private void recalculateXY() {
        for(int i=0;i<points.size();i++){
            points.get(i).x = (5000/max_x)*points.get(i).x;
            points.get(i).y = (5000/max_y)*points.get(i).y;
        }
    }

    private void UnitGraph(Canvas canvas) {
        float max = 5000;
        for(float i=1000;i<max;i+= 1000){
            canvas.drawLine(0,i,canvas.getHeight(),i,unitLine);
            canvas.drawLine(i,0,i,canvas.getHeight(),unitLine);
        }
    }

    private void DrawContinuousLines(Canvas canvas) {

        Point present = points.get(0);
        Point previous;

        for (int i=1;i<points.size();i++) {
            previous = present;
            present = points.get(i);
            canvas.drawLine(previous.getX(), previous.getY(), present.getX(), present.getY(), line);
        }
    }
}

