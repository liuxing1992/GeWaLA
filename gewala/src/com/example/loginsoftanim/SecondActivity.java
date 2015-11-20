package com.example.loginsoftanim;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;

public class SecondActivity  extends Activity{

	private CustomBuyButton button;
	
	private ActionableTitleBar mTitleBar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_second);
		
		mTitleBar=(ActionableTitleBar) this.findViewById(R.id.bar);
		mTitleBar.setActivityBackAction(this);
		button=(CustomBuyButton) this.findViewById(R.id.button);
		button.setText(10);
		
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
					
				Intent intent=new Intent(SecondActivity.this, ThirdActivity.class);
				startActivity(intent);
			}
		});
	}
}
