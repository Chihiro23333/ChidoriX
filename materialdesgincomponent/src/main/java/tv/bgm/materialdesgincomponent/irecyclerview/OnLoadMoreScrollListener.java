package tv.bgm.materialdesgincomponent.irecyclerview;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

/**
 * Created by aspsine on 16/3/13.
 */
public abstract class OnLoadMoreScrollListener extends RecyclerView.OnScrollListener {

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {

        if(dy >0){


            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            int visibleItemCount = layoutManager.getChildCount();

            boolean triggerCondition = visibleItemCount > 0
                    && canTriggerLoadMore(recyclerView);
            if (triggerCondition) {
                Log.d("eee","onScrolled");
                onLoadMore(recyclerView);
            }

        }

    }

    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {

//
//        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
//        int visibleItemCount = layoutManager.getChildCount();
////
//        Log.d("eee","onScrollStateChanged"+newState);
//
//        boolean triggerCondition = visibleItemCount > 0
//                && newState == RecyclerView.SCROLL_STATE_IDLE
//                && canTriggerLoadMore(recyclerView);
//
//        if (triggerCondition) {
//            onLoadMore(recyclerView);
//        }
    }

    public boolean canTriggerLoadMore(RecyclerView recyclerView) {
        View lastChild = recyclerView.getChildAt(recyclerView.getChildCount() - 1);
        int position = recyclerView.getChildLayoutPosition(lastChild);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        int totalItemCount = layoutManager.getItemCount();
        return totalItemCount - 1 == position;
    }

    public abstract void onLoadMore(RecyclerView recyclerView);
}
