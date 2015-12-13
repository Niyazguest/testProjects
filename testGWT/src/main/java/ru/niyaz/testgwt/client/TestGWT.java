package ru.niyaz.testgwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;

/**
 * Created by user on 12.12.15.
 */
public class TestGWT implements EntryPoint {

    private VerticalPanel vPanel = new VerticalPanel();
    private HorizontalPanel hPanel = new HorizontalPanel();
    private TextBox textBox = new TextBox();
    private Button button = new Button("Задом наперёд");
    private AsyncCallback<String> callback;
    private GetReverseWordAsync getReverseWordAsync = GWT.create(GetReverseWord.class);


    public void onModuleLoad() {
        button.setWidth("150%");
        HorizontalPanel hPanel2 = new HorizontalPanel();
        hPanel2.setHeight("50%");
        hPanel.setSpacing(50);
        hPanel.add(textBox);
        hPanel.add(button);
        vPanel.setSpacing(500);
        vPanel.add(hPanel2);
        vPanel.add(hPanel);
        RootPanel.get("word").add(vPanel);
        textBox.setFocus(true);
        button.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                addWord(textBox.getText());
            }
        });
        callback = new AsyncCallback<String>() {
            public void onFailure(Throwable caught) {
                return;
            }

            public void onSuccess(String result) {
                textBox.setText(result);
            }
        };
    }

    private void addWord(String word) {
        getReverseWordAsync.getReverseWord(textBox.getText(), callback);
    }

}
