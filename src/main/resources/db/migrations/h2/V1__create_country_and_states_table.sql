CREATE TABLE country
  (
     country    VARCHAR(50) NOT NULL,
     cases      INT NOT NULL,
     confirmed  INT NOT NULL,
     deaths     INT NOT NULL,
     recovered  INT NOT NULL,
     updated_at VARCHAR(50) NOT NULL
  );

CREATE TABLE states
  (
    uid      INT NOT NULL,
    uf       VARCHAR(50) NOT NULL,
    state    VARCHAR(20) NOT NULL,
    cases    INT NOT NULL,
    deaths   INT NOT NULL,
    suspects INT NOT NULL,
    refuses  INT NOT NULL,
    datetime VARCHAR(20) NOT NULL
  );