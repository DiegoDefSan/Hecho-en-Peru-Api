package com.ddefilippi.hecho_en_peru_trabalho_3;

import com.ddefilippi.hecho_en_peru_trabalho_3.model.Category;
import com.ddefilippi.hecho_en_peru_trabalho_3.model.Handcraft;
import com.ddefilippi.hecho_en_peru_trabalho_3.model.Product;
import com.ddefilippi.hecho_en_peru_trabalho_3.model.Region;
import com.ddefilippi.hecho_en_peru_trabalho_3.repository.CategoryRepository;
import com.ddefilippi.hecho_en_peru_trabalho_3.repository.HandcraftRepository;
import com.ddefilippi.hecho_en_peru_trabalho_3.repository.ProductRepository;
import com.ddefilippi.hecho_en_peru_trabalho_3.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class HechoEnPeruTrabalho3Application implements org.springframework.boot.CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private HandcraftRepository handcraftRepository;

	@Autowired
	private RegionRepository regionRepository;

	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(HechoEnPeruTrabalho3Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<Category> cateroryList = new ArrayList<>(
			List.of(
					// Change the categories names to english

				new Category("Accessories"),
				new Category("Furniture"),
				new Category("Ponchos"),
				new Category("Scarfs"),
				new Category("Decorations"),
				new Category("Hats")
			)
		);

		categoryRepository.saveAll(cateroryList);

		List<Handcraft> handcraftList = new ArrayList<>(
			List.of(
				new Handcraft(
				"Carlos Quispe Cárdenas",
				"Talented goldsmith who creates unique jewelry inspired by the rich history and culture of Cusco. His pieces are handmade with precious metals and semi-precious stones, and reflect the beauty and essence of the region."
				),
				new Handcraft (
				"Rosa Gutiérrez Gómez",
				"Rosa is a talented ceramist who creates unique pieces inspired by the rich history and culture of Apurimac. Her pieces are handmade with clay and reflect the beauty and essence of the region."
				)
			)
		);

		handcraftRepository.saveAll(handcraftList);

		List<Region> regionList = new ArrayList<>(
			List.of(
				new Region("Amazonas"),
				new Region("Apurimac"),
				new Region("Ayacucho"),
				new Region("Cusco"),
				new Region("Lima"),
				new Region("Puno"),
				new Region("Tacna"),
				new Region("Tumbes"),
				new Region("Ucayali"),
				new Region("Arequipa"),
				new Region("Cajamarca"),
				new Region("Callao"),
				new Region("Huancavelica"),
				new Region("Huanuco"),
				new Region("Ica"),
				new Region("Junin"),
				new Region("La Libertad"),
				new Region("Lambayeque"),
				new Region("Loreto"),
				new Region("Madre de Dios"),
				new Region("Moquegua"),
				new Region("Pasco"),
				new Region("Piura"),
				new Region("San Martin"),
				new Region("Ancash")
			)
		);

		regionRepository.saveAll(regionList);

		List<Product> productList = new ArrayList<>(
			List.of(
				new Product(),
				new Product(),
				new Product(),
				new Product(),
				new Product()
			)
		);

		productRepository.saveAll(productList);
	}

}
