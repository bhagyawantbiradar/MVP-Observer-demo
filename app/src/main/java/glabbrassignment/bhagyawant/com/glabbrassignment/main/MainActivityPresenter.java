package glabbrassignment.bhagyawant.com.glabbrassignment.main;


import android.view.View;

public class MainActivityPresenter implements MainActivityContract.Presenter {


    private MainActivityContract.View view;
    private MainActivityContract.Model model;

    public MainActivityPresenter(MainActivityContract.View view) {
        this.view = view;
        initPresenter();
    }

    private void initPresenter(){
        model = new MainActivityModel();
        view.initView();
    }

    @Override
    public void onClick(View view) {

    }

}
