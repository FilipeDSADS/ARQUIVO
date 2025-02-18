package com.crud.meuprimeirocrud.repository;

import com.crud.meuprimeirocrud.models.LivroModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivroRepository extends JpaRepository<LivroModel, Long>{

}
