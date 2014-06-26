package com.grq.model.dao.shark;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.grq.model.dao.DaoSupport;
import com.grq.model.pojo.shark.PanelInfo;
@Repository("sharkDao")
@Transactional
public class SharkDaoImpl extends DaoSupport<PanelInfo> implements SharkDao {

}
