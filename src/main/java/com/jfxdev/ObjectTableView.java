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

import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Dustin K. Redmond
 * @since 02/04/2020 15:39
 */
public class ObjectTableView<T> extends TableView<T> {

    /**
     * Constructs an {@code ObjectTableView} suitable for displaying objects of the
     * type passed as parameter. Sets the objects as table rows with the column names
     * defaulting to the field names of the passed class.
     * @param objects {@code ObservableList} of the objects to be used in the {@code TableView}
     * @throws UnsupportedOperationException If no objects are passed.
     * Use {@code new ObjectTableView(Class clazz)} instead.
     */
    public ObjectTableView(ObservableList<T> objects) throws UnsupportedOperationException {
        if (objects == null || objects.size() == 0) {
            throw new UnsupportedOperationException("The object list supplied when instantiating " +
                    "com.jfxdev.ObjectTableView must not be null or size zero. Other constructors support this.");
        }
        new ArrayList<>(Arrays.asList(objects.get(0).getClass().getDeclaredFields())).forEach(field -> {
            String fieldName = field.getName();
            TableColumn<T, ?> column = new TableColumn<>(fieldName);
            column.setCellValueFactory(new PropertyValueFactory<>(fieldName));
            this.getColumns().add(column);
        });
        this.setItems(objects);
    }

    /**
     * Constructs an {@code ObjectTableView} suitable for displaying objects of
     * the specified model class.
     * @param modelClass Class whose fields are to be used as {@code TableColumn}s
     */
    public ObjectTableView(Class<T> modelClass) {
        new ArrayList<>(Arrays.asList(modelClass.getDeclaredFields())).forEach(field -> {
            String fieldName = field.getName();
            TableColumn<T, ?> column = new TableColumn<>(fieldName);
            column.setCellValueFactory(new PropertyValueFactory<>(fieldName));
            this.getColumns().add(column);
        });
    }

    /**
     * Renames a single table column. {@code ObjectTableView().applyColumnNameMapping()}
     * should be preferred for renaming multiple {@code TableColumn}s at once.
     * @param name {@code TableColumn}'s current name
     * @param newName {@code TableColumn}'s intended name
     */
    public void renameColumn(String name, String newName) {
        for (TableColumn<T, ?> col: this.getColumns()) {
            if (col.getText().equals(name)) {
                col.setText(newName);
                break;
            }
        }
    }

    /**
     * Applies column names from a {@code HashMap} where the key signifies the current
     * column name and the value signifies the intended name.
     * @param map {@code HashMap<String,String>} of structure: oldName/newName
     */
    public void applyColumnNameMapping(HashMap<String,String> map) {
        if (map.isEmpty()) return;
        for (TableColumn<T, ?> col: this.getColumns()) {
            if (map.containsKey(col.getText())) {
                col.setText(map.get(col.getText()));
            }
        }
    }
}
