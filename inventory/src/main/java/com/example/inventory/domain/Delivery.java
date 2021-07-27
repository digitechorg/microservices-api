package com.example.inventory.domain;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Delivery {


    @JsonProperty("ItemName")
    public String itemName;

    @JsonProperty("ItemId")
    public String itemId;

    @JsonProperty("Quantity")
    public int quantity;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
