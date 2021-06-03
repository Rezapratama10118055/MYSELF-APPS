package com.example.myselfapps.Viewpages;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.myselfapps.R;

public class slideAdapter extends PagerAdapter {
  Context context;
  LayoutInflater layoutInflater;

  public slideAdapter(Context context){
      this.context=context;
  }
  public int[] slide_gambar = {
          R.drawable.reading,
          R.drawable.book,
          R.drawable.man
  };
  public String[] slide_judul = {
     "MYSELF APPS",
     "FITUR",
     "PENJELASAN"
  };
  public String[] slide_doc = {
    "Adalah suatu aplikasi buatan saya sendiri yang terdiri dari beberapa icon atau fungsi untuk mengenal saya lebih dalam.",
          " Di aplikasi myself apps terdapat fitur Home, Daily Acitivty, Gallery, Music Favorite & Video, Profile ",
          "Aplikasi MYSELF adalah suatu aplikasi yang dirancang untuk memenuhi tugas uts akb saya - REZA PRATAMA  "
  };

    @Override
    public int getCount() {
        return slide_judul.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }

  @NonNull
  @Override
  public Object instantiateItem(@NonNull ViewGroup container, int position) {
     layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
     View view = layoutInflater.inflate(R.layout.card_pageview,container,false);

    ImageView slidegambar = (ImageView) view.findViewById(R.id.imagewr);
    TextView slidejudul = (TextView) view.findViewById(R.id.heding);
    TextView slidedoc = (TextView) view.findViewById(R.id.silde_doc);

    slidegambar.setImageResource(slide_gambar[position]);
    slidejudul.setText(slide_judul[position]);
    slidedoc.setText(slide_doc[position]);

    container.addView(view);
    return view;

  }

  @Override
  public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
    container.removeView((RelativeLayout)object);
  }
}
