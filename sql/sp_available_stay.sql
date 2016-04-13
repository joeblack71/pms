DELIMITER $$

DROP PROCEDURE IF EXISTS `hotel`.`sp_available_stay`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE
	`sp_available_stay`(IN h INT, IN rt char(02),IN ad date, IN dd date)
BEGIN
  declare a int;

  SELECT tRoomType, dOccupationDay, COUNT(dOccupationDay)
	FROM occupation
	WHERE nHotelId = h AND tRoomType = rt AND
	      dOccupationDay >= ad AND dOccupationDay < dd
	GROUP BY dOccupationDay;

END$$

DELIMITER ;