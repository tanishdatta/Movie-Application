DROP DATABASE ticketReservation_db;
CREATE DATABASE ticketReservation_db;

USE ticketReservation_db;

CREATE TABLE RegisteredUser (
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    name VARCHAR(50),
    credit_card_num INT NOT NULL,
    credit_card_holder VARCHAR(50) NOT NULL,
    last_payment DATE NOT NULL,
    PRIMARY KEY (username)
);

CREATE TABLE Payment (
    payment_id INT NOT NULL,
    credit_card_num INT NOT NULL,
    credit_card_holder VARCHAR(50) NOT NULL,
    local_date DATE NOT NULL,
    PRIMARY KEY (payment_id)
);

CREATE TABLE theatre (
    name VARCHAR(50) NOT NULL,
    location VARCHAR(70) NOT NULL,
    PRIMARY KEY (name),
    UNIQUE (location)
);

CREATE TABLE movie (
    name VARCHAR(50) NOT NULL,
    announcement_date DATE NOT NULL,
    PRIMARY KEY (name)
);

CREATE TABLE offered_movie (
    movie_name VARCHAR(50) NOT NULL,
    theatre_name VARCHAR(50) NOT NULL,
    FOREIGN KEY (movie_name)
        REFERENCES movie (name)
        ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (theatre_name)
        REFERENCES theatre (name)
        ON UPDATE CASCADE ON DELETE CASCADE
);
	

CREATE TABLE showtime (
    movie_name VARCHAR(50) NOT NULL,
    theatre_name VARCHAR(50) NOT NULL,
    date_time DATETIME NOT NULL,
    CONSTRAINT showtime_pk PRIMARY KEY (movie_name , theatre_name , date_time),
    FOREIGN KEY (movie_name)
        REFERENCES movie (name)
        ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (theatre_name)
        REFERENCES theatre (name)
        ON UPDATE CASCADE ON DELETE CASCADE
);


CREATE TABLE ticket (
    ticket_id INT NOT NULL,
    showtime_time DATETIME NOT NULL,
    theatre_name VARCHAR(50) NOT NULL,
    movie_name VARCHAR(50) NOT NULL,
    seatXcoord INT NOT NULL,
    seatYcoord INT NOT NULL,
    price INT NOT NULL,
    PRIMARY KEY (ticket_id),
    FOREIGN KEY (theatre_name)
        REFERENCES theatre (name)
        ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (movie_name)
        REFERENCES movie (name)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE refund_credit (
    credit_code INT NOT NULL,
    dollar_amount INT NOT NULL,
    PRIMARY KEY (credit_code)
);

CREATE TABLE seat (
    seatXcoord INT NOT NULL,
    seatYcoord INT NOT NULL,
    theatre_name VARCHAR(50) NOT NULL,
    movie_name VARCHAR(50) NOT NULL,
    showtime_time DATETIME NOT NULL,
    status BIT,
    CONSTRAINT seat_pk PRIMARY KEY (seatXcoord , seatYcoord),
    FOREIGN KEY (theatre_name)
        REFERENCES theatre (name)
        ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (movie_name)
        REFERENCES movie (name)
        ON UPDATE CASCADE ON DELETE CASCADE
);





