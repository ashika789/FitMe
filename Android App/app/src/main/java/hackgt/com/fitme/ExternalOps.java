package hackgt.com.fitme;

import android.util.Log;

import com.reimaginebanking.api.java.Constants.AccountType;
import com.reimaginebanking.api.java.NessieClient;
import com.reimaginebanking.api.java.NessieException;
import com.reimaginebanking.api.java.NessieResultsListener;
import com.reimaginebanking.api.java.models.Account;
import com.reimaginebanking.api.java.models.Address;
import com.reimaginebanking.api.java.models.Customer;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Siddarth on 9/26/2015.
 */
public class ExternalOps {

    private NessieClient nessieClient;
    private String API_KEY = "3f6923379b0ab8da8553b1a421d13423";
    private Address clientAddress;
    private Customer clientCustomer;
    private Account clientAccount;

    private Customer trainerCustomer;
    private Account trainerAccount;

    public ExternalOps() {
        nessieClient = NessieClient.getInstance();
        nessieClient.setAPIKey(API_KEY);
    }

    public void createCustomer(String state, String streetNumber, String streetName, String city, String zip, String firstName, String lastName) {
        this.clientAddress =  new Address(state, streetName, streetNumber, city, zip);
        this.clientCustomer = new Customer();
        clientCustomer.setAddress(clientAddress);
        clientCustomer.setFirst_name(firstName);
        clientCustomer.setLast_name(lastName);
    }

    public void uploadCustomer() {

        // Upload our customer to their database
        NessieResultsListener listener = new NessieResultsListener() {
            @Override
            public void onSuccess(Object o, NessieException e) {
                nessieClient.createCustomer(clientCustomer, this);
            }
        };

        // Set our customer to the customer in the database
        // Effectively we have retrieved the customer's ID
        nessieClient.getCustomers(new NessieResultsListener() {
            @Override
            public void onSuccess(Object result, NessieException e) {
                if (e == null) {
                    //There is no error, do whatever you need here.
                    // Cast the result object to the type that you are requesting and you are good to go
                    ArrayList<Customer> customers = (ArrayList<Customer>) result;

                    for (Customer cus : customers) {
                        if (cus.getFirst_name().equals(clientCustomer.getFirst_name()) && cus.getLast_name().equals(clientCustomer.getLast_name()) && cus.getAddress().equals(clientCustomer.getAddress())) {
                            clientCustomer = cus;
                            return;
                        }
                    }
                } else {
                    //There was an error. Handle it here
                    Log.e("Error", e.toString());
                }
            }
        });
    }

    public void createAccount() {
        // Build account
        Account.Builder accountBuilder = new Account.Builder();
        accountBuilder.type(AccountType.CREDITCARD);
        accountBuilder.nickname(clientCustomer.getFirst_name() + ", s credit card account");
        accountBuilder.rewards(0);
        accountBuilder.balance(200);
        clientAccount = accountBuilder.build();
    }

    public void uploadAccount() {
        // Upload the account and pair it with a customer ID

        nessieClient.createAccount(clientCustomer.get_id(), clientAccount, new NessieResultsListener() {
            @Override
            public void onSuccess(Object o, NessieException e) {
                nessieClient.createAccount(clientCustomer.get_id(), clientAccount, this);
            }
        });

        // Get the account for ourselves
        nessieClient.getAccounts(new NessieResultsListener() {
            @Override
            public void onSuccess(Object o, NessieException e) {
                ArrayList<Account> accounts = ((ArrayList<Account>) o);

                for (Account x : accounts) {
                    if (x.getCustomer().equals(clientCustomer)) {
                        clientAccount = x;
                        return;
                    }
                }
            }
        });

    }

    public Customer getCustomer(final String customerName) {
        nessieClient.getCustomers(new NessieResultsListener() {
            @Override
            public void onSuccess(Object result, NessieException e) {
                if (e == null) {
                    //There is no error, do whatever you need here.
                    // Cast the result object to the type that you are requesting and you are good to go
                    ArrayList<Customer> customers = (ArrayList<Customer>) result;

                    for (Customer cus : customers) {
                        if (cus.getFirst_name().equals(customerName)) {
                            //if (cus.getFirst_name().equals(clientCustomer.getFirst_name()) && cus.getLast_name().equals(clientCustomer.getLast_name()) && cus.getAddress().equals(clientCustomer.getAddress())) {
                            trainerCustomer = cus;
                        }
                    }
                } else {
                    //There was an error. Handle it here
                    Log.e("Error", e.toString());
                }
            }
        });
        return trainerCustomer;
    }

    public Account getAccount(final Customer customer) {
        nessieClient.getAccounts(new NessieResultsListener() {
            @Override
            public void onSuccess(Object result, NessieException e) {
                if (e == null) {
                    //There is no error, do whatever you need here.
                    // Cast the result object to the type that you are requesting and you are good to go
                    ArrayList<Account> accounts = (ArrayList<Account>) result;

                    for (Account acc : accounts) {
                        if (customer.getFirst_name().equals(acc.getCustomer())) {
                            //if (cus.getFirst_name().equals(clientCustomer.getFirst_name()) && cus.getLast_name().equals(clientCustomer.getLast_name()) && cus.getAddress().equals(clientCustomer.getAddress())) {
                            trainerAccount = acc;
                        }
                    }
                } else {
                    //There was an error. Handle it here
                    Log.e("Error", e.toString());
                }
            }
        });
        return trainerAccount;
    }

}
