package com.example.demo.models;

import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/*@Scope(scopeName = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
*/
@Document
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Students {

	private String name;
	@Id
	@Min(value = 1, message = "Required min Roll Number is 1")
	@Max(value = 100, message = "Required max Roll Number is 100")
	private int rollNumber;
	private String fatherName;
	@Min(value = 1, message = "Required min Grade is 1")
	@Max(value = 100, message = "Required max Grade is 10")
	private int grade;
	private String status="Active";
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private Date createdOn=new Date();
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private String updatedOn;
	private String content;
	
	@DocumentReference
	private Results results;

	
}
