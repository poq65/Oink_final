package com.example.pc.testoink;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

/**
 * Created by samsung on 2017-10-06.
 */

public class FirstFragment extends Fragment {
    public FirstFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = (View) inflater.inflate(R.layout.fragment_first, container, false);

        GridView calender = (GridView)view.findViewById(R.id.grid_date);
        //MonthAdapter monthAdapter=new MonthAdapter(getActivity());

        calender.setAdapter(CalenderDialog.monthAdapter);
        CalenderDialog.monthAdapter.setPriviousMonth();
        CalenderDialog.monthAdapter.notifyDataSetChanged();

        TextView year=(TextView) view.findViewById(R.id.txt_year);
        TextView month=(TextView) view.findViewById(R.id.txt_month);

        Log.d("frag",Integer.toString(CalenderDialog.monthAdapter.getCurrentYear())
                +"   ,   "+Integer.toString(CalenderDialog.monthAdapter.getCurrentMonth()));

        year.setText(Integer.toString(CalenderDialog.monthAdapter.getCurrentYear()));
        month.setText(Integer.toString(CalenderDialog.monthAdapter.getCurrentMonth()));

        //calender.setAdapter(CalenderDialog.monthAdapter);

        Log.d("frag_txt",year.getText().toString()
                +"   ,   "+month.getText().toString());

        return view;
    }
}
