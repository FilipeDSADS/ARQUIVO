package com.teste.crud.Service;

import com.teste.crud.Model.Produto;
import com.teste.crud.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public ResponseEntity<Produto> createProduto(@RequestBody Produto produto){
        Produto newProduto = produtoRepository.save(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProduto);
    }

    public ResponseEntity<List<Produto>> getAllProdutos(){
        List<Produto> allProdutos = produtoRepository.findAll();
        return ResponseEntity.ok(allProdutos);
    }

    public ResponseEntity<Optional<Produto>> getProdutoById(@PathVariable Long id){
        Optional<Produto> getProdutoById = produtoRepository.findById(id);
        return ResponseEntity.ok(getProdutoById);
    }

    public ResponseEntity<?> deleteProdutoById(@PathVariable Long id){
        produtoRepository.deleteById(id);
        return ResponseEntity.ok("Deletado!");
    }

    public ResponseEntity<Produto> updateProdutoById(@RequestBody Produto updateProduto, @PathVariable Long id){
        return produtoRepository.findById(id).map(produto -> {
            produto.setNome(updateProduto.getNome());
            produto.setPreco(updateProduto.getPreco());
            produto.setQuantidadeEmEstoque(updateProduto.getQuantidadeEmEstoque());

            Produto updatedProduto = produtoRepository.save(produto);
            return ResponseEntity.ok(updateProduto);
        }).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

}
