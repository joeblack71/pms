DELIMITER $$

DROP PROCEDURE IF EXISTS `hotel`.`CMSP_RESERVATION_FILTER`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CMSP_RESERVATION_FILTER`(
				    IN p_idHotel tinyint,
				    IN p_condition varchar(50) )

BEGIN
	DECLARE v_condition varchar(50);

	SET v_condition = CONCAT("nIdReservation ", p_condition);

	SELECT COUNT(*)
	  FROM reservation
	 WHERE nIdHotel = p_idHotel AND v_condition;

END$$

DELIMITER ;