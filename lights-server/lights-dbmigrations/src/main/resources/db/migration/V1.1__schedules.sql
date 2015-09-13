
create table schedule (
  id              NUMERIC(20),
  name            VARCHAR(128),
  description     VARCHAR(256),

  CONSTRAINT pk_schedule PRIMARY KEY (id)
);

create table schedule_item (
  id              NUMERIC(20) NOT NULL ,
  wait            NUMERIC(20),
  onForSeconds    NUMERIC(20),
  schedule_id     NUMERIC(20) NOT NULL,

  CONSTRAINT pk_schedule_item PRIMARY KEY (id),
  CONSTRAINT fk_schedule FOREIGN KEY (schedule_id) REFERENCES schedule (id)
);

create sequence schedule_seq start with 1000;
create sequence schedule_item_seq start with 1000;

insert into schedule (id,name,description) values (0, 'summer', 'summer schedule');
insert into schedule (id,name,description) values (1, 'winter', 'winter schedule');

insert into schedule_item (ID, ONFORSECONDS, WAIT,  SCHEDULE_ID ) VALUES (0, 5000, 10 , 0 );
insert into schedule_item (ID, ONFORSECONDS, WAIT, SCHEDULE_ID ) VALUES ( 1, 3000, 190 , 0 );

insert into schedule_item (ID, ONFORSECONDS, WAIT,  SCHEDULE_ID ) VALUES (2, 6666, 111 , 1 );
insert into schedule_item (ID, ONFORSECONDS, WAIT, SCHEDULE_ID ) VALUES ( 3, 7777, 222 , 1 );