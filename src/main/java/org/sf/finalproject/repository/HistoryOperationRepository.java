package org.sf.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.sf.finalproject.entity.TableHistoryOperation;

import java.sql.Date;
import java.util.List;
@Repository
public interface HistoryOperationRepository extends JpaRepository<TableHistoryOperation, Long> {

    @Query(value = "SELECT * FROM TABLE_HISTORY_OPERATION WHERE DATE >= :startDate AND DATE <= :endDate AND USER_ID = :userId", nativeQuery = true)
    List<TableHistoryOperation> getAllBetweenDates(@Param("userId") String userId, @Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
