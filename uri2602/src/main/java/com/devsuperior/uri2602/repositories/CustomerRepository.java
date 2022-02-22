package com.devsuperior.uri2602.repositories;

import com.devsuperior.uri2602.dto.CustomerMinDTO;
import com.devsuperior.uri2602.entities.Customer;
import com.devsuperior.uri2602.projections.CustomerMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

//    SQL raiz
    @Query(nativeQuery = true, value = "select name "
            + "from customers "
            + "where upper(state) = upper(:state)" )
    List<CustomerMinProjection> search1(String state);

//    Jpql
    @Query("SELECT new  com.devsuperior.uri2602.dto.CustomerMinDTO(obj.name) "
            + "from Customer obj "
            + "where upper(obj.state) = upper(:state)" )
    List<CustomerMinDTO> search2(String state);



}
