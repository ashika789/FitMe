package hackgt.com.fitme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;

public class Survey extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // getMenuInflater().inflate(R.menu.menu_survey, menu);
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

    public void selectTrainer(View view) {
        // Save form information in SurveyAnswers class
        SurveyAnswers record = SurveyAnswers.getInstance();
        int index = ((RadioGroup) findViewById(R.id.fitnessLevel)).indexOfChild(findViewById(((RadioGroup) findViewById(R.id.fitnessLevel)).getCheckedRadioButtonId()));
        record.setFitnessLevel(index);
        index = ((RadioGroup) findViewById(R.id.goals)).indexOfChild(findViewById(((RadioGroup) findViewById(R.id.goals)).getCheckedRadioButtonId()));
        record.setGoalLevel(index);
        index = ((RadioGroup) findViewById(R.id.weightsOrCardio)).indexOfChild(findViewById(((RadioGroup) findViewById(R.id.weightsOrCardio)).getCheckedRadioButtonId()));
        record.setCardioOrWeightsPreference(index);

        //TODO: make sure this is properly read - currently always returns true
        boolean arms = ((CheckBox) findViewById(R.id.arms)).isChecked();
        boolean legs = ((CheckBox) findViewById(R.id.arms)).isChecked();
        boolean back = ((CheckBox) findViewById(R.id.arms)).isChecked();
        boolean shoulders = ((CheckBox) findViewById(R.id.arms)).isChecked();
        boolean chest = ((CheckBox) findViewById(R.id.arms)).isChecked();
        boolean core = ((CheckBox) findViewById(R.id.arms)).isChecked();
        boolean[] targetAreas = {arms, legs, back, shoulders, chest, core};
        record.setTargetAreas(targetAreas);

        // Open up next screen
        Intent intent = new Intent(this, Trainerlist.class);
        startActivity(intent);
    }
}