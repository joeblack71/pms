DELIMITER $$

DROP PROCEDURE IF EXISTS `hotel`.`CMSP_VAL_ROOMTYPE_ST`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CMSP_VAL_ROOMTYPE_ST`(
	IN h INT, IN t char(02),IN d date )
BEGIN
	DECLARE a int;
	SELECT nAvailableRooms INTO a
	  FROM roomtype_status
	 WHERE nIdHotel = h
	   AND tRoomType = t
	   AND dStatusDate = d
		   LIMIT 1;
	IF a IS NULL THEN
		INSERT INTO roomtype_status VALUES(h,t,d,1,0,0,0,0,0,"I");
	END IF;
	SET @x = a;
END$$

DELIMITER ;