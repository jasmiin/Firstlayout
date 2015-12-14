package com.marketboost.layout;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;

/**
 * Created by Z0NEN on 10/22/2014.
 */
public class menu1_Fragment extends Fragment {
    protected ImageSwitcher  imageSwitcher,imageSwitcher1,imageSwitcher2;
    Animation anim;
    private Handler handler;

    private int[] gallery = { R.drawable.i, R.drawable.j, R.drawable.k,
            R.drawable.l, R.drawable.m };

    private int position;

    private static final Integer DURATION = 10500;

    private Timer timer = null;
    View rootview;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.menu1_layout, container, false);
        imageSwitcher = (ImageSwitcher) rootview.findViewById(R.id.imageSwitcher);
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView myView = new ImageView(getActivity());
                myView.setScaleType(ImageView.ScaleType.FIT_XY);
                myView.setLayoutParams(new ImageSwitcher.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
                return myView;
            }
        });


        position = 0;
        startSlider();
        // Set animations()
        // http://danielme.com/2013/08/18/diseno-android-transiciones-entre-activities/
        Animation fadeIn = AnimationUtils.loadAnimation(getActivity(), R.anim.fade_in);
        Animation fadeOut = AnimationUtils.loadAnimation(getActivity(),R.anim.fade_out);
        imageSwitcher.setInAnimation(fadeIn);
        imageSwitcher.setOutAnimation(fadeOut);

        imageSwitcher1 = (ImageSwitcher) rootview.findViewById(R.id.imageSwitcher1);
        imageSwitcher1.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView myView = new ImageView(getActivity());
                myView.setScaleType(ImageView.ScaleType.FIT_XY);
                myView.setLayoutParams(new ImageSwitcher.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
                return myView;
            }
        });


        position = 0;
        startSlider1();
        // Set animations()
        // http://danielme.com/2013/08/18/diseno-android-transiciones-entre-activities/
        Animation slideIn = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_in_right);
        Animation slideOut = AnimationUtils.loadAnimation(getActivity(),R.anim.slide_out_left);
        imageSwitcher1.setInAnimation(slideIn);
        imageSwitcher1.setOutAnimation(slideOut);




        imageSwitcher2 = (ImageSwitcher) rootview.findViewById(R.id.imageSwitcher2);
        imageSwitcher2.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView myView = new ImageView(getActivity());
                myView.setScaleType(ImageView.ScaleType.FIT_XY);
                myView.setLayoutParams(new ImageSwitcher.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
                return myView;
            }
        });


        position = 0;
        startSlider2();
        // Set animations()
        // http://danielme.com/2013/08/18/diseno-android-transiciones-entre-activities/
        imageSwitcher2.setInAnimation(slideIn);
        imageSwitcher2.setOutAnimation(slideOut);
        return rootview;
    }
    // ////////////////////BUTTONS
    /**
     * starts or restarts the slider
     *
     * @param button
     */
    public void start(View button) {
        if (timer != null) {
            timer.cancel();
        }
        position = 0;
        startSlider();
    }

    public void stop(View button) {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }

    final boolean keepRunning1 = true;


    public void startSlider() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {
                while (keepRunning1) {

                    // Make the thread wait half a second. If you want...
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        Toast.makeText(getActivity().getApplicationContext(), "Default Signature Fail", Toast.LENGTH_LONG).show();
                        e.printStackTrace();
                    }

                    // here you check the value of getActivity() and break up if needed
                    if (getActivity() == null)
                        return;

                    // avoid exception:
                    // "Only the original thread that created a view hierarchy can touch its views"
                    getActivity().runOnUiThread(new Runnable() {
                        public void run() {
                            imageSwitcher.setImageResource(gallery[position]);
                            position++;
                            if (position == gallery.length) {
                                position = 0;
                            }
                        }
                    });
                }
            }
        }, 0, DURATION);


    }

    public void startSlider1() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {
                while (keepRunning1) {

                    // Make the thread wait half a second. If you want...
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        Toast.makeText(getActivity().getApplicationContext(), "Default Signature Fail", Toast.LENGTH_LONG).show();
                        e.printStackTrace();
                    }

                    // here you check the value of getActivity() and break up if needed
                    if (getActivity() == null)
                        return;

                    // avoid exception:
                    // "Only the original thread that created a view hierarchy can touch its views"
                    getActivity().runOnUiThread(new Runnable() {
                        public void run() {
                            imageSwitcher1.setImageResource(gallery[position]);
                            position++;
                            if (position == gallery.length) {
                                position = 0;
                            }
                        }
                    });
                }
            }
        }, 0, DURATION);


    }

    public void startSlider2() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {
                while (keepRunning1) {

                    // Make the thread wait half a second. If you want...
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        Toast.makeText(getActivity().getApplicationContext(), "Default Signature Fail", Toast.LENGTH_LONG).show();
                        e.printStackTrace();
                    }

                    // here you check the value of getActivity() and break up if needed
                    if (getActivity() == null)
                        return;

                    // avoid exception:
                    // "Only the original thread that created a view hierarchy can touch its views"
                    getActivity().runOnUiThread(new Runnable() {
                        public void run() {
                            imageSwitcher2.setImageResource(gallery[position]);
                            position++;
                            if (position == gallery.length) {
                                position = 0;
                            }
                        }
                    });
                }
            }
        }, 0, DURATION);


    }

}

