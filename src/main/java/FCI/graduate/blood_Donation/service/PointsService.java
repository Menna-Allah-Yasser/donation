package FCI.graduate.blood_Donation.service;

import FCI.graduate.blood_Donation.entity.Donate;
import FCI.graduate.blood_Donation.entity.Points;
import FCI.graduate.blood_Donation.repository.PointsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PointsService {

    @Autowired
    private PointsRepo pointsRepo;

    public void addRequest(Points points) {

         pointsRepo.save(points);
    }

    public void updatePoints(String donorEmail , String hospitalEmail , int points){

        pointsRepo.updatePoints(donorEmail , hospitalEmail , points);
    }


}
