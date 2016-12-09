package migdonio1.wifiswitch.data;

/**
 * Created by migdonio1 on 12/9/16.
 */
public class APIConstants {
    public static final String BASE_URL = "http://192.168.0.18:3002";
    public static final String API_PATH = "/api/v1/";

    public static final String API_ENDPOINT = BASE_URL + API_PATH;

    public static class DEVICE {
        public static final String ID = "_id";
        public static final String NAME = "name";
        public static final String STATUS = "status";
        public static final String LATITUDE = "latitude";
        public static final String LONGITUDE = "longitude";
    }

    public static class SENSOR {
        public static final String ID = "_id";
        public static final String NAME = "name";
        public static final String TYPE = "type";
        public static final String STATUS = "status";
    }

    public static class SWITCH {
        public static final String ID = "_id";
        public static final String NAME = "name";
        public static final String STATUS = "status";
    }
}
