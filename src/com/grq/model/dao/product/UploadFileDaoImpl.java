package com.grq.model.dao.product;

import org.springframework.stereotype.Repository;

import com.grq.model.dao.DaoSupport;
import com.grq.model.pojo.product.UploadFile;
@Repository("uploadFileDao")
public class UploadFileDaoImpl extends DaoSupport<UploadFile> implements UploadFileDao {

}
