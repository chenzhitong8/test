package com.heima.news.base;

import com.heima.news.MainActivity;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment {

	public View view;
	public Context ct;
	public SlidingMenu sm;

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		initData(savedInstanceState);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		ct = getActivity();
		//我们的fragment是在mainActivity中的，所以获得activity然后通过它得到滑动菜单
		sm = ((MainActivity)getActivity()).getSlidingMenu();
	}
  
	/**
	 * setContentView;
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = initView(inflater);

		return view;
	}
    public  View getRootView(){
    	return view;
    }
	/**
	 * 初始化view
	 */
	public abstract View initView(LayoutInflater inflater);

	/**
	 * 初始化数据
	 */
	public abstract void initData(Bundle savedInstanceState);

}
