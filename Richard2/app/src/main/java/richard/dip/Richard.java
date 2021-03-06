package richard.dip;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Richard extends AppCompatActivity {

    Intent intent, launch;
    EditText name, address, phone;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    Boolean nameOk, phoneOk, addressOk;
    Uri uri;

    public void init(){

        intent = new Intent(this, Specials_Screen.class);
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        editor = prefs.edit();

        name = (EditText) findViewById(R.id.name_entry);
        phone = (EditText) findViewById(R.id.phone_entry);
        address = (EditText) findViewById(R.id.address_entry);


    }
    public void nextButton(View v){



        try {
            if (name.getText().toString().matches("")) {
                Toast.makeText(this, getString(R.string.name_error), Toast.LENGTH_SHORT).show();
                nameOk = false;
            } else
                nameOk = true;

            if (phone.getText().toString().length() != 10) {
                Toast.makeText(this, getString(R.string.phone_error), Toast.LENGTH_SHORT).show();
                phoneOk = false;
            } else
                phoneOk = true;

            if (address.getText().toString().matches("")) {
                Toast.makeText(this, getString(R.string.address_error), Toast.LENGTH_SHORT).show();
                addressOk = false;
            } else
                addressOk = true;
        }catch(Exception e){
            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
        }

        if(nameOk && phoneOk && addressOk) {

            editor.putString("name_final", name.getText().toString());
            editor.putString("phone_final", phone.getText().toString());
            editor.putString("address_final", address.getText().toString());

            editor.commit();
            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_richard);
        init();
    }//end onCreate

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
                uri = Uri.parse("https://github.com/richarddip28/PizzaApp/blob/master/Help");
                launch = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(launch);
                return true;
            case R.id.dominos_click:
                uri = Uri.parse("https://www.pizzahut.ca/");
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
