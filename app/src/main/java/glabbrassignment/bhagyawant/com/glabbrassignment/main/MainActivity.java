package glabbrassignment.bhagyawant.com.glabbrassignment.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import glabbrassignment.bhagyawant.com.glabbrassignment.Constants;
import glabbrassignment.bhagyawant.com.glabbrassignment.R;
import glabbrassignment.bhagyawant.com.glabbrassignment.adapters.ReadDeliveredAdapter;
import glabbrassignment.bhagyawant.com.glabbrassignment.pojo.MessageDetailsRepository;
import glabbrassignment.bhagyawant.com.glabbrassignment.pojo.StatusDetail;


public class MainActivity extends AppCompatActivity implements MainActivityContract.View, Observer {

    private MainActivityContract.Presenter presenter;
    private RecyclerView recyclerRead, recyclerDelivered;
    private TextView tvMessage;
    MessageDetailsRepository messageDetailsRepository;
    StatusDetail statusDetail;
    ReadDeliveredAdapter readDeliveredAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        messageDetailsRepository = MessageDetailsRepository.getInstance();
        messageDetailsRepository.addObserver(this);
        presenter = new MainActivityPresenter(this);
    }


    @Override
    public void update(Observable o, Object arg) {
        Toast.makeText(this, "Called", Toast.LENGTH_SHORT).show();
        if (o instanceof MessageDetailsRepository) {
            tvMessage.setText(messageDetailsRepository.getMessage());

            ArrayList<StatusDetail> tempStatusReadList = new ArrayList<>();
            for (StatusDetail statusDetail : messageDetailsRepository.getStatusDetails()) {
                if (statusDetail.getStatus() == Constants.READ) {
                    tempStatusReadList.add(statusDetail);
                }
            }

            ArrayList<StatusDetail> tempStatusDeliveredList = new ArrayList<>();
            for (StatusDetail statusDetail : messageDetailsRepository.getStatusDetails()) {
                if (statusDetail.getStatus() == Constants.DELIVERED) {
                    tempStatusDeliveredList.add(statusDetail);
                }
            }

            readDeliveredAdapter = new ReadDeliveredAdapter(tempStatusReadList, this);
            recyclerRead.setAdapter(readDeliveredAdapter);


            readDeliveredAdapter = new ReadDeliveredAdapter(tempStatusDeliveredList, this);
            recyclerDelivered.setAdapter(readDeliveredAdapter);

        }
    }

    @Override
    public void initView() {
        //VIews
        recyclerDelivered = findViewById(R.id.recyclerDelivered);
        recyclerRead = findViewById(R.id.recyclerRead);
        tvMessage = findViewById(R.id.tvMessage);


        recyclerRead.setLayoutManager(new LinearLayoutManager(this));
        recyclerDelivered.setLayoutManager(new LinearLayoutManager(this));
        addFaKeData();
    }

    private void addFaKeData() {
        ArrayList<StatusDetail> statusDetails = new ArrayList<>();
        statusDetails.add(new StatusDetail("9854524894", Constants.DELIVERED));
        statusDetails.add(new StatusDetail("875454864", Constants.DELIVERED));
        statusDetails.add(new StatusDetail("4564566546", Constants.DELIVERED));
        statusDetails.add(new StatusDetail("784564564546", Constants.DELIVERED));
        statusDetails.add(new StatusDetail("456456415612", Constants.DELIVERED));
        statusDetails.add(new StatusDetail("878454648672", Constants.DELIVERED));
        statusDetails.add(new StatusDetail("7987445648412", Constants.DELIVERED));
        messageDetailsRepository.setMessageDetails("Bhagyawant", statusDetails);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        messageDetailsRepository.deleteObserver(this);
    }

    @Override
    public void firstListNotifty() {
        readDeliveredAdapter.notifyDataSetChanged();
    }
}
