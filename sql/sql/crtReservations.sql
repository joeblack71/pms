    USE testing;

    CREATE TABLE reservations
    (
           id_reservation    SMALLINT     NOT NULL AUTO_INCREMENT,
           nights            TINYINT      UNSIGNED NOT NULL,
           arrival           DATE         NOT NULL,
           departure         DATE         NOT NULL,
           adults            TINYINT      UNSIGNED NOT NULL,
           children          TINYINT      UNSIGNED NOT NULL,
           id_roomtype       CHAR(02)     NOT NULL,
           quantity          TINYINT      UNSIGNED NOT NULL,
           id_room           CHAR(04)     NOT NULL,
           arr_info          VARCHAR(06)  NOT NULL, /* hora de llegada */
           id_source         CHAR(06)     NOT NULL,
           id_contact        TINYINT      UNSIGNED, /* puede ser nulo */
           room_rate         DECIMAL(5,2) UNSIGNED NOT NULL,
           id_tpdocument     TINYINT      UNSIGNED NOT NULL,
           id_customer       CHAR(10)     NOT NULL,
           lastname          VARCHAR(15)  NOT NULL,
           firstname         VARCHAR(15)  NOT NULL,
           id_deposit        SMALLINT     NOT NULL,
           rs_creation       TIMESTAMP,
           id_user           CHAR(06)     NOT NULL,
           status            TINYINT      DEFAULT 1,
           PRIMARY KEY(id_reservation),
           INDEX(id_roomtype),   INDEX(id_room),     INDEX(id_source),
           INDEX(id_tpdocument), INDEX(id_customer), INDEX(id_user),
           INDEX(id_deposit),
           /*FOREIGN KEY(id_roomtype)   REFERENCES room_types(id_roomtype),*/
           /*FOREIGN KEY(id_room)       REFERENCES rooms(id_room),*/
           /*FOREIGN KEY(id_source)     REFERENCES sources(id_source),*/
           /*FOREIGN KEY(id_deposit)    REFERENCES deposits(id_deposit),
           FOREIGN KEY(id_tpdocument) REFERENCES tp_documents(id_tpdocument),*/
           FOREIGN KEY(id_customer)   REFERENCES customers(id_customer),
           FOREIGN KEY(id_user)       REFERENCES users(id_user)
    );

