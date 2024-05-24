INSERT INTO usuarios (nombre, apellidos, username, password, telefono, foto, email, direccion, fecha_nacimiento, isProfesional) VALUES
('Juan', 'Perez', 'juanperez', 'password123', '1234567890', 'juan.jpg', 'juan@example.com', 'Calle 123, Ciudad', '1985-05-15', TRUE),
('Maria', 'Gomez', 'mariagomez', 'password456', '0987654321', 'maria.jpg', 'maria@example.com', 'Avenida 456, Ciudad', '1990-08-25', FALSE),
('Carlos', 'Ramirez', 'carlosramirez', 'password789', '1122334455', 'carlos.jpg', 'carlos@example.com', 'Boulevard 789, Ciudad', '1982-12-05', TRUE);

-- Insert services
INSERT INTO servicios (nombre) VALUES
('Plumbing'),
('Electrician'),
('Cleaning');

-- Insert service_profesion data
INSERT INTO servicio_profesion (idusuario, idservicio) VALUES
(1, 1), -- Juan offers Plumbing
(1, 2), -- Juan also offers Electrician services
(3, 3); -- Carlos offers Cleaning

-- Insert requests (solicitudes)
INSERT INTO solicitudes (idservicio_profesion, idusuario, mensaje, estado, resena, estrellas) VALUES
(1, 2, 'Need plumbing service for kitchen sink.', 'Pending', NULL, NULL), -- Maria requests Plumbing
(2, 2, 'Need electrician for new light fixtures.', 'Completed', 'Great service!', 5), -- Maria requests Electrician
(3, 1, 'Need cleaning service for my apartment.', 'In Progress', NULL, NULL); -- Juan requests Cleaning