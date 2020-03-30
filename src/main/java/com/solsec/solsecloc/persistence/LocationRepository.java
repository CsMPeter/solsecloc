package com.solsec.solsecloc.persistence;

import com.solsec.solsecloc.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
