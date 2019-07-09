package com.eagle.order.service.impl;

import com.eagle.order.domain.Destination;
import com.eagle.order.domain.DestinationExample;
import com.eagle.order.mapper.DestinationMapper;
import com.eagle.order.service.DestinationService;
import com.eagle.order.util.QueryData;
import com.eagle.order.util.ReturnResult;
import com.eagle.order.vo.DestinationInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @Description
 * @Author hongling.lin
 * @Date 2019/6/3
 */
@Service
public class DestinationServiceImpl implements DestinationService {

    @Autowired
    private DestinationMapper destinationMapper;

    @Override
    public ReturnResult<List<DestinationInfo>> getList() {
        List<DestinationInfo> destinationList = destinationMapper.getDestinationList();
        return ReturnResult.ok(destinationList);
    }

    @Override
    public ReturnResult<PageInfo<Destination>> queryList(QueryData<Destination> queryData) {
        PageInfo pageInfo = queryData.getPageInfo();
        Destination destination = queryData.getParam();
        DestinationExample destinationExample = new DestinationExample();
        destinationExample.setOrderByClause("CREATE_DATE DESC");
        DestinationExample.Criteria criteria = destinationExample.createCriteria();
        if (!Strings.isNullOrEmpty(destination.getDestination())) {
            criteria.andDestinationLike(destination.getDestination() + "%");
        }
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        List<Destination> orderTaskList = destinationMapper.selectByExample(destinationExample);
        PageInfo<Destination> resultInfo = new PageInfo<Destination>(orderTaskList);
        return ReturnResult.ok(resultInfo);
    }

    @Override
    public ReturnResult<Integer> saveDestination(Destination destination) {
        DestinationExample destinationExample = new DestinationExample();
        DestinationExample.Criteria criteria = destinationExample.createCriteria()
                .andDestinationEqualTo(destination.getDestination())
                .andRecipientEqualTo(destination.getRecipient())
                .andPhoneEqualTo(destination.getPhone())
                .andAddrEqualTo(destination.getAddr());
        List<Destination> destinations = destinationMapper.selectByExample(destinationExample);
        int num = 0;
        if (destinations != null && destinations.size() == 0) {
            num = destinationMapper.insert(destination);
            if(num == 0){
                return ReturnResult.error("新增失败");
            }
        }else {
            return ReturnResult.error("此目的地重复");
        }
        return ReturnResult.ok(num);
    }

    @Override
    public ReturnResult<Integer> updateDestination(Destination destination) {
        DestinationExample destinationExample = new DestinationExample();
        DestinationExample.Criteria criteria = destinationExample.createCriteria()
                .andDestinationEqualTo(destination.getDestination()).andIdNotEqualTo(destination.getId());
        List<Destination> destinations = destinationMapper.selectByExample(destinationExample);
        int num = 0;
        if (destinations != null && destinations.size() == 0) {
            num = destinationMapper.updateByPrimaryKey(destination);
            if (num > 0) {
                return ReturnResult.ok(num);
            } else {
                return ReturnResult.error("修改失败");
            }
        } else {
            return ReturnResult.error("目的地名称重复");
        }
    }

    @Override
    public ReturnResult<Integer> deleteDestination(Long id) {
        int num = destinationMapper.deleteByPrimaryKey(id);
        if (num > 0) {
            return ReturnResult.ok(num);
        }
        return ReturnResult.error("删除失败");
    }

    @Override
    public ReturnResult<Destination> getDestination(Long id) {
        Destination destination = destinationMapper.selectByPrimaryKey(id);
        if(null == destination){
            return ReturnResult.error("获取目的地信息失败");
        }
        return ReturnResult.ok(destination);
    }

    @Override
    public ReturnResult<Destination> getInfoByDestination(String name) {
        DestinationExample destinationExample = new DestinationExample();
        DestinationExample.Criteria criteria = destinationExample.createCriteria().andDestinationEqualTo(name);
        List<Destination> destinations = destinationMapper.selectByExample(destinationExample);
        if(null == destinations && destinations.size() > 0){
            return ReturnResult.error("获取目的地信息失败");
        }
        return ReturnResult.ok(destinations.get(0));
    }
}
