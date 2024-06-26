package FCI.graduate.blood_Donation.controller;

import FCI.graduate.blood_Donation.entity.Login;
import FCI.graduate.blood_Donation.entity.Points;
import FCI.graduate.blood_Donation.service.PointsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/points")
@Tag(name = "Points")
public class PointsController {

    @Autowired
    private PointsService pointsService;

    @GetMapping()
    @Operation(summary = "get all Points")
    public List<Points> findAll(){
        return pointsService.findAll();
    }

    @GetMapping("/{email}")
    @Operation(summary = "get donor points by email")
    public int getPointsByEmail(@PathVariable String email){
        return pointsService.getPointsByEmail(email);
    }

//    @PostMapping
//    public void addRequest(@RequestParam String donorEmail ,@RequestParam String hospitalEmail) {
//        pointsService.addRequest( donorEmail ,hospitalEmail);
//    }

    @PutMapping("")
    @Operation(summary = "update points by value ")
    public void updatePoints(@RequestParam String donorEmail  ,@RequestParam int points){

        pointsService.updatePoints(donorEmail , points);
    }
}
