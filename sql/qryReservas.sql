/*select count(*) from reserva
where year(ddeparture) = 2006*/

/*update reserva set ddeparture = date_add(ddeparture, interval 1 year)
where year(ddeparture) = 2006*/

select year(darrival), month(darrival), count(darrival), sum(nstaydays) from reserva
group by year(darrival), month(darrival) with rollup;

#select * from reserva

select tRoomType,nReservation,dArrival,dDeparture,tStatus
from reservation
where dArrival <= '2007-01-10' and dDeparture > '2007-01-10';