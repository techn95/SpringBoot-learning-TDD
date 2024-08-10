package com.vergez.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vergez.demo.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
