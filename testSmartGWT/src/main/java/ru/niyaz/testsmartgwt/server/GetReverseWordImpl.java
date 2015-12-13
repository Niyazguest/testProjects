package ru.niyaz.testsmartgwt.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import ru.niyaz.testsmartgwt.client.GetReverseWord;

/**
 * Created by user on 12.12.15.
 */
public class GetReverseWordImpl extends RemoteServiceServlet implements GetReverseWord {
    public String getReverseWord(String word) {
        return new StringBuilder(word).reverse().toString();
    }
}
