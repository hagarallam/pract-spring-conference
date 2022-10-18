package com.hagar.conference.service;

import com.hagar.conference.model.Course;
import com.hagar.conference.model.Registration;
import com.hagar.conference.model.RegistrationReport;
import com.hagar.conference.repository.CourseRepository;
import com.hagar.conference.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;
    @Autowired
    private CourseRepository courseRepository;

    @Override
    @Transactional
    public Registration addRegistration(Registration registration){

        registration = registrationRepository.save(registration);

        if(registration.getId() == null ) {
            Course course = new Course();
            course.setName("Intro");
            course.setDescription("should come Intro");
            course.setRegistration(registration);

            courseRepository.save(course);
        }

        return registration;
    }

    @Override
    public List<Registration> findAll() {
        return registrationRepository.findAll();
    }

    @Override
    public List<RegistrationReport> findAllReports() {
        return registrationRepository.findAllReports();

    }
}
