package com.captura.book.model;



import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "librosdb", type = "libros")
public class Libro {
	@Id
    private String FIELD1; //indice  amazon
	private String FIELD2;  //nombre archivo
	private String FIELD3;  //url imagen
	private String FIELD4;  //titulo
	private String FIELD5;  //autor
	private Long FIELD6;  //id categoria
	private String FIELD7;   //categoria
	
	
	
	public Libro() {
		super();
	}
	public Libro(String fIELD1, String fIELD2, String fIELD3, String fIELD4,
			String fIELD5, Long fIELD6, String fIELD7) {
		super();
		FIELD1 = fIELD1;
		FIELD2 = fIELD2;
		FIELD3 = fIELD3;
		FIELD4 = fIELD4;
		FIELD5 = fIELD5;
		FIELD6 = fIELD6;
		FIELD7 = fIELD7;
	}
	public String getFIELD1() {
		return FIELD1;
	}
	public void setFIELD1(String fIELD1) {
		FIELD1 = fIELD1;
	}
	public String getFIELD2() {
		return FIELD2;
	}
	public void setFIELD2(String fIELD2) {
		FIELD2 = fIELD2;
	}
	public String getFIELD3() {
		return FIELD3;
	}
	public void setFIELD3(String fIELD3) {
		FIELD3 = fIELD3;
	}
	public String getFIELD4() {
		return FIELD4;
	}
	public void setFIELD4(String fIELD4) {
		FIELD4 = fIELD4;
	}
	public String getFIELD5() {
		return FIELD5;
	}
	public void setFIELD5(String fIELD5) {
		FIELD5 = fIELD5;
	}
	public Long getFIELD6() {
		return FIELD6;
	}
	public void setFIELD6(Long fIELD6) {
		FIELD6 = fIELD6;
	}
	public String getFIELD7() {
		return FIELD7;
	}
	public void setFIELD7(String fIELD7) {
		FIELD7 = fIELD7;
	}
	
	
		   
		   
}
