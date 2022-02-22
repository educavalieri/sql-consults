package com.devsuperior.uri2611;

import com.devsuperior.uri2611.dto.MovieDTO;
import com.devsuperior.uri2611.projections.MovieMinProjection;
import com.devsuperior.uri2611.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Uri2611Application implements CommandLineRunner {

	@Autowired
	private MovieRepository movieRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2611Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("************************ SQL RAIZ ********************************");


		List<MovieMinProjection> list = movieRepository.search1("Action");
		List<MovieDTO> result = list.stream().map(x -> new MovieDTO(x)).collect(Collectors.toList());
		for( MovieDTO dto : result){
			System.out.println(result);
		}

		System.out.println("************************ JPQA ********************************");

		List<MovieDTO> result2 = movieRepository.search2("Action");
		for (MovieDTO dto : result2
			 ) {
			System.out.println(result2);
		}

	}
}
