DELIMITER $$

DROP PROCEDURE IF EXISTS `hotel`.`CMSP_ROOMTYPE_INSERT`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CMSP_ROOMTYPE_INSERT`(
					    IN p_idHotel			varchar(02),
						IN p_roomType			varchar(02),
						IN p_description		varchar(20),
						IN p_rackRate			varchar(14),
						IN p_totalRooms			varchar(03),
						IN p_availableRooms		varchar(03),
						IN p_blockedRooms		varchar(03) )

BEGIN
    INSERT INTO roomtype(
			nIdHotel, tRoomType, tDescription, nRackRate,
			nTotalRooms, nAvailableRooms, nBlockedRooms)
	VALUES(	p_idHotel, p_roomType, p_description, p_rackRate,
			p_totalRooms, p_availableRooms, p_blockedRooms );
END$$

DELIMITER ;