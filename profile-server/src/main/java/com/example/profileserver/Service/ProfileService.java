package com.example.profileserver.Service;

import com.example.profileserver.DAO.ProfileRepository;
import com.example.profileserver.Domain.Profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {
    final ProfileRepository profileRepository;

    @Autowired //Constructor injection
    ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public void createProfile(Profile profile) {
        profileRepository.save(profile);
    }
}
