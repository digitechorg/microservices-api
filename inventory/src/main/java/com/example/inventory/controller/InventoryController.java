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
        inventoryService.saveOrUpdate( dataHelper.convertJsonObjToDomainObj(inventory));
        return inventory.size();
    }

    @GetMapping("/inventory/{storeId}")
    private Inventory getInventoryByStoreId(@PathVariable("storeId") Integer storeId)
    {
        logger.info("Search for {} ",storeId);
        InventoryDomain inventoryDomain = inventoryService.getInventoryDomainByStoreId(storeId);
        List<InventoryDomain> inventoryDomainList = new ArrayList<>();
        inventoryDomainList.add(inventoryDomain);
       List<Inventory> inventoryList = dataHelper.convertDomainObjToJsonObj(inventoryDomainList);
        return inventoryList.get(0);
    }

    @GetMapping("/allinventory")
    private List<Inventory> getAllInventory()
    {
       List<InventoryDomain> inventoryDomainList = inventoryService.getAllInventory();
        return dataHelper.convertDomainObjToJsonObj(inventoryDomainList);
    }

    @PutMapping("/inventory/{storeId}")
    private void updateInventory(@RequestBody List<Inventory> inventory,@PathVariable("storeId") Integer storeId){
        inventoryService.updateInventory(dataHelper.convertJsonObjToDomainObj(inventory),storeId);
    }

    @DeleteMapping("/inventory/{storeId}")
    private void deleteInventory(@PathVariable("storeId") Integer storeId){
        inventoryService.deleteInventory(storeId);
    }
}
