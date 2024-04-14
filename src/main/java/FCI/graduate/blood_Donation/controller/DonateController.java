package FCI.graduate.blood_Donation.controller;

import FCI.graduate.blood_Donation.entity.Donate;
import FCI.graduate.blood_Donation.service.DonateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/donate")
@Tag(name = "Donate")
public class DonateController {

    @Autowired
    private DonateService donateService;

    @PostMapping("")
    @Operation(summary = "add request to donate")
    public Donate addRequest(@RequestBody Donate donate) {
       return donateService.addRequest(donate);
    }

    @PutMapping("")
    @Operation(summary = "update state_code")
    public void updateStateCode(@RequestParam Long id ,@RequestParam String newState){
        donateService.updateStateCode(id , newState);
    }
}
