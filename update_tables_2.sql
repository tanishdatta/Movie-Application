USE ticketReservation_db;
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

