package FCI.graduate.blood_Donation.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FCI.graduate.blood_Donation.entity.DonorMedicalHistory;
import FCI.graduate.blood_Donation.repository.DonorMedicalHistoryRepo;

@Service
public class DonorMedicalHistoryService {

	@Autowired
	private DonorMedicalHistoryRepo userMedicalInfoRepo;

	Logger logger = LoggerFactory.getLogger(DonorMedicalHistoryService.class);

	public DonorMedicalHistory getUserByEmail(String email) {
		return userMedicalInfoRepo.findById(email).orElseThrow();
	}

	public DonorMedicalHistory addUser(DonorMedicalHistory user) {

		if (user.getChronicDisease() == null)
			user.setChronicDisease("false");

		if (user.getDentist() == null)
			user.setDentist("false");

		if (user.getSurgery() == null)
			user.setSurgery("false");

		if (user.getLastDonateTime() == null)
			user.setLastDonateTime(LocalDate.now());

		return userMedicalInfoRepo.save(user);
	}

	public DonorMedicalHistory updateUser(DonorMedicalHistory user) {

		DonorMedicalHistory oldUser = getUserByEmail(user.getEmail());

		if (user.getLastDonateTime() == null) {
			user.setLastDonateTime(oldUser.getLastDonateTime());
		}

		if (user.getNote() == null) {
			user.setNote(oldUser.getNote());
		}

		if (user.getChronicDisease() == null) {
			user.setChronicDisease(oldUser.getChronicDisease());
		}

		if (user.getDentist() == null) {
			user.setDentist(oldUser.getDentist());
		}

		if (user.getSurgery() == null) {
			user.setSurgery(oldUser.getSurgery());
		}

		if (user.getLegalToDonate() == null) {
			user.setLegalToDonate(oldUser.getLegalToDonate());
		}

		userMedicalInfoRepo.save(user);
		return user;
	}

	public void updateLastDonateTime(String email, LocalDate date) {
		userMedicalInfoRepo.updateLastDonateTime(email, date);
		logger.info("email is  {} , date is {} ", email, date);
	}

	public void updateNote(String email, String note) {
		userMedicalInfoRepo.updateNote(email, note);
	}

	public void updateSurgery(String email, String surgery) {
		userMedicalInfoRepo.updateSurgery(email, surgery);
		logger.info("email is {} , surgery is {} ", email, surgery);
	}

	public void updateDentist(String email, String dentist) {
		userMedicalInfoRepo.updateDentist(email, dentist);
		logger.info("email is  {} , dentist is {} ", email, dentist);
	}

	public void updateChronicDisease(String email, String chronicDisease) {
		userMedicalInfoRepo.updateChronicDisease(email, chronicDisease);
		logger.info("email is  {} , chronicDisease is {} ", email, chronicDisease);
	}

	public void updateLegalToDonate(String email) {

		DonorMedicalHistory donorMedicalHistory = getUserByEmail(email);
		long monthsDifference = ChronoUnit.MONTHS.between(donorMedicalHistory.getLastDonateTime(), LocalDate.now());

		if (donorMedicalHistory.getChronicDisease().equals("false") && donorMedicalHistory.getDentist().equals("false")
				&& donorMedicalHistory.getSurgery().equals("false") && monthsDifference > 3.0) {

			donorMedicalHistory.setLegalToDonate("true");
			userMedicalInfoRepo.updateLegalToDonate(donorMedicalHistory.getEmail(),
					donorMedicalHistory.getLegalToDonate());

			logger.info(
					"email is {} , legal {} , monthsDifference is {} , ChronicDisease is{} , dentist is  {} , surgery is {}",
					donorMedicalHistory.getEmail(), donorMedicalHistory.getLegalToDonate(), monthsDifference,
					donorMedicalHistory.getChronicDisease(), donorMedicalHistory.getDentist(),
					donorMedicalHistory.getSurgery());
		} else {

			donorMedicalHistory.setLegalToDonate("false");
			userMedicalInfoRepo.updateLegalToDonate(donorMedicalHistory.getEmail(),
					donorMedicalHistory.getLegalToDonate());

			logger.info(
					"email is {} , legal {} , monthsDifference is {} , ChronicDisease is{} , dentist is  {} , surgery is {}",
					donorMedicalHistory.getEmail(), donorMedicalHistory.getLegalToDonate(), monthsDifference,
					donorMedicalHistory.getChronicDisease(), donorMedicalHistory.getDentist(),
					donorMedicalHistory.getSurgery());
		}

	}

}
