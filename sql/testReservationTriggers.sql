### Testing Reservation triggers
insert into reservation (nHotel,tRoomType,nNights,
                         dArrival,dDeparture,nQuantity,
                         tStatus,nAdults,nChildren,
                         tLastname)
                 values (1,"SJ",1,'2007-06-01','2007-06-01',1,'T',1,0,"TEST");


update reservation set nNights=1, dArrival='2007-12-01', dDeparture='2007-12-01',
                       nQuantity=2
       where nHotel=1 and nreservation = 5137;

select nReservation,tRoomType,nQuantity,dArrival,dDeparture,nNights
       from reservation order by nReservation desc limit 3;

select * from occupation where nReservation = 5137;// order by dOccupationDay;
select count(*) from occupation;

delete from reservation where nReservation = 5137;

/*update reservation set tRoomType="SJ", tRoomNumber="1004",
                       dArrival='2007-01-10', dDeparture='2007-01-12',
                       nNights=2, tStatus='C', nAdults=2, nChildren=0
       where nreservation = 10;
*/
/*
select sum(nNights) from reservation;
select count(*) from occupation;# where nreservation = 10;
*/
/*
select year(darrival),count(darrival),year(ddeparture),count(ddeparture)
       from reservation
       group by year(darrival) with rollup;
*/
/*select tRoomType as Type, dOccupationDay as Day, count(*) as Rooms,
       sum(nAdults) as Adults, sum(nChildren) as Children
       from occupation
       group by /*tRoomType, *//dOccupationDay with rollup;
/*
select month(dArrival),sum(nNights) from reservation group by month(dArrival);
select month(dOccupationDay),count(dOccupationDay) from occupation
group by month(dOccupationDay) with rollup;
*/