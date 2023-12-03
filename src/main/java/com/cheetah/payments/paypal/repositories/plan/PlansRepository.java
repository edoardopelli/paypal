package com.cheetah.payments.paypal.repositories.plan;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cheetah.payments.paypal.plan.dto.PlanDto;

public interface PlansRepository extends MongoRepository<PlanDto, String> {

}
