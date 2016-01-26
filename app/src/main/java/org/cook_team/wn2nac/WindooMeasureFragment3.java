package org.cook_team.wn2nac;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.NumberPicker;
import android.widget.TextView;

public class WindooMeasureFragment3 extends android.support.v4.app.Fragment {

    //private static EventBus bus = EventBus.getDefault();

    CheckBox checkBox;
    TextView textViewTime;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //if (!bus.isRegistered(this)) bus.register(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_windoo_measure_3, container, false);

        checkBox = (CheckBox) rootView.findViewById(R.id.checkBox);
        textViewTime = (TextView) rootView.findViewById(R.id.textViewTime);
        textViewTime.setText("測量時間長度: " + String.format("%02d",Wn2nacMeasure.min) + "分" + String.format("%02d",Wn2nacMeasure.sec) + "秒");

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        //if (!bus.isRegistered(this)) bus.register(this);
    }

    @Override
    public void onPause() {
        //bus.unregister(this);
        super.onPause();
    }

}