package com.dustinredmond;
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
import javafx.stage.Stage;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Dustin K. Redmond
 * @since 02/04/2020 15:29
 */
public class MappingTest extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        ObjectTableView<TestObj> table = new ObjectTableView<>(this.generateTestObject(1000));
        stage.setScene(new Scene(table));
        stage.show();
    }

    private ObservableList<TestObj> generateTestObject(int limit) {
        ObservableList<TestObj> objs = FXCollections.observableArrayList();
        long c = COUNTER.incrementAndGet();
        for (int i = 0; i < limit; i++) {
            objs.add(new TestObj((int) c, c+"SomeData", c+"SomeOtherData",c+"EvenMore"));
        }
        return objs;
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    private static final AtomicLong COUNTER = new AtomicLong();
}
