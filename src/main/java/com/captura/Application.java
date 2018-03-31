package com.captura;

import com.captura.book.model.Libro;
import com.captura.book.repository.LibroRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.elasticsearch.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.core.JsonParser.Feature;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private ElasticsearchOperations es;

  /*  @Autowired
    private BookService bookService;*/

    @Autowired
    LibroRepository libroRepository;
    
    public static void main(String args[]) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        printElasticSearchInfo();

        /*bookService.save(new Book("1001", "Elasticsearch Basics", "Rambabu Posa", "23-FEB-2017"));
        bookService.save(new Book("1002", "Apache Lucene Basics", "Rambabu Posa", "13-MAR-2017"));
        bookService.save(new Book("1003", "Apache Solr Basics", "Rambabu Posa", "21-MAR-2017"));*/

        //fuzzey search
        /*Page<Book> books = bookService.findByAuthor("Rambabu", new PageRequest(0, 10));*/

        //List<Book> books = bookService.findByTitle("Elasticsearch Basics");

        /*Iterator itr = books.iterator();
        
        while(itr.hasNext()) {
           Object element = itr.next();
           System.out.print(element + " ");
        }*/
        
        //books.forEach(x -> System.out.println(x));
        System.out.print("\n----------------------------------------------------\n");
        /*************/
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(Feature.AUTO_CLOSE_SOURCE, true);
        mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        TypeReference<List<Libro>> mapType = new TypeReference<List<Libro>>() {};
        //InputStream is = TypeReference.class.getResourceAsStream("C:/Documents and Settings/qwerty2/Escritorio/libros.json");
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("lista-libros.json");//convertcsv.json
        try {
        	List<Libro> librosList = mapper.readValue(is, mapType);
        	libroRepository.save(librosList);
        	System.out.println("Lista de libros salvada exitosamente");
        } catch (IOException e) {
        	System.out.println(e.getMessage());
        }


    }

    //usado para debug
    private void printElasticSearchInfo() {

        System.out.println("--ElasticSearch-->");
        Client client = es.getClient();
        Map<String, String> asMap = client.settings().getAsMap();

        /*asMap.forEach((k, v) -> {
            System.out.println(k + " = " + v);
        });*/
        
        for(Map.Entry m:asMap.entrySet()){  
        	   System.out.println(m.getKey()+" = "+m.getValue());  
        	  } 

        
        System.out.println("<--ElasticSearch--");
    }

}