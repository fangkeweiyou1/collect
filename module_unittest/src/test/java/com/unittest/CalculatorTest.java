package com.unittest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by zhangyuncai on 2017/9/10.
 */
public class CalculatorTest {


    private Calculator calculator;

    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    @Test
    public void testAdd() throws Exception {
        int sum = calculator.add(1, 4);
        Assert.assertEquals(3, sum);
    }

    @Test
    public void testAddFloat() throws Exception {
        float sum = calculator.addFloat(1.2345f, 2.345f);
        /**
         * @params 0.5f表示容许误差值
         */
        Assert.assertEquals(1.5f, sum, 0.5f);
    }

    @Ignore("当我想跑所有测试方法唯独不想跑这个,就用Ignore标签")
    @Test
    public void testIsComputerName() throws Exception {
        boolean isComputerName = calculator.isComputerName("电脑");
        Assert.assertTrue(isComputerName);
    }

    @Test
    public void testDivide() throws Exception {
        double three = calculator.divide(4, 2);
        Assert.assertEquals(2, three, 0.5d);
    }

}

/**
 * TODO 注意：上面的每一个方法，都有一个重载的方法，可以在前面加一个String类型的参数，表示如果验证失败的话，将用这个字符串作为失败的结果报告。
 * <p>
 * assertTrue(boolean condition)
 * 验证contidion的值是true
 * <p>
 * assertFalse(boolean condition)
 * 验证contidion的值是false
 * <p>
 * assertNull(Object obj)
 * 验证obj的值是null
 * <p>
 * assertNotNull(Object obj)
 * 验证obj的值不是null
 * <p>
 * assertSame(expected, actual)
 * 验证expected和actual是同一个对象，即指向同一个对象
 * <p>
 * assertNotSame(expected, actual)
 * 验证expected和actual不是同一个对象，即指向不同的对象
 * <p>
 * fail()
 * 让测试方法失败
 */