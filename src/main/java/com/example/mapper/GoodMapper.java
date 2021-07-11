package com.example.mapper;

import com.example.vo.GoodVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodMapper {
    List<GoodVo> select();
    GoodVo findById(@Param("id") int id);
    int reduceInventory(@Param("id") int id);
}