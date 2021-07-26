package com.example.inventory.repositry;


import com.example.inventory.domain.Inventory;
import com.example.inventory.domain.InventoryDomain;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends CrudRepository<InventoryDomain, Integer>
{
    InventoryDomain findByStoreId(Integer storeId);
}
