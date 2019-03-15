package test.com.newsapimvp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import test.com.newsapimvp.R;
import test.com.newsapimvp.model.ArticlesItem;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {



    public MainAdapter(Context context, List<ArticlesItem> articlesItems) {
        this.context = context;
        this.articlesItems = articlesItems;
    }

    private Context context;
    private List<ArticlesItem> articlesItems;


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_row, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.tvTitle.setText(articlesItems.get(i).getTitle());
        viewHolder.tvContent.setText(articlesItems.get(i).getTitle());

        Glide.with(context).load(articlesItems.get(i).getUrlToImage()).into(viewHolder.imgNowPlaying);



    }

    @Override
    public int getItemCount() {

        return articlesItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imgNowPlaying)
        ImageView imgNowPlaying;
        @BindView(R.id.tvTitle)
        TextView tvTitle;
        @BindView(R.id.tvContent)
        TextView tvContent;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

        }
    }
}
