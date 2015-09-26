package hackgt.com.fitme;

import android.app.Activity;
import android.os.Bundle;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.TextView;
public class RunHome extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TypefaceUtil.overrideFont(getApplicationContext(), "SERIF", "fonts/Roboto-Thin.ttf");
        setContentView(R.layout.home);

    }

    public void getProfile(View view) {
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
       // overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        TypefaceUtil.overrideFont(getApplicationContext(), "SERIF", "fonts/Roboto-Thin.ttf");
        setContentView(R.layout.newprofile);
       // overridePendingTransition(R.anim.fadein, R.anim.fadeout);
    }

    public void bmiResults(View view) {
        TypefaceUtil.overrideFont(getApplicationContext(), "SERIF", "fonts/Roboto-Thin.ttf");
//        TextView tv1 = (TextView) findViewById(R.id.bmiVal);
//        NewProfile calc = new NewProfile();
//        String toSet = calc.calcBMI();
        setContentView(R.layout.bmi_screen);
//        tv1.setText(toSet);
    }

//    public void surveyScreen(View view) {
//        // overridePendingTransition(R.anim.fadein, R.anim.fadeout);
//        setContentView(R.layout.bmi_screen);
//        // overridePendingTransition(R.anim.fadein, R.anim.fadeout);
//    }
}
