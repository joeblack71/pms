DELIMITER $$

DROP PROCEDURE IF EXISTS `hotel`.`CMSP_ROOMTYPE_UPDATE`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CMSP_ROOMTYPE_UPDATE`(
					    IN p_idHotel			varchar(02),
						IN p_roomType			varchar(02),
						IN p_description		varchar(20),
						IN p_rackRate			varchar(14),
						IN p_totalRooms			varchar(03),
						IN p_availableRooms		varchar(03),
						IN p_blockedRooms		varchar(03),
						IN p_status				varchar(01) )

BEGIN
	UPDATE roomtypes
			SET tDescription	= p_description,
				nRackRate		= p_rackRate,
				nTotalRooms		= p_totalRooms,
				nAvailableRooms = p_availableRooms,
				nBlockedRooms	= p_blockedRooms,
				tStatus 		= p_status
	 WHERE nIdHotel = p_idHotel AND tRoomType = p_roomType;

END$$

DELIMITER ;