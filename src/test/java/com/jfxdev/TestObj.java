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

import java.util.Date;

/**
 * @author Dustin K. Redmond
 * @since 02/04/2020 15:29
 */
public class TestObj {

    private int id;
    private String name;
    private String city;
    private String country;
    private boolean active;
    private Date created;

    public TestObj(int id, String name, String city, String country) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.country = country;
        this.active = Math.random() >= 0.5;
        this.created = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isActive() { return this.active; }

    public void setActive(boolean active) { this.active = active; }

    public Date getCreated() { return created; }

    public void setCreated(Date created) { this.created = created; }
}
