DELIMITER $$

DROP PROCEDURE IF EXISTS `hotel`.`CTRLPU_SOURCE`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPU_SOURCE`(
			out p_error_type 	  	 varchar(06),
			 in p_id_source			 varchar(06),
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
			 in	p_updated_by		 varchar(04),
			 in p_status 			 varchar(01) )
BEGIN
		DECLARE v_current_date date DEFAULT current_date();
		DECLARE v_error_type varchar(06) DEFAULT '';

		/* Continua luego de intentar registrar un numero de documento duplicado */
		DECLARE ER_DUP_ENTRY CONDITION FOR SQLSTATE '23000'; -- ER_DUP_ENTRY 23000
		DECLARE CONTINUE HANDLER FOR ER_DUP_ENTRY SET v_error_type = '23000'; 

		UPDATE CTRLT_SOURCE
		    SET SRCEC_SOURCE_NAME		 = p_source_name,
				SRCEC_COMMERCIAL_NAME    = p_commercial_name,
				SRCEC_DOCUMENT_NUMBER 	 = p_document_number,
				SRCEC_STREET_TYPE 		 = p_street_type,
				SRCEC_STREET_NAME 		 = p_street_name,
				SRCEC_STREET_NUMBER 	 = p_street_number,
				SRCEC_INTERIOR 			 = p_interior,
				SRCEC_COMPLEMENT		 = p_complement,
				SRCEC_CITY 			 	 = p_city,
				CTRYF_ID_COUNTRY 		 = p_id_country,
				SRCEC_ID_DISTRICT 		 = p_id_district,
				SRCEC_ZIP_CODE 			 = p_zip_code,
				SRCEC_PHONE1 			 = p_phone1,
				SRCEC_PHONE2 			 = p_phone2,
				SRCEC_WEB_PAGE 			 = p_web_page,
				SRCEC_ID_SEGMENT 		 = p_id_segment,
				SRCEC_ID_TYPE 			 = p_id_type,
				SRECC_CATEGORY 			 = p_category,
				RATEF_ID_RATE 			 = p_id_rate,
				SRCEC_CREDIT_TYPE        = p_credit_type,
				SRCEC_REGISTRATION_HOTEL = p_registration_hotel,
				SRCEC_UPDATED_BY 		 = p_updated_by,
				SRCEC_LAST_UPDATE 		 = v_current_date,
				SRCEC_STATUS 			 = p_status
		WHERE SRCEP_ID_SOURCE = p_id_source;

		SET p_error_type = v_error_type;
    END$$

DELIMITER ;