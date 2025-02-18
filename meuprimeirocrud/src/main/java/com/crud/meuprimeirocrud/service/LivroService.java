package com.crud.meuprimeirocrud.service;

import com.crud.meuprimeirocrud.models.LivroModel;
import com.crud.meuprimeirocrud.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepository;

    public List<LivroModel> findAll(){
        return livroRepository.findAll();
    }
}
