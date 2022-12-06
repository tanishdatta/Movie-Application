USE ticketReservation_db;

ALTER TABLE payment ADD amount INT;

SELECT * FROM seat;

ALTER TABLE theatre DROP location;
ALTER TABLE theatre ADD location VARCHAR(50);

Alter TABLE seat DROP primary key,
ADD primary key(seatXcoord, seatYcoord, theatre_name, movie_name, showtime_time);
