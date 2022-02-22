package com.devsuperior.uri2621.repositories;

import com.devsuperior.uri2621.dto.ProductMinDTO;
import com.devsuperior.uri2621.projections.ProductMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.uri2621.entities.Product;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {


    @Query(nativeQuery = true, value = "select products.name "
            + "from products "
            + "inner join providers on products.id_providers = providers.id "
            + "where amount between 10 and 20 "
            + "and providers.name like 'P%'"
            )
    List<ProductMinProjection> search1();


    @Query(nativeQuery = true, value = "select products.name "
            + "from products "
            + "inner join providers on products.id_providers = providers.id "
            + "where amount between :min and :max "
            + "and providers.name like concat(:beginName, '%')"
            )
    List<ProductMinProjection> search2( Integer min, Integer max, String beginName);

    @Query("select new com.devsuperior.uri2621.dto.ProductMinDTO(obj.name) "
            + "from Product obj "
            + "where obj.amount between :min and :max "
            + "and obj.provider.name like concat(:beginName, '%')"
            )
    List<ProductMinDTO> search3(Integer min, Integer max, String beginName);


}
