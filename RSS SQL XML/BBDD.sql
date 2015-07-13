
-- DROP DATABASE rss_data;

CREATE DATABASE IF NOT EXISTS rss_data;
USE rss_data;

CREATE TABLE feed (
	codigo_feed INT AUTO_INCREMENT,
    titulo VARCHAR(500),
    enlace VARCHAR(500),
    descripcion VARCHAR(1500),
    CONSTRAINT pk_feed PRIMARY KEY (codigo_feed)
);

SELECT *
	FROM feed;