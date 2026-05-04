package com.thymeleaf.demo;

import org.springframework.data.repository.CrudRepository;

public interface SiswaRepository extends CrudRepository<Siswa, Integer> {
    
}