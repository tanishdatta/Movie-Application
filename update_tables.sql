USE ticketreservation_db;

UPDATE registereduser  SET last_payment =  '2020-12-04' WHERE username = 'Harnoor5';


INSERT INTO showtime (movie_name, theatre_name, date_time) VALUES
('Star Wars: Episode VII - The Force Awakens','WISH.com_cineplex', '2012-06-18 17:10:10'),
('Avengers: Endgame','WISH.com_cineplex', '2012-06-18 13:10:10'),
('Spider-Man: No Way Home','WISH.com_cineplex', '2012-06-18 10:00:00'),
('Avatar','WISH.com_cineplex', '2012-06-18 06:00:00'),
('Top Gun: Maverick','WISH.com_cineplex', '2012-06-18 20:00:00');