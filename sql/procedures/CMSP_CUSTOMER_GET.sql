DELIMITER $$

DROP PROCEDURE IF EXISTS `hotel`.`CMSP_CUSTOMER_GET`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CMSP_CUSTOMER_GET`(
			IN p_idCustomer	varchar(06),
			IN p_documentNumber varchar(12),
			IN p_hotelRegistration	varchar(03))
BEGIN
	SELECT
		nIdCustomer			idCustomer,
		tLastName1			lastname1,
		tLastName2			lastname2,
		tFirstNames			firstnames,
		DATE_FORMAT(dBirthDate,'%d/%m/%Y')
							birthdate,
		nIdNationality 		nationality,
		nTitle 				title, -- Sr., Sra.
		nDocumentType 		documentType,
		tDocumentNumber 	documentNumber,
		tAddress1 			address1,
		tAddress2 			address2,
		tDistrict 			district,
		tCity 				city,
		nIdCountry 			idCountry,
		tZipCode 			zipCode,
		nPhone1 			phone1,
		nPhone2 			phone2,
		nMovilPhone			movilPhone,
		tEmail 				email,
		tOccupation 		occupation,
		nVipStatus 			vip,
		tRequests 			requests,
		nHotelRegistration	hotelRegistration,
		tMadeBy 			madeBy,
		DATE_FORMAT(dMadeOn,'%d/%m/%Y')	madeOn,
		tStatus 			status
	  FROM customer
	 WHERE ( p_idCustomer = nIdCustomer
			OR p_documentNumber = tDocumentNumber )
	   AND p_hotelRegistration = nHotelRegistration
	   AND tStatus <> '*';
    END$$

DELIMITER ;