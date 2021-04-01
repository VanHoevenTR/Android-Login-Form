package yt.mahmoudgaming.login;

import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Process;
import android.os.StrictMode;
import android.text.InputType;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import android.graphics.drawable.GradientDrawable;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;
import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;

import android.util.TypedValue;
import android.util.DisplayMetrics;

import android.animation.ArgbEvaluator;
import android.animation.TimeAnimator;
import android.animation.ValueAnimator;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.AlertDialog;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.text.Html;
import android.text.InputFilter;
import android.text.InputType;
import android.text.TextUtils;
import android.text.method.DigitsKeyListener;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;
import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.widget.RelativeLayout.ALIGN_PARENT_RIGHT;
import static android.widget.RelativeLayout.CENTER_HORIZONTAL;

import android.util.DisplayMetrics;

public class LoginForm {

    public static native String URL();

    public static native void Check();

    public static native String Login();

    public static native String Login2();

    RelativeLayout mRootContainer;
    LinearLayout.LayoutParams scrlLLExpanded, scrlLL;

    public static void Start(final Context context) {
        int SDK_INT = Build.VERSION.SDK_INT;
        if (SDK_INT > 8) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);

            //Create shared preferences to remember user and pass
            final SharedPreferences sharedPreferences = context.getSharedPreferences("SavePref", 0);
            String struser = sharedPreferences.getString("User", null);
            String strpass = sharedPreferences.getString("Pass", null);
            String strkey = sharedPreferences.getString("Key", null);
            Boolean rememberMe = sharedPreferences.getBoolean("RememberMe", false);

            //Create LinearLayout
            RelativeLayout relativeLayout2 = new RelativeLayout(context);
            relativeLayout2.setPadding(10, 3, 10, 3);
            relativeLayout2.setVerticalGravity(Gravity.CENTER);
            relativeLayout2.setBackgroundColor(0);

            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(LinearLayout.VERTICAL);
            GradientDrawable gradientdrawable = new GradientDrawable();
            gradientdrawable.setCornerRadius(18); //Set corner
            gradientdrawable.setColor(Color.parseColor("#1C2A35")); //Set background color
            gradientdrawable.setStroke(2, Color.parseColor("#32cb00")); //Set
            linearLayout.setBackground(gradientdrawable);

            //Create username edittext field
            TextView txt = new TextView(context);
            txt.setGravity(Gravity.CENTER);
            txt.setText(Login());
            txt.setTextColor(Color.WHITE);
            txt.setBackgroundColor(Color.TRANSPARENT);
            txt.setTextSize(20);

            TextView txt1 = new TextView(context);
            txt1.setGravity(Gravity.CENTER);
            txt1.setText(Login2());
            txt1.setTextColor(Color.GREEN);
            txt1.setBackgroundColor(Color.TRANSPARENT);
            txt1.setTextSize(10);

            TextView textView = new TextView(context);
            textView.setText("Set Username");
            textView.setGravity(Gravity.CENTER);
            textView.setTextSize(14.0f);
            textView.setTextColor(Color.WHITE);
            textView.setTypeface(null, Typeface.BOLD);
            textView.setPadding(0, 5, 0, 5);
            GradientDrawable gradientdrawable2 = new GradientDrawable();
            gradientdrawable2.setColor(Color.parseColor("#2F3D4C")); //Set background color
            gradientdrawable2.setStroke(2, Color.parseColor("#32cb00")); //Set
            textView.setBackground(gradientdrawable2);

            //Create username edittext field
            EditText editTextUser = new EditText(context);
            if (struser != null && !struser.isEmpty()) {
                editTextUser.setText(struser);
            }
            editTextUser.setHintTextColor(Color.parseColor("#444444"));
            editTextUser.setTextColor(Color.parseColor("#ffffff"));
            editTextUser.setHint("User");

            TextView textView2 = new TextView(context);
            textView2.setBackgroundColor(Color.parseColor("#2F3D4C"));
            textView2.setText("Set Key");
            textView2.setGravity(Gravity.CENTER);
            textView2.setTextSize(14.0f);
            textView2.setTextColor(Color.WHITE);
            textView2.setTypeface(null, Typeface.BOLD);
            textView2.setPadding(0, 5, 0, 5);
            GradientDrawable gradientdrawable3 = new GradientDrawable();
            gradientdrawable3.setColor(Color.parseColor("#2F3D4C")); //Set background color
            gradientdrawable3.setStroke(2, Color.parseColor("#32cb00")); //Set
            textView2.setBackground(gradientdrawable3);

            EditText editTextKey = new EditText(context);
            if (strkey != null && !strkey.isEmpty()) {
                editTextKey.setText(strkey);
            }
            editTextKey.setHintTextColor(Color.parseColor("#444444"));
            editTextKey.setTextColor(Color.parseColor("#ffffff"));
            editTextKey.setHint("Key");
            editTextKey.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

            TextView textView3 = new TextView(context);
            textView3.setBackgroundColor(Color.parseColor("#2F3D4C"));
            textView3.setText("Set Password");
            textView3.setGravity(Gravity.CENTER);
            textView3.setTextSize(14.0f);
            textView3.setTextColor(Color.WHITE);
            textView3.setTypeface(null, Typeface.BOLD);
            textView3.setPadding(0, 5, 0, 5);
            GradientDrawable gradientdrawable4 = new GradientDrawable();
            gradientdrawable4.setColor(Color.parseColor("#2F3D4C")); //Set background color
            gradientdrawable4.setStroke(2, Color.parseColor("#32cb00")); //Set
            textView3.setBackground(gradientdrawable4);

            //Create password edittext field
            EditText editTextPass = new EditText(context);
            if (strpass != null && !strpass.isEmpty()) {
                editTextPass.setText(strpass);
            }
            editTextPass.setHintTextColor(Color.parseColor("#444444"));
            editTextPass.setTextColor(Color.parseColor("#ffffff"));
            editTextPass.setHint("Password");
            editTextPass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

            //Create checkbox
            CheckBox checkSaveLogin = new CheckBox(context);
            checkSaveLogin.setPadding(0, 5, 0, 5);
            checkSaveLogin.setTextSize(18);
            checkSaveLogin.setChecked(rememberMe);
            checkSaveLogin.setTextColor(Color.rgb(255, 255, 255));
            checkSaveLogin.setText("Save Login");

            //Create username textView
            final TextView textStatus = new TextView(context);
            textStatus.setGravity(Gravity.CENTER_HORIZONTAL);
            textStatus.setTextColor(Color.rgb(255, 255, 255));
            textStatus.setTextSize(14.0f);
            textStatus.setTypeface(null, Typeface.BOLD);
            textStatus.setPadding(0, 5, 0, 5);
            textStatus.setText("Awaiting login!");
            GradientDrawable gradientdrawable5 = new GradientDrawable();
            gradientdrawable5.setColor(Color.parseColor("#2F3D4C")); //Set background color
            gradientdrawable5.setStroke(2, Color.parseColor("#32cb00")); //Set
            textStatus.setBackground(gradientdrawable5);

            //Create btnLogin
            final Button btnLogin = new Button(context);
            btnLogin.setTextColor(Color.rgb(255, 255, 255));
            btnLogin.setText("Login");
            btnLogin.setBackgroundColor(Color.TRANSPARENT);

            //Add views
            //relativeLayout2.addView(linearLayout);
            linearLayout.addView(txt);
            linearLayout.addView(txt1);
            linearLayout.addView(textView);
            linearLayout.addView(editTextUser);
            linearLayout.addView(textView2);
            linearLayout.addView(editTextKey);
            linearLayout.addView(textView3);
            linearLayout.addView(editTextPass);
            linearLayout.addView(checkSaveLogin);
            linearLayout.addView(textStatus);
            linearLayout.addView(btnLogin);

            //Create alertdialog
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setCancelable(false);
            builder.setView(linearLayout);

            AlertDialog show = builder.show();
            final EditText editText3 = editTextUser;
            final EditText editText5 = editTextKey;
            final EditText editText4 = editTextPass;
            final CheckBox checkSaveLogin2 = checkSaveLogin;
            final AlertDialog alertDialog = show;


            btnLogin.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                        textStatus.setTextColor(Color.parseColor("#ffffff"));
                        textStatus.setText("logging in...");
                        textStatus.setTextSize(13);
                    } else if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    }
                    return false;
                }
            });

            //Request PHP when pressing login button
            btnLogin.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    String user = editText3.getText().toString().trim();
                    String key = editText5.getText().toString().trim();
                    String pass = editText4.getText().toString().trim();

                    boolean isChecked = checkSaveLogin2.isChecked();
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    if (isChecked) {
                        edit.putString("User", user);
                        edit.putString("Key", key);
                        edit.putString("Pass", pass);
                    } else {
                        edit.clear();
                    }
                    edit.putBoolean("RememberMe", isChecked);
                    edit.apply();

                    try {
                        String[] result = this.login(user, pass, key);
                        String status = result[0];
                        String hashS = result[1];
                        String MsgS = result[2];
                        String hashL = this.MD5_Hash(user + pass + key);

                        if (status.equals("1") && hashS.equals(hashL)) {
                            alertDialog.dismiss();
                            // Check();
                            Toast.makeText(context, MsgS, Toast.LENGTH_LONG).show();
                        } else {
                            textStatus.setTextColor(Color.rgb(255, 255, 0));
                            textStatus.setText(MsgS);
                        }
                    } catch (Exception e) {
                        textStatus.setTextColor(Color.rgb(200, 20, 20));
                        textStatus.setText(e.getMessage());
                    }
                }

                public String[] login(String user, String pass, String key) throws IOException {
                    OkHttpClient client = new OkHttpClient();
                    RequestBody formBody = new FormBody.Builder()
                            .add("user", user)
                            .add("key", key)
                            .add("pass", pass)
                            .build();

                    //URL to request
                    Request request = new Request.Builder()
                            .url(URL())
                            .post(formBody)
                            .build();

                    Response response = client.newCall(request).execute();
                    String res = response.body().string();

                    return res.split("\\|");
                }

                public String MD5_Hash(String s) {
                    MessageDigest m = null;

                    try {
                        m = MessageDigest.getInstance("MD5");
                    } catch (NoSuchAlgorithmException e) {
                        e.printStackTrace();
                    }

                    m.update(s.getBytes(), 0, s.length());
                    String hash = new BigInteger(1, m.digest()).toString(16);
                    return hash;
                }
            });

        }
    }
}

