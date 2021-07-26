package com.example.inventory.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import java.util.ArrayList;
import java.util.List;


public class Inventory {

    @JsonProperty("StoreId")
    public Integer storeId;


    @JsonProperty("Sale")
    public List<Sale> sale = new ArrayList<>();

    @JsonProperty("Refund")
    public List<Refund> refund = new ArrayList<>();


    @JsonProperty("Delivery")
    public List<Delivery> delivery = new ArrayList<>();

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public List<Sale> getSale() {
        return sale;
    }

    public void setSale(List<Sale> sale) {
        this.sale = sale;
    }

    public List<Refund> getRefund() {
        return refund;
    }

    public void setRefund(List<Refund> refund) {
        this.refund = refund;
    }

    public List<Delivery> getDelivery() {
        return delivery;
    }

    public void setDelivery(List<Delivery> delivery) {
        this.delivery = delivery;
    }
}
