package com.revature.controllers;

import java.util.List;

import com.google.gson.Gson;
import com.revature.models.CustomerOrder;
import com.revature.models.PaymentMethod;
import com.revature.repositories.PaymentDAO;

import io.javalin.http.Handler;

public class PaymentController {

	PaymentDAO pDAO = new PaymentDAO();

	public Handler insertPaymentHandler = (ctx) -> {
		if (ctx.req.getSession() != null) {
			String body = ctx.body();

			Gson gson = new Gson();

			PaymentMethod payment = gson.fromJson(body, PaymentMethod.class);

			String statement = pDAO.insertCustomerPayment(payment);

			if (statement == "Success") {
				ctx.status(200);
				ctx.result("Payment Successfully Added!");
			} else {
				ctx.status(404);
				ctx.result("Payment Addition Failed!");
			}
		}
	};
	
	public Handler getAllPaymentsHandler = (ctx) -> {
		if (ctx.req.getSession() != null) {
			
			List<PaymentMethod> paymentMethodList= pDAO.getAllPaymentMethods();
			Gson gson = new Gson();
	
			String JSONPayments =  gson.toJson(paymentMethodList);
			
			ctx.result(JSONPayments);
			ctx.status(200);
			} else {
				ctx.result("NOT LIKELY TO HAPPEN");
				ctx.status(404);
			}
		
	};

}
