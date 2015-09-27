package hackgt.com.fitme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class CustomerPurchase extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // This is how we get the string from the previous screen
        Intent intent = getIntent();
        String trainerName = intent.getStringExtra(Trainerlist.TRAINER_NAME);
        String price = intent.getStringExtra(Trainerlist.PRICE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_purchase);
        ((TextView) findViewById(R.id.tname)).setText(trainerName);
        ((TextView) findViewById(R.id.totalPay)).setText(price);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_customer_purchase, menu);
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
}
