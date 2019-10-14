package com.hlw.worldcraft;

import com.hlw.creature.Creature;

public class Grid {

    private int axis_x;
    private int axis_y;

    private Creature occupier;


    public Grid(int axis_x, int axis_y) {
        this.axis_x = axis_x;
        this.axis_y = axis_y;
    }

    public Grid(int axis_x, int axis_y, Creature occupier) {
        this.axis_x = axis_x;
        this.axis_y = axis_y;
        this.occupier = occupier;
    }


    public int getAxis_x() {
        return axis_x;
    }

    public void setAxis_x(int axis_x) {
        this.axis_x = axis_x;
    }

    public int getAxis_y() {
        return axis_y;
    }

    public void setAxis_y(int axis_y) {
        this.axis_y = axis_y;
    }

    public Creature getOccupier() {
        return occupier;
    }

    public void setOccupier(Creature occupier) {

        this.occupier = occupier;
        if (this.occupier != null) {
            occupier.setAxis_x(this.axis_x);
            occupier.setAxis_y(this.axis_y);
        }
    }

    public void clearOccupier() {
        this.occupier = null;
    }

    public boolean isEmptyOccupier() {
        if (this.occupier == null) {
            return true;
        } else {
            return false;
        }
    }

}
