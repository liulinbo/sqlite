package com.nimos.sqlite.fragment.adapter;

import java.util.List;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;


public class MainFragmentAdapter extends FragmentPagerAdapter{
	
	private List<Fragment> fragments; 
	private List<String> titles;
	public MainFragmentAdapter(FragmentManager fm) {
		super(fm);
	}
	public MainFragmentAdapter(FragmentManager fm, List<Fragment> fragments,List<String> titles) {  
        super(fm);  
        this.fragments = fragments;  
        this.titles = titles;
    }  
	@Override
	public Fragment getItem(int position) {
		if(fragments!=null&&position<fragments.size()){
			return fragments.get(position);
		}else{
			return null;
		}
	}

	@Override
	public int getCount() {
		if(fragments!=null){
			return fragments.size();
		}else{ 
			return 0;
		}
	}
	
	 @Override
     public CharSequence getPageTitle(int position) {
		 if(titles!=null&&position<fragments.size()){
			 return titles.get(position);
		 }else{
			 return null;
		 }
     }
}