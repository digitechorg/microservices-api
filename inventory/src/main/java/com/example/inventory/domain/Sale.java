package com.example.inventory.domain;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Sale {

    @JsonProperty("ItemName")
    public String itemName;


    @JsonProperty("ItemId")
    public long itemId;

    @JsonProperty("Quantity")
    public int quantity;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
