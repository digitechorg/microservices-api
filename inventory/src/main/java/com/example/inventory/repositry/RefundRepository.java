package com.example.inventory.repositry;

import com.example.inventory.domain.RefundDomain;
import org.springframework.data.repository.CrudRepository;



public interface RefundRepository extends CrudRepository<RefundDomain, String>
{
}
