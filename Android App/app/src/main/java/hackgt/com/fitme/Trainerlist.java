package hackgt.com.fitme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.reimaginebanking.api.java.models.Customer;

public class Trainerlist extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainerlist);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_trainerlist, menu);
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

    public final static String TRAINER_NAME = "trainerName";
    public final static String PRICE = "price";

    public void trainerOne(View view) {
        Intent intent = new Intent(this, CustomerPurchase.class);
        intent.putExtra(TRAINER_NAME, "Ethan");
        intent.putExtra(PRICE, "75");
        startActivity(intent);
    }

    public void trainerTwo(View view) {
        Intent intent = new Intent(this, CustomerPurchase.class);
        intent.putExtra(TRAINER_NAME, "Jessica");
        intent.putExtra(PRICE, "35");
        startActivity(intent);
    }

    public void trainerThree(View view) {
        Intent intent = new Intent(this, CustomerPurchase.class);
        intent.putExtra(TRAINER_NAME, "Jason");
        intent.putExtra(PRICE, "149");
        startActivity(intent);
    }

}
