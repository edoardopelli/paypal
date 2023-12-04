package com.cheetah.payments.paypal.repositories.subscriptions;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.cheetah.payments.paypal.subscription.dto.SubscriptionDto;

public interface SubscriptionsRepository extends MongoRepository<SubscriptionDto, String> {

	@Query("{'response._id': ?0}")
	SubscriptionDto findBySubscriptionId(String subscriptionId);

}
