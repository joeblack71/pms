DELIMITER $$

DROP PROCEDURE IF EXISTS `hotel`.`CTRLPI_GUEST`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPI_GUEST`(
					    IN p_id_hotel			varchar(02),
						IN p_id_reservation		varchar(06),
						IN p_id_customer		varchar(06),
						IN p_status    			varchar(01) )
BEGIN
    INSERT INTO CTRLT_GUEST(
			MAINP_ID_HOTEL,
			RESVP_ID_RESERVATION,
			CUSTP_ID_CUSTOMER,
			GUESC_STATUS )
	VALUES(	p_id_hotel,
			p_id_reservation,
			p_id_customer,
			p_status );
END$$

DELIMITER ;