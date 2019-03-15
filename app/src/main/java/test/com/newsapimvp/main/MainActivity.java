package test.com.newsapimvp.main;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import test.com.newsapimvp.R;
import test.com.newsapimvp.adapter.MainAdapter;
import test.com.newsapimvp.model.ArticlesItem;

public class MainActivity extends AppCompatActivity implements MainContract.view {

    @BindView(R.id.rv_main)
    RecyclerView rvMain;

    private ProgressDialog progressDialog;

    private MainPresenter presenter = new MainPresenter(this);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter.getDataList();
    }

    @Override
    public void ShowProgress() {

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading");
        progressDialog.setCancelable(false);
        progressDialog.show();

    }

    @Override
    public void HidePregress() {
        progressDialog.dismiss();

    }

    @Override
    public void showDataList(List<ArticlesItem> articlesItemList) {

        rvMain.setLayoutManager(new LinearLayoutManager(this));
        rvMain.setAdapter(new MainAdapter(this,articlesItemList));

    }

    @Override
    public void showFailureMessage(String msg) {
        Toast.makeText(this,  msg, Toast.LENGTH_SHORT).show();

    }
}
