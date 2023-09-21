package com.db.nace.repository;

import com.db.nace.entity.Nace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NaceRepository extends JpaRepository<Nace,Long> {
    Nace findByOrderNum(long orderNum);
}
