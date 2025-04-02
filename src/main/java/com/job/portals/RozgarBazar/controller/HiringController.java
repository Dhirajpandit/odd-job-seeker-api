package com.job.portals.RozgarBazar.controller;

import com.job.portals.RozgarBazar.dto.Hiring;
import com.job.portals.RozgarBazar.dto.HiringDto;
import com.job.portals.RozgarBazar.service.HiringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/employers")
public class HiringController {
    @Autowired
    private HiringService hiringService;

    @PostMapping("/hire")
    public ResponseEntity<?> hireWorker(
            @RequestBody Hiring request) {
        try {
            HiringDto response = hiringService.processHiring(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(
                    Map.of(
                            "error", "Hiring failed",
                            "message", e.getMessage()
                    )
            );
        }
    }
}
