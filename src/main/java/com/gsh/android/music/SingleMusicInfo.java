package com.gsh.android.music;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.view.ViewGroup.LayoutParams;
import android.widget.SimpleAdapter;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.gsh.android.music.R;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;


public class SingleMusicInfo extends PopupWindow {
    private View view;
    private TableLayout tableLayout;

    public SingleMusicInfo(Context context,Map<String, Object> map) {
        super(context);
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.singlemusicinfo, null);


        tableLayout = (TableLayout) view.findViewById(R.id.tablelayout);

        map.remove("bitmap");
        for(String keys : map.keySet()){
            TableRow tableRow = new TableRow(context);
            TextView key = new TextView(context);
            TextView value = new TextView(context);
            Log.i("MusicPlayerService", "SingleMusicInfo..........." + tableRow.hashCode());
            key.setText("   " + keys + "    ");
            value.setText(map.get(keys).toString());
            tableRow.addView(key);
            tableRow.addView(value);
            tableLayout.addView(tableRow);
        }

        this.setContentView(view);
        //设置弹出窗体的宽
        this.setWidth(LayoutParams.MATCH_PARENT);
        //设置弹出窗体的高
        this.setHeight(LayoutParams.WRAP_CONTENT);
        //设置S弹出窗体可点击
        this.setFocusable(true);
        //实例化一个ColorDrawable颜色为半透明

        ColorDrawable dw = new ColorDrawable(Color.rgb(255,228,181));
        //设置弹出窗体的背景
        this.setBackgroundDrawable(dw);
        view.setOnTouchListener(new OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {

                int height = view.findViewById(R.id.tablelayout).getTop();
                int y=(int) event.getY();
                if(event.getAction()==MotionEvent.ACTION_UP){
                    if(y<height){
                        dismiss();
                    }
                }
                return true;
            }
        });

    }
}
