package com.ptw.service.impl;

import com.ptw.pojo.Question;
import com.ptw.mapper.QuestionMapper;
import com.ptw.service.QuestionService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yjiu
 * @since 2019-10-21
 */
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements QuestionService {

}
