package com.simpleservice.repository

import com.simpleservice.entity.Policy
import org.springframework.data.jpa.repository.JpaRepository

interface PolicyRepository : JpaRepository<Policy, Long> {

}
