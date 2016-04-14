DELIMITER $$

DROP PROCEDURE IF EXISTS `hotel`.`CTRLPU_CUSTOMER`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPU_CUSTOMER`(
					   OUT p_error_type			varchar(06),
					    IN p_id_customer		varchar(06),
						IN p_lastname1			varchar(15),
						IN p_lastname2			varchar(15),
						IN p_firstnames			varchar(20),
						IN p_birthdate			varchar(10),
						IN p_nationality		varchar(02),
						IN p_title				varchar(03),
						IN p_document_type		varchar(02),
						IN p_document_number	varchar(12),
						IN p_street_type		varchar(02),
						IN p_street_name		varchar(30),
						IN p_street_number		varchar(04),
						IN p_interior_number	varchar(04),
						IN p_complements		varchar(20),
						IN p_district			varchar(15),
						IN p_city				varchar(15),
						IN p_id_country			varchar(02),
						IN p_zip_code			varchar(10),
						IN p_phone1				varchar(10),
						IN p_phone2				varchar(10),
						IN p_movil_phone		varchar(10),
						IN p_email				varchar(50),
						IN p_occupation			varchar(20),
						IN p_vip_status			varchar(01),
						IN p_requests			tinytext,
						IN p_hotel_registration	varchar(02),
						IN p_update_by			varchar(05),
						IN p_status				varchar(01) )
BEGIN
	declare v_current_date date default current_date();
	declare v_birthdate date;

	/* Continua luego de intentar registrar un documento de identidad duplicado */
	DECLARE foo int default 0;
	DECLARE ER_DUP_ENTRY CONDITION FOR SQLSTATE '23000'; -- ER_DUP_ENTRY 23000
	DECLARE CONTINUE HANDLER FOR ER_DUP_ENTRY SET p_error_type = '23000'; 

	-- TODO: test if
	if !strcmp(p_birthdate,'1971-08-12') then
	   set v_birthdate = 1969-12-31;
	else
	   set v_birthdate = STR_TO_DATE(p_birthDate,'%d/%m/%Y');
	end if;
    UPDATE CTRLT_CUSTOMER SET
			CUSTC_LASTNAME1			= p_lastname1,
			CUSTC_LASTNAME2			= p_lastname2,
			CUSTC_FIRSTNAME			= p_firstNames,
			CUSTC_BIRTHDATE			= v_birthdate,
			CUSTC_NATIONALITY		= p_nationality,
			CUSTC_TITLE				= p_title,
			CUSTF_DOCUMENT_TYPE		= p_document_type,
			CUSTC_DOCUMENT_NUMBER	= p_document_number,
			CUSTC_STREET_TYPE		= p_street_type,
			CUSTC_STREET_NAME		= p_street_name,
			CUSTC_STREET_NUMBER		= p_street_number,
			CUSTC_INTERIOR_NUMBER	= p_interior_number,
			CUSTC_COMPLEMENTS		= p_complements,
			CUSTC_DISTRICT			= p_district,
			CUSTC_CITY				= p_city,
			CTRYF_ID_COUNTRY		= p_id_country,
			CUSTC_ZIPCODE			= p_zip_code,
			CUSTC_PHONE1			= p_phone1,
			CUSTC_PHONE2			= p_phone2,
			CUSTC_MOVIL_PHONE		= p_movil_phone,
			CUSTC_EMAIL				= p_email,
			CUSTC_OCCUPATION		= p_occupation,
			CUSTC_VIP_STATUS		= p_vip_status,
			CUSTC_SPECIAL_REQUESTS	= p_requests,
			CUSTC_REGISTRATION_HOTEL = p_hotel_registration,
			CUSTC_UPDATED_BY		= p_update_by,
			CUSTC_LAST_UPDATE		= v_current_date,
			CUSTC_STATUS			= p_status
	WHERE 	CUSTP_ID_CUSTOMER		= p_id_customer;
END$$

DELIMITER ;