/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package responsibility.approver;

import responsibility.Approver;
import responsibility.Request;

/**
 * Created by 黄桃 on 2017/6/2.
 */
public class SecondApprover extends Approver {
    public SecondApprover(String name) {
        super(name);
    }

    public int processRequest(Request request) {
        if (request.getValue() == 2) {
            return 2;
        } else {
            return this.successor.processRequest(request);
        }
    }
}
