package tv.bgm.materialdesgincomponent.ui;

import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutManager;
import androidx.appcompat.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import tv.bgm.materialdesgincomponent.R;
import tv.bgm.materialdesgincomponent.irecyclerview.IRecyclerView;
import tv.bgm.materialdesgincomponent.irecyclerview.OnLoadMoreListener;
import tv.bgm.materialdesgincomponent.irecyclerview.OnRefreshListener;

/**
 * Created by Chihiro on 2018/7/18.
 */

public class AppBarLayoutActivity extends AppCompatActivity implements OnRefreshListener ,OnLoadMoreListener {


    IRecyclerView ir ;

    private List<String> list = new ArrayList<>();
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.material_desgin_app_bar_layout);

        ir = findViewById(R.id.ir);

        getData();

        adapter = new RecyclerView.Adapter() {
            @NonNull
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                View inflate = LayoutInflater.from(AppBarLayoutActivity.this).inflate( R.layout.item, parent ,false);

                return new ItemViewHolder(inflate);
            }

            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

            }

            @Override
            public int getItemCount() {
                return list.size();
            }
        };
        ir.setIAdapter(adapter);
        ir.setLayoutManager(new LinearLayoutManager(AppBarLayoutActivity.this));
        ir.setOnRefreshListener(this);
        ir.setOnLoadMoreListener(this);
        ir.setRefreshEnabled(true);
        ir.setLoadMoreEnabled(true);
    }

    private void getData() {
        for (int i = 0; i < 20; i++) {
            list.add("item"+i);
        }
    }


    static class ItemViewHolder extends RecyclerView.ViewHolder{

        public ItemViewHolder(View itemView) {
            super(itemView);
        }
    }

    @Override
    public void onLoadMore() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getData();
                adapter.notifyDataSetChanged();
            }
        },2000);
    }

    @Override
    public void onRefresh() {

    }
}
