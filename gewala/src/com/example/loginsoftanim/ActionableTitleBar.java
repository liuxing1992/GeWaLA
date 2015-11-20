package com.example.loginsoftanim;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class ActionableTitleBar extends FrameLayout
{
  private TextView a;
  private TextView b;
  private TextView c;

  public ActionableTitleBar(Context paramContext)
  {
    this(paramContext, null);
  }

  public ActionableTitleBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130771968);
  }

  public ActionableTitleBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(R.layout.actionable_title_row, this, true);
    this.a = ((TextView)findViewById(R.id.title));
    this.b = ((TextView)findViewById(R.id.actionable_bar_left_action));
    this.c = ((TextView)findViewById(R.id.actionable_bar_right_action));
    
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ActionableTitleBar, paramInt, 0);
    
    String str1 = localTypedArray.getString(0);
    String str2 = localTypedArray.getString(1);
    String str3 = localTypedArray.getString(3);
    Drawable localDrawable1 = localTypedArray.getDrawable(2);
    Drawable localDrawable2 = localTypedArray.getDrawable(4);
    localTypedArray.recycle();
    this.a.setText(str1);
    this.b.setText(str2);
    this.c.setText(str3);
    if (localDrawable1 != null)
      this.b.setCompoundDrawablesWithIntrinsicBounds(localDrawable1, null, null, null);
    if (localDrawable2 != null)
      this.c.setCompoundDrawablesWithIntrinsicBounds(null, null, localDrawable2, null);
  }

  public void setActivityBackAction(Activity paramActivity)
  {
    setLeftActionClickListener(new a(this, paramActivity));
  }

  public void setLeftActionClickListener(View.OnClickListener paramOnClickListener)
  {
    this.b.setOnClickListener(paramOnClickListener);
  }

  public void setLeftActionDrawable(Drawable paramDrawable)
  {
    this.b.setCompoundDrawablesWithIntrinsicBounds(paramDrawable, null, null, null);
  }

  public void setLeftActionText(int paramInt)
  {
    this.b.setText(paramInt);
  }

  public void setLeftActionText(CharSequence paramCharSequence)
  {
    this.b.setText(paramCharSequence);
  }

  public void setRightActionClickListener(View.OnClickListener paramOnClickListener)
  {
    this.c.setOnClickListener(paramOnClickListener);
  }

  public void setRightActionDrawable(Drawable paramDrawable)
  {
    this.c.setCompoundDrawablesWithIntrinsicBounds(null, null, paramDrawable, null);
  }

  public void setRightActionEnable(boolean paramBoolean)
  {
    this.c.setEnabled(paramBoolean);
  }

  public void setRightActionText(int paramInt)
  {
    this.c.setText(paramInt);
  }

  public void setRightActionText(CharSequence paramCharSequence)
  {
    this.c.setText(paramCharSequence);
  }

  public void setRightActionTextColor(int paramInt)
  {
    this.c.setTextColor(paramInt);
  }

  public void setRightActionTextColor(ColorStateList paramColorStateList)
  {
    this.c.setTextColor(paramColorStateList);
  }

  public void setTitle(int paramInt)
  {
    this.a.setText(paramInt);
  }

  public void setTitle(CharSequence paramCharSequence)
  {
    this.a.setText(paramCharSequence);
  }
}