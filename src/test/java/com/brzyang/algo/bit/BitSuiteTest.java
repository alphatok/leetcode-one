package com.brzyang.algo.bit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        OtherRadixTest.class,
        BinaryTest.class,
        HexTest.class,
        OctalTest.class,
        // 接着写其他被测单元测试类
})
public class BitSuiteTest {
}
