package com.example.loginsoftanim;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CustomBuyButton extends RelativeLayout {
	private int curMoney = 0;
	private ImageView img;
	private View progress;
	private TextView txt;

	public CustomBuyButton(Context paramContext, AttributeSet paramAttributeSet) {
		super(paramContext, paramAttributeSet);
		if (isInEditMode())
			return;
		LayoutInflater.from(paramContext).inflate(R.layout.btn_usercard_goods_buy, this);
		this.img = ((ImageView) findViewById(R.id.usercard_goods_buy_img));
		this.txt = ((TextView) findViewById(R.id.usercard_goods_buy_txt));
		this.progress = findViewById(R.id.usercard_goods_buy_progress);
	}

	public void closeProgress() {
		this.img.setVisibility(0);
		this.progress.setVisibility(8);
	}

	public void moveToLeft() {
		this.img.setVisibility(0);
		this.progress.setVisibility(8);
		int i = getWidth() / 2 + qz.a(getContext(), 20.0F);
		float[] arrayOfFloat = new float[2];
		arrayOfFloat[0] = i;
		arrayOfFloat[1] = 0.0F;
		ObjectAnimator.ofFloat(this, "translationX", arrayOfFloat)
				.setDuration(500L).start();
		setClickable(true);
	}

	public void moveToRight() {
		this.img.setVisibility(8);
		this.progress.setVisibility(8);
		int i = getWidth() / 2 + qz.a(getContext(), 20.0F);
		float[] arrayOfFloat = new float[2];
		arrayOfFloat[0] = 0.0F;
		arrayOfFloat[1] = i;
		ObjectAnimator.ofFloat(this, "translationX", arrayOfFloat)
				.setDuration(400L).start();
		setClickable(false);
	}

	public void setText(int paramInt) {
		if (paramInt > 0) {
			if (this.curMoney <= 0) {
				setClickable(true);
				this.img.setImageResource(R.drawable.icon_cartwhite);
				this.txt.setTextColor(-1);
			}
		} else {
			if (this.curMoney > 0) {
				setClickable(false);
				this.img.setImageResource(R.drawable.icon_cartred);
				this.txt.setTextColor(Color.rgb(248, 114, 88));
			}
		}

		this.curMoney = paramInt;
		this.txt.setText("гд" + paramInt);

	}

	public void showProgress() {
		this.img.setVisibility(4);
		this.progress.setVisibility(0);
	}
}