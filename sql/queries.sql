call occ1(20060401,20060430);

select tarr, trt, count(trt)
from   t_occ group by tarr, trt;

select count(*)
from   t_occ
where  tarr = 20060415;

select arrival, room_type, reservation
from   reservation
where  arrival = 20060503 order by room_type;