package com.darshan.experimental;

import android.app.Activity;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.transition.Visibility;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final FrameLayout linearLayout = (FrameLayout) findViewById(R.id.parent);
        Button b = (Button) findViewById(R.id.button);
        final TextView ch = (TextView) findViewById(R.id.check);
        //ch.setAlpha(0);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch.getVisibility() == View.GONE) {
                    ch.setVisibility(View.VISIBLE);
                   // ch.setAlpha(1);
                }
                else {
                    ch.setVisibility(View.GONE);
                    //ch.setAlpha(0);
                }
                TransitionSet transitionSet = new TransitionSet();
                Fade fade = new Fade(Fade.IN);
                fade.setDuration(3000);
                fade.setStartDelay(300);
                Slide slide = new Slide(Gravity.RIGHT);
                slide.setMode(Visibility.MODE_IN);
                slide.setDuration(2000);
                ChangeBounds cb = new ChangeBounds();
               // cb.setDuration(3000);
                transitionSet.addTransition(cb);
                transitionSet.addTransition(fade);
                //transitionSet.addTransition(slide);
                //transitionSet.setOrdering(TransitionSet.ORDERING_TOGETHER);
                TransitionManager.beginDelayedTransition(linearLayout, transitionSet);
            }
        });
    }
}
