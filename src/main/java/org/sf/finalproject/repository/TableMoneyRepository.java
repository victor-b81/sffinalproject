package org.sf.finalproject.repository;

import org.sf.finalproject.entity.TableMoney;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TableMoneyRepository {
    Optional<TableMoney> findTableMoneyByUserId(int userId);

}
