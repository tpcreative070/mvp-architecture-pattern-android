package tpcreative.co.mvp_architecture_pattern_android.view;
import android.content.Context;
import java.util.List;
import tpcreative.co.mvp_architecture_pattern_android.model.Staff;

public interface StaffView {

    void startLoading();
    void stopLoading();
    void showData(List<Staff> list);
    Context getContext();

}
