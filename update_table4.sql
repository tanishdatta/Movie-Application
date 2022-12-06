USE ticketReservation_db;

ALTER TABLE payment ADD amount INT;

SELECT * FROM seat;

ALTER TABLE theatre DROP location;
ALTER TABLE theatre ADD location VARCHAR(50);
