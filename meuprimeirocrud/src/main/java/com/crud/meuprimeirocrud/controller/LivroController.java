package com.crud.meuprimeirocrud.controller;

import com.crud.meuprimeirocrud.models.LivroModel;
import com.crud.meuprimeirocrud.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/alunos")
public class LivroController {
    @Autowired
    private LivroService livroService;

    @GetMapping
    private List<LivroModel> findAll(){
        return livroService.findAll();
    }

}
