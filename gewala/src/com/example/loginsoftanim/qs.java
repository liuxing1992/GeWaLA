package com.example.loginsoftanim;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class qs {
	private static final InputMethodManager a = (InputMethodManager) qt.a
			.getSystemService("input_method");

	public static void a(Activity paramActivity) {
		if (paramActivity.getCurrentFocus() != null)
			a.hideSoftInputFromWindow(paramActivity.getCurrentFocus()
					.getWindowToken(), 2);
	}

	public static void a(View paramView) {
		if (paramView == null)
			return;
		a.showSoftInput(paramView, 2);
	}

	public static boolean a() {
		return a.isActive();
	}

	public static void b(View paramView) {
		if (paramView == null)
			return;
		a.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
	}

	public static void c(final View paramView) {
		if (paramView == null)
			return;
		paramView.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramAnonymousView) {
				paramView.setFocusable(true);
				paramView.setFocusableInTouchMode(true);
				paramView.requestFocus();
				qs.b(paramView);
				a.showSoftInput(paramView, 2);
			}
		});
	}
}