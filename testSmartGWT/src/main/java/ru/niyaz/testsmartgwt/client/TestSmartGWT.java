package ru.niyaz.testsmartgwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.AutoFitWidthApproach;
import com.smartgwt.client.types.FieldType;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

/**
 * Created by user on 12.12.15.
 */
public class TestSmartGWT implements EntryPoint {

    private int number = 1;
    private TextBox textBox = new TextBox();
    private ListGrid listGrid = new ListGrid();
    private com.smartgwt.client.widgets.Button button = new com.smartgwt.client.widgets.Button("Отправить");
    private VLayout vLayout = new VLayout(2);
    private HLayout hLayoutTextBox = new HLayout(2);
    private HLayout hLayoutGrid = new HLayout(3);
    private DataSource dataSource = new DataSource();
    private GetReverseWordAsync getReverseWordAsync = GWT.create(GetReverseWord.class);

    public void onModuleLoad() {
        vLayout.setWidth("100%");
        vLayout.setHeight("80%");
        vLayout.setAlign(Alignment.CENTER);
        dataSource.setClientOnly(true);
        DataSourceField pkField = new DataSourceField("id", FieldType.INTEGER, "Id");
        pkField.setPrimaryKey(true);
        dataSource.setFields(pkField, new DataSourceField("reverse", FieldType.TEXT, "Reverse"));
        listGrid.setDataSource(dataSource);
        listGrid.setAutoFetchData(true);
        listGrid.setAlign(Alignment.CENTER);
        listGrid.setDefaultHeight(50);
        listGrid.setCellPadding(5);
        listGrid.setCellHeight(30);
        listGrid.setMinFieldWidth(50);
        listGrid.setWidth("30%");
        listGrid.setAlternateRecordStyles(true);
        ListGridField idField=new ListGridField("id", "Номер");
        idField.setAlign(Alignment.CENTER);
        ListGridField reverseField=new ListGridField("reverse", "Задом наперёд");
        reverseField.setAlign(Alignment.CENTER);
        listGrid.setFields(idField, reverseField);

        hLayoutTextBox.setAlign(Alignment.CENTER);
        hLayoutTextBox.setLayoutTopMargin(100);
        hLayoutTextBox.setHeight("30%");
        hLayoutTextBox.addMember(textBox);
        hLayoutTextBox.addMember(button);
        hLayoutGrid.setAlign(Alignment.CENTER);
        hLayoutGrid.addMember(listGrid);
        hLayoutGrid.setWidth("30%");
        vLayout.addMember(hLayoutTextBox);
        vLayout.addMember(hLayoutGrid);
        RootPanel.get("words").add(vLayout);

        textBox.setFocus(true);
        button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                addWord(textBox.getText());
            }
        });
    }



    private void addWord(String word) {
        AsyncCallback<String> callback = new AsyncCallback<String>() {
            public void onFailure(Throwable caught) {

            }
            public void onSuccess(String result) {
                Record record = new Record();
                record.setAttribute("id", number++);
                record.setAttribute("reverse", result);
                dataSource.addData(record);
            }
        };
        getReverseWordAsync.getReverseWord(textBox.getText(), callback);
    }
}
