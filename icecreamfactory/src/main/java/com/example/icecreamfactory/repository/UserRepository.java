package com.example.icecreamfactory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.icecreamfactory.entity.User;

public interface UserRepository extends JpaRepository<User, String> {


}
