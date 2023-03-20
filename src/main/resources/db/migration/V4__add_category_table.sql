drop table if exists category;
drop table if exists beer_category;

create table category (
    id VARCHAR(36) NOT NULL,
    description VARCHAR(255) DEFAULT NULL,
    created_date datetime(6) DEFAULT NULL,
    last_modified_date datetime(6) DEFAULT NULL,
    version int  DEFAULT NULL,
    PRIMARY KEY (id)
) engine = InnoDB;

create table beer_category (
    category_id VARCHAR(36) NOT NULL,
    beer_id VARCHAR(36) NOT NULL,
    version int DEFAULT NULL,
    PRIMARY KEY (category_id, beer_id),
    CONSTRAINT FOREIGN KEY (category_id) REFERENCES category(id),
    CONSTRAINT FOREIGN KEY (beer_id) REFERENCES beer(id)
)
