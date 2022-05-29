package com.finalProject.Project.repository;

import com.finalProject.Project.model.Computer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComputerRepository extends JpaRepository<Computer, Long> {




    Computer getComputerById(long id);
}
