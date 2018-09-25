package com.example.demo.mapper.acc;

import com.example.demo.model.acc.AccAlarmEvent;
import com.example.demo.model.acc.AccAlarmEventCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccAlarmEventMapper {
    // test GitHub connect 222 wk
    long countByExample(AccAlarmEventCriteria example);

    int deleteByExample(AccAlarmEventCriteria example);

    int deleteByPrimaryKey(String uuid);

    int insert(AccAlarmEvent record);

    int insertSelective(AccAlarmEvent record);

    List<AccAlarmEvent> selectByExample(AccAlarmEventCriteria example);

    AccAlarmEvent selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") AccAlarmEvent record, @Param("example") AccAlarmEventCriteria example);

    int updateByExample(@Param("record") AccAlarmEvent record, @Param("example") AccAlarmEventCriteria example);

    int updateByPrimaryKeySelective(AccAlarmEvent record);

    int updateByPrimaryKey(AccAlarmEvent record);
}