package br.com.alura.forum.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.controller.dto.TopicoDto;
import br.com.alura.forum.model.Curso;
import br.com.alura.forum.model.Topico;

/**
 * A conversão de objetos Java para os formatos JSON e XML é feita com o auxílio
 * das bibliotecas Jackson e JAX-B.
 * 
 * Para um método no controller não encaminhar a requisição a uma página JSP, ou
 * Thymeleaf, devemos utilizar a anotação @ResponseBody;
 * 
 * O Spring, por padrão, converte os dados no formato JSON, utilizando a
 * biblioteca Jackson;
 * 
 * Não é uma boa prática retornar entidades JPA nos métodos dos controllers,
 * sendo mais indicado retornar classes que seguem o padrão DTO (Data Transfer
 * Object);
 * 
 * O modelo arquitetural REST, como recursos, URIs, verbos HTTP, Representações
 * e comunicação stateless.
 * 
 * @author Tharlys de Souza Dias <tharlys.dias@senior.com.br>
 *
 */
@RestController
public class TopicosController {

	/**
	 * Por padrão, o Spring considera que o retorno do método é o nome da página que
	 * ele deve carregar, mas ao utilizar a anotação @ResponseBody, indicamos que o
	 * retorno do método deve ser serializado e devolvido no corpo da resposta.
	 * 
	 * O Spring faz a conversão automaticamente, com o uso da biblioteca Jackson.
	 * 
	 * O mapeamento dos endpoints é feito com a anotação @RequestMapping.
	 * 
	 * Identificador único de recursos (URI): (/topicos)
	 * 
	 * @return Arrays.asList(topico, topico, topico)
	 */
	@RequestMapping("/topicos")
	public List<TopicoDto> lista() {
		Topico topico = new Topico("Dúvida", "Dúvida com Spring", new Curso("String", "Programacao"));

		return TopicoDto.converter(Arrays.asList(topico, topico, topico));
	}
}
