package FCI.graduate.blood_Donation.service;

import FCI.graduate.blood_Donation.entity.Donate;
import FCI.graduate.blood_Donation.entity.DonorPatient;
import FCI.graduate.blood_Donation.entity.Points;
import FCI.graduate.blood_Donation.repository.DonateRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;

@Service
public class DonateService {

    Logger logger = LoggerFactory.getLogger(DonateService.class);
    @Autowired
    private DonateRepo donateRepo;

    private PointsService pointsService;

    public Donate addRequest(Donate donate) {

        Points points = new Points();
        points.setDonor(donate.getDonor());
        points.setHospital(donate.getHospital());
       // pointsService.addRequest(points);
        logger.info("id : "+donate.getId() +" donor : "+donate.getDonor() + "hospital : "+ donate.getHospital()
        +"state_code : "+donate.getStateCode());
        return donateRepo.save(donate);
    }

    public void updateStateCode(Long id , String newState) {

        donateRepo.updateStateCode(id, newState);
    }

}
