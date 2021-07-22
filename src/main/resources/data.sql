INSERT IGNORE INTO `rol` (`id`, `descripcion`, `name`) VALUES
(1, 'ROLE_ADMIN', 'ADMIN'),
(2, 'ROLE_PROFESOR', 'PROFESOR'),
(3, 'ROLE_ESTUDIANTE', 'ESTUDIANTE');

INSERT IGNORE INTO `user` (`id`, `apellido_materno`, `apellido_paterno`, `enabled`, `fono`, `nombre`, `password`, `rut`, `username`) VALUES
(1, 'admin', 'admin', b'1', 111111111, 'admin', '$2a$04$8nnBUn.IOwKdkRPerA2szOXAFAWQ1vsHpAoLU8NRNG89HLua0PdsG', '11111111-1', 'admin@admin.com'),
(3, 'Vergara', 'Chuquimia', b'1', 12312321, 'Rody', '$2a$04$8nnBUn.IOwKdkRPerA2szOXAFAWQ1vsHpAoLU8NRNG89HLua0PdsG', '22222222-2', 'rody@mail.cl');

INSERT IGNORE INTO `user_roles` (`user_id`, `rol_id`) VALUES
(1, 1),
(3, 2),
(6, 3);

INSERT IGNORE INTO `tipo_usuario` (`id`, `tipo`) VALUES
(1, 'administrador'),
(2, 'profesor'),
(3, 'estudiante');

