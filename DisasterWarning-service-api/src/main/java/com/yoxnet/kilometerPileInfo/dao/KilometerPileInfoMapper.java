package com.yoxnet.kilometerPileInfo.dao;

import com.yoxnet.kilometerPileInfo.bean.KilometerPileInfo;
import com.yoxnet.kilometerPileInfo.bean.KilometerPileInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface KilometerPileInfoMapper {
    int countByExample(KilometerPileInfoExample example);

    int deleteByExample(KilometerPileInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(KilometerPileInfo record);

    int insertSelective(KilometerPileInfo record);

    List<KilometerPileInfo> selectByExample(KilometerPileInfoExample example);

    KilometerPileInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") KilometerPileInfo record, @Param("example") KilometerPileInfoExample example);

    int updateByExample(@Param("record") KilometerPileInfo record, @Param("example") KilometerPileInfoExample example);

    int updateByPrimaryKeySelective(KilometerPileInfo record);

    int updateByPrimaryKey(KilometerPileInfo record);
}