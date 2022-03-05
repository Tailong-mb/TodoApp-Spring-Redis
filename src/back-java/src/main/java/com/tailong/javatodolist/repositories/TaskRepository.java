package com.tailong.javatodolist.repositories;

import com.redis.om.spring.repository.RedisDocumentRepository;
import com.tailong.javatodolist.documents.Task;

public interface TaskRepository extends RedisDocumentRepository<Task, String> {
}
