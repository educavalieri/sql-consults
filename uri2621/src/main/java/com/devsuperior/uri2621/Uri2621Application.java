package com.devsuperior.uri2621;

import com.devsuperior.uri2621.dto.ProductMinDTO;
import com.devsuperior.uri2621.projections.ProductMinProjection;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2621.repositories.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Uri2621Application implements CommandLineRunner {

	@Autowired
	private ProductRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2621Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("************************** SQL 1 **************************************");
		List<ProductMinProjection> list =  repository.search1();
		List<ProductMinDTO> object = list.stream().map(x -> new ProductMinDTO(x)).collect(Collectors.toList());
		object.forEach(x -> System.out.println(x));

		System.out.println("************************** SQL 2 **************************************");

		List<ProductMinProjection> list2 =  repository.search2(10, 20, "P");
		List<ProductMinDTO> object2 = list2.stream().map(x -> new ProductMinDTO(x)).collect(Collectors.toList());
		object.forEach(x -> System.out.println(x));

		System.out.println("************************** JPQL **************************************");

		List<ProductMinDTO> list3 =  repository.search3(10, 20, "P");
		list3.forEach(x -> System.out.println(x));


	}
}
