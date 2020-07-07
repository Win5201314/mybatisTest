package com.zsl.mybatis.filter;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * @author : zsl
 * @date : Created in 2020/6/29 11:48 上午
 */
public class BloomFilterTest {

    /**
     * 准备向布隆过滤器预存一百万数据
     */
    private static int size = 1000000;

    /**
     * 初始化布隆过滤器 最后一个参数 容错率
     */
    private static BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(), size, 0.01);
}
