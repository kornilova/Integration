package com.estylesoft.integration;


/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 30.10.13
 * Time: 17:37
 * To change this template use File | Settings | File Templates.
 */
public class CheckResult {

    public enum ResultType{
        ERROR,
        WARNING,
        FATAL;
    }

    private boolean isSuccess;
    private String messageTest;
    private StringBuilder lMessage;
    private char strDelimeter = '\n';

    public CheckResult(boolean isSuccess, String messageTest) {
        this.isSuccess = isSuccess;
        this.messageTest = messageTest;
        lMessage = new StringBuilder();
    }

    public CheckResult() {
        this.isSuccess = true;
        this.messageTest = null;
        lMessage = new StringBuilder();
    }

    public void addToListMessage(String value, ResultType type) {
        if (lMessage.length()==0) lMessage.append(strDelimeter);
        lMessage.append(type.name()+":")
                .append(value)
                .append(strDelimeter);
    }

    public StringBuilder getListMessage() {
        return lMessage;
    }

    public String getFullMessage() {
        return lMessage.toString();
    }


    public void setIsSuccess(boolean isSuccess) {
        if (this.isSuccess != isSuccess) this.isSuccess = isSuccess;
    }

    public boolean getIsSuccess() {
        return isSuccess;
    }

    public void setMessageTest(String messageTest) {
        this.messageTest = messageTest;
    }

    public String getMessageTest() {
        return messageTest;
    }

}
