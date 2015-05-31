package com.heima.news.fragment;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.heima.news.MainActivity;
import com.heima.news.R;
import com.heima.news.base.BaseFragment;

public class MenuFragment2 extends BaseFragment {



	@Override
	public View initView(LayoutInflater inflater) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void initData(Bundle savedInstanceState) {
		ListView list_view = (ListView) view.findViewById(R.id.list_view);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1, android.R.id.text1,
				initData());
		list_view.setAdapter(adapter);
		list_view.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Fragment f  = null;
				switch (position) {
				case 0:
					f  =new Fragment1();
					break;
					
				case 1:
					f  =new Fragment2();
					break;
				case 2:
					f  =new Fragment3();
					break;
				case 3:
					f  =new Fragment4();
					break;
				case 4:
					f  =new Fragment5();
					break;
				}
		        switchFragment(f);
				
			}
		});

	}
	private void switchFragment(Fragment f) {
		// TODO Auto-generated method stub
		if(f != null){
			//如果你的这个fragment被加到activity里了，获得activity就是和你生命周期相关的这个activity
			if(getActivity() instanceof MainActivity){
				((MainActivity)getActivity()).switchFragment(f);
			}
		}
	}
	private List<String> initData() {
		List<String> list = new ArrayList<String>();
		list.add("fragment1");
		list.add("fragment2");
		list.add("fragment3");
		list.add("fragment4");
		list.add("fragment5");
		return list;
	}
	
	

}
