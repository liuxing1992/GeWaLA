package com.example.loginsoftanim;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ViewSwitcher.ViewFactory;

public class MainActivity extends Activity implements ViewFactory {

	private qr inputObserver;

	private RelativeLayout rootView;

	private ImageView ivLogo;

	private FrameLayout layoutInput;

	private ImageSwitcher switcherBackground;
	
	private Button mButton;

	private int[] resIds = { R.drawable.bk_login1, R.drawable.bk_login2,
			R.drawable.bk_login3 };
	private int count=1;
	@SuppressLint("HandlerLeak")
	private Handler handler = new Handler() {

		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case 1:
				int draw=resIds[count%resIds.length];	
//				switcherBackground.setImageResource(draw);
				count++;
				handler.sendEmptyMessageDelayed(1, 3000);
				break;
			}
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		rootView = (RelativeLayout) this
				.findViewById(R.id.layout_user_account_root);
		ivLogo = (ImageView) this.findViewById(R.id.iv_user_logo);
		switcherBackground = (ImageSwitcher) this
				.findViewById(R.id.is_user_account);
		switcherBackground.setFactory(this);
//		switcherBackground.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.bk_fade_in_login));
//		switcherBackground.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.bk_fade_out_login));
		    mButton=(Button) this.findViewById(R.id.back);
		mButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this, SecondActivity.class));
			}
		});
		switcherBackground.setImageResource(R.drawable.bk_login3);
		handler.sendEmptyMessageDelayed(1, 3000);
		
		final int i = qz.a(this, 64.0F);
		layoutInput = (FrameLayout) this.findViewById(R.id.layout_user_account);
		this.inputObserver = new qr(rootView);
		this.inputObserver.a();
		this.inputObserver.a(new qr.a() {
			@Override
			public void onSoftInputShow(int paramInt) {

				AnimatorSet localAnimatorSet = new AnimatorSet();
				Animator[] arrayOfAnimator = new Animator[4];
				arrayOfAnimator[0] = ObjectAnimator.ofFloat(
						MainActivity.this.ivLogo, "scaleX", new float[] { 1.0F,
								0.5F });
				arrayOfAnimator[1] = ObjectAnimator.ofFloat(
						MainActivity.this.ivLogo, "scaleY", new float[] { 1.0F,
								0.5F });
				ImageView localImageView = MainActivity.this.ivLogo;
				float[] arrayOfFloat1 = new float[2];
				arrayOfFloat1[0] = 0.0F;
				arrayOfFloat1[1] = (-i);
				arrayOfAnimator[2] = ObjectAnimator.ofFloat(localImageView,
						"translationY", arrayOfFloat1);
				FrameLayout localFrameLayout = MainActivity.this.layoutInput;
				float[] arrayOfFloat2 = new float[2];
				arrayOfFloat2[0] = 0.0F;
				arrayOfFloat2[1] = (-i);
				arrayOfAnimator[3] = ObjectAnimator.ofFloat(localFrameLayout,
						"translationY", arrayOfFloat2);
				localAnimatorSet.playTogether(arrayOfAnimator);
				localAnimatorSet.setDuration(300L);
				localAnimatorSet.start();
			}

			@Override
			public void onSoftInputHide() {
				AnimatorSet localAnimatorSet = new AnimatorSet();
				Animator[] arrayOfAnimator = new Animator[4];
				arrayOfAnimator[0] = ObjectAnimator.ofFloat(
						MainActivity.this.ivLogo, "scaleX", new float[] { 0.5F,
								1.0F });
				arrayOfAnimator[1] = ObjectAnimator.ofFloat(
						MainActivity.this.ivLogo, "scaleY", new float[] { 0.5F,
								1.0F });
				ImageView localImageView = MainActivity.this.ivLogo;
				float[] arrayOfFloat1 = new float[2];
				arrayOfFloat1[0] = (-i);
				arrayOfFloat1[1] = 0.0F;
				arrayOfAnimator[2] = ObjectAnimator.ofFloat(localImageView,
						"translationY", arrayOfFloat1);
				FrameLayout localFrameLayout = MainActivity.this.layoutInput;
				float[] arrayOfFloat2 = new float[2];
				arrayOfFloat2[0] = (-i);
				arrayOfFloat2[1] = 0.0F;
				arrayOfAnimator[3] = ObjectAnimator.ofFloat(localFrameLayout,
						"translationY", arrayOfFloat2);
				localAnimatorSet.playTogether(arrayOfAnimator);
				localAnimatorSet.setDuration(300L);
				localAnimatorSet.start();
			}

			@Override
			public void onSoftInputChanged(int paramInt) {

			}
		});
	}

	@Override
	public View makeView() {
		ImageView localImageView = new ImageView(this);
		localImageView.setBackgroundColor(-16777216);
		localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
		localImageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
		return localImageView;
	}
}
