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

import com.sun.javaws.exceptions.InvalidArgumentException;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Dustin K. Redmond
 * @since 02/04/2020 15:39
 */
public class ObjectTableView<T> extends TableView<T> {
    public ObjectTableView(ObservableList<T> objects) {
        if (objects == null || objects.size() == 0) {
            throw new UnsupportedOperationException("The object supplied when instantiating " +
                    "com.dustinredmond.ObjectTableView must not be null or size zero.");
        }

        List<Field> fields = new ArrayList<>(
                Arrays.asList(objects.get(0).getClass().getDeclaredFields())
        );

        fields.forEach(field -> {
            ColumnName annotName = field.getAnnotation(ColumnName.class);
            String fieldName = field.getName();
            TableColumn<T, ?> column = new TableColumn<>(
                    (annotName != null && !annotName.value().isEmpty()) ? annotName.value(): fieldName
            );
            column.setCellValueFactory(new PropertyValueFactory<>(fieldName));
            this.getColumns().add(column);
        });
        this.setItems(objects);
    }


    private static final String EMPTY_STRING = "";
}
