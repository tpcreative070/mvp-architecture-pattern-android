package tpcreative.co.mvp_architecture_pattern_android;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import java.util.List;
import tpcreative.co.mvp_architecture_pattern_android.common.DividerItemDecoration;
import tpcreative.co.mvp_architecture_pattern_android.model.Staff;
import tpcreative.co.mvp_architecture_pattern_android.presenter.StaffPresenter;
import tpcreative.co.mvp_architecture_pattern_android.view.StaffView;

public class MainActivity extends AppCompatActivity implements StaffAdapter.ItemSelectedListener,StaffView{

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private StaffAdapter adapter;
    private LinearLayoutManager llm;
    private StaffPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        progressBar  = findViewById(R.id.progressBar);
        setupRecyclerViewItem();
        presenter = new StaffPresenter();
        presenter.bindView(this);
        presenter.getStaffList();

    }


    public void setupRecyclerViewItem() {
        llm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(llm);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));
        adapter = new StaffAdapter(getLayoutInflater(), this, this);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void startLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void stopLoading() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showData(List<Staff> list) {
        adapter.setDataSource(list);
    }

    @Override
    public Context getContext() {

        return getApplicationContext();
    }

    @Override
    public void onClickItem(int position) {

    }

}
