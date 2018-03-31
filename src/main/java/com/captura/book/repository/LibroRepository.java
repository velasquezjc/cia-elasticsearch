package com.captura.book.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.captura.book.model.Libro;

public interface LibroRepository extends ElasticsearchRepository<Libro, String> {

    Page<Libro> findByFIELD5(String author, Pageable pageable);

    List<Libro> findByFIELD4(String title);

}