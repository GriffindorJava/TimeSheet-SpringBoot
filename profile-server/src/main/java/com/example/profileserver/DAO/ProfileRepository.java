package com.example.profileserver.DAO;

import com.example.profileserver.Domain.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProfileRepository extends MongoRepository<Profile, String> {
}