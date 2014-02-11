/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.domain.weixin.dao.impl;

import java.io.Serializable;
import org.springframework.stereotype.Repository;
import com.weixin.datacore.domain.weixin.dao.WeixinPictureDao;
import com.weixin.datacore.domain.weixin.model.WeixinPicture;
import com.weixin.datacore.core.impl.HibernateDAOImpl;

@Repository("weixinPictureDao")
public class WeixinPictureDaoImpl extends HibernateDAOImpl<WeixinPicture, Serializable, Long> implements
WeixinPictureDao {

}
