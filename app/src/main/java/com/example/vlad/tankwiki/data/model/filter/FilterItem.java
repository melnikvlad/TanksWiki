package com.example.vlad.tankwiki.data.model.filter;

public abstract class FilterItem {
    protected boolean isSelected;
    protected int position;

    FilterItem(int pos) {
        isSelected = false;
        position = pos;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
