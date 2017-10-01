package richard.dip;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Details_Screen extends AppCompatActivity {

    String size_pizza,dough_pizza,sauce_pizza, comments;
    String[] list;
    TextView size, dough, sauce, topping_list, commentBox, name, phone, address, subtotal, taxText, totalText;
    SharedPreferences prefs;
    double price,taxes,totalBill;
    DecimalFormat df;
    Intent intent, launch;
    Uri uri;
    double subtotalPrice;
    EditText creditcard;

    public void toConfirmation(View v){

        intent = new Intent(this, Confirmation_Screen.class);


            creditcard = (EditText) findViewById(R.id.creditcardrequest);
            if(creditcard.getText().toString().length() != 16)
                Toast.makeText(this,getString(R.string.card_error),Toast.LENGTH_LONG).show();
            else
                startActivity(intent);



    }

    public void getPrice(){

        if(size_pizza.matches(getString(R.string.sml)))
            subtotalPrice = subtotalPrice + 9.99;
        else if(size_pizza.matches(getString(R.string.med)))
            subtotalPrice = subtotalPrice + 11.99;
        else
            subtotalPrice = subtotalPrice + 13.99;


            subtotalPrice = subtotalPrice + list.length* 1.29;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details__screen);

        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        df = new DecimalFormat("#.00");
        subtotalPrice = 0;

        size_pizza = getIntent().getStringExtra("sizeofpizza");
        dough_pizza = getIntent().getStringExtra("doughofpizza");
        sauce_pizza = getIntent().getStringExtra("sauceofpizza");
        list = getIntent().getStringArrayExtra("list");
        comments = getIntent().getStringExtra("comments");

        getPrice();
        if(getIntent().getDoubleExtra("price", 0.00) == 0.00)
            price = subtotalPrice;
        else
            price = getIntent().getDoubleExtra("price", 0.00);


        taxes = price*0.13;
        totalBill = price+taxes;

        price = price*1.00;
        taxes = taxes*1.00;
        totalBill = totalBill*1.00;



        size = (TextView) findViewById(R.id.size_of_pizza);
        dough = (TextView) findViewById(R.id.dough_of_pizza);
        sauce = (TextView) findViewById(R.id.sauce_of_pizza);
        topping_list = (TextView) findViewById(R.id.toppingList);
        commentBox = (TextView) findViewById(R.id.message_box);
        name = (TextView) findViewById(R.id.name_final);
        phone = (TextView) findViewById(R.id.phone_final);
        address = (TextView) findViewById(R.id.address_final);
        subtotal = (TextView) findViewById(R.id.price_final);
        taxText = (TextView) findViewById(R.id.taxes_final);
        totalText = (TextView) findViewById(R.id.total_final);




        size.setText(size_pizza);
        dough.setText(dough_pizza);
        sauce.setText(sauce_pizza);
        topping_list.setText(Arrays.toString(list));
        commentBox.setText(comments);
        name.setText(prefs.getString("name_final", "no id"));
        phone.setText(prefs.getString("phone_final", "no id"));
        address.setText(prefs.getString("address_final", "no id"));
        subtotal.setText(String.valueOf("$"+df.format(price)));
        taxText.setText(String.valueOf("$"+df.format(taxes)));
        totalText.setText(String.valueOf("$"+df.format(totalBill)));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        switch(item.getItemId()){
            case R.id.help_click:
                uri = Uri.parse("https://github.com/richarddip28");
                launch = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(launch);
                return true;
            case R.id.dominos_click:
                uri = Uri.parse("https://www.dominos.ca/");
                launch = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(launch);
                return true;
            case R.id.richard_click:
                launch = new Intent();
                launch.setClassName("com.android.calculator2",
                        "com.android.calculator2.Calculator");
                startActivity(launch);
                return true;
            default:
                return super.onOptionsItemSelected(item);


        }//end switch
    }//end onOptionsItemSelected
}
