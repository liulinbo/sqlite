package com.nimos.sqlite.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nimos.sqlite.R;



public class ThreeFragment extends Fragment{
      public ThreeFragment() {
      }

      @Override
      public View onCreateView(LayoutInflater inflater, ViewGroup container,
              Bundle savedInstanceState) {
          View rootView = inflater.inflate(R.layout.fragment_three, container, false);
          return rootView;
      }
}