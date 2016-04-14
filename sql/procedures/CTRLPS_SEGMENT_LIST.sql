DELIMITER $$

DROP PROCEDURE IF EXISTS `hotel`.`CTRLPS_SEGMENT_LIST`$$

CREATE DEFINER=`root`@`localhost`

PROCEDURE `CTRLPS_SEGMENT_LIST`(IN p_id_hotel		varchar(02),
								IN p_description	varchar(20),
								IN p_status			varchar(01) )
BEGIN
	DECLARE BLANK varchar(01) DEFAULT '';

	DECLARE v_description varchar(20) DEFAULT ifnull(concat(p_description,'%'),'%');
	DECLARE v_status varchar(01) DEFAULT ifnull(p_status, BLANK);

	SELECT	MAINP_ID_HOTEL		ID_HOTEL,
			SEGMP_ID_SEGMENT	ID_SEGMENT,
			SRCEF_ID_SOURCE		ID_SOURCE,
			SEGMC_DESCRIPTION	DESCRIPTION,
			SEGMC_MADE_BY		MADE_BY,
			SEGMC_MADE_ON		MADE_ON,
			SEGMC_UPDATED_BY	UPDATED_BY,
			SEGMC_LAST_UPDATE	LAST_UPDATE,
			SEGMC_STATUS 		STATUS
	  FROM CTRLT_SEGMENT
	 WHERE p_id_hotel = MAINP_ID_HOTEL
	   AND SEGMC_DESCRIPTION like v_description
	   AND ( v_status = BLANK OR v_status = SEGMC_STATUS )
	 ORDER BY SEGMC_DESCRIPTION;
END$$

DELIMITER ;