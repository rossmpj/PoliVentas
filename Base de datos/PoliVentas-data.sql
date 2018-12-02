INSERT INTO `db_poliventas`.`tb_usuario` (`ci_usuario`, `nombres`, `apellidos`, `telefono`, `whatsapp`, `matricula`, `email`) VALUES ('1503953456', 'Rosa', 'Pincay', '0968503600', true, '201601431', 'rmpincay@espol.edu.ec');
INSERT INTO `db_poliventas`.`tb_usuario` (`ci_usuario`, `nombres`, `apellidos`, `telefono`, `whatsapp`, `matricula`, `email`) VALUES ('0593050492', 'Stefanny', 'Aguirre', '0956402940', true, '201601430', 'sbaguirr@espol.edu.ec');
INSERT INTO `db_poliventas`.`tb_usuario` (`ci_usuario`, `nombres`, `apellidos`, `telefono`, `whatsapp`, `matricula`, `email`) VALUES ('1230504033', 'Edie', 'Chang', '0594959693', false, '201034050', 'echan@espol.edu.ec');
INSERT INTO `db_poliventas`.`tb_usuario` (`ci_usuario`, `nombres`, `apellidos`, `telefono`, `whatsapp`, `matricula`, `email`) VALUES ('5225756787', 'Jenny', 'Fuentes', '0953204020', true, '201503053', 'jjfuen@espol.edu.ec');
INSERT INTO `db_poliventas`.`tb_usuario` (`ci_usuario`, `nombres`, `apellidos`, `telefono`, `whatsapp`, `matricula`, `email`) VALUES ('3522546589', 'Sandra', 'Miranda', '0953502053', false, '201703053', 'smira@espol.edu.ec');
INSERT INTO `db_poliventas`.`tb_usuario` (`ci_usuario`, `nombres`, `apellidos`, `telefono`, `whatsapp`, `matricula`, `email`) VALUES ('0545635352', 'Bryan', 'Tutiven', '0549354024', true, '201503036', 'btuti@espol.edu.ec');
INSERT INTO `db_poliventas`.`tb_usuario` (`ci_usuario`, `nombres`, `apellidos`, `telefono`, `whatsapp`, `matricula`, `email`) VALUES ('7586978073', 'Carlos', 'Cantos', '0935032135', false, '201643046', 'ccanta@espol.edu.ec');
INSERT INTO `db_poliventas`.`tb_usuario` (`ci_usuario`, `nombres`, `apellidos`, `telefono`, `whatsapp`, `matricula`, `email`) VALUES ('0591020194', 'Clara', 'Santander', '0953565356', true, '201745363', 'cmsanta@espol.edu.ec');
INSERT INTO `db_poliventas`.`tb_usuario` (`ci_usuario`, `nombres`, `apellidos`, `telefono`, `whatsapp`, `matricula`, `email`) VALUES ('0356332466', 'Jair', 'Flores', '0964456642', false, '201566356', 'jflores@espol.edu.ec');
INSERT INTO `db_poliventas`.`tb_usuario` (`ci_usuario`, `nombres`, `apellidos`, `telefono`, `whatsapp`, `matricula`, `email`) VALUES ('1346864456', 'Roger', 'Loor', '0223458639', true, '201532566', 'rogloo@espol.edu.ec');
INSERT INTO `db_poliventas`.`tb_usuario` (`ci_usuario`, `nombres`, `apellidos`, `telefono`, `whatsapp`, `matricula`, `email`) VALUES ('0866433454', 'Geanella', 'Pauta', '0964522435', true, '201533244', 'geapau@espol.edu.ec');
INSERT INTO `db_poliventas`.`tb_usuario` (`ci_usuario`, `nombres`, `apellidos`, `telefono`, `whatsapp`, `matricula`, `email`) VALUES ('1267786745', 'Katy', 'Salinas', '0943576894', true, '201442425', 'katsali@espol.edu.ec');
INSERT INTO `db_poliventas`.`tb_usuario` (`ci_usuario`, `nombres`, `apellidos`, `telefono`, `whatsapp`, `matricula`, `email`) VALUES ('0086765422', 'Nataly', 'Martinez', '0424656340', true, '201492537', 'njmarti@espol.edu.ec');
INSERT INTO `db_poliventas`.`tb_usuario` (`ci_usuario`, `nombres`, `apellidos`, `telefono`, `whatsapp`, `matricula`, `email`) VALUES ('0954123473', 'Stalin', 'Baquerizo', '4939294949', false, '201035332', 'stalbauq@espol.edu.ec');
INSERT INTO `db_poliventas`.`tb_usuario` (`ci_usuario`, `nombres`, `apellidos`, `telefono`, `whatsapp`, `matricula`, `email`) VALUES ('1204306843', 'Bob', 'Lino', '049395929', false, '201964603', 'blin@espol.edu.ec');
INSERT INTO `db_poliventas`.`tb_usuario` (`ci_usuario`, `nombres`, `apellidos`, `telefono`, `whatsapp`, `matricula`, `email`) VALUES ('4930608312', 'Ana', 'Pazmiño', '4060402040', true, '304060450', 'apazm@espol.edu.ec');

INSERT INTO `db_poliventas`.`tb_administrador` (`id_administrador`, `cedula`) VALUES ('adm001', '0954123473');
INSERT INTO `db_poliventas`.`tb_administrador` (`id_administrador`, `cedula`) VALUES ('adm002', '1204306843');
INSERT INTO `db_poliventas`.`tb_administrador` (`id_administrador`, `cedula`) VALUES ('adm003', '4930608312');

INSERT INTO `db_poliventas`.`tb_comprador` (`id_comprador`, `cedula`) VALUES ('comp001', '1503953456');
INSERT INTO `db_poliventas`.`tb_comprador` (`id_comprador`, `cedula`) VALUES ('comp002', '0591020194');
INSERT INTO `db_poliventas`.`tb_comprador` (`id_comprador`, `cedula`) VALUES ('comp003', '0356332466');
INSERT INTO `db_poliventas`.`tb_comprador` (`id_comprador`, `cedula`) VALUES ('comp004', '1346864456');
INSERT INTO `db_poliventas`.`tb_comprador` (`id_comprador`, `cedula`) VALUES ('comp005', '0866433454');
INSERT INTO `db_poliventas`.`tb_comprador` (`id_comprador`, `cedula`) VALUES ('comp006', '1267786745');
INSERT INTO `db_poliventas`.`tb_comprador` (`id_comprador`, `cedula`) VALUES ('comp007', '0086765422');

INSERT INTO `db_poliventas`.`tb_vendedor` (`id_vendedor`, `cedula`) VALUES ('vend001', '0593050492');
INSERT INTO `db_poliventas`.`tb_vendedor` (`id_vendedor`, `cedula`) VALUES ('vend002', '1230504033');
INSERT INTO `db_poliventas`.`tb_vendedor` (`id_vendedor`, `cedula`) VALUES ('vend003', '5225756787');
INSERT INTO `db_poliventas`.`tb_vendedor` (`id_vendedor`, `cedula`) VALUES ('vend004', '3522546589');
INSERT INTO `db_poliventas`.`tb_vendedor` (`id_vendedor`, `cedula`) VALUES ('vend005', '0545635352');
INSERT INTO `db_poliventas`.`tb_vendedor` (`id_vendedor`, `cedula`) VALUES ('vend006', '7586978073');

INSERT INTO `db_poliventas`.`tb_identificacion` (`username`, `contrasena`, `rol`, `ci_usuario`) VALUES ('rosa', '1234', 'comprador', '1503953456');
INSERT INTO `db_poliventas`.`tb_identificacion` (`username`, `contrasena`, `rol`, `ci_usuario`) VALUES ('stef', 'stef', 'vendedor', '0593050492');

INSERT INTO `db_poliventas`.`tb_pago` (`id_metodo_pago`, `tipo`) VALUES ('PHONE1', 'celular');
INSERT INTO `db_poliventas`.`tb_pago` (`id_metodo_pago`, `tipo`) VALUES ('EFECT1', 'efectivo');

INSERT INTO `db_poliventas`.`tb_producto` (`cod_producto`, `nombre`, `precio`) VALUES ('chai002', 'Silla plastica', 5.00);
INSERT INTO `db_poliventas`.`tb_producto` (`cod_producto`, `nombre`, `precio`) VALUES ('dress001', 'Vestido pets', 10.00);
INSERT INTO `db_poliventas`.`tb_producto` (`cod_producto`, `nombre`, `precio`) VALUES ('foo001', 'alimento gato', 8.00);
INSERT INTO `db_poliventas`.`tb_producto` (`cod_producto`, `nombre`, `precio`) VALUES ('mou001', 'mouse', 3.00);
INSERT INTO `db_poliventas`.`tb_producto` (`cod_producto`, `nombre`, `precio`) VALUES ('prod003', 'Collar', 20.00);
INSERT INTO `db_poliventas`.`tb_producto` (`cod_producto`, `nombre`, `precio`) VALUES ('prod008', 'Taza', 10.00);
INSERT INTO `db_poliventas`.`tb_producto` (`cod_producto`, `nombre`, `precio`) VALUES ('prod007', 'cable usb', 5.00);

INSERT INTO `db_poliventas`.`tb_categoria` (`id_categoria`, `cod_producto`, `tipo`) VALUES ('home01', 'chai002', 'Hogar');
INSERT INTO `db_poliventas`.`tb_categoria` (`id_categoria`, `cod_producto`, `tipo`) VALUES ('pets01', 'dress001', 'Mascotas');
INSERT INTO `db_poliventas`.`tb_categoria` (`id_categoria`, `cod_producto`, `tipo`) VALUES ('cats01', 'foo001', 'Mascotas');
INSERT INTO `db_poliventas`.`tb_categoria` (`id_categoria`, `cod_producto`, `tipo`) VALUES ('tech01', 'mou001', 'Tecnologia');
INSERT INTO `db_poliventas`.`tb_categoria` (`id_categoria`, `cod_producto`, `tipo`) VALUES ('pets02', 'prod003', 'Mascotas');
INSERT INTO `db_poliventas`.`tb_categoria` (`id_categoria`, `cod_producto`, `tipo`) VALUES ('cats02', 'prod008', 'Mascotas');
INSERT INTO `db_poliventas`.`tb_categoria` (`id_categoria`, `cod_producto`, `tipo`) VALUES ('tech02', 'prod007', 'Tecnologia');

INSERT INTO `db_poliventas`.`tb_pedido` (`estado`, `costo`, `fecha_pedido`, `hora_pedido`, `lugar_entrega`, `id_forma_pago`, `id_comprador_ped`, `id_vendedor_ped`, `cod_producto_ped`) VALUES ('pendiente', 5.00, '2018-11-28', '15:00', 'FIEC', 'PHONE1', 'comp001', 'vend001', 'chai002');
INSERT INTO `db_poliventas`.`tb_pedido` (`estado`, `costo`, `fecha_pedido`, `hora_pedido`, `lugar_entrega`, `id_forma_pago`, `id_comprador_ped`, `id_vendedor_ped`, `cod_producto_ped`) VALUES ('pendiente', 8.00, '2018-11-29', '10:00', 'FCNM', 'EFECT1', 'comp002', 'vend002', 'foo001');
INSERT INTO `db_poliventas`.`tb_pedido` (`estado`, `costo`, `fecha_pedido`, `hora_pedido`, `lugar_entrega`, `id_forma_pago`, `id_comprador_ped`, `id_vendedor_ped`, `cod_producto_ped`) VALUES ('anulado', 10.00, '2018-11-10', '11:00', 'CELEX', 'PHONE1', 'comp003', 'vend003', 'dress001');
INSERT INTO `db_poliventas`.`tb_pedido` (`estado`, `costo`, `fecha_pedido`, `hora_pedido`, `lugar_entrega`, `id_forma_pago`, `id_comprador_ped`, `id_vendedor_ped`, `cod_producto_ped`) VALUES ('exitoso', 8.00, '2018-11-8', '13:00', 'FIMCP', 'PHONE1', 'comp004', 'vend004', 'foo001');
INSERT INTO `db_poliventas`.`tb_pedido` (`estado`, `costo`, `fecha_pedido`, `hora_pedido`, `lugar_entrega`, `id_forma_pago`, `id_comprador_ped`, `id_vendedor_ped`, `cod_producto_ped`) VALUES ('anulado', 20.00, '2018-10-11', '12:50', 'Basico', 'PHONE1', 'comp005', 'vend005', 'prod003');
INSERT INTO `db_poliventas`.`tb_pedido` (`estado`, `costo`, `fecha_pedido`, `hora_pedido`, `lugar_entrega`, `id_forma_pago`, `id_comprador_ped`, `id_vendedor_ped`, `cod_producto_ped`) VALUES ('exitoso', 10.00, '2018-05-11', '11:00', 'FCSH', 'EFECT1', 'comp006', 'vend006', 'prod008');
INSERT INTO `db_poliventas`.`tb_pedido` (`estado`, `costo`, `fecha_pedido`, `hora_pedido`, `lugar_entrega`, `id_forma_pago`, `id_comprador_ped`, `id_vendedor_ped`, `cod_producto_ped`) VALUES ('exitoso', 10.00, '2018-02-11', '9:00', 'FIEC', 'PHONE1', 'comp007', 'vend001', 'prod007');

INSERT INTO `db_poliventas`.`tb_producto_vendedor` (`cantidad`, `id_vendedor_pv`, `cod_producto_pv`) VALUES ('2', 'vend001', 'chai002');
INSERT INTO `db_poliventas`.`tb_producto_vendedor` (`cantidad`, `id_vendedor_pv`, `cod_producto_pv`) VALUES ('1', 'vend002', 'prod003');
INSERT INTO `db_poliventas`.`tb_producto_vendedor` (`cantidad`, `id_vendedor_pv`, `cod_producto_pv`) VALUES ('1', 'vend003', 'chai002');
INSERT INTO `db_poliventas`.`tb_producto_vendedor` (`cantidad`, `id_vendedor_pv`, `cod_producto_pv`) VALUES ('4', 'vend004', 'prod008');
INSERT INTO `db_poliventas`.`tb_producto_vendedor` (`cantidad`, `id_vendedor_pv`, `cod_producto_pv`) VALUES ('6', 'vend005', 'prod007');
INSERT INTO `db_poliventas`.`tb_producto_vendedor` (`cantidad`, `id_vendedor_pv`, `cod_producto_pv`) VALUES ('2', 'vend006', 'prod008');

INSERT INTO `db_poliventas`.`tb_calificacion_producto` (`calificacion_producto`, `cod_producto`, `id_comprador`) VALUES (5, 'prod008', 'comp001');
INSERT INTO `db_poliventas`.`tb_calificacion_producto` (`calificacion_producto`, `cod_producto`, `id_comprador`) VALUES (3, 'prod003', 'comp002');
INSERT INTO `db_poliventas`.`tb_calificacion_producto` (`calificacion_producto`, `cod_producto`, `id_comprador`) VALUES (1, 'prod007', 'comp003');
INSERT INTO `db_poliventas`.`tb_calificacion_producto` (`calificacion_producto`, `cod_producto`, `id_comprador`) VALUES (2, 'prod008', 'comp004');
INSERT INTO `db_poliventas`.`tb_calificacion_producto` (`calificacion_producto`, `cod_producto`, `id_comprador`) VALUES (3, 'prod007', 'comp005');
INSERT INTO `db_poliventas`.`tb_calificacion_producto` (`calificacion_producto`, `cod_producto`, `id_comprador`) VALUES (1, 'prod007', 'comp006');
INSERT INTO `db_poliventas`.`tb_calificacion_producto` (`calificacion_producto`, `cod_producto`, `id_comprador`) VALUES (4, 'prod007', 'comp007');

INSERT INTO `db_poliventas`.`tb_calificacion_vendedor` (`calificacion_vend`, `id_vendedor`) VALUES (1, 'vend001');
INSERT INTO `db_poliventas`.`tb_calificacion_vendedor` (`calificacion_vend`, `id_vendedor`) VALUES (2, 'vend002');
INSERT INTO `db_poliventas`.`tb_calificacion_vendedor` (`calificacion_vend`, `id_vendedor`) VALUES (3, 'vend003');
INSERT INTO `db_poliventas`.`tb_calificacion_vendedor` (`calificacion_vend`, `id_vendedor`) VALUES (4, 'vend004');
INSERT INTO `db_poliventas`.`tb_calificacion_vendedor` (`calificacion_vend`, `id_vendedor`) VALUES (5, 'vend005');
INSERT INTO `db_poliventas`.`tb_calificacion_vendedor` (`calificacion_vend`, `id_vendedor`) VALUES (5, 'vend006');