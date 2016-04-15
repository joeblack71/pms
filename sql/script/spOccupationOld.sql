DELIMITER $$;

DROP PROCEDURE IF EXISTS `hotel`.`occ1`$$

CREATE PROCEDURE `occ1`(IN start_day date, IN end_day date)
BEGIN
  DECLARE vrt        char(02);
  DECLARE varr, vdep date;
  DECLARE vres, vng  tinyint(3) unsigned;
  DECLARE vst        char(01);
  DECLARE n, done    tinyint default 0;
  DECLARE cur1 CURSOR FOR
	  SELECT room_type,   arrival, departure,
		 reservation, nights,  status
	  FROM   reservation
	  WHERE (arrival >= start_day AND arrival   <= end_day) OR
		(arrival <  start_day AND departure >  start_day);
  DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;
  DROP TABLE IF EXISTS t_occ;
  CREATE TEMPORARY TABLE t_occ(tarr date, tdep date, trt char(02),
			       tres int UNSIGNED, tst char(01)) 				  ENGINE = MYISAM;
  OPEN cur1;
  /* This loop creates a new record by each night
     a reservation takes a room (lock by type) */
  REPEAT
    FETCH cur1 INTO vrt, varr, vdep, vres, vng, vst;
    WHILE NOT done AND n < vng DO
	INSERT INTO t_occ VALUES (varr, vdep, vrt, vres, vst);
	SET varr = adddate(varr,1);
	SET n = n + 1;
    END WHILE;
    SET n = 0;
  UNTIL done END REPEAT;
  CLOSE cur1;

  SELECT tarr, trt, count(trt)
  FROM   t_occ GROUP BY tarr, trt;
END$$

DELIMITER ;$$