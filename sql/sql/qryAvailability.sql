describe occupation;

select tRoomType, dOccupationDay, count(tRoomType),tStatus
from occupation
where month(dOccupationDay) = 12
group by tRoomType, dOccupationDay with rollup;

select tRoomType,nReservation,dArrival,dDeparture,tStatus
from reservation
where dArrival <= '2007-01-10' and dDeparture > '2007-01-10';