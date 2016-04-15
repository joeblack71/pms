
    DROP TABLE IF EXISTS customers;
    DROP TABLE IF EXISTS tp_documents;
    DROP TABLE IF EXISTS cities;
    DROP TABLE IF EXISTS countries;

    CREATE TABLE tp_documents
    (
           id_tpdocument     TINYINT      NOT NULL,
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
                   /*ON DELETE CASCADE ON UPDATE CASCADE*/
    );

    CREATE TABLE customers
    (
           id_customer       CHAR(10)     NOT NULL,
           id_tpdocument     TINYINT      NOT NULL,
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
           INDEX(id_tpdocument), INDEX(id_city), INDEX(id_country), INDEX(id_source),
           FOREIGN KEY(id_tpdocument)       REFERENCES tp_documents(id_tpdocument),
           FOREIGN KEY(id_city, id_country) REFERENCES cities(id_city, id_country),
           FOREIGN KEY(id_country)          REFERENCES countries(id_country),
           FOREIGN KEY(id_source)           REFERENCES sources(id_source)
    );

