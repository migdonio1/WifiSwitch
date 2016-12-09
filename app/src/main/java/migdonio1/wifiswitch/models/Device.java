
package migdonio1.wifiswitch.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Device {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("__v")
    @Expose
    private Integer v;
    @SerializedName("switchs")
    @Expose
    private List<Switch> switchs = null;
    @SerializedName("sensors")
    @Expose
    private List<Sensor> sensors = null;
    @SerializedName("position")
    @Expose
    private Position position;

    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The _id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The status
     */
    public String getStatus() {
        return status;
    }

    /**
     * 
     * @param status
     *     The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 
     * @return
     *     The v
     */
    public Integer getV() {
        return v;
    }

    /**
     * 
     * @param v
     *     The __v
     */
    public void setV(Integer v) {
        this.v = v;
    }

    /**
     * 
     * @return
     *     The switchs
     */
    public List<Switch> getSwitchs() {
        return switchs;
    }

    /**
     * 
     * @param switchs
     *     The switchs
     */
    public void setSwitchs(List<Switch> switchs) {
        this.switchs = switchs;
    }

    /**
     * 
     * @return
     *     The sensors
     */
    public List<Sensor> getSensors() {
        return sensors;
    }

    /**
     * 
     * @param sensors
     *     The sensors
     */
    public void setSensors(List<Sensor> sensors) {
        this.sensors = sensors;
    }

    /**
     * 
     * @return
     *     The position
     */
    public Position getPosition() {
        return position;
    }

    /**
     * 
     * @param position
     *     The position
     */
    public void setPosition(Position position) {
        this.position = position;
    }

}
