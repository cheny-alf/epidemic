package com.cheny.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cheny.bean.DataBean;
import com.cheny.handler.DataHandler;
import com.cheny.handler.GraphHandler;
import com.cheny.mapper.DataMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataServiceImpl extends ServiceImpl<DataMapper, DataBean>
        implements DataService {
//
//    @Override
//    public List<DataBean> list() {
//        return DataHandler.getData();
//    }
//
//    @Override
//    public List<DataBean> listById(int id) {
//        if (id == 2) {
//            return GraphHandler.getData();
//        } else {
//            return list();
//        }
//    }
}
