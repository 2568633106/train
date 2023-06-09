package edu.zk.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.zk.domain.TrainCarriage;
import edu.zk.domain.TrainCarriageExample;
import edu.zk.domain.TrainSeat;
import edu.zk.domain.TrainSeatExample;
import edu.zk.mapper.TrainCarriageMapper;
import edu.zk.mapper.TrainSeatMapper;
import edu.zk.req.TrainSeatQueryReq;
import edu.zk.req.TrainSeatSaveReq;
import edu.zk.resp.PageResp;
import edu.zk.resp.TrainSeatQueryResp;
import edu.zk.util.SnowUtil;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainSeatService {

    private static final Logger LOG = LoggerFactory.getLogger(TrainSeatService.class);

    @Resource
    private TrainSeatMapper trainSeatMapper;
    @Autowired
    private TrainCarriageMapper trainCarriageMapper;

    public void save(TrainSeatSaveReq req) {
        DateTime now = DateTime.now();
        TrainSeat trainSeat = BeanUtil.copyProperties(req, TrainSeat.class);
        if (ObjectUtil.isNull(trainSeat.getId())) {
            trainSeat.setId(SnowUtil.getSnowflakeNextId());
            trainSeat.setCreateTime(now);
            trainSeat.setUpdateTime(now);
            trainSeatMapper.insert(trainSeat);
        } else {
            trainSeat.setUpdateTime(now);
            trainSeatMapper.updateByPrimaryKey(trainSeat);
        }
    }

    public PageResp<TrainSeatQueryResp> queryList(TrainSeatQueryReq req) {
        TrainSeatExample trainSeatExample = new TrainSeatExample();
        trainSeatExample.setOrderByClause("id desc");
        TrainSeatExample.Criteria criteria = trainSeatExample.createCriteria();
        criteria.andTrainCodeEqualTo(req.getTrainCode());

        LOG.info("查询页码：{}", req.getPage());
        LOG.info("每页条数：{}", req.getSize());
        PageHelper.startPage(req.getPage(), req.getSize());
        List<TrainSeat> trainSeatList = trainSeatMapper.selectByExample(trainSeatExample);

        PageInfo<TrainSeat> pageInfo = new PageInfo<>(trainSeatList);
        LOG.info("总行数：{}", pageInfo.getTotal());
        LOG.info("总页数：{}", pageInfo.getPages());

        List<TrainSeatQueryResp> list = BeanUtil.copyToList(trainSeatList, TrainSeatQueryResp.class);

        PageResp<TrainSeatQueryResp> pageResp = new PageResp<>();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(list);
        return pageResp;
    }

    public void delete(Long id) {
        trainSeatMapper.deleteByPrimaryKey(id);
    }

    public void saveSeatByCode(String code) {
        TrainSeatExample trainSeatExample = new TrainSeatExample();
        trainSeatExample.createCriteria()
                .andTrainCodeEqualTo(code);
        trainSeatMapper.deleteByExample(trainSeatExample);

        DateTime now = DateTime.now();
        TrainCarriageExample trainCarriageExample = new TrainCarriageExample();
        trainCarriageExample.createCriteria()
                .andTrainCodeEqualTo(code);
        List<TrainCarriage> trainCarriages = trainCarriageMapper.selectByExample(trainCarriageExample);

        int index=1;
        for (TrainCarriage trainInfo : trainCarriages) {
            for (int i = 0; i < trainInfo.getColCount(); i++) {
                for (int j = 0; j < trainInfo.getRowCount(); j++) {
                    TrainSeat trainSeat = new TrainSeat();
                    trainSeat.setId(SnowUtil.getSnowflakeNextId());
                    trainSeat.setTrainCode(trainInfo.getTrainCode());
                    trainSeat.setCarriageIndex(trainInfo.getIndex());
                    trainSeat.setRow(trainInfo.getColCount().toString());
                    trainSeat.setCol(trainInfo.getRowCount().toString());
                    trainSeat.setSeatType(trainInfo.getSeatType());
                    trainSeat.setCarriageSeatIndex(index++);
                    trainSeat.setCreateTime(now);
                    trainSeat.setUpdateTime(now);
                    trainSeatMapper.insert(trainSeat);
                }
            }
        }
    }
}
