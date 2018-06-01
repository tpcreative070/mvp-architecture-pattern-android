package tpcreative.co.mvp_architecture_pattern_android.common;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class BaseHolder <V> extends RecyclerView.ViewHolder {

    public BaseHolder(View itemView) {
        super(itemView);
    }
    public void bind(V data, int position){}
    public void event(){}

}

