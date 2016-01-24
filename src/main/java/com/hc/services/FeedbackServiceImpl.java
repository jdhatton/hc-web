package com.hc.services;

import org.skife.jdbi.v2.sqlobject.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hrt.data.db.dao.FeedbackDao;

@Component
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	FeedbackDao dao;
	
	public FeedbackServiceImpl() {
		super();
	}

	@Autowired
	public FeedbackServiceImpl(FeedbackDao dao) { 
		this.dao = dao;
	}

	@Transaction
	public void processFeedback(long userId, String feedback) {
		dao.addFeedback(userId, feedback);
		
		//
		// TODO: notify admin of feedback.
		//
	}

}
