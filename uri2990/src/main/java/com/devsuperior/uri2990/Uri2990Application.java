package com.devsuperior.uri2990;

import com.devsuperior.uri2990.dto.EmpregadoDeptDTO;
import com.devsuperior.uri2990.projections.EmpregadoDeptProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2990.repositories.EmpregadoRepository;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Uri2990Application implements CommandLineRunner {

	@Autowired
	private EmpregadoRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2990Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("************************ SQL Raiz **************************************");

		List<EmpregadoDeptProjection> list1 = repository.search1();
		List<EmpregadoDeptDTO> dto = list1.stream().map(x -> new EmpregadoDeptDTO(x)).collect(Collectors.toList());
		dto.forEach(x -> System.out.println(x));

		System.out.println("/n/n");
		System.out.println("************************ JPQL **************************************");

		List<EmpregadoDeptDTO> list2 = repository.search2();
		list2.forEach(x -> System.out.println(x));
	}
}
