package com.example.cs4blogmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Comment {
    @Id
    private Long id;
    private String content;

    @ManyToOne
    private User user;
    @ManyToOne
    private Blog blog;
}
