DELIMITER $$;

DROP PROCEDURE IF EXISTS `hotel`.`spAvailability`$$

CREATE PROCEDURE `occ1`(IN hotel tinyint, IN arrival date,
			IN departure date, IN roomType char(02),
			INOUT isAvailable boolean)
BEGIN
  DECLARE vrt        char(02);
  DECLARE varr, vdep date;
  DECLARE vres, vng  tinyint(3) unsigned;
  DECLARE vst        char(01);
  DECLARE n, done    tinyint default 0;

  DECLARE cur1 CURSOR FOR
	  SELECT tRoomType, dOccupationDay, COUNT(dOccupationDay)
		 FROM occupation
		 WHERE nHotel = hotel AND
		       dOccupationDay >= arrival AND
		       dOccupationDay <  departure AND
		       tRoomType = roomtType
		 GROUP BY dOccupationDay;
  DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;

END$$

DELIMITER ;$$