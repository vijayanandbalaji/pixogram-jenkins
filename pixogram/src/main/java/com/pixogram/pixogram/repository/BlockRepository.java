package com.pixogram.pixogram.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pixogram.pixogram.model.BlockDetails;

public interface BlockRepository extends JpaRepository<BlockDetails, Long> {

}
