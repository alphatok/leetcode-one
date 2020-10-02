package com.brzyang;

import com.brzyang.algo.bit.BitSuiteTest;
import com.brzyang.algo.lang.LangSuiteTest;
import com.brzyang.algo.sort.SortSuiteTest;
import com.brzyang.algo.util.UtilSuiteTest;
import junit.framework.TestCase;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        SortSuiteTest.class,
        UtilSuiteTest.class,
        BitSuiteTest.class,
        LangSuiteTest.class,
        // 接着写其他被测单元测试类
})

public class AppTest  extends TestCase{
}
