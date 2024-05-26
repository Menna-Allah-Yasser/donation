package FCI.graduate.blood_Donation.service;

import FCI.graduate.blood_Donation.entity.*;
import FCI.graduate.blood_Donation.repository.DonorRepo;
import FCI.graduate.blood_Donation.repository.HospitalRepo;
import FCI.graduate.blood_Donation.repository.PointsRepo;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class PointsService {

    Logger logger = LoggerFactory.getLogger(PointsService.class);
    @Autowired
    private PointsRepo pointsRepo;

    @Autowired
    private DonorRepo donorRepo;

    @Autowired
    private HospitalRepo hospitalRepo;

    public List<Points> findAll(){
        return pointsRepo.findAll();
    }

//    public void addRequest(String donorEmail , String hospitalEmail) {
//
//        Points points= new Points();
//
//        Donor donor= donorRepo.getById(donorEmail);
//        Hospital hospital=hospitalRepo.getById(hospitalEmail);
//
//        points.setDonor(donor);
//        points.setHospital(hospital);
//
//         pointsRepo.save(points);
//
//         logger.info("id : "+ points.getId());
//    }

//    public void updatePoints(String donorEmail , String hospitalEmail , int points){
//
//        pointsRepo.updatePoints(donorEmail , hospitalEmail , points);
//    }


}
