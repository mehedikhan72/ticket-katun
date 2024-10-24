package com.hy.ticketkatun.train.controller;

import com.hy.ticketkatun.train.dto.TrainResponse;
import com.hy.ticketkatun.train.service.TrainService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/train")
@RequiredArgsConstructor
public class TrainController {
    private final TrainService trainService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<TrainResponse> getAllTrains() {
        return trainService.getAllTrains();
    }

    @GetMapping("/seats/{trainName}") // Endpoint to get seats by train name
    public ResponseEntity<?> getSeatsOfATrain(@PathVariable String trainName) {
        return ResponseEntity.ok(trainService.getSeatsOfATrain(trainName));
    }
}
