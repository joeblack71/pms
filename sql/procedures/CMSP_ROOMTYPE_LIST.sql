DELIMITER $$

DROP PROCEDURE IF EXISTS `hotel`.`CMSP_ROOMTYPE_LIST`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CMSP_ROOMTYPE_LIST`(
					IN p_idHotel varchar(02) )
BEGIN
	SELECT	nIdHotel		idHotel,
			tRoomType		roomType,
			tDescription	description,
			nRackRate		rackRate,
			nTotalRooms		totalRooms,
			nAvailableRooms	availableRooms,
			nBlockedRooms	blockedRooms
	  FROM roomtype rt
	 WHERE p_idHotel = nIdHotel
	   AND tStatus = 'A';
END$$

DELIMITER ;