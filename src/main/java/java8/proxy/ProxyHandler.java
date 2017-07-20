/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package java8.proxy;


import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ProxyHandler
 *
 * @author huangtao
 * @since 2017-07-20
 */
public class ProxyHandler implements InvocationHandler {
    private Subject subject;

    public ProxyHandler(Subject subject) {
        this.subject = subject;
    }

    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        ///???????????
        System.out.println(o.getClass().getName());
        if (o instanceof ProxyHandler) {
            System.out.println("real subject");
        } else {
            System.out.println("not real subject");
        }
        return method.invoke(subject, objects);
    }

    public static void main(String[] args) throws Exception {
        RealSubject realSubject = new RealSubject();
        Subject proxySubject = (Subject) Proxy.newProxyInstance(RealSubject.class.getClassLoader(), new Class[]{Subject.class}, new ProxyHandler(realSubject));
        proxySubject.doSomething(1, "huangTao");
        createProxyClassFile();
    }

    public static void createProxyClassFile() throws IOException {
        String name = "ProxySubject";
        byte[] data = ProxyGenerator.generateProxyClass(name, new Class[]{Subject.class});
        FileOutputStream outputStream = new FileOutputStream(name + ".txt");
        outputStream.write(data);
        outputStream.close();
    }
}
