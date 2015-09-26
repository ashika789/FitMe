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
//        double height = ;
//        double weight = ;
        setContentView(R.layout.newprofile);
    }
}
