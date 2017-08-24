package com.jlc.cloud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jlc.cloud.dao.MessageMapper;
import com.jlc.cloud.model.Message;
import com.jlc.cloud.service.IMessageService;


@Service
public class MessageServiceImpl implements IMessageService {
	
	@Autowired
	private MessageMapper messageMapper;

	@Override
	public List<Message> list() {
		List<Message> list = messageMapper.list();
		return list;
	}

	@Override
	public int count() {
		return messageMapper.count();
	}
}
