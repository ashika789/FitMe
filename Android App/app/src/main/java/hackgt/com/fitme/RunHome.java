package hackgt.com.fitme;

import android.app.Activity;
import android.os.Bundle;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

public class RunHome extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

    }

    public void getProfile(View view) {
       // overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.newprofile);
       // overridePendingTransition(R.anim.fadein, R.anim.fadeout);
    }

    public void bmiResults(View view) {
        // overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.bmi_screen);
        // overridePendingTransition(R.anim.fadein, R.anim.fadeout);
    }

//    public void surveyScreen(View view) {
//        // overridePendingTransition(R.anim.fadein, R.anim.fadeout);
//        setContentView(R.layout.bmi_screen);
//        // overridePendingTransition(R.anim.fadein, R.anim.fadeout);
//    }
}
