package com.example.abid_mehdi_4twin7.repositories;

import com.example.abid_mehdi_4twin7.entities.Bloc;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.CrudRepository;

public interface IblocRepository extends JpaRepository <Bloc,Long> {


}
