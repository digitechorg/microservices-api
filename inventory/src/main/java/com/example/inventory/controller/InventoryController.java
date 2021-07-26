package com.example.inventory.controller;

import com.example.inventory.domain.Inventory;
import com.example.inventory.domain.InventoryDomain;
import com.example.inventory.helper.DataHelper;
import com.example.inventory.service.InventoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api/")
@RestController
public class InventoryController {

    Logger logger = LoggerFactory.getLogger(InventoryController.class);

    @Autowired
    InventoryService inventoryService;

    @Autowired
    private DataHelper dataHelper;

    @PostMapping("/inventory")
    private int saveInventory(@RequestBody List<Inventory> inventory)
    {
        logger.info("ID before: "+ inventory.get(0).getStoreId());
        inventoryService.saveOrUpdate( dataHelper.convertJsonObjToDomainObj(inventory));
        logger.info("ID After: "+ inventory.get(0).getStoreId());
        return inventory.size();
    }

    @GetMapping("/inventory/{storeId}")
    private InventoryDomain getInventoryByStoreId(@PathVariable("storeId") Integer storeId)
    {
        logger.info("ID : "+ storeId);
        return inventoryService.getInventoryDomainByStoreId(storeId);
    }

    @GetMapping("/allinventory")
    private List<Inventory> getAllInventory()
    {
        List<Inventory> inventoryList = new ArrayList<>();
       List<InventoryDomain> inventoryDomainList = inventoryService.getAllInventory();

        return inventoryList;
    }
}
