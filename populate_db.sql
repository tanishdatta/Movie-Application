USE ticketReservation_db;


INSERT INTO registereduser (username, password, name, credit_card_num, credit_card_holder, last_payment) VALUES
('Tanish1', 'ensf', 'Tanish', 1234, 'Tanish', '2022-12-4'),
('Truman2', 'ensf', 'Trunam', 1234, 'Trunam', '2022-12-4'),
('Max3', 'ensf', 'Max', 1234, 'Max', '2022-12-4'),
('Shanelle4', 'ensf', 'Shanelle', 1234, 'Shanelle', '2022-12-4'),
('Harnoor5', 'ensf', 'Harnoor', 1234, 'Harnoor', '2010-12-4');

INSERT INTO movie (name, announcement_date) VALUES
('Star Wars: Episode VII - The Force Awakens', '2022-12-01'),
('Avengers: Endgame', '2022-12-01'),
('Spider-Man: No Way Home', '2022-12-01'),
('Avatar','2022-12-06'),
('Top Gun: Maverick', '2022-01-01');

INSERT INTO theatre (name, location) VALUES
('WISH.com_cineplex', 'somewhere');

INSERT INTO showtime (movie_name, theatre_name, date_time) VALUES
('Star Wars: Episode VII - The Force Awakens','WISH.com_cineplex', '2022-12-16 17:10:00'),
('Avengers: Endgame','WISH.com_cineplex', '2022-12-18 13:10:00'),
('Spider-Man: No Way Home','WISH.com_cineplex', '2022-12-21 10:00:00'),
('Avatar','WISH.com_cineplex', '2022-12-07 06:00:00'),
('Top Gun: Maverick','WISH.com_cineplex', '2022-12-06 20:00:00');

INSERT INTO offered_movie (movie_name, theatre_name) VALUES
('Star Wars: Episode VII - The Force Awakens','WISH.com_cineplex'),
('Avengers: Endgame','WISH.com_cineplex'),
('Spider-Man: No Way Home','WISH.com_cineplex');

ALTER TABLE payment
    DROP payment_id;
ALTER TABLE payment
    ADD payment_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY;
ALTER TABLE ticket
    DROP ticket_id;
ALTER TABLE ticket
    ADD ticket_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY;
    
ALTER TABLE refund_credit
    DROP credit_code;
ALTER TABLE refund_credit
    ADD credit_code INT NOT NULL AUTO_INCREMENT PRIMARY KEY;
    
    ALTER TABLE ticket
MODIFY showtime_time timestamp;

ALTER TABLE showtime
MODIFY date_time timestamp;

ALTER TABLE ticket
MODIFY showtime_time timestamp;

ALTER TABLE seat DROP FOREIGN KEY seat_ibfk_2;

Alter TABLE seat DROP primary key,
ADD primary key(seatXcoord, seatYcoord, theatre_name, movie_name);

ALTER TABLE payment ADD amount INT;


