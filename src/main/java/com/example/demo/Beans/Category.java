package com.example.demo.Beans;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public enum Category {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    SPORT,TOURISM,SPA,KIDS,SHOWS,FOOD,BEVERAGES,ELECTRONICS
}
