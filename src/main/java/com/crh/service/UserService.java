package com.crh.service;

import com.crh.entity.SysUsr;
import com.crh.mapper.SysUsrMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author crh
 * @date 2020-03-18 16:20
 */
@Service
public class UserService {
    @Autowired
    SysUsrMapper sysUsrMapper;

    public void addUser(SysUsr usr){
        sysUsrMapper.insert(usr);
    }
    public List<SysUsr> selectAll(){
       return sysUsrMapper.selectAll();
    }
    public void updateUser(SysUsr usr){
        sysUsrMapper.updateByPrimaryKey(usr);
    }
    public void deleteUser(Integer pkId){
        sysUsrMapper.deleteByPrimaryKey(pkId);
    }
}
