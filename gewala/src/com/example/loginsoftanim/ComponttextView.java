package com.example.loginsoftanim;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ComponttextView extends LinearLayout {

	
	public ComponttextView(Context context, AttributeSet attrs) {
		super(context, attrs);	
		
		LayoutInflater.from(context).inflate(R.layout.custom_compont_text, this);
		
		frontTextView=(TextView) findViewById(R.id.front);
		behindTextView=(TextView) findViewById(R.id.behind);
		
		TypedArray typedArray=context.obtainStyledAttributes(attrs, R.styleable.CompontTextView);
		
		int frontColor=typedArray.getColor(R.styleable.CompontTextView_frontTextColor, defautColor);
		int behindColor=typedArray.getColor(1, frontColor);
		String frontText=typedArray.getString(2);
		String behindtext=typedArray.getString(3);
		int magin=typedArray.getInt(4, space);
		float frontSize=typedArray.getFloat(5, defaultSize);
		float behindSize=typedArray.getFloat(6, defaultSize);
		
		typedArray.recycle();
		
		frontTextView.setText(frontText);
		behindTextView.setText(behindtext);
		frontTextView.setTextColor(frontColor);
		behindTextView.setTextColor(behindColor);
		frontTextView.setTextSize(frontSize);
		behindTextView.setTextSize(behindSize);
		
		LayoutParams params=(LayoutParams) frontTextView.getLayoutParams();
		params.setMargins(0, 0, magin, 0);
		frontTextView.setLayoutParams(params);
	}
	
	public ComponttextView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		
		
	}
	private TextView frontTextView;
	private TextView behindTextView;
	
	private int defautColor=0xff333333;
	int space=5;
	float defaultSize=15.0f;
	
	
	public void setBehindText(String text){
		behindTextView.setText(text);
	}
	
	public void setFrontText(String text){
		frontTextView.setText(text);
	}

	/**下划线**/
	public void setFlag(){
		
		frontTextView.getPaint().setFlags(Paint. UNDERLINE_TEXT_FLAG ); //下划线
		frontTextView.getPaint().setAntiAlias(true);//抗锯齿
	}
}
