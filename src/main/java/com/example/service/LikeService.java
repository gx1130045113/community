package com.example.service;

public interface LikeService {

    void like(int userId,int entityType,int entityId);

    Long findEntityLikeKey(int entityType,int entityId);

    int findEntityLikeStatus(int userId,int entityType,int entityId);
}
