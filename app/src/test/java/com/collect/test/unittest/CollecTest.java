package com.collect.test.unittest;

import com.blankj.utilcode.utils.RegexUtils;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by zhangyuncai on 2017/9/10.
 */
public class CollecTest {



    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testAdd() throws Exception {
        boolean tel = RegexUtils.isMobileSimple("135 5453 5244");
        System.out.println("-----------------<<<>>>--------------------tel:"+tel);
    }


}
