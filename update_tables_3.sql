USE ticketReservation_db;
ALTER TABLE ticket
MODIFY showtime_time timestamp;

ALTER TABLE showtime
MODIFY date_time timestamp;

ALTER TABLE ticket
MODIFY showtime_time timestamp;

ALTER TABLE seat DROP FOREIGN KEY seat_ibfk_2;

Alter TABLE seat DROP primary key,
ADD primary key(seatXcoord, seatYcoord, theatre_name, movie_name);