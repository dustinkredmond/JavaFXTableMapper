package com.jfxdev;
/*
 *  Copyright (C) 2020 Dustin K. Redmond
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option)
 * any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for
 * more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 59
 * Temple Place, Suite 330, Boston, MA 02111-1307 USA
 *
 */

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Simple test/proof of concept for the {@code ObjectTableView}
 * Run it as a JavaFX application to see the ObjectTableView in action.
 * @author Dustin K. Redmond
 * @since 02/04/2020 15:29
 */
@SuppressWarnings("unused")
public class MappingTest extends Application {

    @Override
    @SuppressWarnings("RedundantThrows")
    public void start(Stage stage) throws Exception {

        ObjectTableView<TestObj> table = new ObjectTableView<>(generateTestObject(5));
        HashMap<String,String> columnNames = new HashMap<>();
        columnNames.put("id", "T1_ID");
        columnNames.put("name", "NAME");
        table.applyColumnNameMapping(columnNames);

        ObjectTableView<TestObj> table2 = new ObjectTableView<>(TestObj.class);
        table2.setItems(generateTestObject(10));
        table2.renameColumn("id", "T2_ID");

        stage.setScene(new Scene(new HBox(table, table2)));
        stage.setTitle("ObjectTableView: Testing");
        stage.show();
    }

    /**
     * Returns {@code ObservableList} of dummy instances of {@code TestObj} (simple POJO class)
     * @param amount Amount of objects the list should return.
     * @return {@code ObservableList} of {@code TestObj} with data.
     */
    private ObservableList<TestObj> generateTestObject(int amount) {
        ObservableList<TestObj> objs = FXCollections.observableArrayList();
        for (int i = 0; i < amount; i++) {
            long c = COUNTER.incrementAndGet();
            objs.add(new TestObj((int) c, c+"SomeData", c+"SomeOtherData",c+"EvenMoreData"));
        }
        return objs;
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    private static final AtomicLong COUNTER = new AtomicLong();
}
