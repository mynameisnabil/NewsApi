package test.com.newsapimvp.main;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import test.com.newsapimvp.model.ResponseBerita;
import test.com.newsapimvp.network.ApiClient;
import test.com.newsapimvp.network.ApiInterface;

public class MainPresenter implements MainContract.Presenter {

    private final MainContract.view view;

    public MainPresenter(MainContract.view view) {
        this.view = view;

    }

    private ApiInterface apiInterface = ApiClient.getCilent().create(ApiInterface.class);



    @Override
    public void getDataList() {
        //todo menampilkan loading
        view.ShowProgress();

        //meriquest objeck call
        Call<ResponseBerita>call = apiInterface.getData();

        //menjalankan request api
        call.enqueue(new Callback<ResponseBerita>() {
            @Override
            public void onResponse(Call<ResponseBerita> call, Response<ResponseBerita> response) {
                //menutup l;oading
                view.HidePregress();

                //cek data
                if(response.body() != null){
                    ResponseBerita responseBerita = response.body();

                    view.showDataList(response.body().getArticles());
                }
            }

            @Override
            public void onFailure(Call<ResponseBerita> call, Throwable t) {

                view.HidePregress();

                //menampilkan pesan eror
                view.showFailureMessage(t.getMessage());

            }
        });

    }
}
