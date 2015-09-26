package hackgt.com.fitme;

import android.app.Activity;
import android.content.Intent;
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
        Intent intent = new Intent(this, NewProfile.class);
        startActivity(intent);
       //  overridePendingTransition(R.anim.fadein, R.anim.fadeout);
       // overridePendingTransition(R.anim.fadein, R.anim.fadeout);
       // overridePendingTransition(R.anim.fadein, R.anim.fadeout);
    }
        // TypefaceUtil.overrideFont(getApplicationContext(), "SERIF", "fonts/Roboto-Thin.ttf");
        // setContentView(R.layout.newprofile);
       // overridePendingTransition(R.anim.fadein, R.anim.fadeout);
}
