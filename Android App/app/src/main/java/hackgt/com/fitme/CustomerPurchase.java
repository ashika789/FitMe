package hackgt.com.fitme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.reimaginebanking.api.java.models.Account;
import com.reimaginebanking.api.java.models.Customer;

public class CustomerPurchase extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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

    public void makePayment(View view) {


        Intent intent = new Intent(this, ClosingScreen.class);
        startActivity(intent);
    }

    public void paymentProcess(View view) {
        //USING NESSIE CLIENT
        // Parse information
        String firstName = ((EditText) findViewById(R.id.firstName)).getText().toString();
        String lastName = ((EditText) findViewById(R.id.lastName)).getText().toString();
        String state = ((EditText) findViewById(R.id.state)).getText().toString();
        String streetNumber = ((EditText) findViewById(R.id.streetNumber)).getText().toString();
        String streetName = ((EditText) findViewById(R.id.streetName)).getText().toString();
        String city = ((EditText) findViewById(R.id.city)).getText().toString();
        String zip = ((EditText) findViewById(R.id.zip)).getText().toString();
        String ccn = ((EditText) findViewById(R.id.ccn)).getText().toString();

        // Store customer / account information
        ExternalOps nessieClient = new ExternalOps();
        nessieClient.createCustomer(state, streetNumber, streetName, city, zip, firstName, lastName);
        nessieClient.uploadCustomer();
        nessieClient.createAccount();
        nessieClient.uploadAccount();

        // Get trainer information - already on bank website
        String trainerName = ((TextView) findViewById(R.id.tname)).getText().toString();
        String price = ((TextView) findViewById(R.id.totalPay)).getText().toString();
        Customer trainer = nessieClient.getTrainerCustomer(trainerName);
         Account trainerAccount = nessieClient.getAccount(trainer);
        Log.d("APP USER: ", "$$$$$$$: " + nessieClient.getClientAccount().getBalance());
        Log.d("TRAINER : ", "$$$$$$$: "+ nessieClient.getTrainerAccount().getBalance());

        // Make the transfer
        nessieClient.makeTransfer(Double.parseDouble(price));

        Log.d("TRAINER : ", "$$$$$$$: "+ nessieClient.getTrainerAccount().getBalance());
        Log.d("APP USER: ", "$$$$$$$: " + nessieClient.getClientAccount().getBalance());
    }
}
