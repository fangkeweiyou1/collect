//package com.collect.activity;
//
//import android.os.Bundle;
//import android.os.Looper;
//import android.support.annotation.Nullable;
//
//import com.collect.R;
//import com.collect.base.BaseActivity;
//
//import cn.campusapp.router.annotation.RouterMap;
//import io.reactivex.Observable;
//import io.reactivex.Observer;
//import io.reactivex.android.schedulers.AndroidSchedulers;
//import io.reactivex.annotations.NonNull;
//import io.reactivex.disposables.Disposable;
//import io.reactivex.functions.Function;
//import io.reactivex.schedulers.Schedulers;
//
///**
// * Created by zhangyuncai on 2017/8/19.
// */
//@RouterMap("activity://rxjava")
//public class RxjavaActivity extends BaseActivity {
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_rxjava);
//
//
//        Observable<Integer> observable = new Observable<Integer>() {
//            @Override
//            protected void subscribeActual(Observer<? super Integer> observer) {
//                boolean b = Looper.getMainLooper() == Looper.myLooper();
//                observer.onNext(4);
//                observer.onNext(5);
//                observer.onNext(6);
//                observer.onComplete();
//
//            }
//        };
//
//        Observer<Integer> observer = new Observer<Integer>() {
//            @Override
//            public void onSubscribe(@NonNull Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(@NonNull Integer integer) {
//                boolean b = Looper.getMainLooper() == Looper.myLooper();
//            }
//
//            @Override
//            public void onError(@NonNull Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//            }
//        };
//
//        Observer<String> observer1 = new Observer<String>() {
//            @Override
//            public void onSubscribe(@NonNull Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(@NonNull String s) {
//            }
//
//            @Override
//            public void onError(@NonNull Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//            }
//        };
//
//        observable.subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .map(new Function<Integer, String>() {
//                    @Override
//                    public String apply(@NonNull Integer integer) throws Exception {
//                        return "啦啦";
//                    }
//                })
//                .subscribe(observer1);
//
////        Observable.create(new ObservableOnSubscribe<Integer>() {
////            @Override
////            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
////                e.onNext(1);
////                e.onNext(2);
////                e.onNext(3);
////                e.onComplete();
////
////            }
////        }).subscribe(new Observer<Integer>() {
////            @Override
////            public void onSubscribe(@NonNull Disposable d) {
////
////            }
////
////            @Override
////            public void onNext(@NonNull Integer integer) {
////            }
////
////            @Override
////            public void onError(@NonNull Throwable e) {
////
////            }
////
////            @Override
////            public void onComplete() {
////            }
////        });
//    }
//}
