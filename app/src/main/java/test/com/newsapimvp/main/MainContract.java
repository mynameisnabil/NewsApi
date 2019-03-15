package test.com.newsapimvp.main;

import java.util.List;

import test.com.newsapimvp.model.ArticlesItem;

public interface MainContract {
    interface view{
        //todo membuat loading
        void ShowProgress();
        void HidePregress();

        //todo menampilkan datalist ke view
        void showDataList(List<ArticlesItem>articlesItemList);


        //todo menampilkan pesan gagal

        void showFailureMessage(String msg);




    }

    interface Presenter{
        //todo mengambil data dari api
        void getDataList();

    }
}
