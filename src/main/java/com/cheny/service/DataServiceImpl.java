package com.cheny.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cheny.bean.DataBean;
import com.cheny.mapper.DataMapper;
import org.springframework.stereotype.Service;

@Service
public class DataServiceImpl extends ServiceImpl<DataMapper, DataBean>
        implements DataService {

//    @Override
//    public List<DataBean> list() {
//        return DataHandler.getData();
//    }
}
