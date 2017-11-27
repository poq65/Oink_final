package com.iswu.pc.testoink;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.iswu.pc.testoink.R;

public class CalenderDialog extends AppCompatActivity {

    public static MonthAdapter monthAdapter;
    static public int finish = 0;
    private TextView month, year;
    private ImageView pig;
    private ViewPager vp;


    static private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender_dialog);

        monthAdapter = new MonthAdapter(this);

        context = getApplicationContext();


        pig=(ImageView)findViewById(R.id.img_pig);

        // 돼지눌렀을시 일일 설정액 설정
        pig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),DailyMoneySet.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });

        vp=(ViewPager)findViewById(R.id.vp_calender);
        vp.setAdapter(new pageAdapter(getSupportFragmentManager()));
        vp.setCurrentItem(50000);



    }

    //backey 설정
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {


        if(event.getKeyCode() == KeyEvent.KEYCODE_BACK){

            // 전화면
            Intent intent = new Intent(getApplicationContext(),//현재화면의
                    MainActivity.class);//다음 넘어갈 클래스 지정

            startActivity(intent);//다음 화면으로 넘어간다
            finish();
        }
        return true;

    }

}
