package com.example.maimuta;

import android.view.View;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.ArcShape;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.PathShape;
import android.graphics.drawable.shapes.RectShape;

// class qui dessine les figures pour les training programs
public class CustomDrawableViewTrainingProgram extends View 
{
	private ShapeDrawable mDrawable;
	
	public CustomDrawableViewTrainingProgram(Context context) 
	{
		super(context);
		int x = 0;
		int y =  0;
		int width = 100;
		int height = 100;
		mDrawable = new ShapeDrawable(new OvalShape());
		mDrawable.getPaint().setColor(0xff74AC23);
		mDrawable.setBounds(x, y, x + width, y + height);
	}
	
	// constructeur qui crée la vue avec une position et une taille donnée
	public CustomDrawableViewTrainingProgram(Context context, int x, int y, int width, int height)
	{
		super(context);
		
		mDrawable = new ShapeDrawable(new RectShape());
		mDrawable.getPaint().setColor(0xff74AC23);
		mDrawable.setBounds(x, y, x + width, y + height);
	}
	
	private ShapeDrawable getShapeDrawable()
	{
		return mDrawable;
	}
	
	public void setShapeDrawable(ShapeDrawable s)
	{
		mDrawable = s;
	}
	
	protected void onDraw(Canvas canvas) 
	{
		super.onDraw(canvas);
		mDrawable.draw(canvas);
	}
	
	// function who change the color of the current figure
	public void changeRandomColor(IntColor intColor)
	{
		mDrawable.getPaint().setColor(intColor.chooseRandomColor());
	}
	
	public void setCustomView(CustomDrawableViewTrainingProgram v)
	{
		mDrawable = v.getShapeDrawable();
	}
	
}
