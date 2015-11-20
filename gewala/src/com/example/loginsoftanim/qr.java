package com.example.loginsoftanim;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;

public class qr implements ViewTreeObserver.OnGlobalLayoutListener {
	public boolean a;
	int b = 0;
	private View c;
	private Rect d = new Rect();
	private qr.a e = new qr.a() {
		public void onSoftInputChanged(int paramAnonymousInt) {
		}

		public void onSoftInputHide() {
		}

		public void onSoftInputShow(int paramAnonymousInt) {
		}
	};

	public qr(View paramView) {
		this.c = paramView;
	}

	public void a() {
		this.c.getViewTreeObserver().addOnGlobalLayoutListener(this);
	}

	public void a(qr.a parama) {
		this.e = parama;
	}

	public void b() {
		if (Build.VERSION.SDK_INT >= 16)
			this.c.getViewTreeObserver().removeOnGlobalLayoutListener(this);
	}

	public void onGlobalLayout() {
		c.getWindowVisibleDisplayFrame(this.d);
		int i = this.c.getRootView().getHeight() - this.d.bottom;
		System.out.println("----i-"+i+"---b-"+b);
		
		if (i==b) {
			if (i==0) {
				this.e.onSoftInputChanged(i);
			}else {
				this.e.onSoftInputShow(i);
			}
		}else{
			if (i>=200) {
				b=i;
				this.e.onSoftInputShow(i);
			}else {
				this.e.onSoftInputHide();
			}
		}
	}

	public static abstract interface a {
		public abstract void onSoftInputChanged(int paramInt);

		public abstract void onSoftInputHide();

		public abstract void onSoftInputShow(int paramInt);
	}
}