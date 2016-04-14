DELIMITER $$

DROP PROCEDURE IF EXISTS `hotel`.`CMSP_AVAILABLE_STAY`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CMSP_AVAILABLE_STAY`(
		IN h INT,
		IN rt char(02),
		IN ad date,
		IN dd date )
BEGIN
	DECLARE a int;
	SELECT tRoomType, dOccupationDay, COUNT(dOccupationDay)
	  FROM occupation
	 WHERE nIdHotel = h
	   AND tRoomType = rt
	   AND dOccupationDay >= ad
	   AND dOccupationDay < dd
	GROUP BY dOccupationDay;
END$$

DELIMITER ;