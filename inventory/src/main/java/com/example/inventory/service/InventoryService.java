package com.example.inventory.service;

import com.example.inventory.domain.Inventory;
import com.example.inventory.domain.InventoryDomain;

import java.util.List;

public interface InventoryService {

    void saveOrUpdate(List<InventoryDomain> inventoryDomainList);

    InventoryDomain getInventoryDomainByStoreId(Integer storeId);

    List<InventoryDomain> getAllInventory();
}
