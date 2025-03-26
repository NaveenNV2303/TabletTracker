package com.DeviceAtlas.TabletTracker.TabletTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.DeviceAtlas.TabletTracker.TabletTracker.model.UserAgentEntity;

import java.util.List;

public interface UserAgentRepository extends JpaRepository<UserAgentEntity, Long> {
	
	@Query("SELECT u FROM UserAgentEntity u WHERE u.primaryHardwareType = 'Tablet' ORDER BY CAST(SPLIT_PART(u.osVersion, '.', 1) AS integer) DESC")
    List<UserAgentEntity> findByPrimaryHardwareTypeOrderByOsVersionDesc(String hardwareType);
	
}
