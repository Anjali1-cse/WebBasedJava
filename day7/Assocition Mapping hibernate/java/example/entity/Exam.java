package example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity// marks this class entity class
@Table(name="Exam_Master")//maps this class to the the table: Exam_Master

public class Exam {
   @Id//marks this field as an ID field
   @Column(name="exam_code", length=5)//Map this field to the column
   private String  code;
   @Column(name="exam_name", length=30)
   private String name;
   @Column(name="exam_type", length=30)
   private String type;
   @Column(name="exam_dur")
   private int duration;
   public Exam() {
	super();
   }
   public Exam(String code, String name, String type, int duration) {
	super();
	this.code = code;
	this.name = name;
	this.type = type;
	this.duration = duration;
   }
   public String getCode() {
	return code;
   }
   public void setCode(String code) {
	this.code = code;
   }
   public String getName() {
	return name;
   }
   public void setName(String name) {
	this.name = name;
   }
   public String getType() {
	return type;
   }
   public void setType(String type) {
	this.type = type;
   }
   public int getDuration() {
	return duration;
   }
   public void setDuration(int duration) {
	this.duration = duration;
   }
   @Override
   public String toString() {
	return "Exam [code=" + code + ", name=" + name + ", type=" + type + ", duration=" + duration + "]";
   }
   
}
