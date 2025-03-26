package com.DeviceAtlas.TabletTracker.TabletTracker.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.DeviceAtlas.TabletTracker.TabletTracker.model.UserAgentEntity;
import com.DeviceAtlas.TabletTracker.TabletTracker.service.UserAgentService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user-agents")
@CrossOrigin(origins = "*")
public class UserAgentController {

    private final UserAgentService service;

    public UserAgentController(UserAgentService service) {
        this.service = service;
    }
    
    @PostMapping("/load-from-frontend")
    public ResponseEntity<Map<String, String>> loadUserAgentFromFrontend(@RequestBody String userAgent) {
        Map<String, String> response = new HashMap<>();
    	try {
            service.fetchAndStoreUserAgentData(userAgent);
            response.put("message","User-Agent data loaded and stored successfully!");
            return ResponseEntity.ok(response);  // 200 OK with success message
        } catch (Exception e) {
            e.printStackTrace();
            response.put("message", "Error loading User-Agent data!");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);  // 500 with error message
        }
    }

    @GetMapping("/tablets")
    public List<UserAgentEntity> getTablets() {
        return service.getTabletsSortedByOsVersion();
    }
    
    @DeleteMapping("/delete-all")
    public ResponseEntity<Map<String, String>> deleteAllDevices() {
        Map<String, String> response = new HashMap<>();
        try {
            service.deleteAllDevices();
            response.put("message", "All User-Agent data deleted successfully!");
            return ResponseEntity.ok(response); // 200 OK
        } catch (Exception e) {
            e.printStackTrace();
            response.put("message", "Error deleting User-Agent data!");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response); // 500 Internal Server Error
        }
    }

    
}
