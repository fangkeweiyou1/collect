package com.collect.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.collect.R;
import com.collect.model.TestModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zhangyuncai on 2017/7/27.
 */

public class TestAdpater extends RecyclerView.Adapter<TestAdpater.TestViewHolder> {


    private Context mContext;
    private List<TestModel> list;
    private TestListener listener;

    public TestAdpater(Context context, TestListener listener) {
        this.mContext = context;
        this.listener = listener;

        addTestData();
    }

    public TestAdpater(Context context, List<TestModel> list, TestListener listener) {
        this.mContext = context;
        this.list = list;
        this.listener = listener;

        if (list == null || list.size() == 0) {
            addTestData();
        }

    }

    public void setData(List<TestModel> list) {
        this.list = list;

        if (list == null || list.size() == 0) {
            addTestData();
        }
    }

    public interface TestListener {
        void onClickItem(String content);
    }

    private void addTestData() {
        list = new ArrayList<>();

        TestModel model;
        for (int i = 0; i < 100; i++) {
            model = new TestModel();
            model.setName("测试名称" + i);
            model.setContent("测试内容" + i);
            list.add(model);

        }
    }

    @Override
    public TestViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.adapter_test, parent, false);

        TestViewHolder holder = new TestViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(TestViewHolder holder, int position) {
        holder.bindData(position);

    }

    @Override
    public int getItemCount() {
        if (list != null)
            return list.size();
        return 0;
    }

    class TestViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_name)
        TextView tv_name;
        @BindView(R.id.tv_content)
        TextView tv_content;

        private View itemView;

        public TestViewHolder(View itemView) {
            super(itemView);

            this.itemView = itemView;

            ButterKnife.bind(this, itemView);
        }

        private void bindData(int position) {
            final TestModel model = list.get(position);
            tv_name.setText(model.getName());
            tv_content.setText(model.getContent());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onClickItem(model.getContent());
                    }
                }
            });

//            itemView.getX()

            tv_name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String string = tv_name.getText().toString();
                    if (TextUtils.equals(string, "测试名称0")) {
                        tv_name.setText("上帝啊");
                    } else {
                        tv_name.setText("测试名称0");

                    }
                }
            });
        }
    }
}
