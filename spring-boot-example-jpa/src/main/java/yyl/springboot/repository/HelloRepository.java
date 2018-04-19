package yyl.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import yyl.springboot.entity.Hello;

public interface HelloRepository extends JpaRepository<Hello, Long> {
}