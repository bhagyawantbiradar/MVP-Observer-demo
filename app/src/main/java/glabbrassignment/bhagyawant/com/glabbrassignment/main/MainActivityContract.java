package glabbrassignment.bhagyawant.com.glabbrassignment.main;

import android.view.View;

import glabbrassignment.bhagyawant.com.glabbrassignment.pojo.MessageDetailsRepository;

public interface MainActivityContract {

    interface View{
        void initView();
    }

    interface Model {
        MessageDetailsRepository getMessage();
    }

    interface Presenter{
        void onClick(android.view.View view);
    }
}
