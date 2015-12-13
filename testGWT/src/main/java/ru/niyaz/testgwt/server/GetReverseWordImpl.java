package ru.niyaz.testgwt.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import ru.niyaz.testgwt.client.GetReverseWord;

/**
 * Created by user on 12.12.15.
 */
public class GetReverseWordImpl extends RemoteServiceServlet implements GetReverseWord {
    public String getReverseWord(String word) {
        return new StringBuilder(word).reverse().toString();
    }
}
