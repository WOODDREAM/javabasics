/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package responsibility;

import responsibility.Approver;
import responsibility.approver.DirectorApprover;
import responsibility.approver.SecondApprover;
import responsibility.approver.ThirdAprover;

/**
 * Created by 黄桃 on 2017/6/2.
 */
public class ApproverTest {
    public static void main(String[] args) {
        Approver approver1, approver2, approver3;
        approver1 = new DirectorApprover("我是第一个责任人");
        approver2 = new SecondApprover("我是第二个责任人");
        approver3 = new ThirdAprover("我是第三个责任人");
        approver1.setSuccessor(approver2);
        approver2.setSuccessor(approver3);
        Request request = new Request();
        request.setValue(1);
        approver1.handle(request);

    }
}
