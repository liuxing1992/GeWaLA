package com.example.loginsoftanim;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.widget.TextView;

public class MarqueeTextView extends TextView
{
  public MarqueeTextView(Context paramContext)
  {
    super(paramContext);
    createView();
  }

  public MarqueeTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    createView();
  }

  public MarqueeTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    createView();
  }

  private void createView()
  {
    setEllipsize(TruncateAt.MARQUEE);
    setMarqueeRepeatLimit(-1);
    setFocusableInTouchMode(true);
  }

  public boolean isFocused()
  {
    return true;
  }

  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    if (paramBoolean)
      super.onFocusChanged(paramBoolean, paramInt, paramRect);
  }

  public void onWindowFocusChanged(boolean paramBoolean)
  {
    if (paramBoolean)
      super.onWindowFocusChanged(paramBoolean);
  }
}