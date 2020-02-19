drop table if exists project
drop table if exists endpoints;

create table project(
    project_id serial primary key not null,
    project_name varchar(255) not null,
);

create table endpoints(
   endpoint_id serial primary key not null,
   project_id serial references project(project_id) not null
   endpoint_url varchar(255) not null,
   request_method varchar(255) not null
);

------------------------------------------------------------------
        --Dumping table for project
------------------------------------------------------------------
insert into project(project_name) values('Time Entry System');
insert into project(project_name) values('Pollster');
insert into project(project_name) values('Chess');

-------------------------------------------------------------------
       --Dumping table for endpoints
-------------------------------------------------------------------

INSERT into endpoints(endpoint_url, request_method) values('https://employeeservice002.herokuapp.com/v1/api/employee/{{id}}', 'GET');
INSERT into endpoints(endpoint_url, request_method) values('https://employeeservice002.herokuapp.com/v1/api/employees', 'GET');
INSERT into endpoints(endpoint_url, request_method) values('https://timeentry002.herokuapp.com/v1/api/projects', 'GET');
INSERT into endpoints(endpoint_url, request_method) values('https://timeentry002.herokuapp.com/v1/api/getloggedproject', 'GET');
INSERT into endpoints(endpoint_url, request_method) values('https://timeentry002.herokuapp.com/v1/api/getloggedsick', 'GET');
INSERT into endpoints(endpoint_url, request_method) values('https://timeentry002.herokuapp.com/v1/api/getloggedvacation', 'GET');
INSERT into endpoints(endpoint_url, request_method) values('https://timeentry002.herokuapp.com/v1/api/{{end_date}}', 'GET');
INSERT into endpoints(endpoint_url, request_method) values('https://timeentry002.herokuapp.com/v1/api/projects/assigned/employee/{{id}}', 'GET');
