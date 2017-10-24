package com.collect.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.Button;

import com.bigkoo.pickerview.adapter.WheelAdapter;
import com.bigkoo.pickerview.lib.WheelView;
import com.bigkoo.pickerview.listener.OnItemSelectedListener;
import com.collect.R;
import com.collect.base.BaseActivity;
import com.collect.model.PickerA;
import com.collect.model.PickerB;
import com.collect.model.PickerBaseModel;
import com.collect.model.PickerC;
import com.collect.model.PickerD;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.campusapp.router.annotation.RouterMap;

/**
 * Created by zhangyuncai on 2017/9/23.
 */
@RouterMap("activity://pickerview5")
public class PickerView5Activity extends BaseActivity {

    @BindView(R.id.bt_index)
    Button btIndex;
    @BindView(R.id.wheela)
    WheelView wheelA;
    @BindView(R.id.wheelb)
    WheelView wheelB;
    @BindView(R.id.wheelc)
    WheelView wheelC;
    @BindView(R.id.wheeld)
    WheelView wheelD;
    private MyAdapter adapterA;
    private MyAdapter adapterB;
    private MyAdapter adapterC;
    private MyAdapter adapterD;


    private List<PickerA> pickerAList;
    private List<PickerB> pickerBList;
    private List<PickerC> pickerCList;
    private List<PickerD> pickerDList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_pickerview5);
        ButterKnife.bind(this);

        initData();


        adapterA = new MyAdapter(pickerAList);
        adapterB = new MyAdapter(pickerBList);
        adapterC = new MyAdapter(pickerCList);
        adapterD = new MyAdapter(pickerDList);

        wheelA.setAdapter(adapterA);
        wheelB.setAdapter(adapterB);
        wheelC.setAdapter(adapterC);
        wheelD.setAdapter(adapterD);

        wheelA.setCyclic(false);
        wheelB.setCyclic(false);
        wheelC.setCyclic(false);
        wheelD.setCyclic(false);

        wheelA.setOnItemSelectedListener(new MyOnItemSelectedListenerImp(pickerAList));
        wheelB.setOnItemSelectedListener(new MyOnItemSelectedListenerImp(pickerBList));
        wheelC.setOnItemSelectedListener(new MyOnItemSelectedListenerImp(pickerCList));
        wheelD.setOnItemSelectedListener(new MyOnItemSelectedListenerImp(pickerDList));

//        wheel1.setOnItemSelectedListener(new OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(int index) {
//                System.out.println("-----------------<<<>>>--------------------index=" + index);
//            }
//        });

//        btIndex.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                wheel1.setCurrentItem(4);
//            }
//        });

    }

    private void initData() {
        pickerAList = new ArrayList<>();
        pickerBList = new ArrayList<>();
        pickerCList = new ArrayList<>();
        pickerDList = new ArrayList<>();

        PickerA a = null;
        for (int i = 0; i < 4; i++) {
            a = new PickerA();
            a.index = i;
            a.name = "A" + i;
            pickerAList.add(a);
        }


        PickerB b = null;
        for (int i = 0; i < 3; i++) {
            b = new PickerB();
            b.index = i;
            b.name = "B" + i;
            pickerBList.add(b);
        }

        PickerC c = null;
        for (int i = 0; i < 5; i++) {
            c = new PickerC();
            c.index = i;
            c.name = "C" + i;
            pickerCList.add(c);
        }

        PickerD d = null;
        for (int i = 0; i < 6; i++) {
            d = new PickerD();
            d.index = i;
            d.name = "D" + i;
            pickerDList.add(d);
        }

        Random random = new Random();
        Set<Integer> set1;
        Set<Integer> set2;
        Set<Integer> set3;
        for (PickerA pickerA : pickerAList) {
            set1 = new HashSet<>();
            set2 = new HashSet<>();
            set3 = new HashSet<>();
            for (int i = 0; i < pickerBList.size(); i++) {
                if (random.nextBoolean()) {
                    int j = random.nextInt(pickerBList.size());
                    set1.add(j);
                }
            }
            pickerA.bList = set1;
            for (int i = 0; i < pickerCList.size(); i++) {
                if (random.nextBoolean()) {
                    int j = random.nextInt(pickerCList.size());
                    set2.add(j);
                }
            }
            pickerA.cList = set2;
            for (int i = 0; i < pickerDList.size(); i++) {
                if (random.nextBoolean()) {
                    int j = random.nextInt(pickerDList.size());
                    set3.add(j);
                }
            }
            pickerA.dList = set3;
        }

        for (PickerB pickerB : pickerBList) {
            set1 = new HashSet<>();
            set2 = new HashSet<>();
            set3 = new HashSet<>();
            for (int i = 0; i < pickerAList.size(); i++) {
                if (random.nextBoolean()) {
                    int j = random.nextInt(pickerAList.size());
                    set1.add(j);
                }
            }
            pickerB.aList = set1;
            for (int i = 0; i < pickerCList.size(); i++) {
                if (random.nextBoolean()) {
                    int j = random.nextInt(pickerCList.size());
                    set2.add(j);
                }
            }
            pickerB.cList = set2;
            for (int i = 0; i < pickerDList.size(); i++) {
                if (random.nextBoolean()) {
                    int j = random.nextInt(pickerDList.size());
                    set3.add(j);
                }
            }
            pickerB.dList = set3;
        }

        for (PickerC pickerC : pickerCList) {
            set1 = new HashSet<>();
            set2 = new HashSet<>();
            set3 = new HashSet<>();
            for (int i = 0; i < pickerBList.size(); i++) {
                if (random.nextBoolean()) {
                    int j = random.nextInt(pickerBList.size());
                    set1.add(j);
                }
            }
            pickerC.bList = set1;
            for (int i = 0; i < pickerCList.size(); i++) {
                if (random.nextBoolean()) {
                    int j = random.nextInt(pickerCList.size());
                    set2.add(j);
                }
            }
            pickerC.aList = set2;
            for (int i = 0; i < pickerAList.size(); i++) {
                if (random.nextBoolean()) {
                    int j = random.nextInt(pickerAList.size());
                    set3.add(j);
                }
            }
            pickerC.dList = set3;
        }

        for (PickerD pickerD : pickerDList) {
            set1 = new HashSet<>();
            set2 = new HashSet<>();
            set3 = new HashSet<>();
            for (int i = 0; i < pickerBList.size(); i++) {
                if (random.nextBoolean()) {
                    int j = random.nextInt(pickerBList.size());
                    set1.add(j);
                }
            }
            pickerD.bList = set1;
            for (int i = 0; i < pickerCList.size(); i++) {
                if (random.nextBoolean()) {
                    int j = random.nextInt(pickerCList.size());
                    set2.add(j);
                }
            }
            pickerD.cList = set2;
            for (int i = 0; i < pickerAList.size(); i++) {
                if (random.nextBoolean()) {
                    int j = random.nextInt(pickerAList.size());
                    set3.add(j);
                }
            }
            pickerD.aList = set3;
        }

    }

    class MyAdapter<T extends PickerBaseModel> implements WheelAdapter<String> {
        private List<T> datas;

        public MyAdapter(List<T> datas) {
            this.datas = datas;
        }

        @Override
        public int getItemsCount() {
            if (datas != null) {
                return datas.size();
            }
            return 0;
        }

        @Override
        public String getItem(int index) {
            return datas.get(index).name;
        }

        @Override
        public int indexOf(String string) {
            for (int i = 0; i < datas.size(); i++) {
                if (TextUtils.equals(datas.get(i).name, string)) {
                    return i;
                }
            }
            return 0;
        }
    }

    class MyOnItemSelectedListenerImp<T extends PickerBaseModel> implements OnItemSelectedListener {
        private List<T> datas;


        public MyOnItemSelectedListenerImp(List<T> datas) {
            this.datas = datas;
        }

        @Override
        public void onItemSelected(int index) {
            if (datas != null && datas.size() > index) {
                T t = datas.get(index);
                Set<Integer> alist = t.getAlist();
                Set<Integer> blist = t.getBlist();
                Set<Integer> clist = t.getClist();
                Set<Integer> dlist = t.getDlist();


                if (alist != null) {
                    for (Integer integer : alist) {
                        System.out.println("-----------------<<<>>>--------------------A:" + integer);
                    }
                    wheelA.setCurrentItem(getMin(alist));
                }

                if (blist != null) {
                    for (Integer integer : blist) {
                        System.out.println("-----------------<<<>>>--------------------B:" + integer);
                    }
                    wheelB.setCurrentItem(getMin(blist));
                }

                if (clist != null) {
                    for (Integer integer : clist) {
                        System.out.println("-----------------<<<>>>--------------------C:" + integer);
                    }
                    wheelC.setCurrentItem(getMin(clist));
                }

                if (dlist != null) {
                    for (Integer integer : dlist) {
                        System.out.println("-----------------<<<>>>--------------------D:" + integer);
                    }
                    wheelD.setCurrentItem(getMin(dlist));
                }
            }
        }
    }

    public int getMin(Set<Integer> set) {
        int min = 100;
        if (set != null) {
            for (Integer integer : set) {
                if (min > integer) {
                    min = integer;
                }
            }
        }
        return min;
    }
}
