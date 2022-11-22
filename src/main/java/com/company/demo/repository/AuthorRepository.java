package com.company.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.demo.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

	public Optional<Author> findByAuthorEmail(String authorEmail);

}
