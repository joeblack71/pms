DELIMITER $$

DROP PROCEDURE IF EXISTS `hotel`.`CMSP_CUSTOMER_LIST`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CMSP_CUSTOMER_LIST`(
					IN p_idHotel INT, IN param VARCHAR(25) )
BEGIN
	SELECT 	nIdCustomer			idCustomer,
			CONCAT(tLastName1, CONCAT(', ',tFirstNames) )
								customerNames,
			DATE_FORMAT(dBirthDate,'%d/%m/%Y')
								birthdate,
			nIdNationality		idNationality,
			ct.tNationality		desNationality,
			nTitle				title,
			nDocumentType		documentType,
			tDocumentNumber		documentNumber,
			tAddress1			address1,
			tAddress2			address2,
			tDistrict			district,
			tCity				city,
			c.nIdCountry		idCountry,
			tZipCode			zipCode,
			CONCAT(nPhone1, nPhone2, nMovilPhone)
								phones,
			tEmail				email,
			tOccupation			occupation,
			nVipStatus			vipStatus,
			tRequests			requests,
			nHotelRegistration	hotelRegistration,
			tMadeBy				madeBy,
			DATE_FORMAT(dMadeOn,'%d/%m/%Y')
								madeOn
	  FROM customer c
			LEFT JOIN country ct ON c.nIdNationality = ct.nIdCountry
	 WHERE c.nHotelRegistration = p_idHotel
	   AND c.tLastName1 LIKE CONCAT('%', param ,'%')
     ORDER BY c.tLastName1;
END$$

DELIMITER ;