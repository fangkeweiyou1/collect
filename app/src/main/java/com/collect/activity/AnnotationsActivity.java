//package com.collect.activity;
//
//import android.os.Bundle;
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;
//import android.widget.TextView;
//
//import com.collect.R;
//import com.collect.annotationstest.GetViewTo;
//import com.collect.base.BaseActivity;
//
//import java.lang.annotation.Inherited;
//import java.lang.reflect.Field;
//
//import cn.campusapp.router.annotation.RouterMap;
//
///**
// * Created by zhangyuncai on 2017/8/2.
// * 学习annotations的使用
// */
//@RouterMap({"activity://annotations"})
//public class AnnotationsActivity extends BaseActivity {
//    @GetViewTo(R.id.tv_annotations1)
//    private TextView tv1;
//    @GetViewTo(R.id.tv_annotations2)
//    private TextView tv2;
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_annotations);
//
//        /*
//        TODO 元注解是由java提供的基础注解，负责注解其它注解
//
//        元注解有：
//        @Retention：注解保留的生命周期
//        @Target：注解对象的作用范围。
//        @Inherited：@Inherited标明所修饰的注解，在所作用的类上，是否可以被继承。
//        @Documented：如其名，javadoc的工具文档化，一般不关心。
//
//         */
//
//        /*
//        TODO Retention说标明了注解被生命周期，对应RetentionPolicy的枚举，表示注解在何时生效：
//        SOURCE：只在源码中有效，编译时抛弃，如上面的@Override。
//        CLASS：编译class文件时生效。
//        RUNTIME：运行时才生效。
//         */
////        String str = null;
////        Test2 test2 = new Test2();
////        test2.show(str);
//
//        /*
//        TODO @Target
//
//        Target标明了注解的适用范围，对应ElementType枚举，明确了注解的有效范围。
//        TYPE：类、接口、枚举、注解类型。
//        FIELD：类成员（构造方法、方法、成员变量）。
//        METHOD：方法。
//        PARAMETER：参数。
//        CONSTRUCTOR：构造器。
//        LOCAL_VARIABLE：局部变量。
//        ANNOTATION_TYPE：注解。
//        PACKAGE：包声明。
//        TYPE_PARAMETER：类型参数。
//        TYPE_USE：类型使用声明。
//         */
//
//        /*
//       TODO  @Inherited
//
//        注解所作用的类，在继承时默认无法继承父类的注解。除非注解声明了 @Inherited。同时Inherited声明出来的注，只对类有效，
//        对方法／属性无效。
//         */
//
//        //通过注解生成控件
////        getAllAnnotation();
//
//        test(null);
//
//    }
//
//    private void test(@NonNull String str) {
//    }
//
//    /**
//     * 解析注解,获取控件(TODO 没有成功过)
//     */
//    public void getAllAnnotation() {
//        Field[] fields = this.getClass().getDeclaredFields();
//        if (fields != null) {
//            for (Field field : fields) {
////                String name = field.getName();
//
//                try {
//                    if (field.getAnnotations() != null) {
////                        if (field.isAnnotationPresent(GetViewTo.class)) {
//                        field.setAccessible(true);
//
//                        GetViewTo getViewTo = field.getAnnotation(GetViewTo.class);
//
//                        if (getViewTo != null) {
//                            int value = getViewTo.value();
//                            field.set(this, findViewById(getViewTo.value()));
////                        }
//                        }
//                    }
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//
//    class Test {
//        public void show(@NonNull String str) {
//        }
//    }
//
//    class Test2 extends Test {
//        @Override
//        public void show(@NonNull String str) {
//            super.show(str);
//        }
//    }
//
//    @Inherited
//    public @interface Ain {
//        String value();
//    }
//
//    @Ain("ddd")
//    class Test3 {
//
//    }
//}
