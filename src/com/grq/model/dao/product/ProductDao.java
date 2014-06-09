package com.grq.model.dao.product;

import java.util.List;

import com.grq.model.dao.BaseDao;
import com.grq.model.pojo.product.ProductInfo;

public interface ProductDao extends BaseDao<ProductInfo>{
	public List<ProductInfo> findCommend();//��ѯ�Ƽ���Ʒ��ǰ10�������ϼ�ʱ�併������
	public List<ProductInfo> findClickcount();//��ѯ�������ǰ10����Ʒ
	public List<ProductInfo> findSellCount();//��ѯ������õ�ǰ10����Ʒ
}
