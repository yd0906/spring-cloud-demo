package com.jlc.cloud.service;

import java.util.List;
import com.jlc.cloud.model.Message;

public interface IMessageService {

	List<Message> list();

	int count();

}
