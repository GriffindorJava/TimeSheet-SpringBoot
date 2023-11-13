package com.example.profileserver.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.profileserver.Domain.Profile;
import com.example.profileserver.Domain.Contact;
import com.example.profileserver.Service.ProfileService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    ProfileService profileService;

    @Autowired
    ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @CrossOrigin
    @GetMapping("")
    public ResponseEntity<ApiResponse<?>> getAllProfiles() {
        try {
            List<Profile> data = profileService.getAllProfiles();
            String message = "All profiles fetched successfully";
            ApiResponse<List<Profile>> apiResponse = new ApiResponse<>(message, data);
            return ResponseEntity.ok(apiResponse);
        } catch (Exception e) {
            e.printStackTrace();
            String message = "Failed to fetch profiles";
            ApiResponse<String> apiResponse = constructErrorResponse(message);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiResponse);
        }
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> getProfile(@PathVariable String id) {
        try {
            Optional<Profile> result = profileService.getProfileById(id);
            if(result.isPresent()) {
                Profile data = result.get();
                String message = String.format("Profile of %s fetched successfully", id);
                ApiResponse<Profile> apiResponse = new ApiResponse<>(message, data);
                return ResponseEntity.ok(apiResponse);
            } else {
                String data = "N/A";
                String message = "Profile not found";
                ApiResponse<String> apiResponse = new ApiResponse<>(message, data);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);
            }
        } catch (Exception e) {
            e.printStackTrace();
            String message = String.format("Failed to fatch %s's info", id);
            ApiResponse<String> apiResponse = constructErrorResponse(message);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiResponse);
        }
    }

    @CrossOrigin
    @PostMapping("")
    public ResponseEntity<ApiResponse<?>> createProfile(@RequestBody Profile profile) {
        try {
            Profile data = profileService.createProfile(profile);
            String message = "Profile created successfully";
            ApiResponse<Profile> apiResponse = new ApiResponse<Profile>(message, data);
            return ResponseEntity.ok(apiResponse);
        } catch (Exception e) {
            e.printStackTrace();
            String message = "Failed to create new profile";
            ApiResponse<String> apiResponse = constructErrorResponse(message);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiResponse);
        }
    }

    @CrossOrigin
    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> updateContact(@PathVariable String id, @RequestBody Contact contact) {
        try {
            Contact data = profileService.updateContact(id, contact);
            String message = String.format("Update contact for user %s successfully", id);
            ApiResponse<Contact> apiResponse = new ApiResponse<Contact>(message, data);
            return ResponseEntity.ok(apiResponse);
        } catch (Exception e) {
            e.printStackTrace();
            String message = "Failed to update Contact for user" + id;
            ApiResponse<String> apiResponse = constructErrorResponse(message);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiResponse);
        }
    }


    private ApiResponse<String> constructErrorResponse(String message) {
        String data = "N/A";
        return new ApiResponse<String>(message, data);
    }

}