var SagePay = {

	aesEncrypt: function (inputText, keyString) {	
		var keyAscii = CryptoJS.enc.Latin1.parse(keyString);
		var keyHex = CryptoJS.enc.Hex.parse(CryptoJS.enc.Hex.stringify(keyAscii));
		
		var encrypted = CryptoJS.AES.encrypt(inputText, keyHex, { iv: keyHex });

		return '@' + CryptoJS.enc.Hex.stringify(encrypted.ciphertext).toUpperCase()
	},
	
	triggerEncrypt: function () {
		var plainText = document.getElementById('plainText')
		var cryptString = document.getElementById('cryptString')
		var encryptionPassword = document.getElementById('encryptionPassword')

		cryptString.value = SagePay.aesEncrypt(plainText.value, encryptionPassword.value);
	},
	
	registerTransaction: function () {
		var registrationString = "VendorTxCode=chipbuttysrus-13860625" + (Math.random() * 10000) + "&" +
		"amount=" + document.getElementById("amount").value + 
		"&Currency=GBP&Description=TESTPAYMENT&SuccessURL=http://www.google.com/sagepay-java-kit-1.2.2.0/form/success/&" +
		"FailureURL=http://172.16.106.129/api/transaction-failure" + "?" + 
			"customerMobileNumber=" + document.getElementById("phoneNumber").value +
			"&customerEmailAddress=" + document.getElementById("emailAddress").value +
		"&BillingSurname=Surname&BillingFirstnames=Fname Mname&BillingAddress1=BillAddress Line 1&BillingCity=BillCity&BillingPostCode=W1A 1BL&BillingCountry=GB&DeliverySurname=Surname&DeliveryFirstnames=Fname Mname&DeliveryAddress1=BillAddress Line 1&DeliveryCity=BillCity&DeliveryPostCode=W1A 1BL&DeliveryCountry=GB&CustomerName=Fname Mname Surname&CustomerEMail=customer@example.com&SendEMail=1&eMailMessage=Thanks for your order&BillingAddress2=BillAddress Line 2&BillingPhone=44 (0)7933 000 000&DeliveryAddress2=BillAddress Line 2&DeliveryPhone=44 (0)7933 000 000&AllowGiftAid=0&ApplyAVSCV2=0&Apply3DSecure=0";

		var registrationCryptString = document.getElementById("registrationCryptString");
        registrationCryptString.value = SagePay.aesEncrypt(registrationString, "4X4CauKt56wYcM2M");
		
		document.getElementById("registrationForm").submit();
	}
}