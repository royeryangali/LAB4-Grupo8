package com.example.laboratorio4.repository;

import com.example.laboratorio4.dto.EmpleadoPorSearch;
import com.example.laboratorio4.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryRepository extends JpaRepository<History,Integer> {

    @Query(value ="SELECT e.first_name as Nombre, e.last_name as Apellido, j.job_title as Cargo, jh.start_date as FechaInicio,jh.end_date as FechaFin,timestampdiff(YEAR,  jh.start_date,jh.end_date) as AniosTrabajados, timestampdiff(MONTH, jh.start_date,jh.end_date) as MesesTrabajados FROM employees e INNER JOIN job_history jh ON (e.employee_id=jh.employee_id) INNER JOIN jobs j ON (j.job_id=e.job_id) ORDER BY AniosTrabajados DESC",nativeQuery=true)
    List<EmpleadoPorSearch> historialEmpleados (String busqueda);

}
