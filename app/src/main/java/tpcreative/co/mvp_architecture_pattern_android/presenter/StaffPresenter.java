package tpcreative.co.mvp_architecture_pattern_android.presenter;
import android.os.Handler;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import tpcreative.co.mvp_architecture_pattern_android.common.Presenter;
import tpcreative.co.mvp_architecture_pattern_android.model.Staff;
import tpcreative.co.mvp_architecture_pattern_android.view.StaffView;

public class StaffPresenter extends Presenter<StaffView> {

    private Handler handler = new Handler();

    public StaffPresenter(){

    }

    public void getStaffList(){
        final StaffView view = view();
        final List<Staff> list = new ArrayList<>();
        list.add(new Staff("Tran","TP",1));
        list.add(new Staff("Tran","TPCreative",2));
        view.startLoading();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                view.showData(list);
                view.stopLoading();
            }
        },3000);
    }
}
