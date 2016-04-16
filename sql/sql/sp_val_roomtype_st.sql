DELIMITER //
drop procedure sp_val_roomtype_st//
CREATE PROCEDURE sp_val_roomtype_st(IN h INT, IN t char(02),IN d date)
BEGIN
  declare a int;
  select nAvailableRooms into a from roomtype_status
         where nhotelId = h AND tRoomType = t AND dStatusDate = d
         limit 1;
  if a is null then
     insert into roomtype_status values(h,t,d,1,0,0,0,0,0,"I");
  else update roomtype_status set 
  end if;
  set @x = a;
END//

DELIMITER ;