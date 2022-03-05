package com.tailong.javatodolist.documents;

import com.redis.om.spring.annotations.Document;
import org.springframework.data.annotation.Id;

@Document
public class Task {
    @Id
    public String id;
    public String name;
    public boolean complete = false;

}
