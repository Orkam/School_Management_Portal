/**
@project school-management-portal-backend
@author Gustavo Guevara
@created 17 Oct 2023
*/
package com.management.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.management.portal.Model.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol,Long>{

}
