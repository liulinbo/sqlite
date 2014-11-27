package com.nimos.sqlite.fragment;

import java.util.List;

import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.FinalDb;
import net.tsz.afinal.annotation.view.ViewInject;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.nimos.sqlite.R;
import com.nimos.sqlite.bean.User;

public class OneFragment extends Fragment implements OnClickListener {
	@ViewInject(id=R.id.button_add,click="onClick") 
	Button mAddBtn;
	@ViewInject(id=R.id.button_delete,click="onClick") 
	Button mDeleteBtn;
	@ViewInject(id=R.id.button_update,click="onClick") 
	Button mUpdateBtn;
	@ViewInject(id=R.id.button_query,click="onClick") 
	Button mQueryBtn;
	
	@ViewInject(id=android.R.id.list) 
	ListView mListView;
	
	private FinalDb finalDb;
	public OneFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_one, container,
				false);
//		mListView = (ListView)rootView.findViewById(android.R.id.list);
		FinalActivity.initInjectedView(this, rootView);
		return rootView;
	}

	@Override
	public void onClick(View v) {
		if(finalDb==null){
			finalDb = FinalDb.create(this.getActivity());
		}
		switch(v.getId()){
			case R.id.button_add:
				User user = new User();
		        user.setAge(11);
		        user.setName("wanghb");
		        user.setDepartment("SoftDepartment");
		        finalDb.save(user);
				break;
			case R.id.button_delete:
//				finalDb.deleteAll(User.class);
//				finalDb.dropTable(User.class);
				break;
			case R.id.button_update:
				User u=finalDb.findById(1, User.class);
				u.setName(u.getName()+" New");
				finalDb.update(u);
				break;
			case R.id.button_query:
				String[] str;
				
				List<User> userList = finalDb.findAll(User.class);
				str=new String[userList.size()];
				User uer;
				for(int i=0;i<userList.size();++i){
					uer=userList.get(i);
					str[i]="ID:"+uer.getId()+"|Name:"+uer.getName()+"|Age:"+uer.getAge();
				}
				ListAdapter adater=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_expandable_list_item_1,str);
				mListView.setAdapter(adater);
				break;
		}
	}
}