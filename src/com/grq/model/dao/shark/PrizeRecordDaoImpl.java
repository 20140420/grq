package com.grq.model.dao.shark;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.grq.model.dao.DaoSupport;
import com.grq.model.pojo.shark.PrizeRecord;
@Repository("prizeRecordDao")
@Transactional
public class PrizeRecordDaoImpl extends DaoSupport<PrizeRecord> implements PrizeRecordDao {

}
