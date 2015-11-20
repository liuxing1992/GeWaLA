package com.example.loginsoftanim;

import android.content.Context;
import android.util.AttributeSet;

public class ScrollView extends android.widget.ScrollView
{
  private a a;

  public ScrollView(Context paramContext)
  {
    super(paramContext);
  }

  public ScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public ScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.a != null)
      this.a.a(paramInt1, paramInt2, paramInt3, paramInt4);
  }

  public void setOnScrollChangeListener(a parama)
  {
    this.a = parama;
  }

  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  }
}