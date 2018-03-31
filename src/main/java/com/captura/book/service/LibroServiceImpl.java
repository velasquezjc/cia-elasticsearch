package com.captura.book.service;

import com.captura.book.model.Libro;
import com.captura.book.repository.LibroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroServiceImpl implements LibroService {

    private LibroRepository libroRepository;

    @Autowired
    public void setBookRepository(LibroRepository bookRepository) {
        this.libroRepository = bookRepository;
    }

    public Libro save(Libro book) {
        return libroRepository.save(book);
    }

    public void delete(Libro book) {
        libroRepository.delete(book);
    }

    public Libro findOne(String id) {
        return libroRepository.findOne(id);
    }

    public Iterable<Libro> findAll() {
        return libroRepository.findAll();
    }

    public Page<Libro> findByAuthor(String author, PageRequest pageRequest) {
        return libroRepository.findByFIELD5(author, pageRequest);
    }

    public List<Libro> findByTitle(String title) {
        return libroRepository.findByFIELD4(title);
    }

}