package com.hrt.data.db.dao;

import org.springframework.stereotype.Component;

@Component
public class FeedbackDaoImpl implements FeedbackDao {

	public FeedbackDaoImpl() { }

	public void addFeedback(long userId, String feedback) {
		Feedbacks dao = DAO.getDBI().onDemand(Feedbacks.class);
		dao.insert(userId, feedback);
	}

}
