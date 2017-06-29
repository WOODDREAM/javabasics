/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package responsibility.approver;

import responsibility.Approver;
import responsibility.Request;

/**
 * Created by 黄桃 on 2017/6/2.
 */
public class ThirdAprover extends Approver {

    public ThirdAprover(String name) {
        super(name);
    }

    public int processRequest(Request request) {
        return 3;
    }
}
