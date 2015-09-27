package hackgt.com.fitme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class NewProfile extends Activity {

    public final static String BMI_KEY = "bmi";

    public NewProfile() {

    }

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

        // Calculate BMI
        double heightFeet = Double.parseDouble(((EditText) findViewById(R.id.heightFeet)).getText().toString());
        double heightInches = Double.parseDouble(((EditText) findViewById(R.id.heightInches)).getText().toString());
        double weight = Double.parseDouble(((EditText) findViewById(R.id.weight)).getText().toString());
        double height = heightInches + heightFeet * 12;
        double bmi = (weight * .45) / Math.pow((height * .025), 2);
        bmi = ((int) ((bmi * 10) + .5)) / 10.0; // Round it to nearest tenth
        String bmiMessage = "" + bmi;

        // Create new intent for next class
        Intent intent = new Intent(this, BMIScreen.class);
        intent.putExtra(BMI_KEY, bmiMessage);
        startActivity(intent);
    }
}