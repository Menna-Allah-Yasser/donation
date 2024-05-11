package FCI.graduate.blood_Donation.controller;

import FCI.graduate.blood_Donation.entity.Donate;
import FCI.graduate.blood_Donation.service.DonateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/donations")
@Tag(name = "Donate")
public class DonateController {

    @Autowired
    private DonateService donateService;


    @PostMapping("")
    @Operation(summary = "add request to donate")
    public void addRequest(@RequestParam  String donorEmail ,@RequestParam String hospitalEmail) {
        donateService.addRequest( donorEmail ,  hospitalEmail);
    }

    @PutMapping("")
    @Operation(summary = "update state_code")
    public void updateStateCode(@RequestParam Long id ,@RequestParam String newState){
        donateService.updateStateCode(id , newState);
    }

    @GetMapping()
    @Operation(summary = "get all in donate")
    public List<Donate> findAll(){
       return  donateService.findAll();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "delete donation request by id")
    public void delete(@PathVariable Long id){
        donateService.delete(id);
    }
}
