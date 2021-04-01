package yt.mahmoudgaming.login;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.graphics.Color;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.animation.TimeAnimator;
import android.graphics.drawable.GradientDrawable;
import android.widget.RelativeLayout;
import android.widget.LinearLayout;

public class MainActivity extends Activity {
    static {
        //Load lib file

        // When you change the lib name, change also on Android.mk file
        // Both must have same name
        System.loadLibrary("MahmoudAlaa");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LoginForm.Start(this);
		
    }
}
