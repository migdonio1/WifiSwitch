
package migdonio1.wifiswitch.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Switch {

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
    @SerializedName("timeOn")
    @Expose
    private List<Object> timeOn = null;

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
     *     The timeOn
     */
    public List<Object> getTimeOn() {
        return timeOn;
    }

    /**
     * 
     * @param timeOn
     *     The timeOn
     */
    public void setTimeOn(List<Object> timeOn) {
        this.timeOn = timeOn;
    }

}
