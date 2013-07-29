package com.example.test;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class draw1d extends View {
	
	Paint paint;
	float x1 = 0, y1 = 0, x2 = 0, y2 = 0;
	boolean isDown = false;
	ArrayList<Float[]> points;
	
	
	public draw1d(Context context) {
		super(context);
		paint = new Paint();
		paint.setColor(Color.BLACK);
		paint.setAntiAlias(true);
		paint.setStyle(Paint.Style.FILL);
		points = new ArrayList<Float[]>();
		// TODO Auto-generated constructor stub
	}
	
	public boolean onTouchEvent (MotionEvent event) {
		int action = event.getAction();
		switch (action) {
		case MotionEvent.ACTION_DOWN:
			Log.i("Tag", "Down");
			if (!isDown){
				x1 = event.getX();
				y1 = event.getY();
				}
			isDown = true;
			x2 = event.getX();
			y2 = event.getY();
			break;
		case MotionEvent.ACTION_MOVE:
			Log.i("Tag", "Move");
//			x1 = event.getX();
//			y1 = event.getY();
			break;
			
		case MotionEvent.ACTION_UP:
			Log.i("Tag", "UP");
//			x1 = event.getX();
//			y1 = event.getY();
			isDown = false;
			Float [] arr = {x1, y1, x2, y2};
			points.add(arr);
			
			break;
		}
		x1 = event.getX();
		y1 = event.getY();
		Log.i("MyTag", "x = " + event.getX() + " and y = " + event.getY());
		invalidate();
		return true;
	}
	
	
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		for (Float[] f : points){
			canvas.drawLine(f[0], f[1], f[2], f[3], paint);
		}
		if (isDown){
			canvas.drawLine(x1, y1, x2, y2, paint);
		}
//		canvas.drawLine(x1, y1, x2, y2, paint);
//		Log.i("koord"," x1 " + x1 + " x2 " + x2 + " y1 " + y1 + " y2 " + y2);
		
		
		
		
		
		
		/*paint.setStyle(Paint.Style.FILL);
		
		paint.setColor(Color.GREEN);
		canvas.drawPaint(paint);
		
		paint.setStyle(Paint.Style.FILL_AND_STROKE);
		
		paint.setAntiAlias(true);
		paint.setColor(Color.YELLOW);
		canvas.drawCircle(450, 70, 150, paint);
		
		
		paint.setStyle(Paint.Style.FILL);

		paint.setColor(Color.RED);
		canvas.drawRect(50, 100, 400, 300, paint);
		
		paint.setColor(Color.BLUE);
		paint.setStyle(Paint.Style.FILL);
		paint.setAntiAlias(true);
		paint.setTextSize(30);
		canvas.drawText("This is text", 60, 150, paint);
		
		int x = 60;
		int y = 450;
		
		paint.setColor(Color.YELLOW);
		paint.setTextSize(40);
		String strFortext = "под углом";
		Rect rect = new Rect();
		
		canvas.rotate(-45, x + rect.exactCenterX(), y + rect.exactCenterY());
		
		paint.setStyle(Paint.Style.FILL);
		canvas.drawText(strFortext, x, y, paint);
		
		canvas.restore();
		
		Resources res = this.getResources();
		Bitmap bitmap = BitmapFactory.decodeResource(res, R.drawable.ic_launcher);
		canvas.drawBitmap(bitmap, 500, 500, paint);
		*/
		
		
		
		
	}

}
