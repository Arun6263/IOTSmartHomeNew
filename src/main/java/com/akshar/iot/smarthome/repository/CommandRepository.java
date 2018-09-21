package com.akshar.iot.smarthome.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akshar.iot.smarthome.model.Command;

@Repository("commandRepository")
public interface CommandRepository extends JpaRepository<Command, Long> {
	List<Command> findAll();
}
