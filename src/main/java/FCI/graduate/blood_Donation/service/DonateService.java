package FCI.graduate.blood_Donation.service;

import FCI.graduate.blood_Donation.entity.*;
import FCI.graduate.blood_Donation.repository.DonateRepo;
import FCI.graduate.blood_Donation.repository.DonorRepo;
import FCI.graduate.blood_Donation.repository.HospitalRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

@Service
public class DonateService {

    Logger logger = LoggerFactory.getLogger(DonateService.class);
    @Autowired
    private DonateRepo donateRepo;

    @Autowired
    private DonorRepo donorRepo;

    @Autowired
    private HospitalRepo hospitalRepo;

    public void addRequest(String donorEmail , String hospitalEmail) {

        Donate donate = new Donate();

        Donor donor= donorRepo.getById(donorEmail);
        Hospital hospital=hospitalRepo.getById(hospitalEmail);

        donate.setDonor(donor);
        donate.setHospital(hospital);

         donateRepo.save(donate);

        logger.info("id : "+donate.getId() +"   donor e-mail: "+donorEmail + "   hospital e-mail: "+ hospitalEmail
                +"   state_code : "+donate.getStateCode());
    }

    public List<Donate> findAll(){
        return donateRepo.findAll();
    }

    public void updateStateCode(Long id , String newState) {

        donateRepo.updateStateCode(id, newState);
    }

}
