package tpcreative.co.mvp_architecture_pattern_android;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import tpcreative.co.mvp_architecture_pattern_android.common.BaseAdapter;
import tpcreative.co.mvp_architecture_pattern_android.common.BaseHolder;
import tpcreative.co.mvp_architecture_pattern_android.model.Staff;

public class StaffAdapter extends BaseAdapter<Staff, BaseHolder> {

    private Activity myActivity;
    private ItemSelectedListener itemSelectedListener;
    private String TAG = StaffAdapter.class.getSimpleName();

    public StaffAdapter(LayoutInflater inflater, Activity activity, ItemSelectedListener itemSelectedListener) {
        super(inflater);
        this.myActivity = activity;
        this.itemSelectedListener = itemSelectedListener;
    }

    @Override
    public int getItemCount() {
        return dataSource.size();
    }

    @Override
    public BaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new StaffItemHolder(inflater.inflate(R.layout.staff_item, parent, false));
    }

    public class StaffItemHolder extends BaseHolder<Staff> {

        public StaffItemHolder(View itemView) {
            super(itemView);
        }

        private Staff data;
        private TextView tvName;
        private TextView tvRole;
        int mPosition ;

        @Override
        public void bind(Staff data, int position) {
            super.bind(data, position);
            tvName = itemView.findViewById(R.id.tvName);
            tvRole = itemView.findViewById(R.id.tvRole);
            tvName.setText(data.first_name + " " + data.last_name);
            tvRole.setText(""+data.role);
        }

    }

    public  interface ItemSelectedListener{
        void onClickItem(int position);
    }

}
