package com.jpa.jpaexample.controller;

import com.jpa.jpaexample.repository.CrudEntityRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class CrudController {

    private final CrudEntityRepository crudEntityRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping("/searchParam")
    public String searchParamMember(@RequestParam(value = "age") int age) {
        List resultList = entityManager.createQuery("select name from sample_member where age > :age")
                .setParameter("age", age)
                .getResultList();
        return resultList.toString();
    }

    @GetMapping("/searchParamRepo")
    public String searchParamRepoMember(@RequestParam(value = "name") String name) {
        return crudEntityRepository.searchParamRepo(name).toString();
    }

    @GetMapping("/search")
    public String searchAllMember() {
        return crudEntityRepository.findAll().toString();
    }
}
