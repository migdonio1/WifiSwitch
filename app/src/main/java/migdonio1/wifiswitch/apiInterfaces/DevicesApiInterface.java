package migdonio1.wifiswitch.apiInterfaces;

import java.util.List;

import migdonio1.wifiswitch.models.Device;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by migdonio1 on 12/9/16.
 */
public interface DevicesApiInterface {
    @GET("devices")
    Call<List<Device>> DeviceList();

    @GET("devices/{device_id}")
    Call<Device> getDevice(@Path("device_id") String device);

    @GET("devices/{device_id}/switchs")
    Call<List<Device>> getSwitchs(@Path("device_id") String device);

    @GET("devices/{device_id}/sensors")
    Call<List<Device>> getSensors(@Path("device_id") String device);
}
