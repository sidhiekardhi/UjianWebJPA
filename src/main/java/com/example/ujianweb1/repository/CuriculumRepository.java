package com.example.ujianweb1.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ujianweb1.entity.Curiculum;


@Repository
public interface CuriculumRepository extends JpaRepository<Curiculum, Integer>{

}
