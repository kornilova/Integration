package com.estylesoft.integration;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 30.10.13
 * Time: 17:37
 * To change this template use File | Settings | File Templates.
 */
public class CheckResult {

    private boolean isSuccess;
    private String messageTest;

    public CheckResult(boolean isSuccess, String messageTest)
    {
        this.isSuccess=isSuccess;
        this.messageTest=messageTest;
    }

    public CheckResult()
    {
        this.isSuccess=true;
        this.messageTest=null;
    }

    public void setIsSuccess(boolean isSuccess)
    {
         this.isSuccess = isSuccess;
    }

    public boolean getIsSuccess()
    {
        return isSuccess;
    }

    public void setMessageTest(String messageTest)
    {
        this.messageTest = messageTest;
    }

    public String getMessageTest()
    {
        return messageTest;
    }
}
