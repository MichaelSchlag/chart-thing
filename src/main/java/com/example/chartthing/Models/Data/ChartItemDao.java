package com.example.chartthing.Models.Data;

import com.example.chartthing.Models.ChartItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ChartItemDao extends CrudRepository<ChartItem, Integer>{
}

