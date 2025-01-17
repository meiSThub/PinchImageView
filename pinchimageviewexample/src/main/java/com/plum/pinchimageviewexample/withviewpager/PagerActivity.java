package com.plum.pinchimageviewexample.withviewpager;

import android.app.Activity;
import android.os.Bundle;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.plum.pinchimageview.PinchImageView;
import com.plum.pinchimageviewexample.Global;
import com.boycy815.pinchimageviewexample.R;
import com.plum.pinchimageviewexample.images.ImageSource;
import com.nostra13.universalimageloader.core.DisplayImageOptions;

import java.util.LinkedList;


public class PagerActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager);

        final LinkedList<PinchImageView> viewCache = new LinkedList<PinchImageView>();
        final DisplayImageOptions thumbOptions = new DisplayImageOptions.Builder().resetViewBeforeLoading(true).cacheInMemory(true).build();
        final DisplayImageOptions originOptions = new DisplayImageOptions.Builder().build();

        final ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return Global.getTestImagesCount();
            }

            @Override
            public boolean isViewFromObject(View view, Object o) {
                return view == o;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                PinchImageView piv;
                if (viewCache.size() > 0) {
                    piv = viewCache.remove();
                    piv.reset();
                } else {
                    piv = new PinchImageView(PagerActivity.this);
                }
                ImageSource image = Global.getTestImage(position);
                Global.getImageLoader(getApplicationContext()).displayImage(image.getThumb(100, 100).url, piv, thumbOptions);
                container.addView(piv);
                return piv;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                PinchImageView piv = (PinchImageView) object;
                container.removeView(piv);
                viewCache.add(piv);
            }

            @Override
            public void setPrimaryItem(ViewGroup container, int position, Object object) {
                PinchImageView piv = (PinchImageView) object;
                ImageSource image = Global.getTestImage(position);
                Global.getImageLoader(getApplicationContext()).displayImage(image.getThumb(1000, 1000).url, piv, originOptions);
            }
        });
    }
}