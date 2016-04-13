/* Monthly Occupation*/
select month(dOccupationDay), count(dOccupationDay)
       from occupation
       group by month(dOccupationDay); 

/* Daily Occupation in a month (order by type)*/
select tRoomType, dOccupationDay, tStatus /*count(*)*/
       from occupation
       where month(dOccupationDay) = 12
       order by tRoomType, dOccupationDay;

/* Daily Occupation in a month (order by day)*/
select dOccupationDay, tRoomType, count(tRoomType)
       from occupation
       where month(dOccupationDay) = 12
       group by dOccupationDay, tRoomType with rollup;

/* testing occupation in a specific range */
select dOccupationDay, tRoomType, nReservation, tStatus
       from occupation
       /*where dOccupationDay >= '2007-12-01' and dOccupationDay < '2007-12-02'
             and tRoomType = 'SJ'*/
       where nReservation = 5137
       order by dOccupationDay;

select count(*) from occupation;
delete from occupation where nReservation = 0;

select dOccupationDay, o.tRoomType, count(o.tRoomType)
       from occupation o, roomtype
       where dOccupationDay >= '2007-12-02' and dOccupationDay < '2007-12-04'
             and o.tRoomType = 'ES'
       group by dOccupationDay, o.tRoomType;
