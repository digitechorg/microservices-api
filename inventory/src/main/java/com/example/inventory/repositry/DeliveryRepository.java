package com.example.inventory.repositry;

import com.example.inventory.domain.DeliveryDomain;
import org.springframework.data.repository.CrudRepository;


public interface DeliveryRepository extends CrudRepository<DeliveryDomain, String>
{
}
