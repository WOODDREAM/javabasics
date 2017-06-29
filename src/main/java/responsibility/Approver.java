/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package responsibility;

/**
 * Created by 黄桃 on 2017/6/2.
 */
public abstract class Approver {
    protected Approver successor;//后继对象
    protected String name;//责任人名字

    public Approver(String name) {
        this.name = name;
    }

    /**
     * 设置后继者
     *
     * @param approver
     */
    public void setSuccessor(Approver approver) {
        this.successor = approver;
    }

    public abstract int processRequest(Request request);

    public void printName() {
        System.out.println("name:" + this.name);
    }

    public void handle(Request request) {
        printName();
        System.out.println(processRequest(request));
    }

}
