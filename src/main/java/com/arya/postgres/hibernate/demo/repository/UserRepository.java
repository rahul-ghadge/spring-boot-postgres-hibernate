package com.arya.postgres.hibernate.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arya.postgres.hibernate.demo.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

}
