DROP TABLE IF EXISTS Reservation ;
CREATE TABLE Reservation (pk_id_Reservation BIGINT AUTO_INCREMENT NOT NULL,
v_destination_Reservation TEXT,
v_etapes_Reservation TEXT,
v_nbPassagers_Reservation TEXT,
PRIMARY KEY (pk_id_Reservation)) ENGINE=InnoDB;

