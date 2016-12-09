package migdonio1.wifiswitch.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;

import java.util.List;

import migdonio1.wifiswitch.R;
import migdonio1.wifiswitch.apiInterfaces.DevicesApiInterface;
import migdonio1.wifiswitch.app.fragments.CardsListRecyclerViewAdapter;
import migdonio1.wifiswitch.models.Device;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static migdonio1.wifiswitch.data.APIConstants.API_ENDPOINT;

public class DeviceDetailActivity extends AppCompatActivity implements OnMapReadyCallback{

    private DevicesApiInterface apiDevices;
    private GoogleMap map;
    private Intent intent;

    private Device device;

    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_detail);

        intent = getIntent();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiDevices = retrofit.create(DevicesApiInterface.class);

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        map.setMapType(GoogleMap.MAP_TYPE_HYBRID);

        Call<Device> call = apiDevices.getDevice(intent.getStringExtra("id"));

        call.enqueue(new Callback<Device>() {
            @Override
            public void onResponse(Call<Device> call, Response<Device> response) {
                device = response.body();
                moveMap();
            }

            @Override
            public void onFailure(Call<Device> call, Throwable t) {
                Toast.makeText(DeviceDetailActivity.this, "Error: El servidor no responde, intentelo mas tarde", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void moveMap() {
        CameraUpdate camUpd1 = CameraUpdateFactory.newLatLngZoom(new LatLng(device.getPosition().getLatitude(), device.getPosition().getLongitude()), 18);
        map.moveCamera(camUpd1);
    }
}
