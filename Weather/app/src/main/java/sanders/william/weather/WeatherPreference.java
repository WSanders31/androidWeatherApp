package sanders.william.weather;

import android.app.Activity;
import android.content.SharedPreferences;

/**
 * Created by william.sanders on 6/29/16.
 */
public class WeatherPreference {

        SharedPreferences prefs;

        public WeatherPreference(Activity activity){
            prefs = activity.getPreferences(Activity.MODE_PRIVATE);
        }

        // If the user has not chosen a city yet, return
        // Sydney as the default city
        String getCity(){
            return prefs.getString("city", "Chicago");
        }

        void setCity(String city){
            prefs.edit().putString("city", city).apply();
        }

    }
