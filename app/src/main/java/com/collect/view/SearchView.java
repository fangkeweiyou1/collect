package com.collect.view;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.collect.R;

import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;

/**
 * Created by zhangyuncai on 2017/9/29.
 */

public class SearchView extends FrameLayout implements View.OnClickListener {

    private Context mContext;
    private FrameLayout mSearchLayout;//整个view的布局容器
    private RelativeLayout toplayout;//布局顶部视图
    private ImageButton ib_back;//返回标志
    private ImageButton ib_clear;//清除标志
    private Button bt_search;//搜索文字
    private EditText mSearchSrcTextView;//编辑搜索
    private RecyclerView mRecyclerView;//用于联想
    private SearchViewAdapter mAdapter;


    private SearchViewListener mSearchViewListener;//搜索状态监听


    public SearchView(Context context) {
        this(context, null);
    }

    public SearchView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SearchView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mContext = context;

        init();

        initView();

        initData();

        initEvent();
    }

    private void init() {
        LayoutInflater.from(mContext).inflate(R.layout.view_search, this, true);

        mSearchLayout = (FrameLayout) findViewById(R.id.fl_searchview_layout);
        toplayout = (RelativeLayout) findViewById(R.id.rl_searchview_toplayout);
        ib_back = (ImageButton) findViewById(R.id.ib_searchview_back);
        ib_clear = (ImageButton) findViewById(R.id.ib_searchview_clear);
        bt_search = (Button) findViewById(R.id.bt_searchview_search);
        mSearchSrcTextView = (EditText) findViewById(R.id.et_searchview_edit);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_searchview);
    }

    private void initView() {
        mAdapter = new SearchViewAdapter(null);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        mRecyclerView.setAdapter(mAdapter);
    }

    private void initData() {
    }

    private void initEvent() {
        ib_back.setOnClickListener(this);
        mSearchSrcTextView.setOnClickListener(this);
        ib_clear.setOnClickListener(this);
        bt_search.setOnClickListener(this);

        //点击搜索监听
        mSearchSrcTextView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                onSubmitQuery();
                return true;
            }
        });

        //编辑文字变化监听
        mSearchSrcTextView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                startFilter(s);
                ib_clear.setVisibility(TextUtils.isEmpty(s) ? GONE : VISIBLE);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mSearchSrcTextView.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    showKeyboard(mSearchSrcTextView);
                    startFilter("");
                }
            }
        });

        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                if (mSearchViewListener != null) {
                    String searchText = (String) view.getTag();
                    if (!TextUtils.isEmpty(searchText)) {
                        mSearchSrcTextView.setText(searchText);
                        mSearchSrcTextView.setSelection(searchText.length());
                        mSearchViewListener.onQueryTextSubmit(searchText);
                    }
                }
            }
        });
    }

    private List<String> suggestions;//联想词集合

    /**
     * 设置建议集合
     */
    public void setSuggestions(List<String> suggestions) {
        this.suggestions = suggestions;
        startFilter(mSearchSrcTextView.getText());
    }

    public void hideKeyboard(View view) {
        InputMethodManager imm = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public void showKeyboard(View view) {
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.GINGERBREAD_MR1 && view.hasFocus()) {
            view.clearFocus();
        }
        view.requestFocus();
        InputMethodManager imm = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(view, 0);
    }

    /**
     * 联想词筛选
     *
     * @param s
     */
    private void startFilter(CharSequence s) {

        String string = s.toString();
        Timber.d("----------->>>>>>>>-----------当前编辑文字:" + string);

        List<String> filters = new ArrayList<>();
        if (!TextUtils.isEmpty(string)) {
            if (suggestions != null) {
                for (String s1 : suggestions) {
                    if (s1.contains(string)) {
                        filters.add(s1);
                    }
                }
            }
        }
        if (filters.size() != 0) {
            mAdapter.replaceData(filters);
            mRecyclerView.setVisibility(VISIBLE);
            Timber.d("----------->>>>>>>>-----------有筛选词,显示联想控件" + filters.toString());
        } else {
            mRecyclerView.setVisibility(GONE);
            Timber.d("----------->>>>>>>>-----------无筛选词,隐藏联想控件");
        }

    }

    /**
     * 点击搜索后
     */
    private void onSubmitQuery() {
        //搜索文字
        String query = mSearchSrcTextView.getText().toString().trim();
        Timber.d("----------->>>>>>>>-----------搜索文字=" + query);
        if (!TextUtils.isEmpty(query)) {
            //关闭联想列表
            mRecyclerView.setVisibility(GONE);

            //关闭键盘
            hideKeyboard(this);

            //失去焦点
            mSearchSrcTextView.clearFocus();

            if (mSearchViewListener != null) {
                mSearchViewListener.onQueryTextSubmit(query);
            }

        }
    }


    @Override
    public void onClick(View v) {
        if (v == ib_back) {
            if (mSearchViewListener != null) {
                mSearchViewListener.onClickBack();
            }
        } else if (v == ib_clear) {
            mSearchSrcTextView.setText(null);
        } else if (v == mSearchSrcTextView) {
            startFilter("");
        } else if (v == bt_search) {
            onSubmitQuery();
        }
    }


    /**
     * 搜索状态监听
     *
     * @param listener
     */
    public void setOnSearchViewListener(com.collect.view.SearchView.SearchViewListener listener) {
        mSearchViewListener = listener;
    }

    public interface SearchViewListener {

        /**
         * 点击返回icon
         */
        void onClickBack();

        /**
         * 点击搜索
         *
         * @param query 点击搜索后的 编辑栏的文字
         * @return
         */
        void onQueryTextSubmit(String query);

    }

    /**
     * 联想词适配器
     */
    public class SearchViewAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
        public SearchViewAdapter(@Nullable List<String> data) {
            super(R.layout.item_search_adapter, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, String item) {
            helper.setText(R.id.tv_searchview_name, item);
            helper.itemView.setTag(item);
        }

    }

}
