package test.com.newsapimvp.network;

import retrofit2.Call;
import retrofit2.http.GET;
import test.com.newsapimvp.model.ResponseBerita;

public interface ApiInterface {
    @GET("v2/top-headlines?sources=bbc-sport&apiKey=b71cd3aa60ac4a11a1f803a36a6ed30e")
    Call<ResponseBerita>getData();

}
