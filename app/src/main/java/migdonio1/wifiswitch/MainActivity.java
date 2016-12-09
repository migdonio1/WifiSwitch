package migdonio1.wifiswitch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import migdonio1.wifiswitch.app.DeviceListActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickDeviceListButton(View view) {
        Intent intent = new Intent(this, DeviceListActivity.class);
        startActivity(intent);
    }
}
