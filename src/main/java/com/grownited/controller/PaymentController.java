package com.grownited.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.authorize.Environment;
import net.authorize.api.contract.v1.ANetApiResponse;
import net.authorize.api.contract.v1.CreateTransactionRequest;
import net.authorize.api.contract.v1.CreateTransactionResponse;
import net.authorize.api.contract.v1.CreditCardType;
import net.authorize.api.contract.v1.CustomerDataType;
import net.authorize.api.contract.v1.MerchantAuthenticationType;
import net.authorize.api.contract.v1.MessageTypeEnum;
import net.authorize.api.contract.v1.PaymentType;
import net.authorize.api.contract.v1.TransactionRequestType;
import net.authorize.api.contract.v1.TransactionResponse;
import net.authorize.api.contract.v1.TransactionTypeEnum;
import net.authorize.api.controller.CreateTransactionController;
import net.authorize.api.controller.base.ApiOperationBase;

@Controller
public class PaymentController {
	
	@GetMapping("/paymentPage")
	public String page() {
		return "Payment";
	}

	@PostMapping("/processPayment")
	public ModelAndView processPayment(
	        @RequestParam("cardNumber") String cardNumber,
	        @RequestParam("expiryDate") String expiryDate,
	        @RequestParam("email") String email) {

	    System.out.println("Payment Details Received:");
	    System.out.println("Card Number: " + cardNumber);
	    System.out.println("Expiry Date: " + expiryDate);
	    System.out.println("Email: " + email);

	    // Run the payment transaction
	    ANetApiResponse response = run("2T5TXk3eC", "632wW52zs6DWAeCH", 500, cardNumber, expiryDate, email);

	    ModelAndView modelAndView;
	    
	    if (response instanceof CreateTransactionResponse) {
	        CreateTransactionResponse transactionResponse = (CreateTransactionResponse) response;
	        
	        if (transactionResponse.getMessages().getResultCode() == MessageTypeEnum.OK) {
	            TransactionResponse result = transactionResponse.getTransactionResponse();
	            if (result != null && result.getMessages() != null) {
	                System.out.println("Payment Successful!");
	                modelAndView = new ModelAndView("PaymentSuccess");
	                modelAndView.addObject("email", email);
	                return modelAndView;
	            }
	        }
	    }

	    // If payment failed, show error page
	    modelAndView = new ModelAndView("Payment");
	    modelAndView.addObject("errorMessage", "Payment failed. Please try again.");
	    return modelAndView;
	}

    public  ANetApiResponse run(String apiLoginId, String transactionKey, int amount,String ccNum,String expDate,String email) {

        // Set the request to operate in either the sandbox or production environment
        ApiOperationBase.setEnvironment(Environment.SANDBOX);

        // Create object with merchant authentication details
        MerchantAuthenticationType merchantAuthenticationType  = new MerchantAuthenticationType() ;
        merchantAuthenticationType.setName(apiLoginId);
        merchantAuthenticationType.setTransactionKey(transactionKey);

        // Populate the payment data
        PaymentType paymentType = new PaymentType();
        CreditCardType creditCard = new CreditCardType();
        creditCard.setCardNumber(ccNum);
        creditCard.setExpirationDate(expDate);
        paymentType.setCreditCard(creditCard);

        // Set email address (optional)
        CustomerDataType customer = new CustomerDataType();
        customer.setEmail(email);

        // Create the payment transaction object
        TransactionRequestType txnRequest = new TransactionRequestType();
        txnRequest.setTransactionType(TransactionTypeEnum.AUTH_CAPTURE_TRANSACTION.value());
        txnRequest.setPayment(paymentType);
        txnRequest.setCustomer(customer);
        txnRequest.setAmount(new BigDecimal(amount).setScale(2, RoundingMode.CEILING));

        // Create the API request and set the parameters for this specific request
        CreateTransactionRequest apiRequest = new CreateTransactionRequest();
        apiRequest.setMerchantAuthentication(merchantAuthenticationType);
        apiRequest.setTransactionRequest(txnRequest);

        // Call the controller
        CreateTransactionController controller = new CreateTransactionController(apiRequest);
        controller.execute();

        // Get the response
        CreateTransactionResponse response = new CreateTransactionResponse();
        response = controller.getApiResponse();
        
        // Parse the response to determine results
        if (response!=null) {
            // If API Response is OK, go ahead and check the transaction response
            if (response.getMessages().getResultCode() == MessageTypeEnum.OK) {
                TransactionResponse result = response.getTransactionResponse();
                if (result.getMessages() != null) {
                    System.out.println("Successfully created transaction with Transaction ID: " + result.getTransId());
                    System.out.println("Response Code: " + result.getResponseCode());
                    System.out.println("Message Code: " + result.getMessages().getMessage().get(0).getCode());
                    System.out.println("Description: " + result.getMessages().getMessage().get(0).getDescription());
                    System.out.println("Auth Code: " + result.getAuthCode());
                } else {
                    System.out.println("Failed Transaction.");
                    if (response.getTransactionResponse().getErrors() != null) {
                        System.out.println("Error Code: " + response.getTransactionResponse().getErrors().getError().get(0).getErrorCode());
                        System.out.println("Error message: " + response.getTransactionResponse().getErrors().getError().get(0).getErrorText());
                    }
                }
            } else {
                System.out.println("Failed Transaction.");
                if (response.getTransactionResponse() != null && response.getTransactionResponse().getErrors() != null) {
                    System.out.println("Error Code: " + response.getTransactionResponse().getErrors().getError().get(0).getErrorCode());
                    System.out.println("Error message: " + response.getTransactionResponse().getErrors().getError().get(0).getErrorText());
                } else {
                    System.out.println("Error Code: " + response.getMessages().getMessage().get(0).getCode());
                    System.out.println("Error message: " + response.getMessages().getMessage().get(0).getText());
                }
            }
        } else {
            // Display the error code and message when response is null 
            ANetApiResponse errorResponse = controller.getErrorResponse();
            System.out.println("Failed to get response");
            if (!errorResponse.getMessages().getMessage().isEmpty()) {
                System.out.println("Error: "+errorResponse.getMessages().getMessage().get(0).getCode()+" \n"+ errorResponse.getMessages().getMessage().get(0).getText());
            }
        }
        
        return response;
    }
}
