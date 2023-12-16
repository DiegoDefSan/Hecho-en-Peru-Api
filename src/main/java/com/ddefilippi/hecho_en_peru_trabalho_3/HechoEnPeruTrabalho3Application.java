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
				new Product(
					"Poncho de lana",
					150.00,
					50,
					"poncho-lana.jpg",
					4.5,
					"The poncho is a typical garment of the Andean region of Peru. It is a rectangular piece of fabric with a hole in the center for the head. It is usually made of wool and is used to protect against the cold.",
					"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed vitae ero",
					cateroryList.get(2),
					regionList.get(3),
					handcraftList.get(0)
				),
				new Product(
						"Poncho de lana tejido a crochet",
						170.00,
						50,
						"poncho-tejido-crochet.jpg",
						4.5,
						"The poncho is a typical garment of the Andean region of Peru. It is a rectangular piece of fabric with a hole in the center for the head. It is usually made of wool and is used to protect against the cold.",
						"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed vitae ero",
						cateroryList.get(2),
						regionList.get(5),
						handcraftList.get(0)
				),
				new Product(
						"Plato Urpi",
						75.00,
						50,
						"plato-urpi.jpg",
						3.5,
						"The poncho is a typical garment of the Andean region of Peru. It is a rectangular piece of fabric with a hole in the center for the head. It is usually made of wool and is used to protect against the cold.",
						"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed vitae ero",
						// Category decorations
						cateroryList.get(4),
						// Region Ayacucho
						regionList.get(2),
						handcraftList.get(1)
				),
				new Product(
						"Aretes de fibra de chambira",
						30.00,
						50,
						"aretes-hilo.jpg",
						4.5,
						"The poncho is a typical garment of the Andean region of Peru. It is a rectangular piece of fabric with a hole in the center for the head. It is usually made of wool and is used to protect against the cold.",
						"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed vitae ero",
						// Category accessories
						cateroryList.get(0),
						// Region Amazonas
						regionList.get(0),
						handcraftList.get(1)
				),
				new Product(
						"Collar de mostacilla",
						172.50,
						50,
						"collar-mostacilla.jpg",
						3.7,
						"The poncho is a typical garment of the Andean region of Peru. It is a rectangular piece of fabric with a hole in the center for the head. It is usually made of wool and is used to protect against the cold.",
						"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed vitae ero",
						// Category accessories
						cateroryList.get(0),
						// Region Amazonas
						regionList.get(0),
						handcraftList.get(1)
				),
				new Product(
						"Set de cojines de lana",
						120.00,
						50,
						"cojin-lana.jpg",
						4.5,
						"The poncho is a typical garment of the Andean region of Peru. It is a rectangular piece of fabric with a hole in the center for the head. It is usually made of wool and is used to protect against the cold.",
						"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed vitae ero",
						// Category decorations
						cateroryList.get(4),
						// Region Ayacucho
						regionList.get(2),
						handcraftList.get(0)
				),
				new Product(
						"Chalina tejida",
						70.00,
						50,
						"chalina-tejida.jpg",
						4.5,
						"The poncho is a typical garment of the Andean region of Peru. It is a rectangular piece of fabric with a hole in the center for the head. It is usually made of wool and is used to protect against the cold.",
						"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed vitae ero",
						// Category scarfs
						cateroryList.get(3),
						// Region Apurimac
						regionList.get(1),
						handcraftList.get(0)
				),
				new Product(
						"Banco tejido de lana",
						550.00,
						50,
						"banco-tejido.jpg",
						4.5,
						"The poncho is a typical garment of the Andean region of Peru. It is a rectangular piece of fabric with a hole in the center for the head. It is usually made of wool and is used to protect against the cold.",
						"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed vitae ero",
						// Category furniture
						cateroryList.get(1),
						// Region Ayacucho
						regionList.get(2),
						handcraftList.get(0)
				),
				new Product(
						"Baúl tejido",
						80.00,
						50,
						"baul-tejido.jpg",
						4.5,
						"The straw hat is a typical garment of the Andean region of Peru. It is a rectangular piece of fabric with a hole in the center for the head. It is usually made of straw and is used to protect against the sun.",
						"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed vitae ero",
						// Category furniture
						cateroryList.get(1),
						// Region Huancavelica
						regionList.get(12),
						handcraftList.get(1)
				),
				new Product(
						"Poncho de lana con capucha",
						115.00,
						50,
						"poncho-capucha.jpg",
						4.5,
						"The poncho is a typical garment of the Andean region of Peru. It is a rectangular piece of fabric with a hole in the center for the head. It is usually made of wool and is used to protect against the cold.",
						"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed vitae ero",
						// Category ponchos
						cateroryList.get(2),
						// Region Ayacucho
						regionList.get(2),
						handcraftList.get(0)
				),
				new Product(
						"Chullo de lana con orejeras",
						50.00,
						50,
						"chullo-blanco.jpeg",
						4.5,
						"The straw hat is a typical garment of the Andean region of Peru. It is a rectangular piece of fabric with a hole in the center for the head. It is usually made of straw and is used to protect against the sun.",
						"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed vitae ero",
						// Category hats
						cateroryList.get(5),
						// Region Lima
						regionList.get(4),
						handcraftList.get(1)
				),
				new Product(
						"Cuadro tejido de lana",
						150.00,
						50,
						"cuadro-tejido.jpg",
						4.5,
						"The straw hat is a typical garment of the Andean region of Peru. It is a rectangular piece of fabric with a hole in the center for the head. It is usually made of straw and is used to protect against the sun.",
						"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed vitae ero",
						// Category decorations
						cateroryList.get(4),
						// Region Lima
						regionList.get(4),
						handcraftList.get(1)
				)
			)
		);

		productRepository.saveAll(productList);
	}

}
