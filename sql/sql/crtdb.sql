/*
 * createTables.SQL
 *
 * Created on 09 de Enero de 2006, 06:30 PM
 *
 * Crea las sgts. tablas:
 *
 *        1.  hoteles               ** hoteles de la cadena **
 *        2.  room_types            ** tipos de habitacion por hotel **
 *        3.  rooms                 ** habitaciones x hotel **
 *        4.  segments              ** segmentos de clientes **
 *        5.  type_rates            ** tipos de tarifa x cliente **
 *        6.  type_sources          ** tipo de fuentes **
 *        7.  sources               ** fuentes de ingreso **
 *        8.  contacts              ** contactos x entidad **
 *        9.  sp_services           ** servicios especiales **
 *        10. deposits              ** depositos en garantia **
 *        11. reservations          ** reservaciones **
 *        12. rsv_services          ** servicios x reservacion **
 *        13. rsv_status            ** estado de reservaciones **
 *        14. type_status           ** ocupacion x tipo **
 *        15. tp_documents          ** tipos de documentos **
 *        16. countries             ** paises de procedencia **
 *        18. cities                ** ciudades x paises **
 *        19. titles                ** tratamiento de huespedes **
 *        20. customers             ** clientes **
 *
 *
 */

    DROP DATABASE IF EXISTS testing;

    CREATE DATABASE testing;

    USE testing;

    CREATE TABLE hoteles
    (
           id_hotel          CHAR(02)     NOT NULL,
           ht_name           CHAR(40)     NOT NULL,
           ht_address        CHAR(40)     NOT NULL,
           ht_city           CHAR(20)     NOT NULL,
           ht_rooms          TINYINT      UNSIGNED NOT NULL,
           ht_type           CHAR(02)     NOT NULL, /* ex = executive; rs = resort; etc */
           installation_date DATE         NOT NULL,
           startup_date      DATE         NOT NULL,
           status            TINYINT      DEFAULT 1,
           PRIMARY KEY(id_hotel)
    ) TYPE = INNODB;

    CREATE TABLE room_types
    (
           id_roomtype       CHAR(02)     NOT NULL,
           rt_description    CHAR(20)     NOT NULL,
           rt_rooms          TINYINT      UNSIGNED NOT NULL DEFAULT 1,
           rt_rackrate       DECIMAL(5,2) UNSIGNED NOT NULL DEFAULT '0.00',
           specifications    TINYTEXT,
           status            TINYINT      DEFAULT 1,
           PRIMARY KEY(id_roomtype)
    ) TYPE = INNODB;

    CREATE TABLE rooms
    (
           id_room           CHAR(04)     NOT NULL,
           id_roomtype       CHAR(02)     NOT NULL,
           rm_description    CHAR(20)     NOT NULL,
           floor             TINYINT      NOT NULL,
           rm_rackrate       DECIMAL(5,2) UNSIGNED NOT NULL DEFAULT '0.00',
           specifications    TINYTEXT,
           status            TINYINT      DEFAULT 1,
           PRIMARY KEY(id_room),
           INDEX(id_roomtype),
           FOREIGN KEY(id_roomtype) REFERENCES room_types(id_roomtype)
    ) TYPE = INNODB;

    CREATE TABLE segments
    (
           id_segment        CHAR(03)     NOT NULL,
           sg_description    CHAR(40)     NOT NULL,
           status            TINYINT      DEFAULT 1,
           PRIMARY KEY(id_segment)
    )TYPE = INNODB;

    CREATE TABLE type_rates
    (
           id_typerate       CHAR(02)     NOT NULL,
           tr_description    CHAR(20)     NOT NULL,
           discount_factor   DECIMAL(4,2) UNSIGNED NOT NULL DEFAULT '0.00',
           status            TINYINT      DEFAULT 1,
           PRIMARY KEY(id_typerate)
     )TYPE = INNODB;

    CREATE TABLE type_sources
    (
           id_typesource     CHAR(04)     NOT NULL,
           ts_description    CHAR(40)     NOT NULL,
           status            TINYINT      DEFAULT 1,
           PRIMARY KEY(id_typesource)
     )TYPE = INNODB;

    CREATE TABLE sources
    (
           id_source         CHAR(06)     NOT NULL,
           id_segment        CHAR(03)     NOT NULL,
           sc_description    CHAR(40)     NOT NULL,
           id_typerate       CHAR(02)     NOT NULL, /* FR = Full Rate; C1 = Conf. 1; etc */
           id_typesource     CHAR(04)     NOT NULL, /* RECP = Recept.; CORP = Corpor., etc.) */
           comments          TINYTEXT,
           created_date      TIMESTAMP,
           id_user           CHAR(05),              /* Falta crear tabla de usuarios */
           status            TINYINT      DEFAULT 1,
           PRIMARY KEY(id_source),
           INDEX(id_segment), INDEX(id_typesource), INDEX(id_typerate),
           FOREIGN KEY(id_segment)    REFERENCES segments(id_segment),
           FOREIGN KEY(id_typesource) REFERENCES type_sources(id_typesource),
           FOREIGN KEY(id_typerate)   REFERENCES type_rates(id_typerate)
    )TYPE = INNODB;

    CREATE TABLE contacts
    (
           id_contact        TINYINT      UNSIGNED NOT NULL,
           id_source         CHAR(06)     NOT NULL,
           ct_description    CHAR(30)     NOT NULL,
           status            TINYINT      DEFAULT 1,
           PRIMARY KEY(id_contact, id_source),
           INDEX(id_source),
           FOREIGN KEY(id_source) REFERENCES sources(id_source)
    );

    CREATE TABLE sp_services
    (
           ss_code           CHAR(02)     NOT NULL,
           ss_description    CHAR(40)     NOT NULL,
           rate_service      DECIMAL(4,2) UNSIGNED NOT NULL DEFAULT '0.00',
           status            TINYINT      DEFAULT 1
     );

    CREATE TABLE users
    (
           id_user           CHAR(02)     NOT NULL,
           us_description    CHAR(40)     NOT NULL,
           status            TINYINT      DEFAULT 1,
           PRIMARY KEY(id_user)
     );

    CREATE TABLE tp_documents
    (
           id_tpdocument     TINYINT      UNSIGNED NOT NULL,
           td_description    CHAR(20)     NOT NULL,
           status            TINYINT      DEFAULT 1,
           PRIMARY KEY(id_tpdocument)
     );

    CREATE TABLE countries
    (
           id_country        SMALLINT     UNSIGNED NOT NULL,  /* revisar tipo de clave */
           cn_description    CHAR(20)     NOT NULL,
           nationality       CHAR(20)     NOT NULL,
           status            TINYINT      DEFAULT 1,
           PRIMARY KEY(id_country)
    );

    CREATE TABLE cities
    (
           id_city           TINYINT      UNSIGNED NOT NULL,
           id_country        SMALLINT     UNSIGNED NOT NULL,  /* revisar tipo de clave */
           ci_description    CHAR(20),
           status            TINYINT      DEFAULT 1,
           PRIMARY KEY(id_city, id_country),
           INDEX(id_country),
           FOREIGN KEY(id_country) REFERENCES countries(id_country)
                   ON DELETE CASCADE ON UPDATE CASCADE
    );

    CREATE TABLE titles /* greetings */
    (
           title             TINYINT      UNSIGNED,
           description       VARCHAR(15)
    );


    CREATE TABLE customers
    (
           id_customer       CHAR(10)     NOT NULL,
           id_tpdocument     TINYINT      UNSIGNED NOT NULL,
           lastname_1        VARCHAR(15)  NOT NULL,
           middlename        VARCHAR(10)  NOT NULL,
           firstname         VARCHAR(15)  NOT NULL,
           title             TINYINT,
           customer_type     TINYINT,     /* 1 = Particular; 2 = Corporativo */
           vip_guest         TINYINT,
           frequent_guest    TINYINT,
           id_city           TINYINT      UNSIGNED NOT NULL,
           id_country        SMALLINT     UNSIGNED NOT NULL,
           address           VARCHAR(50),
           district          VARCHAR(15),
           zip_code          VARCHAR(05),
           phone             INT,
           e_mail            VARCHAR(40),
           id_source         CHAR(06),
           sp_service        TINYINT,     /* True = tiene servicios especiales */
           comments          VARCHAR(50),
           status            TINYINT  DEFAULT 1,
           PRIMARY KEY(id_customer, id_tpdocument),
           INDEX(id_tpdocument), INDEX(id_city, id_country),
           INDEX(id_country),    INDEX(id_source),
           FOREIGN KEY(id_tpdocument)       REFERENCES tp_documents(id_tpdocument),
           FOREIGN KEY(id_city, id_country) REFERENCES cities(id_city, id_country),
           FOREIGN KEY(id_country)          REFERENCES countries(id_country),
           FOREIGN KEY(id_source)           REFERENCES sources(id_source)
    );

    CREATE TABLE reservations
    (
           id_reservation    SMALLINT     UNSIGNED NOT NULL AUTO_INCREMENT,
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
           room_rate         DECIMAL(5,2) UNSIGNED NOT NULL DEFAULT '0.00',
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

           FOREIGN KEY(id_roomtype)   REFERENCES room_types(id_roomtype),
           FOREIGN KEY(id_room)       REFERENCES rooms(id_room),
           FOREIGN KEY(id_source)     REFERENCES sources(id_source),
           FOREIGN KEY(id_tpdocument) REFERENCES tp_documents(id_tpdocument),
           FOREIGN KEY(id_customer)   REFERENCES customers(id_customer),
           FOREIGN KEY(id_user)       REFERENCES users(id_user)
    );

    CREATE TABLE deposits
    (
           id_deposit        SMALLINT     NOT NULL,
           id_reservation    SMALLINT     UNSIGNED NOT NULL AUTO_INCREMENT,
           deposit_date      DATE         NOT NULL,
           vencid_date       DATE,
           id_user           CHAR(03)     NOT NULL,
           status            TINYINT      DEFAULT 1,
           PRIMARY KEY(id_deposit),
           INDEX(id_reservation),
           FOREIGN KEY(id_reservation) REFERENCES reservations(id_reservation)
    );

    /* Contiene el detalle de los serv. requ. por un huesped */
    CREATE TABLE rsv_services
    (
           id_reservation    SMALLINT     UNSIGNED NOT NULL AUTO_INCREMENT,
           id_service        CHAR(01),
           status            TINYINT      DEFAULT 1,
           PRIMARY KEY(id_reservation, id_service),
           INDEX(id_reservation),
           FOREIGN KEY(id_reservation) REFERENCES reservations(id_reservation)
                   ON DELETE CASCADE ON UPDATE CASCADE
    );

    CREATE TABLE rsv_status
    (
           rs_code           CHAR(01)     NOT NULL, /* T = Tentativa; C = Confirmada; etc */
           rs_description    CHAR(20)     NOT NULL,
           rs_colour         CHAR(12)               /* Verde; Azul; Rojo; etc. */
    );

    CREATE TABLE type_status
    (
           id_reservation    SMALLINT     UNSIGNED NOT NULL AUTO_INCREMENT,
           id_roomtype       CHAR(02)     NOT NULL,
           ts_arrival        DATE         NOT NULL,
           ts_departure      DATE         NOT NULL,
           ts_nights         TINYINT      NOT NULL,
           ts_quantity       TINYINT      NOT NULL,
           status            TINYINT      DEFAULT 1,
           PRIMARY KEY(id_reservation),
           FOREIGN KEY(id_reservation) REFERENCES reservations(id_reservation)
    );

