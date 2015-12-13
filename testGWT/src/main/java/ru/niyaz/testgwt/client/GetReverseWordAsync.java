package ru.niyaz.testgwt.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Created by user on 11.12.15.
 */
public interface GetReverseWordAsync {
    void getReverseWord(String word, AsyncCallback<String> callback);
}
