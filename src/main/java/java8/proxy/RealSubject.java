/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package java8.proxy;

/**
 * RealSubject
 *
 * @author huangtao
 * @since 2017-07-20
 */
public class RealSubject implements Subject {
    public void doSomething(Integer index, String name) throws Exception {
        if (null == index) {
            index = 0;
        }
        if (index > name.length()) {
            throw new Exception("index of length");
        }
        System.out.println(name.indexOf(name, index));
    }
}
