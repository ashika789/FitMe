package hackgt.com.fitme;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class NewProfile extends Activity {

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

    // You need a way to reference the BMI in the next class.
    // We do this by referencing a "key" that is associated with the message we sent to that class.
    public final static String BMI_KEY = "bmi";

    public void calcBMI(View view) {

        // Calculate BMI
        double heightFeet = Double.parseDouble(((EditText) findViewById(R.id.heightFeet)).getText().toString());
        double heightInches = Double.parseDouble(((EditText) findViewById(R.id.heightInches)).getText().toString());
        double weight = Double.parseDouble(((EditText) findViewById(R.id.weight)).getText().toString());
        double height = heightInches + heightFeet * 12;
        double bmi = (weight * .45) / Math.pow((height * .025), 2);

        // Create new intent for next class
        Intent intent = new Intent(this, BMIScreen.class);

        String bmiMessage = "" + bmi;

        // putExtra is basically mapping a string with a value in the intent, and this intent
        // is passed into the next class.
        // To access it, we just need to get the intent and get(BMI_KEY).
        intent.putExtra(BMI_KEY, bmiMessage);

        startActivity(intent);
    }

}
