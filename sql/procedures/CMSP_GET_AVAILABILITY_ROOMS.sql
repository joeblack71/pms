DELIMITER $$

DROP PROCEDURE IF EXISTS `hotel`.`CMSP_GET_AVAILABILITY_ROOMS`$$

CREATE PROCEDURE `CMSP_GET_AVAILABILITY_ROOMS`( IN p_idhotel char(1),
											    IN p_roomType char(2),
												IN p_startDate date,
												IN p_endDate date,
												IN p_status char(1) )
BEGIN
	declare a int;

	SELECT tRoomType, dOccupationDay, COUNT(dOccupationDay)
	  FROM occupation
	 WHERE nIdHotel = p_idhotel
	   AND tRoomType like if(p_roomType is null or p_roomType = '', '%', p_roomType)
	   AND dOccupationDay >= p_startDate
	   AND dOccupationDay <= p_endDate
       AND tStatus like if(p_status is null or p_status = '', '%', p_status)
	 GROUP BY tRoomType, dOccupationDay;
END$$

DELIMITER ;