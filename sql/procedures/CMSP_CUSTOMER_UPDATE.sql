DELIMITER $$

DROP PROCEDURE IF EXISTS `hotel`.`CMSP_CUSTOMER_UPDATE`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CMSP_CUSTOMER_UPDATE`(
					    IN p_idCustomer			varchar(06),
						IN p_lastname1			varchar(15),
						IN p_lastname2			varchar(15),
						IN p_firstnames			varchar(20),
						IN p_birthdate			varchar(10),
						IN p_nationality		varchar(02),
						IN p_title				varchar(03),
						IN p_documentType		varchar(02),
						IN p_documentNumber		varchar(12),
						IN p_address1			varchar(50),
						IN p_address2			varchar(50),
						IN p_district			varchar(15),
						IN p_city				varchar(15),
						IN p_idCountry			varchar(02),
						IN p_zipCode			varchar(05),
						IN p_phone1				varchar(10),
						IN p_phone2				varchar(10),
						IN p_movilPhone			varchar(10),
						IN p_email				varchar(50),
						IN p_occupation			varchar(20),
						IN p_vipStatus			varchar(01),
						IN p_requests			tinytext,
						IN p_hotelRegistration	varchar(02),
						IN p_madeBy				varchar(05),
						IN p_status				char(01) )

BEGIN
	declare v_birthdate date;

	-- TODO: test if
	if !strcmp(p_birthdate,'1971-08-12') then
	   set v_birthdate = 1969-12-31;
	else
	   set v_birthdate = STR_TO_DATE(p_birthDate,'%d/%m/%Y');
	end if;

    UPDATE customer SET
			tLastName1			= p_lastname1,
			tLastName2			= p_lastname2,
			tFirstNames			= p_firstNames,
			dBirthDate			= v_birthdate,
			nIdNationality		= p_idNationality,
			tTitle				= p_title,
			nDocumentType		= p_documentType,
			tDocumentNumber		= p_documentNumber,
			tAddress1			= p_address1,
			tAddress2			= p_address2,
			tDistrict			= p_district,
			tCity				= p_city,
			nIdCountry			= p_idCountry,
			tZipCode			= p_zipCode,
			nPhone1				= p_phone1,
			nPhone2				= p_phone2,
			nMovilPhone			= p_movilPhone,
			tEmail				= p_email,
			tOccupation			= p_occupation,
			nVipStatus			= p_vipStatus,
			tRequests			= p_requests,
			nHotelRegistration	= p_hotelRegistration,
			tMadeBy				= p_madeBy,
			dMadeOn				= CURRENT_TIMESTAMP(),
			tStatus				= p_Status
	WHERE 	nIdCustomer			= p_idCustomer;
END$$

DELIMITER ;