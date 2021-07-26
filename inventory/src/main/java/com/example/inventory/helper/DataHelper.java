package com.example.inventory.helper;

import com.example.inventory.domain.*;
import com.example.inventory.service.InventoryServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHelper {

    Logger logger = LoggerFactory.getLogger(DataHelper.class);

   public List<InventoryDomain> convertJsonObjToDomainObj(List<Inventory> inventoryList){
       logger.info(" Datahelper size" +inventoryList.size());
        List<InventoryDomain> inventoryDomainList = new ArrayList<>();
        InventoryDomain inventoryDomain;
        SaleDomain saleDomain;
        DeliveryDomain deliveryDomain;
        RefundDomain refundDomain;
        for(Inventory  inventory:inventoryList ){
            inventoryDomain = new InventoryDomain();
            List<DeliveryDomain> deliveryDomainList = new ArrayList<>();
            List<RefundDomain> refundDomainList = new ArrayList<>();
            List<SaleDomain> saleDomainList = new ArrayList<>();

            for(Delivery delivery: inventory.getDelivery()){
                deliveryDomain = new DeliveryDomain();
                deliveryDomain.setItemId(delivery.getItemId());
                deliveryDomain.setItemName(delivery.getItemName());
                deliveryDomain.setQuantity(delivery.getQuantity());
                deliveryDomainList.add(deliveryDomain);
            }
            for(Refund refund: inventory.getRefund()){
                refundDomain = new RefundDomain();
                refundDomain.setItemId(refund.getItemId());
                refundDomain.setItemName(refund.getItemName());
                refundDomain.setQuantity(refund.getQuantity());
                refundDomainList.add(refundDomain);
            }
            for(Sale sale: inventory.getSale()){
                saleDomain = new SaleDomain();
                saleDomain.setItemId(sale.getItemId());
                saleDomain.setItemName(sale.getItemName());
                saleDomain.setQuantity(sale.getQuantity());
                saleDomainList.add(saleDomain);
            }
            inventoryDomain.setSaleDomain(saleDomainList);
            inventoryDomain.setDeliveryDomain(deliveryDomainList);
            inventoryDomain.setRefundDomain(refundDomainList);
            inventoryDomain.setStoreId(inventory.getStoreId());
            inventoryDomainList.add(inventoryDomain);
        }
       logger.info(" end by  size" +inventoryDomainList.size());
        return inventoryDomainList;
    }
}
