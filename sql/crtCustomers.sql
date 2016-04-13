    USE testing;

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
           id_city           TINYINT      NOT NULL,
           id_country        TINYINT      UNSIGNED NOT NULL,
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
           INDEX(id_tpdocument), INDEX(id_city, id_country), INDEX(id_source),
           FOREIGN KEY(id_tpdocument)       REFERENCES tp_documents(id_tpdocument),
           /*FOREIGN KEY(id_city, id_country) REFERENCES cities(id_city, id_country)*/
           FOREIGN KEY(id_source)           REFERENCES sources(id_source)
    );

