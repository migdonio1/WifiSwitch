package migdonio1.wifiswitch.app.fragments;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import migdonio1.wifiswitch.R;
import migdonio1.wifiswitch.models.Device;

/**
 * Created by migdonio1 on 12/9/16.
 */
public class CardsListRecyclerViewAdapter extends RecyclerView.Adapter<CardsListRecyclerViewAdapter.DeviceHolder> {

    private static String LOG = "CardsListRecyclerViewAdapter";
    private List<Device> mDeviceSet;
    private static CardClickListener cardClickListener;

    @Override
    public DeviceHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_row, parent, false);
        DeviceHolder dataDeviceHolder = new DeviceHolder(view);

        return dataDeviceHolder;
    }

    @Override
    public void onBindViewHolder(DeviceHolder holder, int position) {
        String name = mDeviceSet.get(position).getName();
        String status = mDeviceSet.get(position).getStatus();
        String sensors = String.valueOf(mDeviceSet.get(position).getSensors().size());
        String switchs = String.valueOf(mDeviceSet.get(position).getSwitchs().size());

        sensors = sensors + " Sensores";
        switchs = switchs + " Switches";

        holder.name.setText(name);
        holder.status.setText(status);
        holder.sensors.setText(sensors);
        holder.switchs.setText(switchs);
    }

    public void addItem(Device device, int index) {
        mDeviceSet.add(index, device);
        notifyItemInserted(index);
    }

    public void deleteItem(int index) {
        mDeviceSet.remove(index);
    }

    @Override
    public int getItemCount() {
        return mDeviceSet.size();
    }

    public static class DeviceHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name;
        TextView status;
        TextView sensors;
        TextView switchs;

        public DeviceHolder (View itemView){
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.card_view_name_text);
            status = (TextView) itemView.findViewById(R.id.card_view_status_text);
            sensors = (TextView) itemView.findViewById(R.id.card_view_sensor_text);
            switchs  = (TextView) itemView.findViewById(R.id.card_view_switch_text);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            cardClickListener.onItemClick(getAdapterPosition(), view);
        }
    }

    public void setOnItemClickListener(CardClickListener cardClickListener){
        this.cardClickListener = cardClickListener;
    }

    public CardsListRecyclerViewAdapter(List<Device> mDeviceSet){
        this.mDeviceSet = mDeviceSet;
    }

    public interface CardClickListener {
        public void onItemClick(int position, View view);
    }
}

