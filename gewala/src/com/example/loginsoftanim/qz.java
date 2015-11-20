package com.example.loginsoftanim;

import android.content.Context;
import android.content.res.Resources;
import android.location.Location;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.widget.Toast;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class qz {
	public static final String a = qz.class.getSimpleName();
	private static long b;
	private static Random c = new Random(System.currentTimeMillis());

	public static int a(Context paramContext, float paramFloat) {
		if (paramContext == null)
			return (int) paramFloat;
		return (int) (0.5F + paramFloat
				* paramContext.getResources().getDisplayMetrics().density);
	}

}