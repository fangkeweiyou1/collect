package com.collect.model;

import com.bigkoo.pickerview.model.IPickerViewData;

/**
 * Created by zhangyuncai on 2017/9/20.
 */

public class YijiModel implements IPickerViewData {

    public YijiModel(String des) {
        this.des = des;
    }

    private String des;

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    /**
     * 弹窗显示的文字
     * @return
     */
    @Override
    public String getPickerViewText() {
        return des;
    }
}
