package com.captura;

import com.captura.Application;
import com.captura.book.model.Libro;
import com.captura.book.service.LibroService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class LibroServiceTest {

    @Autowired
    private LibroService libroService;
    
    @Autowired
    private ElasticsearchTemplate esTemplate;

    //@Before
    public void before() {
        esTemplate.deleteIndex(Libro.class);
        esTemplate.createIndex(Libro.class);
        esTemplate.putMapping(Libro.class);
        esTemplate.refresh(Libro.class);
    }

    //@Test
    public void testSave() {

        Libro book = new Libro("10010", "1001archivo.pdf", "https://111.com", "Elasticsearch Basics","Rambabu Posa",new Long(4),"23-FEB-2017");
        Libro testBook = libroService.save(book);
        
        assertNotNull(testBook.getFIELD1());
        assertEquals(testBook.getFIELD4(), book.getFIELD4());
        assertEquals(testBook.getFIELD5(), book.getFIELD5());
        assertEquals(testBook.getFIELD7(), book.getFIELD7());

    }
    
    @Test
    public void testFindOne() {

    	//Libro book = new Libro("1001", "1001archivo.pdf", "https://111.com", "Elasticsearch Basics","Rambabu Posa",new Long(4),"23-FEB-2017");
        
        //libroService.save(book);

        //Libro testBook = libroService.findOne(book.getFIELD1());
        Libro testBook = libroService.findOne("1001");
        assertNotNull(testBook.getFIELD1());
//        assertEquals(testBook.getFIELD4(), book.getFIELD4());
 //       assertEquals(testBook.getFIELD5(), book.getFIELD5());
 //       assertEquals(testBook.getFIELD7(), book.getFIELD7());

    }

    //@Test
    public void testFindByTitle() {

    	Libro book = new Libro("1001", "1001archivo.pdf", "https://111.com", "Elasticsearch Basics","Rambabu Posa",new Long(4),"23-FEB-2017");
        Libro testBook = libroService.save(book);

        List<Libro> byTitle = libroService.findByTitle(book.getFIELD4());
        assertThat(byTitle.size(), is(1));
    }

    //@Test
    public void testFindByAuthor() {

        List<Libro> bookList = new ArrayList<Libro>();
        bookList.add(new Libro("1001", "1001archivo.pdf", "https://111.com", "Elasticsearch Basics","Rambabu Posa",new Long(4),"23-FEB-2017"));
        bookList.add(new Libro("1002", "1002archivo.pdf", "https://2.com", "Apache Lucene Basics","Rambabu Posa",new Long(4),"20-FEB-2017"));
        bookList.add(new Libro("1003", "1003archivo.pdf", "https://3.com", "Apache Solr Basics","Rambabu Posa",new Long(8),"24-FEB-2017"));
        bookList.add(new Libro("1004", "1004archivo.pdf", "https://4.com", "Spring Data + ElasticSearch","Rambabu Posa",new Long(4),"15-FEB-2017"));
        bookList.add(new Libro("1005", "1005archivo.pdf", "https://5.com", "Spring Boot + MongoDB","Mkyong",new Long(5),"29-FEB-2017"));
        

        for (Libro book : bookList) {
            libroService.save(book);
        }

        Page<Libro> byAuthor = libroService.findByAuthor("Rambabu Posa", new PageRequest(0, 10));
        assertThat(byAuthor.getTotalElements(), is(4L));

        Page<Libro> byAuthor2 = libroService.findByAuthor("Mkyong", new PageRequest(0, 10));
        assertThat(byAuthor2.getTotalElements(), is(1L));

    }

    //@Test
    public void testDelete() {

    	Libro book = new Libro("1001", "1001archivo.pdf", "https://111.com", "Elasticsearch Basics","Rambabu Posa",new Long(4),"23-FEB-2017");
        libroService.save(book);
        libroService.delete(book);
        Libro testBook = libroService.findOne(book.getFIELD1());
        assertNull(testBook);
    }

}
