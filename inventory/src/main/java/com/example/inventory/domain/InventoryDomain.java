package com.example.inventory.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "INVENTORY")
public class InventoryDomain {
    @Id
    @Column(name ="storeId" )
    public Integer storeId;

    @OneToMany(targetEntity = SaleDomain.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "storeIdFk", referencedColumnName = "storeId")
    public List<SaleDomain> saleDomain = new ArrayList<>();

    @OneToMany(targetEntity = RefundDomain.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "storeIdFk", referencedColumnName = "storeId")
    public List<RefundDomain> refundDomain = new ArrayList<>();

    @OneToMany(targetEntity = DeliveryDomain.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "storeIdFk", referencedColumnName = "storeId")
    public List<DeliveryDomain> deliveryDomain = new ArrayList<>();

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public List<SaleDomain> getSaleDomain() {
        return saleDomain;
    }

    public void setSaleDomain(List<SaleDomain> saleDomain) {
        this.saleDomain = saleDomain;
    }

    public List<RefundDomain> getRefundDomain() {
        return refundDomain;
    }

    public void setRefundDomain(List<RefundDomain> refundDomain) {
        this.refundDomain = refundDomain;
    }

    public List<DeliveryDomain> getDeliveryDomain() {
        return deliveryDomain;
    }

    public void setDeliveryDomain(List<DeliveryDomain> deliveryDomain) {
        this.deliveryDomain = deliveryDomain;
    }
}
