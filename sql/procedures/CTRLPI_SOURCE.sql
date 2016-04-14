DELIMITER $$

DROP PROCEDURE IF EXISTS `hotel`.`CTRLPI_SOURCE`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPI_SOURCE`(
			out p_id_source 	  	 int,
			out p_error_type 	  	 varchar(06),
			 in	p_source_name 	  	 varchar(50),
			 in	p_commercial_name 	 varchar(50),
			 in	p_document_number 	 varchar(11),
			 in	p_street_type 	  	 varchar(02),
			 in	p_street_name	  	 varchar(30),
			 in	p_street_number   	 varchar(30),
			 in	p_interior		  	 varchar(04),
			 in	p_complement	  	 varchar(20),
			 in	p_id_district 	  	 varchar(02),
			 in	p_city 		  	 	 varchar(20),
			 in p_id_country 	  	 varchar(03),
			 in	p_zip_code 		  	 varchar(10),
			 in	p_phone1 		  	 varchar(10),
			 in	p_phone2 		  	 varchar(10),
			 in	p_web_page 		  	 varchar(50),
			 in	p_id_segment 	  	 varchar(02),
			 in	p_id_type 		  	 varchar(02),
			 in	p_category 		  	 varchar(01),
			 in	p_id_rate		  	 varchar(04),
			 in	p_credit_type 	  	 varchar(02),
			 in	p_registration_hotel varchar(03),
			 in	p_made_by 			 varchar(04),
			 in p_status 			 varchar(01) )
BEGIN
		DECLARE v_current_date date DEFAULT current_date();

		/* Continua luego de intentar registrar un numero de documento duplicado */
		DECLARE ER_DUP_ENTRY CONDITION FOR SQLSTATE '23000'; -- ER_DUP_ENTRY 23000
		DECLARE CONTINUE HANDLER FOR ER_DUP_ENTRY SET p_error_type = '23000'; 

		INSERT INTO CTRLT_SOURCE
			  (	SRCEP_ID_SOURCE,
				SRCEC_SOURCE_NAME,
				SRCEC_COMMERCIAL_NAME,
				SRCEC_DOCUMENT_NUMBER,
				SRCEC_STREET_TYPE,
				SRCEC_STREET_NAME,
				SRCEC_STREET_NUMBER,
				SRCEC_INTERIOR,
				SRCEC_COMPLEMENT,
				SRCEC_ID_DISTRICT,
				SRCEC_CITY,
				CTRYF_ID_COUNTRY,
				SRCEC_ZIP_CODE,
				SRCEC_PHONE1,
				SRCEC_PHONE2,
				SRCEC_WEB_PAGE,
				SRCEC_ID_SEGMENT,
				SRCEC_ID_TYPE,
				SRECC_CATEGORY,
				RATEF_ID_RATE,
				SRCEC_CREDIT_TYPE,
				SRCEC_REGISTRATION_HOTEL,
				SRCEC_MADE_BY,
				SRCEC_MADE_ON,
				SRCEC_UPDATED_BY,
				SRCEC_LAST_UPDATE,
				SRCEC_STATUS )
		VALUES( p_id_source,
				p_source_name,
				p_commercial_name,
				p_document_number,
				p_street_type,
				p_street_name,
				p_street_number,
				p_interior,
				p_complement,
				p_id_district,
				p_city,
				p_id_country,
				p_zip_code,
				p_phone1,
				p_phone2,
				p_web_page,
				p_id_segment,
				p_id_type,
				p_category,
				p_id_rate,
				p_credit_type,
				p_registration_hotel,
				p_made_by,
				v_current_date,
				p_made_by,
				v_current_date,
				p_status );
		SET p_id_source = LAST_INSERT_ID();
    END$$

DELIMITER ;