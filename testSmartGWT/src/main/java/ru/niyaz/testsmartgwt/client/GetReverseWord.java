package ru.niyaz.testsmartgwt.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * Created by user on 11.12.15.
 */

@RemoteServiceRelativePath("reverseWord")
public interface GetReverseWord extends RemoteService {
    String getReverseWord(String word);
}