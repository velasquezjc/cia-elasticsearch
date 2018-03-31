package com.captura.book.service;

import com.captura.book.model.Libro;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface LibroService {

    Libro save(Libro book);

    void delete(Libro book);

    Libro findOne(String id);

    Iterable<Libro> findAll();

    Page<Libro> findByAuthor(String author, PageRequest pageRequest);

    List<Libro> findByTitle(String title);

}