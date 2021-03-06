DELIMITER $$

DROP PROCEDURE IF EXISTS `hotel`.`CTRLPS_GUEST_LIST`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPS_GUEST_LIST`(
							IN p_idHotel varchar(02),
							IN p_status  varchar(01) )
BEGIN
		SELECT 	MAINP_ID_HOTEL			ID_HOTEL,
				RESVP_ID_RESERVATION	ID_RESERVATION,
				g.CUSTP_ID_CUSTOMER		ID_CUSTOMER,
				c.CUSTC_DOCUMENT_NUMBER	DOCUMENT_NUMBER,
				CONCAT(c.CUSTC_LASTNAME1, ', ', c.CUSTC_FIRSTNAME)
										CUSTOMER_NAMES,
				GUESC_STATUS			STATUS
		  FROM CTRLT_GUEST g
				LEFT JOIN CTRLT_CUSTOMER c ON g.CUSTP_ID_CUSTOMER = c.CUSTP_ID_CUSTOMER
		 WHERE p_idHotel = MAINP_ID_HOTEL
		   AND ( p_status = '' OR p_status = g.GUESC_STATUS );
END$$

DELIMITER ;