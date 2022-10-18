package com.hagar.conference.repository;

import com.hagar.conference.model.Registration;
import com.hagar.conference.model.RegistrationReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration,Long> {
    List<RegistrationReport> registrationReport();
}
