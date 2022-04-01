create table empregador(
	id int identity(1,1),
	nome varchar(150) not null,
	identificador varchar(18) not null,
	primary key(id)
);

insert into empregador (nome, identificador) values ('Microton Tecnologia','14.567.432/0001-18');
insert into empregador (nome, identificador) values ('WK Sistemas','07.567.432/0001-67');