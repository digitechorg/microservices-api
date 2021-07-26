package com.example.inventory.service;

import com.example.inventory.controller.InventoryController;
import com.example.inventory.domain.Inventory;
import com.example.inventory.domain.InventoryDomain;
import com.example.inventory.repositry.InventoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {
    Logger logger = LoggerFactory.getLogger(InventoryServiceImpl.class);
    @Autowired
    InventoryRepository rootRepository;


    @Override
    @Transactional
    public void saveOrUpdate(List<InventoryDomain> inventoryDomainList) {
    logger.info(" size" +inventoryDomainList.size());
        for(InventoryDomain inventoryDomain :inventoryDomainList){
            logger.info(" size " +inventoryDomain.getStoreId());
            rootRepository.save(inventoryDomain);

        }

    }

    @Override
    public InventoryDomain getInventoryDomainByStoreId(Integer storeId) {

        return rootRepository.findByStoreId(storeId);
    }

    @Override
    public List<InventoryDomain> getAllInventory() {

        return (List<InventoryDomain>) rootRepository.findAll();
    }

}
