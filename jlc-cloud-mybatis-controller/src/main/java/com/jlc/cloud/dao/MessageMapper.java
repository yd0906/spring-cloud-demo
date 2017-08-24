package com.jlc.cloud.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.jlc.cloud.model.Message;

@Repository
public interface MessageMapper {
	
	List<Message> list();
	
	int count();
}
