package com.svalero.libraryreactive.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "libraries")
public class Library {

    @Id
    private String id;
    @Field
    private String code;
    @Field
    private String name;
    @Field
    private String city;
    @Field
    private String address;
    @Field
    private String phone;

}
