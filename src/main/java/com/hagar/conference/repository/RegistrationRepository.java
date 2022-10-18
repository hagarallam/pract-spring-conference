package com.hagar.conference.repository;

import com.hagar.conference.model.Registration;
import com.hagar.conference.model.RegistrationReport;

import java.util.List;

public interface RegistrationRepository {
    Registration save(Registration registration);

    List<Registration> findAll();

    List<RegistrationReport> findAllReports();
}
