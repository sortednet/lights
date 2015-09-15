

create table light (
  id              NUMERIC(20),
  name            VARCHAR(128),
  description     VARCHAR(256),

  CONSTRAINT pk_light PRIMARY KEY (id)
);

create sequence light_seq start with 1000;


create table schedule (
  id              NUMERIC(20) NOT NULL,
  name            VARCHAR(128),
  description     VARCHAR(256),

  CONSTRAINT pk_schedule PRIMARY KEY (id)
);

create table schedule_item (
  id              NUMERIC(20) NOT NULL,
  wait            NUMERIC(20),
  onForSeconds    NUMERIC(20),
  schedule_id     NUMERIC(20) NOT NULL,
  light_id        NUMERIC(20) NOT NULL,

  CONSTRAINT pk_schedule_item PRIMARY KEY (id),
  CONSTRAINT fk_schedule FOREIGN KEY (schedule_id) REFERENCES schedule (id),
  CONSTRAINT fk_light FOREIGN KEY (light_id) REFERENCES light (id)
);


create sequence schedule_seq start with 1000;
create sequence schedule_item_seq start with 1000;

insert into light (id, name, description) values ('0', 'Tree fern spot', 'Spotlight hightlighting the tree fern');
insert into light (id, name, description) values ('1', 'Small bed 1', 'Low light in the small bed');
insert into light (id, name, description) values ('2', 'Rock spot', 'Spot light on the rock unter tree fern');

insert into schedule (id,name,description) values ('0', 'summer', 'summer schedule');
insert into schedule (id,name,description) values ('1', 'winter', 'winter schedule');

insert into schedule_item (ID, ONFORSECONDS, WAIT,  SCHEDULE_ID, LIGHT_ID ) VALUES ('0', 5000, 10 , '0', '0' );
insert into schedule_item (ID, ONFORSECONDS, WAIT, SCHEDULE_ID, LIGHT_ID ) VALUES ( '1', 3000, 190 , '0', '1' );

insert into schedule_item (ID, ONFORSECONDS, WAIT,  SCHEDULE_ID, LIGHT_ID ) VALUES ('2', 6666, 111 , '1', '2' );
insert into schedule_item (ID, ONFORSECONDS, WAIT, SCHEDULE_ID, LIGHT_ID ) VALUES ( '3', 7777, 222 , '1', '0' );