DELIMITER $$

DROP PROCEDURE IF EXISTS `hotel`.`CTRLPS_CUSTOMER`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPS_CUSTOMER`(
			IN p_id_hotel			varchar(02),
			IN p_id_customer		varchar(06),
			IN p_document_number 	varchar(12),
			IN p_status				varchar(01) )
BEGIN
	DECLARE EMPTY varchar(01) DEFAULT '';
	-- REFACTOR
	-- tempo sentences
	IF p_id_customer IS NULL THEN
		SET p_id_customer = EMPTY;
	END IF;
	IF p_document_number IS NULL THEN
		SET p_document_number = EMPTY;
	END IF;
	IF p_status IS NULL THEN
		SET p_status = EMPTY;
	END IF;
	-- end tempo sentences
	SELECT	CUSTP_ID_CUSTOMER		id_customer,
			CUSTC_LASTNAME1			lastname1,
			CUSTC_LASTNAME2			lastname2,
			CUSTC_FIRSTNAME			firstname,
			DATE_FORMAT(CUSTC_BIRTHDATE,'%d/%m/%Y')
									birthdate,
			CUSTC_NATIONALITY 		nationality,
			CUSTC_TITLE 			title, -- Mr., Miss, etc.
			CUSTF_DOCUMENT_TYPE 	document_type,
			CUSTC_DOCUMENT_NUMBER 	document_number,
			CUSTC_STREET_TYPE 		street_type,
			CUSTC_STREET_NAME 		street_name,
			CUSTC_STREET_NUMBER		street_number,
			CUSTC_INTERIOR_NUMBER	interior_number,
			CUSTC_COMPLEMENTS 		complements,
			CUSTC_DISTRICT 			district,
			CUSTC_CITY 				city,
			CTRYF_ID_COUNTRY 		id_country,
			CUSTC_ZIPCODE 			zip_code,
			CUSTC_PHONE1 			phone1,
			CUSTC_PHONE2 			phone2,
			CUSTC_MOVIL_PHONE		movil_phone,
			CUSTC_EMAIL 			email,
			CUSTC_OCCUPATION 		occupation,
			CUSTC_VIP_STATUS 		vip,
			CUSTC_SPECIAL_REQUESTS 	requests,
			CUSTC_REGISTRATION_HOTEL hotel_registration,
			CUSTC_MADE_BY 			made_by,
			DATE_FORMAT(CUSTC_MADE_ON,'%d/%m/%Y')
									made_on,
			CUSTC_UPDATED_BY 		updated_by,
			DATE_FORMAT(CUSTC_LAST_UPDATE,'%d/%m/%Y')
									last_update,
			CUSTC_STATUS 			status
	  FROM CTRLT_CUSTOMER c
			LEFT JOIN ctrlt_country ct
					  ON c.CUSTC_NATIONALITY = ct.CTRYP_ID_COUNTRY
	 WHERE ( ( p_id_customer = CUSTP_ID_CUSTOMER AND p_document_number = EMPTY )
			 OR ( p_document_number = CUSTC_DOCUMENT_NUMBER AND p_id_customer = EMPTY ) )
	   AND ( p_status = EMPTY OR p_status = CUSTC_STATUS );
    END$$

DELIMITER ;