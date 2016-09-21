package com.chiigu.bottomnavigationbarsamples;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.ashokvarma.bottomnavigation.BadgeItem;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

public class MainActivity extends AppCompatActivity {

    private final static String TAG="MainActivity";
    private BottomNavigationBar bottom_navigation_bar;
    private LinearLayout fl_content;
    private BadgeItem badge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        initBottomNavigationBar();
    }

    private void initBottomNavigationBar() {

        bottom_navigation_bar.setMode(BottomNavigationBar.MODE_SHIFTING);
        bottom_navigation_bar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE);
        //设置默认颜色
        bottom_navigation_bar
                .setInActiveColor(R.color.colorInActive)//设置未选中的Item的颜色，包括图片和文字
                .setActiveColor(R.color.colorPrimary)
                .setBarBackgroundColor(R.color.colorBarBg);//设置整个控件的背景色
        //设置徽章
        badge=new BadgeItem()
//                .setBorderWidth(2)//Badge的Border(边界)宽度
//                .setBorderColor("#FF0000")//Badge的Border颜色
//                .setBackgroundColor("#9ACD32")//Badge背景颜色
//                .setGravity(Gravity.RIGHT| Gravity.TOP)//位置，默认右上角
                .setText("2")//显示的文本
//                .setTextColor("#F0F8FF")//文本颜色
//                .setAnimationDuration(2000)
//                .setHideOnSelect(true)//当选中状态时消失，非选中状态显示
        ;
        //添加选项
        bottom_navigation_bar.addItem(new BottomNavigationItem(R.mipmap.ic_directions_run_white_24dp, "步行"))
                .addItem(new BottomNavigationItem(R.mipmap.ic_directions_bike_white_24dp, "骑行").setBadgeItem(badge))
                .addItem(new BottomNavigationItem(R.mipmap.ic_local_airport_black_24dp, "公交").setInactiveIcon(ContextCompat.getDrawable(this,R.mipmap.ic_directions_bus_white_24dp)))
                .addItem(new BottomNavigationItem(R.mipmap.ic_directions_car_white_24dp, "自驾"))
                .addItem(new BottomNavigationItem(R.mipmap.ic_directions_railway_white_24dp, "火车"))
                .initialise();//初始化BottomNavigationButton,所有设置需在调用该方法前完成
        bottom_navigation_bar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {//未选中 -> 选中
            }

            @Override
            public void onTabUnselected(int position) {//选中 -> 未选中
            }

            @Override
            public void onTabReselected(int position) {//选中 -> 选中
            }
        });

    }

    public void hide(View view){
        bottom_navigation_bar.hide();
    }
    public void show(View view){
        bottom_navigation_bar.unHide();
        badge.toggle();
        Snackbar.make(bottom_navigation_bar,"你好啊",Snackbar.LENGTH_SHORT).show();
    }



    private void findView(){
        fl_content = (LinearLayout) findViewById(R.id.fl_content);
        bottom_navigation_bar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
    }
}
