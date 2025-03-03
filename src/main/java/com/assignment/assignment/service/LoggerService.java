package com.assignment.assignment.service;

import com.assignment.assignment.domain.Logger;
import com.assignment.assignment.repo.LoggerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoggerService {

    @Autowired
    private LoggerRepo loggerRepo;

    public void logOperation(String operation) {
        Logger log = new Logger(operation);
        loggerRepo.save(log);
    }
}