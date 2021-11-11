package com.java.spring.javaspringbasico.repository;

import com.java.spring.javaspringbasico.model.ProdutoModelo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProdutoRepositorio extends CrudRepository<ProdutoModelo, Long> {

    //Listar todos os produtos
    public List<ProdutoModelo> findAll();

    //Pesquisar por código
    public ProdutoModelo findById(long id);

    //Remover produto
    public void delete(ProdutoModelo produto);

    //Cadastrar/Alterar produto
    //public ProdutoModelo save(ProdutoModelo produto);   <-- esse código funciona também

    <ProdMod extends ProdutoModelo> ProdMod save(ProdMod entity);  //ProdMod é uma classe temporária(poderia ser qualquer nome)
}
