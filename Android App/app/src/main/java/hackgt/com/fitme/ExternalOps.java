package hackgt.com.fitme;

import android.util.Log;

import com.reimaginebanking.api.java.NessieClient;
import com.reimaginebanking.api.java.NessieException;
import com.reimaginebanking.api.java.NessieResultsListener;
import com.reimaginebanking.api.java.models.Customer;

import java.util.ArrayList;

/**
 * Created by Siddarth on 9/26/2015.
 */
public class ExternalOps {

    private NessieClient nessieClient;
    private String API_KEY = "3f6923379b0ab8da8553b1a421d13423";
    private ArrayList<Customer> trainers;

    public ExternalOps() {
        nessieClient = NessieClient.getInstance();
        nessieClient.setAPIKey(API_KEY);
        trainers = new ArrayList<>();
    }

    public static String chooseExerciseList() {
        return "";
    }

    public boolean setTrainers() {
        nessieClient.getCustomers(new NessieResultsListener(){
            @Override
            public void onSuccess(Object result, NessieException e){
                if(e == null){
                    //There is no error, do whatever you need here.
                    // Cast the result object to the type that you are requesting and you are good to go
                    trainers = (ArrayList<Customer>) result;
                } else {
                    //There was an error. Handle it here
                    Log.e("Error", e.toString());
                }
            }
        });

        return trainers.size() > 0;
    }

    public ArrayList<Customer> getTrainers() {
        return trainers;
    }

    public boolean handlePayment(String client, String trainer) {



        return true;
    }
}
