/**
 * IMPORTANT: Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *

 *
 */
package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.android.justjava.R;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     *
     *
     */

    public void increment(View view ){

        if ( quantity == 100) {
            return ;
        }

         quantity = quantity +1;
        displayQuantity(quantity);
    }


    public void decrement(View view){

        if ( quantity == 1) {
            return;
        }
        quantity = quantity -1;
    displayQuantity(quantity);

    }

    public void submitOrder(View view) {


        EditText nameField = (EditText) findViewById(R.id.name_field);
        Editable nameEditable = nameField.getText();
        String name = nameEditable.toString();


        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();

        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        int price = calculatePrice();
        String priceMessage = createOrderSummary(price, hasWhippedCream, hasChocolate);
        displayMessage(priceMessage);
    }


    private String createOrderSummary( int price, boolean addWhippedCream, boolean addChocolate){
        String priceMessage = "Name: Kaptain Kunal";
        priceMessage = priceMessage + "\nAdd whipped cream ?" + addWhippedCream;
        priceMessage = priceMessage + "\nAdd Chocolate?" + addChocolate;
        priceMessage = priceMessage + "\nQuantity" + quantity;
        priceMessage = priceMessage + "\nTotal: $ " + calculatePrice();
        priceMessage = priceMessage + "\nThank you!";
        return priceMessage;
    }

    private int calculatePrice(){
        int price = quantity * 3;
        return price;
    }

    public void displayMessage(String message){
    TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
    orderSummaryTextView.setText(message);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int numberOfCoffees) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees);
    }

}