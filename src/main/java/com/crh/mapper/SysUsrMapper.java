package com.crh.mapper;

import com.crh.entity.SysUsr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SysUsrMapper {
    int deleteByPrimaryKey(Integer pkId);

    int insert(SysUsr record);

    SysUsr selectByPrimaryKey(Integer pkId);

    List<SysUsr> selectAll();

    int updateByPrimaryKey(SysUsr record);
}