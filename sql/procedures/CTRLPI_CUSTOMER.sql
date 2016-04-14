DELIMITER $$

DROP PROCEDURE IF EXISTS `hotel`.`CTRLPI_CUSTOMER`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPI_CUSTOMER`(
                       OUT p_last_insert_id     int, 
                       OUT p_error_type   		varchar(06), 
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
						IN p_phone1				varchar(07),
						IN p_phone2				varchar(07),
						IN p_movil_phone		varchar(10),
						IN p_email				varchar(50),
						IN p_occupation			varchar(20),
						IN p_vip_status			varchar(01),
						IN p_requests			tinytext,
						IN p_hotel_registration	varchar(02),
						IN p_made_by			varchar(05) )
BEGIN
	declare v_current_date date default current_date();
	declare v_birthdate date;

	/* Continua luego de intentar registrar un documento de identidad duplicado */
	DECLARE ER_DUP_ENTRY CONDITION FOR SQLSTATE '23000'; -- ER_DUP_ENTRY 23000
	DECLARE CONTINUE HANDLER FOR ER_DUP_ENTRY SET p_error_type = '23000'; 

	-- TODO: test if
	if !strcmp(p_birthdate,'1971-08-12') then
	   set v_birthdate = 1969-12-31;
	else
	   set v_birthdate = STR_TO_DATE(p_birthDate,'%d/%m/%Y');
	end if;
    insert into CTRLT_CUSTOMER
		   (CUSTC_LASTNAME1,
			CUSTC_LASTNAME2,
			CUSTC_FIRSTNAME,
			CUSTC_BIRTHDATE,
			CUSTC_NATIONALITY,
			CUSTC_TITLE,
			CUSTF_DOCUMENT_TYPE,
			CUSTC_DOCUMENT_NUMBER,
			CUSTC_STREET_TYPE,
			CUSTC_STREET_NAME,
			CUSTC_STREET_NUMBER,
			CUSTC_INTERIOR_NUMBER,
			CUSTC_COMPLEMENTS,
			CUSTC_DISTRICT,
			CUSTC_CITY,
			CTRYF_ID_COUNTRY,
			CUSTC_ZIPCODE,
			CUSTC_PHONE1,
			CUSTC_PHONE2,
			CUSTC_MOVIL_PHONE,
			CUSTC_EMAIL,
			CUSTC_OCCUPATION,
			CUSTC_VIP_STATUS,
			CUSTC_SPECIAL_REQUESTS,
			CUSTC_REGISTRATION_HOTEL,
			CUSTC_MADE_BY,
			CUSTC_MADE_ON,
			CUSTC_UPDATED_BY,
			CUSTC_LAST_UPDATE,
			CUSTC_STATUS)
	values (p_lastname1,
			p_lastname2,
			p_firstnames,
			v_birthdate,
			p_nationality,
			p_title,
			p_document_type,
			p_document_number,
			p_street_type,
			p_street_name,
			p_street_number,
			p_interior_number,
			p_complements,
			p_district,
			p_city,
			p_id_country,
			p_zip_code,
			p_phone1,
			p_phone2,
			p_movil_phone,
			p_email,
			p_occupation,
			p_vip_status,
			p_requests,
			p_hotel_registration,
			p_made_by,
			v_current_date,
			p_made_by,
			v_current_date,
			'A');
     set p_last_insert_id = LAST_INSERT_ID();
END$$

DELIMITER ;