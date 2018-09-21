package glabbrassignment.bhagyawant.com.glabbrassignment.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.Observable;
import java.util.Observer;

import glabbrassignment.bhagyawant.com.glabbrassignment.R;
import glabbrassignment.bhagyawant.com.glabbrassignment.pojo.MessageDetailsRepository;


public class MainActivity extends AppCompatActivity implements MainActivityContract.View, Observer {

    private Observable messageDetailsRepositoryObservable;
    private MainActivityContract.Presenter presenter;
    private RecyclerView recyclerRead,recyclerDelivered;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void update(Observable o, Object arg) {


    }

    @Override
    public void initView() {
        messageDetailsRepositoryObservable = MessageDetailsRepository.getInstance();
        messageDetailsRepositoryObservable.addObserver(this);
        presenter = new MainActivityPresenter(this);
    }

    @Override
    public void setViewData() {

    }
}
