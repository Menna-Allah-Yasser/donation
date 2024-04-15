package FCI.graduate.blood_Donation.controller;

import FCI.graduate.blood_Donation.entity.Points;
import FCI.graduate.blood_Donation.service.PointsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/points")
@Tag(name = "Points")
public class PointsController {

    @Autowired
    private PointsService pointsService;

    @PostMapping
    public void addRequest(@RequestParam String donorEmail ,@RequestParam String hospitalEmail) {
        pointsService.addRequest( donorEmail ,hospitalEmail);
    }
    @PutMapping("")
    @Operation(summary = "update points by positive or negative value ")
    public void updatePoints(@RequestParam String donorEmail ,@RequestParam String hospitalEmail ,@RequestParam int points){

        pointsService.updatePoints(donorEmail , hospitalEmail , points);
    }
}
