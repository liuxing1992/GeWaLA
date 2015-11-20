package com.example.loginsoftanim;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;



public class MarqueeImageView extends View
{
  private static final String KEY_BITMAP_1 = "bk_line1";
  private static final String KEY_BITMAP_2 = "bk_line2";
  private static final String KEY_BITMAP_3 = "bk_line3";
  private static final String KEY_BITMAP_4 = "bk_line4";
  private static final String KEY_BITMAP_5 = "bk_line5";
  private static final String KEY_BITMAP_6 = "bk_line6";
  private static final int MOVE_STEP = 2;
  private int height = 0;
  private boolean init = false;
  private int itemHeight = 0;
  private int mArchor1 = 0;
  private int mArchor2 = 0;
  private int mArchor3 = -1;
  private int mArchor4 = -1;
  private Bitmap[] mBitmaps = new Bitmap[6];
  private int mOriginalHeight = 0;
  private Paint mPaint = new Paint();
  private Rect mSrcRect;
  private int width = 0;

  public MarqueeImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initBitmaps();
  }

  public MarqueeImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initBitmaps();
  }

  private void initBitmaps()
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = false;
    localOptions.inSampleSize = 2;

    ImageCache imageCache=ImageCache.getInstance();
    
    loadBitmaps(localOptions, imageCache, R.drawable.bk_line1, "bk_line1", 0);
    loadBitmaps(localOptions, imageCache, R.drawable.bk_line2, "bk_line2", 1);
    loadBitmaps(localOptions, imageCache, R.drawable.bk_line3, "bk_line3", 2);
    loadBitmaps(localOptions, imageCache, R.drawable.bk_line4, "bk_line4", 3);
    loadBitmaps(localOptions, imageCache, R.drawable.bk_line5, "bk_line5", 4);
    loadBitmaps(localOptions, imageCache, R.drawable.bk_line6, "bk_line6", 5);
    this.mPaint.setAntiAlias(true);
    this.mPaint.setStyle(Paint.Style.STROKE);
  }

  private void loadBitmaps(BitmapFactory.Options paramOptions, ImageCache paramImageCache, int paramInt1, String paramString, int paramInt2)
  {
    Bitmap localBitmap = paramImageCache.getBitmap(paramString);
    if (localBitmap == null)
    {
      localBitmap = BitmapFactory.decodeResource(getContext().getResources(), paramInt1, paramOptions);
      paramImageCache.putBitmap(paramString, localBitmap);
      this.mBitmaps[paramInt2] = localBitmap;
    }else {
    	 this.mBitmaps[paramInt2] = localBitmap;
	}
   
      if (this.mOriginalHeight == 0)
        this.mOriginalHeight = localBitmap.getHeight();
    
  }

  public void onDestroy()
  {
    while (true)
    {
      int j;
      try
      {
        Bitmap[] arrayOfBitmap = this.mBitmaps;
        int i = arrayOfBitmap.length;
        j = 0;
        if (j < i)
        {
          Bitmap localBitmap = arrayOfBitmap[j];
          if ((localBitmap != null) && (!localBitmap.isRecycled()))
            localBitmap.recycle();
        }
        else
        {
          this.mBitmaps = null;
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      j++;
    }
  }

  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (!this.init)
    {
      this.mArchor1 = 0;
      this.mArchor2 = this.width;
      this.mArchor3 = (getWidth() - this.width);
      this.mArchor4 = (getWidth() - 2 * this.width);
      this.mSrcRect = new Rect(0, (this.mOriginalHeight - this.itemHeight) / 2, this.width, (this.mOriginalHeight + this.itemHeight) / 2);
      this.init = true;
    }
    paramCanvas.clipRect(new Rect(0, 0, getWidth(), getHeight()));
    if (this.mArchor1 <= -this.width)
      this.mArchor1 = (2 * this.width + this.mArchor1);
    if (this.mArchor2 <= -this.width)
      this.mArchor2 = (2 * this.width + this.mArchor2);
    if (this.mArchor3 >= getWidth())
      this.mArchor3 = (-2 * this.width + this.mArchor3);
    if (this.mArchor4 >= getWidth())
      this.mArchor4 = (-2 * this.width + this.mArchor4);
    paramCanvas.drawBitmap(this.mBitmaps[0], this.mSrcRect, new Rect(this.mArchor1, 0, this.mArchor1 + this.width, this.itemHeight), this.mPaint);
    paramCanvas.drawBitmap(this.mBitmaps[1], this.mSrcRect, new Rect(this.mArchor2, 0, this.mArchor2 + this.width, this.itemHeight), this.mPaint);
    paramCanvas.drawBitmap(this.mBitmaps[2], this.mSrcRect, new Rect(this.mArchor3, this.itemHeight, this.mArchor3 + this.width, 2 * this.itemHeight), this.mPaint);
    paramCanvas.drawBitmap(this.mBitmaps[3], this.mSrcRect, new Rect(this.mArchor4, this.itemHeight, this.mArchor4 + this.width, 2 * this.itemHeight), this.mPaint);
    paramCanvas.drawBitmap(this.mBitmaps[4], this.mSrcRect, new Rect(this.mArchor1, 2 * this.itemHeight, this.mArchor1 + this.width, 3 * this.itemHeight), this.mPaint);
    paramCanvas.drawBitmap(this.mBitmaps[5], this.mSrcRect, new Rect(this.mArchor2, 2 * this.itemHeight, this.mArchor2 + this.width, 3 * this.itemHeight), this.mPaint);
    this.mArchor1 = (-2 + this.mArchor1);
    this.mArchor2 = (-2 + this.mArchor2);
    this.mArchor3 = (2 + this.mArchor3);
    this.mArchor4 = (2 + this.mArchor4);
    invalidate();
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.height = View.MeasureSpec.getSize(paramInt2);
    this.width = (7 * this.height / 3);
    this.itemHeight = (this.height / 3);
    setMeasuredDimension(paramInt1, View.MeasureSpec.makeMeasureSpec(this.height, 1073741824));
  }
}