package hackgt.com.fitme;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class NewProfile extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newprofile);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_new_profile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void calcBMI(View view) {

        double heightFeet = Double.parseDouble(((EditText) findViewById(R.id.heightFeet)).getText().toString());
        double heightInches = Double.parseDouble(((EditText) findViewById(R.id.heightInches)).getText().toString());
        double weight = Double.parseDouble(((EditText) findViewById(R.id.weight)).getText().toString());

        double height = heightInches + heightFeet * 12;
        double bmi = (weight * .45) / Math.pow((height * .025), 2);

        System.out.println(bmi);
    }
}
