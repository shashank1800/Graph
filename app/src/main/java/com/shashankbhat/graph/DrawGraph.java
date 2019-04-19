package com.shashankbhat.graph;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;

import java.util.ArrayList;

public class DrawGraph {
    private ArrayList<Point> points;
    private Paint coordinate,line;
    private Bitmap bg;
    private Context context;
    private Canvas canvas;

    public DrawGraph(Context context) {
        this.context = context;

        bg = Bitmap.createBitmap(2000,2000,Bitmap.Config.ARGB_8888);

        canvas = new Canvas(bg);
        canvas.translate(0,canvas.getHeight());
        canvas.scale(10,-10);

        points = new ArrayList<>();
        coordinate = new Paint();
        line = new Paint();

        coordinate.setColor(Color.BLUE);
        line.setColor(Color.GREEN);

    }

    public void addPoint(float x,float y){
        points.add(new Point(x,y));
    }

    public void setCoordinateColor(int color){
        coordinate.setColor(color);
    }
    public void setLineColor(int color){
        line.setColor(color);
    }

    @SuppressLint("NewApi")
    public BitmapDrawable drawGraph(){

        DrawCoordinate(canvas,canvas.getHeight(),canvas.getWidth());
        DrawContinuousLines(canvas);

        return new BitmapDrawable(bg);
    }

    private void DrawContinuousLines(Canvas canvas) {
        line.setStrokeWidth(1);

        Point present = points.get(1);
        Point previous = points.get(0);

        for (Point point : points) {
            canvas.drawLine(previous.getX(), previous.getY(), present.getX(), present.getY(), line);
            previous = present;
            present = point;
        }
    }

    private void DrawCoordinate(Canvas canvas,int height, int width) {
        coordinate.setStrokeWidth(2);
        canvas.drawLine(0, 0, 0, height, coordinate);
        canvas.drawLine(0, 0,  width,0, coordinate);
    }
}

