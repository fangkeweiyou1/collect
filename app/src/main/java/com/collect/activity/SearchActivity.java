package com.collect.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.collect.R;
import com.collect.view.SearchView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.campusapp.router.annotation.RouterMap;
import timber.log.Timber;

/**
 * Created by zhangyuncai on 2017/9/29.
 */
@RouterMap("activity://search")
public class SearchActivity extends AppCompatActivity {
    @BindView(R.id.searchview)
    SearchView searchview;
    @BindView(R.id.recyclerview_mayknow)
    RecyclerView recyclerview_mayknow;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);

        String string = "daf adfad";
        int trimmedLength = TextUtils.getTrimmedLength(string);
        System.out.println("-----------------<<<>>>--------------------trimmedLength=" + trimmedLength);

        initView();

        initData();

        initEvent();
    }

    private void initView() {
        List<String> Suggestions = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Suggestions.add("棉纱" + i);
        }
        searchview.setSuggestions(Suggestions);

        recyclerview_mayknow.setLayoutManager(new LinearLayoutManager(this));
        recyclerview_mayknow.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("可能认识的数据" + i);
        }
        recyclerview_mayknow.setAdapter(new SearchViewAdapter(list));
    }

    private void initData() {

    }

    private void initEvent() {


        searchview.setOnSearchViewListener(new SearchView.SearchViewListener() {
            @Override
            public void onClickBack() {
                Timber.d("----------->>>>>>>>-----------onClickBack=");
            }

            @Override
            public void onQueryTextSubmit(String query) {
                Timber.d("----------->>>>>>>>-----------query="+query);
            }
        });
    }

    /**
     * 联想词适配器
     */
    public class SearchViewAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
        public SearchViewAdapter(@Nullable List<String> data) {
            super(R.layout.item_search_adapter,data);
        }

        @Override
        protected void convert(BaseViewHolder helper, String item) {
            helper.setText(R.id.tv_searchview_name, item);
            helper.itemView.setTag(item);
        }

    }

}
