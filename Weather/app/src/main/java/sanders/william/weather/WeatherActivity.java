package sanders.william.weather;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class WeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_weather, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_change_city) {
            showInputDialog();
            return true;
        } else if (id == R.id.action_display_list) {
            Intent intent = new Intent(this, ListActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    private void showInputDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Change City");
        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);
        builder.setPositiveButton("Go", new DialogInterface.OnClickListener() {
           @Override
            public void onClick(DialogInterface dialog, int which) {
               changeCity(input.getText().toString());
           }
        });
        builder.show();
    }

    public void changeCity(String city) {
        WeatherFragment wf = (WeatherFragment)getSupportFragmentManager().findFragmentById(R.id.weather_fragment);
        wf.changeCity(city);
        new WeatherPreference(this).setCity(city);
    }

}
