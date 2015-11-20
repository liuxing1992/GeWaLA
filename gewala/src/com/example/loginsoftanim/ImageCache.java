package com.example.loginsoftanim;

import java.lang.ref.SoftReference;
import java.util.HashMap;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
/**
 * 图片的内部缓存
 * @author Administrator
 *
 */
public class ImageCache {

	/**
	 * 最近最少使用删除
	 */
	private LruCache<String, Bitmap> memoryCache;
	
	private HashMap<String, SoftReference<Bitmap>> secondCache;
	
	private  static ImageCache imageCache;

	private SoftReference<Bitmap> softReference;
	
	
	
	private  ImageCache() {
		/**
		 * 最大支持字节数
		 */
			int maxSize=(int) (Runtime.getRuntime().maxMemory()/8);
			memoryCache=new LruCache<String, Bitmap>(maxSize){
				@Override
				protected int sizeOf(String key, Bitmap value) {
					
					return value.getByteCount();
				}
			};
			
			secondCache=new HashMap<String, SoftReference<Bitmap>>();
			
			//sdCardCache=new SDCardCache();
	} 
	public static ImageCache getInstance(){
		
		if (imageCache==null) {
			imageCache=new ImageCache();
		}
		return imageCache;
	}

	public void putBitmap(String url,Bitmap bitmap){
		
		if (url!=null&&bitmap!=null) {
			memoryCache.put(url, bitmap);
			
			secondCache.put(url, new SoftReference<Bitmap>(bitmap));//添加二级（软引用）缓存
			
			//sdCardCache.writeBitmapByPath(url, "listCache", bitmap);
		}
	} 
	public Bitmap getBitmap(String url){
		Bitmap bitmap=null;
		if (url!=null) {
			bitmap=memoryCache.get(url);
			if (bitmap==null) {
				softReference = secondCache.get(url);		
				if (softReference!=null) {
					bitmap=softReference.get();
				}
			}
		}
		
		return bitmap;		
	}
	
}
