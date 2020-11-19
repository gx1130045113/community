package com.example.service;

import com.example.domain.DiscussPost;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author gx
 * @since 2020-11-05
 */
public interface DiscussPostService extends IService<DiscussPost> {
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);

    int selectDiscussPostRows(int userId);


}
