package edu.zk.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.zk.controller.enus.SeatColEnum;
import edu.zk.domain.TrainCarriage;
import edu.zk.domain.TrainCarriageExample;
import edu.zk.exception.BusinessException;
import edu.zk.exception.BusinessExceptionEnum;
import edu.zk.mapper.TrainCarriageMapper;
import edu.zk.req.TrainCarriageQueryReq;
import edu.zk.req.TrainCarriageSaveReq;
import edu.zk.resp.PageResp;
import edu.zk.resp.TrainCarriageQueryResp;
import edu.zk.util.SnowUtil;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainCarriageService {

    private static final Logger LOG = LoggerFactory.getLogger(TrainCarriageService.class);

    @Resource
    private TrainCarriageMapper trainCarriageMapper;

    //火车中添加车厢
    //判断唯一列（车次编号+厢号）组合是否被添加过
    //根据座位类型直接生成座位列数和总座位数
    public void save(TrainCarriageSaveReq req) {
        DateTime now = DateTime.now();
        String seatType = req.getSeatType();
        int col = SeatColEnum.getSeatCol(seatType);
        req.setColCount(col);
        req.setSeatCount(col*req.getRowCount());

        TrainCarriage trainCarriage = BeanUtil.copyProperties(req, TrainCarriage.class);

        if(isExists(req.getTrainCode(),req.getIndex())){
            throw new BusinessException(BusinessExceptionEnum.BUSINESS_TRAIN_CARRIAGE_INDEX_UNIQUE_ERROR);
        }

        if (ObjectUtil.isNull(trainCarriage.getId())) {
            trainCarriage.setId(SnowUtil.getSnowflakeNextId());
            trainCarriage.setCreateTime(now);
            trainCarriage.setUpdateTime(now);
            trainCarriageMapper.insert(trainCarriage);
        } else {
            trainCarriage.setUpdateTime(now);
            trainCarriageMapper.updateByPrimaryKey(trainCarriage);
        }
    }

    private boolean isExists(String trainCode, Integer index) {
        TrainCarriageExample trainCarriageExample = new TrainCarriageExample();
        trainCarriageExample.createCriteria()
                .andTrainCodeEqualTo(trainCode)
                .andIndexEqualTo(index);
        List<TrainCarriage> trainCarriages = trainCarriageMapper.selectByExample(trainCarriageExample);
        if(trainCarriages!=null&&trainCarriages.size()!=0){
            return true;
        }
        return false;
    }


    public PageResp<TrainCarriageQueryResp> queryList(TrainCarriageQueryReq req) {
        TrainCarriageExample trainCarriageExample = new TrainCarriageExample();
        trainCarriageExample.setOrderByClause("id desc");
        TrainCarriageExample.Criteria criteria = trainCarriageExample.createCriteria();

        LOG.info("查询页码：{}", req.getPage());
        LOG.info("每页条数：{}", req.getSize());
        PageHelper.startPage(req.getPage(), req.getSize());
        List<TrainCarriage> trainCarriageList = trainCarriageMapper.selectByExample(trainCarriageExample);

        PageInfo<TrainCarriage> pageInfo = new PageInfo<>(trainCarriageList);
        LOG.info("总行数：{}", pageInfo.getTotal());
        LOG.info("总页数：{}", pageInfo.getPages());

        List<TrainCarriageQueryResp> list = BeanUtil.copyToList(trainCarriageList, TrainCarriageQueryResp.class);

        PageResp<TrainCarriageQueryResp> pageResp = new PageResp<>();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(list);
        return pageResp;
    }

    public void delete(Long id) {
        trainCarriageMapper.deleteByPrimaryKey(id);
    }


}
