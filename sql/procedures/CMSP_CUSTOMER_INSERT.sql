DELIMITER $$

DROP PROCEDURE IF EXISTS `hotel`.`CMSP_CUSTOMER_INSERT`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CMSP_CUSTOMER_INSERT`(
					   OUT p_idCustomer			int,
						IN p_lastname1			varchar(15),
						IN p_lastname2			varchar(15),
						IN p_firstnames			varchar(20),
						IN p_birthdate			date,
						IN p_nationality		tinyint,
						IN p_title				varchar(3),
						IN p_documentType		tinyint,
						IN p_documentNumber		varchar(12),
						IN p_address1			varchar(50),
						IN p_address2			varchar(50),
						IN p_district			varchar(15),
						IN p_city				varchar(15),
						IN p_idCountry			tinyint,
						IN p_zipCode			varchar(5),
						IN p_phone1				integer,
						IN p_phone2				integer,
						IN p_movilPhone			integer,
						IN p_email				varchar(50),
						IN p_occupation			varchar(20),
						IN p_vipStatus			tinyint,
						IN p_requests			tinytext,
						IN p_hotelRegistration	tinyint,
						IN p_madeBy				smallint,
						IN p_status				char(1) )
BEGIN
    INSERT INTO customer(
			tLastName1, tLastName2, tFirstNames,
			tBirthDate, nIdNationality, tTitle, nDocumentType,
			tDocumentNumber, tAddress1, tAddress2, tDistrict,
			tCity, nIdCountry, tZipCode, nPhone1, nPhone2,
			nMovilPhone, tEmail, tOccupation, nVipStatus,
			tRequests, nHotelRegistration, tMadeBy, dMadeOn )/*tStatus )*/
				VALUES(
			p_lastname1, p_lastname2, p_firstNames,
			p_birthDate, p_idNationality, p_title, p_documentType,
			p_documentNumber, p_address1, p_address2, p_district,
			p_city, p_idCountry, p_zipCode, p_phone1, p_phone2,
			p_movilPhone, p_email, p_occupation, p_vipStatus,
			p_requests, p_hotelRegistration, p_madeBy, CURRENT_TIMESTAMP() ); /*p_Status);*/
END$$

DELIMITER ;