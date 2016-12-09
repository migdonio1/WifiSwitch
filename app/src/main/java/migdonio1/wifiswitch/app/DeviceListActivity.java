package migdonio1.wifiswitch.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

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

public class DeviceListActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private DevicesApiInterface apiDevices;

    private List<Device> devices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_list);

        mRecyclerView = (RecyclerView)findViewById(R.id.my_recycler_view);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiDevices = retrofit.create(DevicesApiInterface.class);

        Call<List<Device>> call = apiDevices.DeviceList();

        call.enqueue(new Callback<List<Device>>() {
            @Override
            public void onResponse(Call<List<Device>> call, Response<List<Device>> response) {
                devices = response.body();
                mAdapter = new CardsListRecyclerViewAdapter(devices);
                mRecyclerView.setAdapter(mAdapter);

                ((CardsListRecyclerViewAdapter) mAdapter)
                        .setOnItemClickListener(new CardsListRecyclerViewAdapter.CardClickListener(){

                            @Override
                            public void onItemClick(int position, View view) {
                                Intent intent = new Intent(getApplicationContext(), DeviceDetailActivity.class);
                                intent.putExtra("id", devices.get(position).getId());

                                startActivity(intent);
                            }
                        });
            }

            @Override
            public void onFailure(Call<List<Device>> call, Throwable t) {
                Toast.makeText(DeviceListActivity.this, "Error: El servidor no responde, intentelo mas tarde", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
