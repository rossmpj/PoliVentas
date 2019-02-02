#drop database if exists db_poliventas;
CREATE DATABASE db_poliventas;
USE db_poliventas;

create table tb_usuario(
	ci_usuario varchar(10),
    nombres varchar(30) not null,
    apellidos varchar(30) not null,
    telefono varchar(10),
    direccion varchar(200),
    whatsapp boolean,
    matricula varchar(9) not null,
    email varchar(40) not null,
    username varchar(20) not null,
    contrasena varchar(20) not null,
    estado boolean,
    primary key (ci_usuario)
);

create table tb_comprador(
	id_comprador varchar(11),
    cedula varchar(10) not null,
    primary key (id_comprador),
    constraint ci_comprador foreign key (cedula) references tb_usuario(ci_usuario)
);

create table tb_vendedor(
	id_vendedor varchar(11),
    cedula varchar(10) not null,
    id_comprador varchar(10),
    primary key (id_vendedor),
    constraint ci_vendedor foreign key (cedula) references tb_usuario(ci_usuario),    
    constraint id_comprador foreign key (id_comprador) references tb_comprador(id_comprador)
);

create table tb_producto(
	id_producto varchar(10),
    nombre varchar(70),
    descripcion varchar(400) default null,
    precio double not null,
    categoria varchar(30),
    stock int,
    estado boolean, 
    num_busquedas int,
    id_vendedor varchar(10),
    primary key(id_producto),
    constraint id_vendedor foreign key (id_vendedor) references tb_vendedor(id_vendedor)
);

create table tb_administrador(
	id_administrador varchar(11),
    cedula varchar(10) not null,
    primary key (id_administrador),
    constraint ci_administrador foreign key (cedula) references tb_usuario(ci_usuario)
);
  
create table tb_calificacion_producto(
	id_calificacion_prod int auto_increment,
    primary key (id_calificacion_prod),
    calificacion_producto int default 0,
    id_producto varchar(10),
    constraint id_producto_calif foreign key (id_producto) references tb_producto(id_producto),
    id_comprador varchar(10),
    constraint id_comprador_calif_prod foreign key (id_comprador) references tb_comprador(id_comprador)    
);

create table tb_calificacion_vendedor(
	id_calificacion_vend int auto_increment,
    calificacion_vendedor int default 0,
    primary key (id_calificacion_vend),
    id_vendedor varchar(10),
    constraint id_vendedor_calif foreign key (id_vendedor) references tb_vendedor(id_vendedor),
    id_comprador varchar(10),
    constraint id_comprador_calif foreign key (id_comprador) references tb_comprador(id_comprador)
);

create table tb_forma_pago(
	id_forma_pago varchar(7),
    nombre varchar(15),
    primary key(id_forma_pago)
);

create table tb_pago(
	id_pago int auto_increment,
    id_forma_pago varchar(10) not null,
    detalle varchar(100),
    primary key(id_pago),
    constraint id_forma_pago foreign key (id_forma_pago) references tb_forma_pago(id_forma_pago)
);
    
create table tb_pedido(
	id_pedido int auto_increment,
    estado varchar(15),
    costo double,
    cantidad_pedida int,
    fecha_pedido date,
	hora_pedido time,
	fecha_entrega date default null,
	hora_entrega time default null,
    lugar_entrega varchar(100),
    primary key (id_pedido),
    id_pago varchar(10),
    constraint id_pago_ped foreign key (id_pago) references tb_pago(id_forma_pago),
    id_comprador_ped varchar(10),
    constraint id_comprador_ped foreign key (id_comprador_ped) references tb_comprador(id_comprador),
    id_vendedor_ped varchar(10),
    constraint id_vendedor_ped foreign key (id_vendedor_ped) references tb_vendedor(id_vendedor),
    id_producto_ped varchar(10),
    constraint id_producto_ped foreign key (id_producto_ped) references tb_producto(id_producto)
);

delimiter $
create procedure login (in idus varchar(10), in pass varchar(10), out cedula varchar(10))
	begin
		set cedula = null;
		select ci_usuario into cedula
		from tb_usuario
		where STRCMP(username,idus)=0  and  STRCMP(contrasena,pass)=0;
	end $
delimiter ;
