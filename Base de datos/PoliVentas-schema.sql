#drop database if exists db_poliventas;
CREATE DATABASE db_poliventas;
USE db_poliventas;

create table tb_usuario(
	ci_usuario varchar(10),
    nombres varchar(30) not null,
    apellidos varchar(30) not null,
    telefono varchar(10),
    whatsapp boolean,
    matricula varchar(9) not null,
    email varchar(40) not null,
    primary key (ci_usuario)
);

create table tb_comprador(
	id_comprador varchar(10),
    cedula varchar(30) not null,
    primary key (id_comprador),
    constraint ci_comprador foreign key (cedula) references tb_usuario(ci_usuario)
);

create table tb_vendedor(
	id_vendedor varchar(10),
    cedula varchar(30) not null,
    primary key (id_vendedor),
    constraint ci_vendedor foreign key (cedula) references tb_usuario(ci_usuario)
);

create table tb_administrador(
	id_administrador varchar(10),
    cedula varchar(30) not null,
    primary key (id_administrador),
    constraint ci_administrador foreign key (cedula) references tb_usuario(ci_usuario)
);

create table tb_producto(
	cod_producto varchar(10),
    nombre varchar(70),
    descripcion varchar(400) default null,
    precio double not null,
    estado varchar(15) default null, #revisar
    primary key(cod_producto)
);
    
create table tb_categoria(
	id_categoria varchar(10),
    cod_producto varchar(10),
    tipo varchar(20),
    primary key (id_categoria),
    constraint cod_producto foreign key (cod_producto) references tb_producto(cod_producto)
);

create table tb_calificacion_producto(
	id_calificacion_prod int auto_increment,
    primary key (id_calificacion_prod),
    calificacion_producto int,
    cod_producto varchar(10),
    constraint cod_producto_calif foreign key (cod_producto) references tb_producto(cod_producto),
    id_comprador varchar(10),
    constraint id_comprador_calif_prod foreign key (id_comprador) references tb_comprador(id_comprador)    
);

create table tb_calificacion_vendedor(
	id_calificacion_vend int auto_increment,
    primary key (id_calificacion_vend),
    calificacion_vend int,
    id_vendedor varchar(10),
    constraint id_vendedor_calif foreign key (id_vendedor) references tb_vendedor(id_vendedor)
);

create table tb_producto_vendedor(
	id_producto_vendedor int auto_increment,
    cantidad int,
    primary key (id_producto_vendedor),
    id_vendedor_pv varchar(10),
    constraint id_vendedor_prod_vend foreign key (id_vendedor_pv) references tb_vendedor(id_vendedor),
    cod_producto_pv varchar(10),
    constraint cod_producto_pv foreign key (cod_producto_pv) references tb_producto(cod_producto) 
);

create table tb_identificacion(
	username varchar(20),
    contrasena varchar(15),
    rol varchar(30),
    primary key (username),
    ci_usuario varchar(10),
    constraint ci_usuario foreign key (ci_usuario) references tb_usuario(ci_usuario)
);

create table tb_pago(
	id_metodo_pago varchar(10) not null,
    tipo varchar(10),
    primary key(id_metodo_pago)
);
    
create table tb_pedido(
	cod_pedido int auto_increment,
    estado varchar(15),
    costo double,
    fecha_pedido date,
	hora_pedido time,
	fecha_entrega date default null,
	hora_entrega time default null,
    lugar_entrega varchar(100),
    primary key (cod_pedido),
    id_forma_pago varchar(10) not null,
    constraint id_forma_pago_ped foreign key (id_forma_pago) references tb_pago(id_metodo_pago),
    id_comprador_ped varchar(10),
    constraint id_comprador_ped foreign key (id_comprador_ped) references tb_comprador(id_comprador),
    id_vendedor_ped varchar(10),
    constraint id_vendedor_ped foreign key (id_vendedor_ped) references tb_vendedor(id_vendedor),
    cod_producto_ped varchar(10), #revisar
    constraint cod_producto_ped foreign key (cod_producto_ped) references tb_producto(cod_producto)
);
