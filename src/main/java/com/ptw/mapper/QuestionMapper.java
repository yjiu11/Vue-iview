package com.ptw.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ptw.pojo.Question;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yjiu
 * @since 2019-10-21
 */
@Mapper
public interface QuestionMapper extends BaseMapper<Question> {

}
