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

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Applying {@code @ColumnName} annotation to a field in a Java object causes
 * {@code com.dustinredmond.ObjectTableView} to use the annotation-specified value
 * as the JavaFX {@code TableView}'s column name.
 * <p>
 * If a field does not have this annotation, {@code ObjectTableView} will use the field's
 * actual name as the @{code TableColumn} name.
 *
 * @author Dustin K. Redmond
 * @since 02/04/2020 16:36
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ColumnName {
    /**
     * @return The custom name of the TableColumn used when mapping to a JavaFX TableView
     */
    String value() default "";
}
