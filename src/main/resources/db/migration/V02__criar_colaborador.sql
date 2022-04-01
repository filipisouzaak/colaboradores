create table colaborador(
	id int identity(1,1),
	nome varchar(50) not null,
	sobrenome varchar(50),
	id_empregador int not null,
	primary key (id),
	foreign key (id_empregador) references empregador(id)
);

insert into colaborador (nome, sobrenome, id_empregador) values 
('Filipi André de','Souza',1),
('Leonardo Augusto de','Souza',2),
('Fabio de','Souza',2),
('Luciana Regina Woelfer de','Souza',1);