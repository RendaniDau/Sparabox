package com.sparabox.repository;

import com.sparabox.domain.persistence.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantRepository extends JpaRepository<Merchant, Long> {
    Merchant findByNameAndCity(String name, String city);
}
