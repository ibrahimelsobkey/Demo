package com.example.demo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
 
@Document
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Results{
 
  private String totalMarks;
  private String obtainedMarks;
  @Id
  @Min(value = 1, message = "Required min Roll Number is 1")
  @Max(value = 100, message = "Required max Roll Number is 100")
  private int rollNumber;
  @Min(value = 1, message = "Required min Grade is 1")
  @Max(value = 100, message = "Required max Grade is 10")
  private int grade;
  private String remarks;
  private String positionInClass;
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private String createdOn;
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private String updatedOn;
  
	/*
	 * @DocumentReference(lazy = true, lookup = "{ 'results' : ?#{#self._id} }")
	 * 
	 * @ReadOnlyProperty private Students students;
	 */
	 
	 

}

