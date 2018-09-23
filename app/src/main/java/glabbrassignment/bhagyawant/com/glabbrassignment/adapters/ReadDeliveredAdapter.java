package glabbrassignment.bhagyawant.com.glabbrassignment.adapters;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import glabbrassignment.bhagyawant.com.glabbrassignment.Constants;
import glabbrassignment.bhagyawant.com.glabbrassignment.R;
import glabbrassignment.bhagyawant.com.glabbrassignment.pojo.MessageDetailsRepository;
import glabbrassignment.bhagyawant.com.glabbrassignment.pojo.StatusDetail;

public class ReadDeliveredAdapter extends RecyclerView.Adapter<ReadDeliveredAdapter.ViewHolder> {

    private MessageDetailsRepository messageDetailsRepository;
    private ArrayList<StatusDetail> statusDetails;
    private Activity activity;

    public ReadDeliveredAdapter(ArrayList<StatusDetail> statusDetails, Activity activity) {
        this.messageDetailsRepository = MessageDetailsRepository.getInstance();
        this.statusDetails = statusDetails;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final StatusDetail statusDetail = statusDetails.get(position);
        holder.tvContactNumber.setText(statusDetail.getContactNumber());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(statusDetail.getStatus()== Constants.READ){
                    for(int i =0;i<messageDetailsRepository.getStatusDetails().size();i++)
                    {
                        if(messageDetailsRepository.getStatusDetails().get(i).getContactNumber().equals(statusDetail.getContactNumber()))
                        {
                            messageDetailsRepository.getStatusDetails().get(i).setStatus(Constants.DELIVERED);
                            messageDetailsRepository.setMessageDetails("Status changed to delivered for "+statusDetail.getContactNumber(),statusDetails);
                        }
                    }
                }

                if(statusDetail.getStatus()== Constants.DELIVERED){
                    for(int i =0;i<messageDetailsRepository.getStatusDetails().size();i++)
                    {
                        if(messageDetailsRepository.getStatusDetails().get(i).getContactNumber().equals(statusDetail.getContactNumber()))
                        {
                            messageDetailsRepository.getStatusDetails().get(i).setStatus(Constants.READ);
                            messageDetailsRepository.setMessageDetails("Status changed to delivered for "+statusDetail.getContactNumber(),statusDetails);
                        }
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return statusDetails.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final TextView tvContactNumber;

        public ViewHolder(View itemView) {
            super(itemView);
            tvContactNumber = itemView.findViewById(R.id.tvContactNumber);
        }
    }
}
