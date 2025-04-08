package com.teste.crud.Controller;

import com.teste.crud.Model.Produto;
import com.teste.crud.Service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @Operation(summary = "Criar um novo produto.")
    @PostMapping("/create-produto")
    public ResponseEntity<Produto> createProduto(@RequestBody Produto produto){
        return produtoService.createProduto(produto);
    }

    @GetMapping("/list-all-produtos")
    public ResponseEntity<List<Produto>> getAllProdutos(){
        return produtoService.getAllProdutos();
    }

    @GetMapping("/list-produto/{id}")
    public ResponseEntity<Optional<Produto>> getProdutoById(@PathVariable Long id){
        return produtoService.getProdutoById(id);
    }

    @DeleteMapping("/delete-by-id/{id}")
    public ResponseEntity<?> deleteProdutoById(@PathVariable Long id){
        return produtoService.deleteProdutoById(id);
    }

    @PutMapping("/update-by-id/{id}")
    public ResponseEntity<Produto> updateProduto(@RequestBody Produto produto, @PathVariable Long id){
        return produtoService.updateProdutoById(produto, id);
    }

}
