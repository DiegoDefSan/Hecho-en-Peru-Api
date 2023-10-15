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
				new Category("Acessórios"),
				new Category("Mobiliário"),
				new Category("Ponchos"),
				new Category("Cachecóis"),
				new Category("Decorações"),
				new Category("Chapéus")
			)
		);

		categoryRepository.saveAll(cateroryList);

		List<Handcraft> handcraftList = new ArrayList<>(
			List.of(
				new Handcraft(
				"Carlos Quispe Cárdenas",
				"Ourives talentoso que cria jóias únicas inspiradas na rica história e cultura de Cusco. As suas peças são feitas à mão com metais preciosos e pedras semi-preciosas, e reflectem a beleza e a essência da região."
				),
				new Handcraft (
				"Rosa Gutiérrez Gómez",
				"Ceramista de exceção. A sua habilidade e destreza na modelação e decoração do barro permitem-lhe criar peças de cerâmica de grande beleza. As suas obras reflectem a rica iconografia inca e os motivos da natureza."
				)
			)
		);

		handcraftRepository.saveAll(handcraftList);

		List<Region> regionList = new ArrayList<>(
			List.of(
				new Region("Amazonas"),
				new Region("Apurimac"),
				new Region("Ayacucho"),
				new Region("Cusco")
			)
		);

		regionRepository.saveAll(regionList);

		List<Product> productList = new ArrayList<>(
			List.of(
				new Product(
					"Poncho de lana",
					150.00,
					"Este poncho de lã é feito à mão por artesãos de Cusco. É um produto de alta qualidade, com um design exclusivo e uma textura suave e agradável.",
					"100% lã de alpaca. Dimensões: 150 x 200 cm. Peso: 0,5 kg.",
					cateroryList.get(2),
					regionList.get(3),
					handcraftList.get(0)
				),
				new Product(
					"Chullo de lana con orejeras",
					50.00,
					"Este chapéu de palha é feito à mão por artesãos de Cusco. É um produto de alta qualidade, com um design exclusivo e uma textura suave e agradável.",
					"100% palha de milho. Dimensões: 30 x 30 x 15 cm. Peso: 0,2 kg.",
					cateroryList.get(5),
					regionList.get(3),
					handcraftList.get(0)
				),
				new Product(
					"Plato Urpi",
					50.00,
					"Este prato de cerâmica é feito à mão por artesãos de Apurimac. É um produto de alta qualidade, com um design exclusivo e uma textura suave e agradável.",
					"100% cerâmica. Dimensões: 30 x 30 x 15 cm. Peso: 0,2 kg.",
					cateroryList.get(4),
					regionList.get(1),
					handcraftList.get(1)
				),
				new Product(
					"Jarra Urpi",
					50.00,
					"Esta jarra de cerâmica é feita à mão por artesãos de Apurimac. É um produto de alta qualidade, com um design exclusivo e uma textura suave e agradável.",
					"100% cerâmica. Dimensões: 30 x 30 x 15 cm. Peso: 0,2 kg.",
					cateroryList.get(4),
					regionList.get(1),
					handcraftList.get(0)
				),
				new Product(
					"Bufanda tejida",
					70.00,
					"Esta cachecol de lã é feito à mão por artesãos de Ayacucho. É um produto de alta qualidade, com um design exclusivo e uma textura suave e agradável.",
					"100% lã de alpaca. Dimensões: 30 x 30 x 15 cm. Peso: 0,2",
					cateroryList.get(3),
					regionList.get(2),
					handcraftList.get(0)
				)
			)
		);

		productRepository.saveAll(productList);
	}

}
