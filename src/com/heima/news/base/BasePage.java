package com.heima.news.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

public abstract class BasePage {
   private View view;
   public Context ct;
/**
    * 1 。画界面
    * 2    初始化数据
    */
	public BasePage(Context ct) {
		//一个普通类要设置界面必须要有context传递进来通过这个context可以获得inflater对象然后通过这个对象可以设置初始化view
		this.ct = ct;
		/*LayoutInflater.from(ct).inflate(2, null);这两种都是可以的就是用到上下文*/
		LayoutInflater inflater = (LayoutInflater)ct.getSystemService(
			      Context.LAYOUT_INFLATER_SERVICE);
		view = initView(inflater);
	}
	public  View getRootView(){
    	return view;
    }
	public abstract View initView(LayoutInflater inflater);
    
	public abstract void initData();
}
