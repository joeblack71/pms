DELIMITER $$

DROP PROCEDURE IF EXISTS `hotel`.`CTRLPS_SOURCE_LIST`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPS_SOURCE_LIST`(
								IN p_id_hotel			varchar(02),
								IN p_source_name		varchar(40),
								IN p_commercial_name	varchar(40),
								IN p_status				varchar(01) )
BEGIN
	DECLARE v_source_name varchar(41) DEFAULT concat(p_source_name,'%');
	DECLARE v_commercial_name varchar(41) DEFAULT concat(p_commercial_name,'%');
	SELECT	SRCEP_ID_SOURCE				ID_SOURCE,
			SRCEC_SOURCE_NAME			SOURCE_NAME,
			SRCEC_COMMERCIAL_NAME		COMMERCIAL_NAME,
			SRCEC_DOCUMENT_NUMBER		DOCUMENT_NUMBER,
			SRCEC_STREET_TYPE			STREET_TYPE,
			SRCEC_STREET_NAME			STREET_NAME,
			SRCEC_STREET_NUMBER			STREET_NUMBER,
			SRCEC_INTERIOR				INTERIOR,
			SRCEC_COMPLEMENT			COMPLEMENT,
			SRCEC_ID_DISTRICT			ID_DISTRICT,
			SRCEC_CITY					CITY,
			CTRYF_ID_COUNTRY			ID_COUNTRY,
			SRCEC_ZIP_CODE 				ZIP_CODE,
			SRCEC_PHONE1				PHONE1,
			SRCEC_PHONE2				PHONE2,
			SRCEC_WEB_PAGE				WEB_PAGE,
			SRCEC_ID_SEGMENT 			ID_SEGMENT,
			SRCEC_ID_TYPE 				ID_TYPE,
			SRECC_CATEGORY				CATEGORY,
			RATEF_ID_RATE 				ID_RATE,
			SRCEC_CREDIT_TYPE 			CREDIT_TYPE,
			SRCEC_REGISTRATION_HOTEL	REGISTRATION_HOTEL,
			SRCEC_MADE_BY 				MADE_BY,
			SRCEC_MADE_ON 				MADE_ON,
			SRCEC_UPDATED_BY 			UPDATED_BY,
			SRCEC_LAST_UPDATE 			LAST_UPDATE,
			SRCEC_STATUS 				STATUS
	  FROM CTRLT_SOURCE
	 WHERE ( p_id_hotel    = '' OR p_id_hotel = SRCEC_REGISTRATION_HOTEL )
	   AND ( p_source_name = '' OR SRCEC_SOURCE_NAME like v_source_name )
	   AND ( p_commercial_name = '' OR SRCEC_COMMERCIAL_NAME like v_commercial_name )
	   AND ( p_status	   = '' OR p_status = SRCEC_STATUS );
END$$

DELIMITER ;