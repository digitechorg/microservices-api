package com.example.inventory.repositry;


import com.example.inventory.domain.Sale;
import com.example.inventory.domain.SaleDomain;
import org.springframework.data.repository.CrudRepository;

public interface SaleRepository extends CrudRepository<SaleDomain, String>
{
}
