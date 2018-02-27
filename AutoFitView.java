package com.yourapp;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;


public class AutoFitView extends View {

	Context context;
	TextPaint paint;
	int measuredWidth;
	String text;
	String stuts = "";
	float percent5;


	public AutoFitView(Context context) {
		this(context,null,0);
	}

	public AutoFitView(Context context, @Nullable AttributeSet attrs) {
		this(context, attrs,0);
	}

	public AutoFitView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		this.context =context;
		paint = new TextPaint();

		TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.auto);
		CharSequence autofit_text = a.getString(R.styleable.auto_autofit_text);

		text = autofit_text != null ? autofit_text.toString() : "";

		a.recycle();
	}

	@Override
	protected void onDraw(Canvas canvas) {

		measuredWidth = getMeasuredWidth();
		paint.setTextSize(100);

		boolean run = adjustTextSize();
		if(run) {
			Rect bounds = new Rect();
			paint.getTextBounds(text, 0, text.length(), bounds);
			float iheight = bounds.height();

			paint.setColor(Color.BLACK);
			canvas.drawText(text, 0, iheight, paint);
		}
	}

	private boolean adjustTextSize(){
		if(getTextWidth(text,paint) == 0.0f)
			return false;

		measuredWidth = getMeasuredWidth();

		stuts = getTextWidth(text,paint) < measuredWidth ? "small" : "big";
		percent5 = measuredWidth-(measuredWidth * 1/100);

		if (stuts.equals("small")){
			while (getTextWidth(text,paint) < percent5) {
				paint.setTextSize(paint.getTextSize() + 1);

			}
		}
		else if(stuts.equals("big")){
			while (getTextWidth(text,paint) > measuredWidth){
				paint.setTextSize(paint.getTextSize()-1);
			}
		}
		return true;
	}

	private float getTextWidth(String text,TextPaint paint) {
		if (text.equals("") || text.length()==0 ) return 0.0f;

		int length = text.length();
		float[] widths = new float[length];
		int count;

		try {
			count = paint.getTextWidths(text, 0, length, widths);
		}catch (Exception e){
			return 0;
		}

		float width = 0;
		for (int i = 0; i < count; i++) {
			width += widths[i];
		}
		return width;
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		if (w != oldw || h != oldh)
			adjustTextSize();
	}


}
