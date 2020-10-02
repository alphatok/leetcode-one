package com.brzyang.algo.lang;


import junit.framework.TestCase;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        MyIntegerTest.class,
        MyStringTest.class,
        // 接着写其他被测单元测试类
})

public class LangSuiteTest extends TestCase {

}