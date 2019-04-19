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
    private Paint paint;
    private Bitmap bg;
    private Context context;

    public DrawGraph(Context context) {
        this.context = context;
    }

    @SuppressLint("NewApi")
    public BitmapDrawable drawGraph(){
        points = new ArrayList<>();
        paint = new Paint();
        bg = Bitmap.createBitmap(400,400,Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bg);
        canvas.translate(0,canvas.getHeight());
        canvas.scale(5,-5);

        points.add(new Point(10,10));
        points.add(new Point(40,60));
        points.add(new Point(60,100));

        paint.setStrokeWidth(2);
        paint.setColor(Color.RED);
        DrawCoordinate(canvas,canvas.getHeight(),canvas.getWidth());

        paint.setStrokeWidth(1);
        paint.setColor(Color.BLUE);
        DrawContinuousLines(canvas);

        return new BitmapDrawable(bg);
    }

    private void DrawContinuousLines(Canvas canvas) {

        paint.setColor(Color.BLUE);

        Point present = points.get(1);
        Point previous = points.get(0);

        for (Point point : points) {
            canvas.drawLine(previous.getX(), previous.getY(), present.getX(), present.getY(), paint);
            previous = present;
            present = point;
        }
    }

    private void DrawCoordinate(Canvas canvas,int height, int width) {
        paint.setColor(Color.GRAY);
        canvas.drawLine(0, 0, 0, height, paint);
        canvas.drawLine(0, 0,  width,0, paint);
    }
}
