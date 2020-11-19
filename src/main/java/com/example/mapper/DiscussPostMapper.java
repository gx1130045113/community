package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.domain.DiscussPost;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author gx
 * @since 2020-11-05
 */
public interface DiscussPostMapper extends BaseMapper<DiscussPost> {

    List<DiscussPost> selectDiscussPosts(@Param("userId")int userId,@Param("offset")int offset,@Param("limit")int limit);

    int selectDiscussPostRows(@Param("userId") int userId);

}
