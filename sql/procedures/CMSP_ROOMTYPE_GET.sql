DELIMITER $$

DROP PROCEDURE IF EXISTS `hotel`.`CMSP_ROOMTYPE_GET`$$

CREATE DEFINER=`root`@`localhost`

PROCEDURE `CMSP_ROOMTYPE_GET`(
								IN p_idHotel	varchar(02),
								IN p_roomType	varchar(02),
								IN p_status		varchar(01) )

BEGIN

	SELECT	tDescription	description,
			nRackRate		rackRate,
			nTotalRooms		totalRooms,
			nAvailableRooms	availableRooms,
			nBlockedRooms	blockedRooms,
			tStatus 		status
	  FROM customer
	 WHERE p_idHotel  = nIdHotel
	   AND p_roomType = tRoomType
	   AND ( p_status = '' OR p_status = tStatus );

END$$

DELIMITER ;