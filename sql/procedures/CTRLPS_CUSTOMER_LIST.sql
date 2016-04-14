DELIMITER $$

DROP PROCEDURE IF EXISTS `hotel`.`CTRLPS_CUSTOMER_LIST`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPS_CUSTOMER_LIST`(
					IN p_idHotel INT, IN param VARCHAR(25) )
BEGIN
	declare v_param varchar(26);
	declare DOCUMENT_TYPE_TABLE smallint DEFAULT 1;
	declare TITLE_TABLE smallint DEFAULT 2;
	
	SET v_param = concat(param,'%');
	SELECT	CUSTP_ID_CUSTOMER		id_customer,
			CUSTC_LASTNAME1			lastname1,
			CUSTC_LASTNAME2			lastname2,
			CUSTC_FIRSTNAME			firstname,
			DATE_FORMAT(CUSTC_BIRTHDATE,'%d/%m/%Y')
									birthdate,
			ct.CTRYC_NATIONALITY 	nationality,
			t.ITMTP_ITEM_DESCRIPTION
									title, -- Mr., Miss, etc.
			dt.ITMTP_ITEM_DESCRIPTION
									document_type,
			CUSTC_DOCUMENT_NUMBER 	document_number,
			CUSTC_STREET_TYPE 		street_type,
			CUSTC_STREET_NAME 		street_name,
			CUSTC_STREET_NUMBER		street_number,
			CUSTC_INTERIOR_NUMBER	interior_number,
			CUSTC_COMPLEMENTS 		complements,
			CUSTC_DISTRICT 			district,
			CUSTC_CITY 				city,
			ct.CTRYC_COUNTRY_NAME	country_name,
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
			LEFT JOIN ctrlt_table_item t
					  ON c.CUSTF_DOCUMENT_TYPE = t.ITMTP_ID_ITEM
						 AND t.ITMTP_ID_TABLE = TITLE_TABLE
			LEFT JOIN ctrlt_table_item dt
					  ON c.CUSTF_DOCUMENT_TYPE = dt.ITMTP_ID_ITEM
						 AND dt.ITMTP_ID_TABLE = DOCUMENT_TYPE_TABLE
	 WHERE c.CUSTC_REGISTRATION_HOTEL = p_idHotel
	   AND c.CUSTC_LASTNAME1 LIKE v_param
     ORDER BY c.CUSTC_LASTNAME1;
END$$

DELIMITER ;