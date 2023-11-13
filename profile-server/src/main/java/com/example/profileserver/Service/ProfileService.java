package com.example.profileserver.Service;

import com.example.profileserver.DAO.ProfileRepository;
import com.example.profileserver.Domain.Contact;
import com.example.profileserver.Domain.Profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {
    final ProfileRepository profileRepository;

    @Autowired //Constructor injection
    ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public Profile createProfile(Profile profile) {
        profileRepository.save(profile);
        return profile;
    }

    public Optional<Profile> getProfileById(String id) {
        return profileRepository.findById(id);
    }

    public Contact updateContact(String id, Contact contact) {
        Optional<Profile> profileToBeUpdated = profileRepository.findById(id);
        profileToBeUpdated.ifPresent(profile -> {
            profile.setContact(contact);
            profileRepository.save(profile);
        });
        return contact;
    }

    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }

}
