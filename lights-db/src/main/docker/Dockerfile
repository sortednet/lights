FROM sortednet/oracle
ADD schemas.sql schemas.sql
RUN /bin/bash -c 'hostname ; service oracle-xe start; sqlplus system/oracle @schemas.sql'
