package sanders.william.weather;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ListView listView = (ListView)findViewById(R.id.list_weather);

        ArrayList<String> test = new ArrayList<>();
        test.add("William");
        test.add("E");
        test.add("Sanders");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_weather_row, test);

        if(listView != null) {
            listView.setAdapter(adapter);
        }

    }

}
