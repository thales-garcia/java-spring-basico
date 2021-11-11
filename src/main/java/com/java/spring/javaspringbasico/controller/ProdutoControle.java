package com.java.spring.javaspringbasico.controller;

import com.java.spring.javaspringbasico.model.ProdutoModelo;
import com.java.spring.javaspringbasico.repository.ProdutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProdutoControle {

    //Ações
    @Autowired   // diz para o spring que "acoes" é responsável por executar comandos previamente disponíveis no repositório
    private ProdutoRepositorio acoes;  //serão as ações de banco

    //Listar produtos
    @RequestMapping(value="/produtos", method= RequestMethod.GET)
    public @ResponseBody List<ProdutoModelo> listar(){
        return acoes.findAll();
    }
    // GET : http://localhost:8080/api/produtos


    //Cadastrar produtos
    @RequestMapping(value="/cadastro", method=RequestMethod.POST)
    public @ResponseBody ProdutoModelo cadastrar(@RequestBody ProdutoModelo produto){
        return acoes.save(produto);
    }
    // POST : http://localhost:8080/api/cadastro


    //Filtrar produtos
    @RequestMapping(value="/produtos/{id}", method=RequestMethod.GET)
    public @ResponseBody ProdutoModelo filtrar(@PathVariable Integer id){
        return acoes.findById(id);
        // http://localhost:8080/api/produtos/1            filtra o produto com Id = 1
    }
    // GET : http://localhost:8080/api/produtos/5


    //Alterar produtos
    @RequestMapping(value="/produtos", method=RequestMethod.PUT)
    public @ResponseBody ProdutoModelo alterar(@RequestBody ProdutoModelo produto){
        return acoes.save(produto);
    }
    //PUT : http://localhost:8080/api/produtos


    //Deletar produtos
    @RequestMapping(value="produtos/{id}", method=RequestMethod.DELETE)
    public @ResponseBody String remover(@PathVariable Integer id){
        ProdutoModelo produto = filtrar(id);
        this.acoes.delete(produto);
        return "Deletou o produto " + id;
    }
    //DELETE : http://localhost:8080/api/produtos/7


}
