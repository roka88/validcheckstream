package com.roka.validcheckstream;


/**
 * Created by roka on 2016. 9. 2..
 */
public class ValidCheckStream {

    private static ValidCheckStream mValidCheckStream;
    private static String mErrMsg = "ok";

    private ValidCheckStream() {}

    public static ValidCheckStream stream() {
        if (mValidCheckStream == null) {
            mValidCheckStream = new ValidCheckStream();
        }
        mErrMsg = "ok";
        return mValidCheckStream;
    }

    public ValidCheckStream check(ValidCheckFunction listener, String errMsg) {
        if (listener.function()) {
            return mValidCheckStream;
        }
        if (mErrMsg.equals("ok")) {
            this.mErrMsg = errMsg;
        }
        return mValidCheckStream;
    }

    public String result() {
        return mErrMsg;
    }
}
