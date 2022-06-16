package com.imed.imobiliaria.controller;


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.imed.imobiliaria.exception.ImobiliariaNotFoundException;

import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;

@RestController
class CasaController {

	private final ImobiliariaRepository repository;

	CasaController(ImobiliariaRepository repository) {
		this.repository = repository;
	}
	
	//GET(/Casas)
	@Operation(summary="Receber imoveis", description="Recebe uma lista de imoveis")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Imovel encontrado"),
			@ApiResponse(code = 401, message = "Sem autorização"),
		    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
		    @ApiResponse(code = 404, message = "Imovel não encontrado"),
	})
	
	// Aggregate root
	// tag::get-aggregate-root[]
	@GetMapping("/Casas")
	List<Casa> getAllImoveis() {
		return repository.findAll();
	}
	
	//POST(/Casas)
	@Operation(summary="Enviar imoveis", description="Envia e adiciona um novo imovel")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Imovel enviado"),
			@ApiResponse(code = 201, message = "Imovel criado"),
			@ApiResponse(code = 401, message = "Sem autorização"),
		    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
		    @ApiResponse(code = 404, message = "Não encontrado"),
	})
	// end::get-aggregate-root[]
	@PostMapping("/Casas")
	Casa newImovel(@RequestBody Casa newCasa) {
		return repository.save(newCasa);
	}
	
	//GET(/Casas/id)
	@Operation(summary="Receber imovel especifico", description="Recebe um unico imovel resultado da pesquisa por id")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Imovel encontrado"),
			@ApiResponse(code = 401, message = "Sem autorização"),
		    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
		    @ApiResponse(code = 404, message = "Imovel não encontrado"),
	})
	// Single item
	@GetMapping("/Casas/{id}")
	Casa getOneImovel(@PathVariable("id") @ApiParam(name = "id", value = "Imovel id", example = "1") Long id) {

		return repository.findById(id)
				.orElseThrow(() -> new ImobiliariaNotFoundException(id));
	}
	
	//Put(/Casas/id)
	@Operation(summary="Editar imovel", description="Edita um imovel já existente")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Imovel editado"),
			@ApiResponse(code = 201, message = "Imovel criado"),
			@ApiResponse(code = 401, message = "Sem autorização"),
		    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
		    @ApiResponse(code = 404, message = "Imovel não existe"),
	})
	@PutMapping("/Casas/{id}")
	Casa replaceImovel(@RequestBody Casa newCasa, @PathVariable("id") @ApiParam(name = "id", value = "Imovel id", example = "1") Long id) {

		return repository.findById(id)
				.map(Casa -> {
					Casa.setNegocioImovel(Casa.getNegocioImovel());
					Casa.setPrecoImovel(Casa.getPrecoImovel());
					Casa.setLocalImovel(Casa.getLocalImovel());
					Casa.setMetragem(Casa.getMetragem());
					Casa.setBanheiros(Casa.getBanheiros());
					Casa.setComodos(Casa.getComodos());

					return repository.save(Casa);
				})
				.orElseGet(() -> {
					newCasa.setId(id);
					return repository.save(newCasa);
				});
	}
	
	//Delete(/Casas/id)
	@Operation(summary="Deleta imovel", description="Deleta um imovel especifico pelo id")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Imovel deletado"),
			@ApiResponse(code = 204, message = "Lista de imoveis vazia"),
			@ApiResponse(code = 401, message = "Sem autorização"),
		    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
		    @ApiResponse(code = 404, message = "Imovel não existe"),
	})
	@DeleteMapping("/Casas/{id}")
	void deleteImovel(@PathVariable("id") @ApiParam(name = "id", value = "Imovel id", example = "1")Long id) {
		repository.deleteById(id);
	}
}