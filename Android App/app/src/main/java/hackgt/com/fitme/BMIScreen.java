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

public class BMIScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // This is how we get the string from the previous screen
        Intent intent = getIntent();
        String bmi = intent.getStringExtra(NewProfile.BMI_KEY);

        super.onCreate(savedInstanceState);

        String res = "";
        if(Double.parseDouble(bmi) < 18.50) {
            res = "Underweight";
        } else if (Double.parseDouble(bmi) >= 18.50 && Double.parseDouble(bmi) <24.99) {
            res = "Healthy";
        }else if (Double.parseDouble(bmi) >= 24.99 && Double.parseDouble(bmi) <29.99) {
            res = "Overweight";
        }else if (Double.parseDouble(bmi) >=29.99) {
            res = "Obese";
        }
        setContentView(R.layout.bmi_screen_activity);
        ((TextView) findViewById(R.id.textView5)).setText(bmi);
        ((TextView) findViewById(R.id.resultbmi)).setText(res);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bmiscreen, menu);
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

    public void takeQuiz(View view) {
        Intent intent = new Intent(this, Survey.class);
        startActivity(intent);
    }

}
