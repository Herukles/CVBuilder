package com.Herukles.CVBuilder.CV.Services;

import com.Herukles.CVBuilder.CV.Models.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface CVService {
    CV save(CV cv);
    Optional<CV> findById(@RequestParam Long id);

    ResponseEntity<HttpStatus> deleteCV(Long id);
}
