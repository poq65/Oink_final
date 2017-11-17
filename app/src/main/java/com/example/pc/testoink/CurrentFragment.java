package com.example.pc.testoink;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

/**
 * Created by Leeyerin on 2017. 10. 28..
 */

public class CurrentFragment extends Fragment {

    public CurrentFragment(){  }


    static public GridView calender;
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState)
    {
        View view = (View) inflater.inflate(R.layout.fragment_current, container, false);

        calender = (GridView)view.findViewById(R.id.grid_date);
        //MonthAdapter monthAdapter=new MonthAdapter(getActivity());

        calender.setAdapter(CalenderDialog.monthAdapter);



        TextView year=(TextView) view.findViewById(R.id.txt_year_Current);
        final TextView month=(TextView) view.findViewById(R.id.txt_month_Current);

        Log.d("frag",Integer.toString(CalenderDialog.monthAdapter.getCurrentYear())
                +"   ,   "+Integer.toString(CalenderDialog.monthAdapter.getCurrentMonth()));

        year.setText(Integer.toString(CalenderDialog.monthAdapter.getCurrentYear()));
        month.setText(Integer.toString(CalenderDialog.monthAdapter.getCurrentMonth()));






        calender.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //showCostom(this,position);
                // 전화면
                Intent intent = new Intent(getContext(),MainActivity.class);
                //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                String setDate =CalenderDialog.monthAdapter.getCurrentYear() + "-" +
                        CalenderDialog.monthAdapter.getCurrentMonth()+"-"+ CalenderDialog.monthAdapter.items[position].date;
                MainActivity.intent_setDate = setDate;

                Log.d("day","day :" + CalenderDialog.monthAdapter.getCurrentDate());

                getContext().startActivity(intent);






            }
        });


        return view;
    }




}
