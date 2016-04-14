DELIMITER $$

DROP PROCEDURE IF EXISTS `hotel`.`CMSP_CUSTOMER_DELETE`$$

CREATE DEFINER=`root`@`localhost`

PROCEDURE `CMSP_CUSTOMER_DELETE`(IN p_idCustomer varchar(06),
								 IN p_hotelRegistration varchar(03) )

BEGIN

	UPDATE customer
	   SET tStatus = "*"
	 WHERE nIdCustomer = p_idCustomer
	   AND nHotelRegistration = p_hotelRegistration;

END$$

DELIMITER ;