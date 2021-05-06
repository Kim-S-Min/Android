package com.example.location;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.security.Provider;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static androidx.constraintlayout.motion.widget.Debug.getLocation;
import static java.security.Security.getProviders;

public class MainActivity extends AppCompatActivity {

    private static final Object LOCATION_SERVICE = ;
    ImageView onOffView;
    TextView allProviderView;
    TextView enableProviderView;
    TextView providerView;
    TextView latitudeProviderView;
    TextView longitudeProviderView;
    TextView accuracyProviderView;
    TextView timeProviderView;

    LocationManager manager;

    List<String> enabledProviders;
    float bestAccuracy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onOffView = findViewById(R.id.lab1_onOffView);
        enableProviderView = findViewById(R.id.lab1_enableProviders);
        allProviderView = findViewById(R.id.lab1_allProviders);
        providerView = findViewById(R.id.lab1_provider);
        latitudeProviderView = findViewById(R.id.lab1_latitude);
        longitudeProviderView = findViewById(R.id.lab1_longitude);
        accuracyProviderView = findViewById(R.id.lab1_accuracy);
        timeProviderView = findViewById(R.id.lab1_time);

        manager = (LocationManager)getSystemService(LOCATION_SERVICE);

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, 100);
        } else {
            getProviders();
            getLocation();
        }
    }

    private void showToast(String message) {
        Toast t = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        t.show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 100 && grantResults.length > 0) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getProviders();
                getLocation();
            } else {
                showToast("permission이 없습니다.");
            }
        }
    }

    private void getProviders() {
        String result = "All Providers: ";
        List<String> providers = manager.getAllProviders();
        for (String provider: providers) {
            result += provider + ",";
        }
        allProviderView.setText(result);

        result = "Enabled Providers: ";
        enabledProviders = manager.getProviders(true);
        for (String provider: enabledProviders) {
            result += provider + ",";
        }
        enableProviderView.setText(result);
    }

    private void getLocation() {
        for(String provider : enabledProviders) {
            Location location = null;
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                location = manager.getLastKnownLocation(provider);
            } else {
                showToast("permission이 없습니다...");
            }
            if (location != null) {
                float accuracy = location.getAccuracy();
                if (bestAccuracy == 0) {
                    bestAccuracy = accuracy;
                    setLocationInfo(provider, location);
                } else {
                    if (accuracy < bestAccuracy) {
                        bestAccuracy = accuracy;
                        setLocationInfo(provider, location);
                    }
                }
            }
        }
    }

    private void setLocationInfo(String provider, Location location) {
        if(location != null) {
            providerView.setText(provider);
            latitudeProviderView.setText(String.valueOf(location.getLatitude()));
            longitudeProviderView.setText(String.valueOf(location.getLongitude()));
            accuracyProviderView.setText(String.valueOf(location.getAccuracy() + "m"));
            Date date = new Date(location.getTime());
            SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            timeProviderView.setText(sd.format(date));
            onOffView.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.ic_on, null));
        } else {
            showToast("location 객체가 null...");
        }
    }
}