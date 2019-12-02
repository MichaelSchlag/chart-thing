package com.example.chartthing.Models.Data;

import com.example.chartthing.Models.Chart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ChartDao extends CrudRepository<Chart, Integer>{
}
