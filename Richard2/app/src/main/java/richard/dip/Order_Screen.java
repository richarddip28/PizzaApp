package richard.dip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.R.id.list;

public class Order_Screen extends AppCompatActivity {

    Intent intent;
    String size_pizza, dough_pizza, sauce_pizza;
    ArrayList<String> list;
    Spinner size_spinner, dough_spinner, sauce_spinner;
    CheckBox cb1,cb2,cb3,cb4,cb5,cb6,cb7,cb8,cb9,cb10,cb11,cb12;
    EditText messages;

    public void getToppings(){

        list = new ArrayList<String>();
        cb1 = (CheckBox) findViewById(R.id.cb1);
        cb2 = (CheckBox) findViewById(R.id.cb2);
        cb3 = (CheckBox) findViewById(R.id.cb3);
        cb4 = (CheckBox) findViewById(R.id.cb4);
        cb5 = (CheckBox) findViewById(R.id.cb5);
        cb6 = (CheckBox) findViewById(R.id.cb6);
        cb7 = (CheckBox) findViewById(R.id.cb7);
        cb8 = (CheckBox) findViewById(R.id.cb8);
        cb9 = (CheckBox) findViewById(R.id.cb9);
        cb10 = (CheckBox) findViewById(R.id.cb10);
        cb11 = (CheckBox) findViewById(R.id.cb11);
        cb12 = (CheckBox) findViewById(R.id.cb12);

        if(cb1.isChecked()) {
            list.add(getString(R.string.pepperoni_topping));
        }
        if(cb2.isChecked())
            list.add(getString(R.string.cheese_topping));
        if(cb3.isChecked())
            list.add(getString(R.string.chicken_topping));
        if(cb4.isChecked())
            list.add(getString(R.string.bacon_topping));
        if(cb5.isChecked())
            list.add(getString(R.string.pineapple_topping));
        if(cb6.isChecked())
            list.add(getString(R.string.mushroom_topping));
        if(cb7.isChecked())
            list.add(getString(R.string.greenpepper_topping));
        if(cb8.isChecked())
            list.add(getString(R.string.sausage_topping));
        if(cb9.isChecked())
            list.add(getString(R.string.groundbeef_topping));
        if(cb10.isChecked())
            list.add(getString(R.string.redonion_topping));
        if(cb11.isChecked())
            list.add(getString(R.string.tomatoes_topping));
        if(cb12.isChecked())
            list.add(getString(R.string.basil_topping));


    }//end getToppings()

    public void getInfo(){

        intent=new Intent(this, Details_Screen.class);

        size_spinner = (Spinner)findViewById(R.id.spinner_size);
        dough_spinner = (Spinner)findViewById(R.id.spinner_dough);
        sauce_spinner = (Spinner)findViewById(R.id.spinner_sauce);

        size_pizza = size_spinner.getSelectedItem().toString();
        dough_pizza = dough_spinner.getSelectedItem().toString();
        sauce_pizza = sauce_spinner.getSelectedItem().toString();

        messages = (EditText) findViewById(R.id.messages_text);
        String commentToSend = messages.getText().toString();

        getToppings();

        try {
            intent.putExtra("sizeofpizza", size_pizza);
            intent.putExtra("doughofpizza", dough_pizza);
            intent.putExtra("sauceofpizza", sauce_pizza);
            String[] toppings = list.toArray(new String[list.size()]);
            toppings = list.toArray(toppings);
            intent.putExtra("list", toppings);
            intent.putExtra("comments", commentToSend);

        }catch(Exception e){
            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG);
        }


    }

    public void toDetailsScreen(View v){

        getInfo();
        startActivity(intent);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order__screen);
    }
}
