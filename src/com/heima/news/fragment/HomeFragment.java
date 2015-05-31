package com.heima.news.fragment;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.heima.news.R;
import com.heima.news.base.BaseFragment;
import com.heima.news.base.BasePage;
import com.heima.news.home.FunctionPage;
import com.heima.news.home.GovAffairsPage;
import com.heima.news.home.NewsCenterPage;
import com.heima.news.home.SettingPage;
import com.heima.news.home.SmartServicePage;
import com.heima.news.view.CustomViewPager;
import com.heima.news.view.LazyViewPager.OnPageChangeListener;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

public class HomeFragment extends BaseFragment {
	/**
	 * 1 初始化viewpager 通过使用adapter的形式去实现
	 */
	private View view;
	@ViewInject(R.id.viewpager)
	private CustomViewPager viewpager;
	@ViewInject(R.id.main_radio)
	private RadioGroup main_radio;
	private int checkedId = R.id.rb_function;

	@Override
	public View initView(LayoutInflater inflater) {
		view = inflater.inflate(R.layout.frag_home2, null);
//		viewpager = (CustomViewPager) view.findViewById(R.id.viewpager);
//		main_radio = (RadioGroup) view.findViewById(R.id.main_radio);
		 ViewUtils.inject(this, view); //注入view和事件
		return view;
	}

	List<BasePage> list = new ArrayList<BasePage>();;

	
	@Override
	public void initData(Bundle savedInstanceState) {
		
		list.add(new FunctionPage(ct));
		list.add(new NewsCenterPage(ct));
		list.add(new SmartServicePage(ct));
		list.add(new GovAffairsPage(ct));
		list.add(new SettingPage(ct));
		HomePageAdapter adapter = new HomePageAdapter(ct, list);
		viewpager.setAdapter(adapter);
		viewpager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int position) {
				//如果位置是0的话，才能出现滑动菜单。。如果是其他的tab出现的时候，滑动菜单就给屏蔽掉。
				if(0 ==position){
					sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
				}else{
					sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
				}
				BasePage page = list.get(position);
				page.initData();
			}
			
			@Override
			public void onPageScrolled(int position, float positionOffset,
					int positionOffsetPixels) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int state) {
				// TODO Auto-generated method stub
				
			}
		});
		main_radio.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
				case R.id.rb_function:
					viewpager.setCurrentItem(0, false);
					checkedId = 0;
					break;

				case R.id.rb_news_center:
					viewpager.setCurrentItem(1, false);
					checkedId = 1;
					break;
				case R.id.rb_smart_service:
					viewpager.setCurrentItem(2, false);
					checkedId = 2;
					break;
				case R.id.rb_gov_affairs:
					viewpager.setCurrentItem(3, false);
					checkedId = 3;
					break;
				case R.id.rb_setting:
					viewpager.setCurrentItem(4, false);
					checkedId = 4;
					break;
				}

			}
		});
		main_radio.check(checkedId);
	}

	class HomePageAdapter extends PagerAdapter {
		private Context ct;
		private List<BasePage> list;

		public HomePageAdapter(Context ct, List<BasePage> list) {
			this.ct = ct;
			this.list = list;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return list.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			// TODO Auto-generated method stub
			return arg0 == arg1;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			// TODO Auto-generated method stub
//			super.destroyItem(container, position, object);
			((CustomViewPager) container).removeView(list.get(position)
					.getRootView());

		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			((CustomViewPager) container).addView(list.get(position)
					.getRootView(), 0);
			return list.get(position).getRootView();
		}

	}
}
