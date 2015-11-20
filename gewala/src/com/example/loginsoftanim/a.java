package com.example.loginsoftanim;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;

class a implements View.OnClickListener {
	
	private Activity activity;
	a(ActionableTitleBar paramActionableTitleBar, Activity paramActivity) {
			this.activity=paramActivity;
	}

	public void onClick(View paramView) {
		activity.onBackPressed();
	}
}